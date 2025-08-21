#include <jni.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>
#include <unistd.h>
#include <sys/utsname.h>
#include <sys/sysinfo.h>
#include <sys/types.h>
#include <pwd.h>
#include "SystemInfo.h"

#ifdef _WIN32
#include <windows.h>
#include <psapi.h>
#include <direct.h>
#define getcwd _getcwd
#else
#include <sys/sysinfo.h>
#include <sys/utsname.h>
#endif

// Implementation of native method getOperatingSystem()
JNIEXPORT jstring JNICALL Java_SystemInfo_getOperatingSystem(JNIEnv *env, jobject obj) {
#ifdef _WIN32
    return (*env)->NewStringUTF(env, "Windows");
#elif defined(__APPLE__)
    return (*env)->NewStringUTF(env, "macOS");
#elif defined(__linux__)
    return (*env)->NewStringUTF(env, "Linux");
#else
    return (*env)->NewStringUTF(env, "Unknown");
#endif
}

// Implementation of native method getArchitecture()
JNIEXPORT jstring JNICALL Java_SystemInfo_getArchitecture(JNIEnv *env, jobject obj) {
#ifdef _WIN32
    SYSTEM_INFO sysInfo;
    GetSystemInfo(&sysInfo);
    switch (sysInfo.wProcessorArchitecture) {
        case PROCESSOR_ARCHITECTURE_AMD64:
            return (*env)->NewStringUTF(env, "x64");
        case PROCESSOR_ARCHITECTURE_ARM:
            return (*env)->NewStringUTF(env, "ARM");
        case PROCESSOR_ARCHITECTURE_IA64:
            return (*env)->NewStringUTF(env, "IA64");
        case PROCESSOR_ARCHITECTURE_INTEL:
            return (*env)->NewStringUTF(env, "x86");
        default:
            return (*env)->NewStringUTF(env, "Unknown");
    }
#else
    struct utsname uts;
    if (uname(&uts) == 0) {
        return (*env)->NewStringUTF(env, uts.machine);
    }
    return (*env)->NewStringUTF(env, "Unknown");
#endif
}

// Implementation of native method getTotalMemory()
JNIEXPORT jlong JNICALL Java_SystemInfo_getTotalMemory(JNIEnv *env, jobject obj) {
#ifdef _WIN32
    MEMORYSTATUSEX memInfo;
    memInfo.dwLength = sizeof(MEMORYSTATUSEX);
    GlobalMemoryStatusEx(&memInfo);
    return (jlong)memInfo.ullTotalPhys;
#else
    struct sysinfo si;
    if (sysinfo(&si) == 0) {
        return (jlong)si.totalram * si.mem_unit;
    }
    return -1;
#endif
}

// Implementation of native method getFreeMemory()
JNIEXPORT jlong JNICALL Java_SystemInfo_getFreeMemory(JNIEnv *env, jobject obj) {
#ifdef _WIN32
    MEMORYSTATUSEX memInfo;
    memInfo.dwLength = sizeof(MEMORYSTATUSEX);
    GlobalMemoryStatusEx(&memInfo);
    return (jlong)memInfo.ullAvailPhys;
#else
    struct sysinfo si;
    if (sysinfo(&si) == 0) {
        return (jlong)si.freeram * si.mem_unit;
    }
    return -1;
#endif
}

// Implementation of native method getProcessorCount()
JNIEXPORT jint JNICALL Java_SystemInfo_getProcessorCount(JNIEnv *env, jobject obj) {
#ifdef _WIN32
    SYSTEM_INFO sysInfo;
    GetSystemInfo(&sysInfo);
    return (jint)sysInfo.dwNumberOfProcessors;
#else
    return (jint)sysconf(_SC_NPROCESSORS_ONLN);
#endif
}

// Implementation of native method getProcessorInfo()
JNIEXPORT jstring JNICALL Java_SystemInfo_getProcessorInfo(JNIEnv *env, jobject obj) {
#ifdef _WIN32
    char processorInfo[256];
    DWORD bufferSize = sizeof(processorInfo);
    if (GetComputerNameA(processorInfo, &bufferSize)) {
        return (*env)->NewStringUTF(env, processorInfo);
    }
    return (*env)->NewStringUTF(env, "Windows Processor");
#else
    FILE *file = fopen("/proc/cpuinfo", "r");
    if (file != NULL) {
        char line[256];
        while (fgets(line, sizeof(line), file)) {
            if (strncmp(line, "model name", 10) == 0) {
                char *colon = strchr(line, ':');
                if (colon != NULL) {
                    colon++; // Skip the colon
                    while (*colon == ' ' || *colon == '\t') colon++; // Skip whitespace
                    char *newline = strchr(colon, '\n');
                    if (newline != NULL) *newline = '\0';
                    fclose(file);
                    return (*env)->NewStringUTF(env, colon);
                }
            }
        }
        fclose(file);
    }
    return (*env)->NewStringUTF(env, "Unknown Processor");
#endif
}

// Implementation of native method getCurrentTimeMillis()
JNIEXPORT jlong JNICALL Java_SystemInfo_getCurrentTimeMillis(JNIEnv *env, jobject obj) {
    return (jlong)time(NULL) * 1000;
}

// Implementation of native method getCurrentWorkingDirectory()
JNIEXPORT jstring JNICALL Java_SystemInfo_getCurrentWorkingDirectory(JNIEnv *env, jobject obj) {
    char cwd[1024];
    if (getcwd(cwd, sizeof(cwd)) != NULL) {
        return (*env)->NewStringUTF(env, cwd);
    }
    return (*env)->NewStringUTF(env, "Error getting current directory");
}

// Implementation of native method getEnvironmentVariable()
JNIEXPORT jstring JNICALL Java_SystemInfo_getEnvironmentVariable(JNIEnv *env, jobject obj, jstring name) {
    const char *native_name = (*env)->GetStringUTFChars(env, name, 0);
    
    const char *value = getenv(native_name);
    jstring result = NULL;
    
    if (value != NULL) {
        result = (*env)->NewStringUTF(env, value);
    }
    
    (*env)->ReleaseStringUTFChars(env, name, native_name);
    return result;
}

// Implementation of native method getEnvironmentVariables()
JNIEXPORT jobjectArray JNICALL Java_SystemInfo_getEnvironmentVariables(JNIEnv *env, jobject obj) {
#ifdef _WIN32
    // Windows implementation
    LPWCH env_block = GetEnvironmentStringsW();
    if (env_block == NULL) {
        return NULL;
    }
    
    // Count environment variables
    int count = 0;
    LPWCH p = env_block;
    while (*p != '\0') {
        count++;
        while (*p != '\0') p++;
        p++;
    }
    
    // Create Java string array
    jobjectArray result = (*env)->NewObjectArray(env, count, 
        (*env)->FindClass(env, "java/lang/String"), NULL);
    
    if (result != NULL) {
        p = env_block;
        int index = 0;
        while (*p != '\0' && index < count) {
            // Convert wide char to UTF-8
            int len = WideCharToMultiByte(CP_UTF8, 0, p, -1, NULL, 0, NULL, NULL);
            if (len > 0) {
                char *utf8_str = (char *)malloc(len);
                WideCharToMultiByte(CP_UTF8, 0, p, -1, utf8_str, len, NULL, NULL);
                jstring env_var = (*env)->NewStringUTF(env, utf8_str);
                (*env)->SetObjectArrayElement(env, result, index, env_var);
                free(utf8_str);
            }
            index++;
            while (*p != '\0') p++;
            p++;
        }
    }
    
    FreeEnvironmentStringsW(env_block);
    return result;
#else
    // Unix implementation
    extern char **environ;
    if (environ == NULL) {
        return NULL;
    }
    
    // Count environment variables
    int count = 0;
    char **p = environ;
    while (*p != NULL) {
        count++;
        p++;
    }
    
    // Create Java string array
    jobjectArray result = (*env)->NewObjectArray(env, count, 
        (*env)->FindClass(env, "java/lang/String"), NULL);
    
    if (result != NULL) {
        p = environ;
        int index = 0;
        while (*p != NULL && index < count) {
            jstring env_var = (*env)->NewStringUTF(env, *p);
            (*env)->SetObjectArrayElement(env, result, index, env_var);
            index++;
            p++;
        }
    }
    
    return result;
#endif
}

// Implementation of native method getCurrentProcessId()
JNIEXPORT jint JNICALL Java_SystemInfo_getCurrentProcessId(JNIEnv *env, jobject obj) {
#ifdef _WIN32
    return (jint)GetCurrentProcessId();
#else
    return (jint)getpid();
#endif
}

// Implementation of native method getHostname()
JNIEXPORT jstring JNICALL Java_SystemInfo_getHostname(JNIEnv *env, jobject obj) {
    char hostname[256];
#ifdef _WIN32
    DWORD size = sizeof(hostname);
    if (GetComputerNameA(hostname, &size)) {
        return (*env)->NewStringUTF(env, hostname);
    }
#else
    if (gethostname(hostname, sizeof(hostname)) == 0) {
        return (*env)->NewStringUTF(env, hostname);
    }
#endif
    return (*env)->NewStringUTF(env, "Unknown");
}

// Implementation of native method getSystemLoad()
JNIEXPORT jdouble JNICALL Java_SystemInfo_getSystemLoad(JNIEnv *env, jobject obj) {
#ifdef _WIN32
    // Windows doesn't have a direct equivalent to load average
    // Return a placeholder value
    return 0.0;
#else
    double loadavg[3];
    if (getloadavg(loadavg, 3) != -1) {
        return (jdouble)loadavg[0]; // Return 1-minute load average
    }
    return -1.0;
#endif
}

// Implementation of native method getSystemUptime()
JNIEXPORT jstring JNICALL Java_SystemInfo_getSystemUptime(JNIEnv *env, jobject obj) {
#ifdef _WIN32
    // Windows implementation
    ULARGE_INTEGER uptime;
    if (GetTickCount64) {
        uptime.QuadPart = GetTickCount64();
    } else {
        uptime.QuadPart = GetTickCount();
    }
    
    unsigned long seconds = (unsigned long)(uptime.QuadPart / 1000);
    unsigned long days = seconds / 86400;
    unsigned long hours = (seconds % 86400) / 3600;
    unsigned long minutes = (seconds % 3600) / 60;
    seconds = seconds % 60;
    
    char uptime_str[256];
    snprintf(uptime_str, sizeof(uptime_str), "%lu days, %lu hours, %lu minutes, %lu seconds", 
             days, hours, minutes, seconds);
    return (*env)->NewStringUTF(env, uptime_str);
#else
    // Unix implementation
    struct sysinfo si;
    if (sysinfo(&si) == 0) {
        unsigned long seconds = si.uptime;
        unsigned long days = seconds / 86400;
        unsigned long hours = (seconds % 86400) / 3600;
        unsigned long minutes = (seconds % 3600) / 60;
        seconds = seconds % 60;
        
        char uptime_str[256];
        snprintf(uptime_str, sizeof(uptime_str), "%lu days, %lu hours, %lu minutes, %lu seconds", 
                 days, hours, minutes, seconds);
        return (*env)->NewStringUTF(env, uptime_str);
    }
    return (*env)->NewStringUTF(env, "Unknown");
#endif
}

// Optional: JNI_OnLoad function for library initialization
JNIEXPORT jint JNICALL JNI_OnLoad(JavaVM *vm, void *reserved) {
    printf("JNI SystemInfo library loaded successfully!\n");
    return JNI_VERSION_1_8;
}

// Optional: JNI_OnUnload function for library cleanup
JNIEXPORT void JNICALL JNI_OnUnload(JavaVM *vm, void *reserved) {
    printf("JNI SystemInfo library unloaded.\n");
} 