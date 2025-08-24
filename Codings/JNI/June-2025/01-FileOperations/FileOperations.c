#include <jni.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/stat.h>
#include <dirent.h>
#include <unistd.h>
#include "FileOperations.h"

#ifdef _WIN32
#include <windows.h>
#include <direct.h>
#define PATH_SEPARATOR "\\"
#else
#define PATH_SEPARATOR "/"
#endif

// Implementation of native method createFile()
JNIEXPORT jboolean JNICALL Java_FileOperations_createFile(JNIEnv *env, jobject obj, jstring filename) {
    const char *native_filename = (*env)->GetStringUTFChars(env, filename, 0);
    
    FILE *file = fopen(native_filename, "w");
    jboolean result = (file != NULL) ? JNI_TRUE : JNI_FALSE;
    
    if (file != NULL) {
        fclose(file);
        printf("Created file: %s\n", native_filename);
    } else {
        printf("Failed to create file: %s\n", native_filename);
    }
    
    (*env)->ReleaseStringUTFChars(env, filename, native_filename);
    return result;
}

// Implementation of native method writeToFile()
JNIEXPORT jboolean JNICALL Java_FileOperations_writeToFile(JNIEnv *env, jobject obj, jstring filename, jstring content) {
    const char *native_filename = (*env)->GetStringUTFChars(env, filename, 0);
    const char *native_content = (*env)->GetStringUTFChars(env, content, 0);
    
    FILE *file = fopen(native_filename, "w");
    if (file == NULL) {
        printf("Failed to open file for writing: %s\n", native_filename);
        (*env)->ReleaseStringUTFChars(env, filename, native_filename);
        (*env)->ReleaseStringUTFChars(env, content, native_content);
        return JNI_FALSE;
    }
    
    size_t written = fwrite(native_content, 1, strlen(native_content), file);
    fclose(file);
    
    jboolean result = (written == strlen(native_content)) ? JNI_TRUE : JNI_FALSE;
    printf("Written %zu bytes to file: %s\n", written, native_filename);
    
    (*env)->ReleaseStringUTFChars(env, filename, native_filename);
    (*env)->ReleaseStringUTFChars(env, content, native_content);
    return result;
}

// Implementation of native method readFromFile()
JNIEXPORT jstring JNICALL Java_FileOperations_readFromFile(JNIEnv *env, jobject obj, jstring filename) {
    const char *native_filename = (*env)->GetStringUTFChars(env, filename, 0);
    
    FILE *file = fopen(native_filename, "r");
    if (file == NULL) {
        printf("Failed to open file for reading: %s\n", native_filename);
        (*env)->ReleaseStringUTFChars(env, filename, native_filename);
        return (*env)->NewStringUTF(env, "Error: Could not open file");
    }
    
    // Get file size
    fseek(file, 0, SEEK_END);
    long file_size = ftell(file);
    fseek(file, 0, SEEK_SET);
    
    // Read file content
    char *buffer = (char *)malloc(file_size + 1);
    if (buffer == NULL) {
        fclose(file);
        (*env)->ReleaseStringUTFChars(env, filename, native_filename);
        return (*env)->NewStringUTF(env, "Error: Memory allocation failed");
    }
    
    size_t read_size = fread(buffer, 1, file_size, file);
    buffer[read_size] = '\0';
    fclose(file);
    
    printf("Read %zu bytes from file: %s\n", read_size, native_filename);
    
    jstring result = (*env)->NewStringUTF(env, buffer);
    free(buffer);
    
    (*env)->ReleaseStringUTFChars(env, filename, native_filename);
    return result;
}

// Implementation of native method appendToFile()
JNIEXPORT jboolean JNICALL Java_FileOperations_appendToFile(JNIEnv *env, jobject obj, jstring filename, jstring content) {
    const char *native_filename = (*env)->GetStringUTFChars(env, filename, 0);
    const char *native_content = (*env)->GetStringUTFChars(env, content, 0);
    
    FILE *file = fopen(native_filename, "a");
    if (file == NULL) {
        printf("Failed to open file for appending: %s\n", native_filename);
        (*env)->ReleaseStringUTFChars(env, filename, native_filename);
        (*env)->ReleaseStringUTFChars(env, content, native_content);
        return JNI_FALSE;
    }
    
    size_t written = fwrite(native_content, 1, strlen(native_content), file);
    fclose(file);
    
    jboolean result = (written == strlen(native_content)) ? JNI_TRUE : JNI_FALSE;
    printf("Appended %zu bytes to file: %s\n", written, native_filename);
    
    (*env)->ReleaseStringUTFChars(env, filename, native_filename);
    (*env)->ReleaseStringUTFChars(env, content, native_content);
    return result;
}

// Implementation of native method getFileSize()
JNIEXPORT jlong JNICALL Java_FileOperations_getFileSize(JNIEnv *env, jobject obj, jstring filename) {
    const char *native_filename = (*env)->GetStringUTFChars(env, filename, 0);
    
    struct stat file_stat;
    jlong size = -1;
    
    if (stat(native_filename, &file_stat) == 0) {
        size = (jlong)file_stat.st_size;
        printf("File size: %ld bytes\n", size);
    } else {
        printf("Failed to get file size: %s\n", native_filename);
    }
    
    (*env)->ReleaseStringUTFChars(env, filename, native_filename);
    return size;
}

// Implementation of native method deleteFile()
JNIEXPORT jboolean JNICALL Java_FileOperations_deleteFile(JNIEnv *env, jobject obj, jstring filename) {
    const char *native_filename = (*env)->GetStringUTFChars(env, filename, 0);
    
    int result = remove(native_filename);
    jboolean success = (result == 0) ? JNI_TRUE : JNI_FALSE;
    
    if (success) {
        printf("Deleted file: %s\n", native_filename);
    } else {
        printf("Failed to delete file: %s\n", native_filename);
    }
    
    (*env)->ReleaseStringUTFChars(env, filename, native_filename);
    return success;
}

// Implementation of native method fileExists()
JNIEXPORT jboolean JNICALL Java_FileOperations_fileExists(JNIEnv *env, jobject obj, jstring filename) {
    const char *native_filename = (*env)->GetStringUTFChars(env, filename, 0);
    
    struct stat file_stat;
    jboolean exists = (stat(native_filename, &file_stat) == 0) ? JNI_TRUE : JNI_FALSE;
    
    printf("File %s: %s\n", native_filename, exists ? "exists" : "does not exist");
    
    (*env)->ReleaseStringUTFChars(env, filename, native_filename);
    return exists;
}

// Implementation of native method listDirectory()
JNIEXPORT jobjectArray JNICALL Java_FileOperations_listDirectory(JNIEnv *env, jobject obj, jstring path) {
    const char *native_path = (*env)->GetStringUTFChars(env, path, 0);
    
    DIR *dir = opendir(native_path);
    if (dir == NULL) {
        printf("Failed to open directory: %s\n", native_path);
        (*env)->ReleaseStringUTFChars(env, path, native_path);
        return NULL;
    }
    
    // Count files in directory
    int count = 0;
    struct dirent *entry;
    while ((entry = readdir(dir)) != NULL) {
        count++;
    }
    rewinddir(dir);
    
    // Create Java string array
    jobjectArray result = (*env)->NewObjectArray(env, count, (*env)->FindClass(env, "java/lang/String"), NULL);
    if (result == NULL) {
        closedir(dir);
        (*env)->ReleaseStringUTFChars(env, path, native_path);
        return NULL;
    }
    
    // Fill array with file names
    int index = 0;
    while ((entry = readdir(dir)) != NULL && index < count) {
        jstring filename = (*env)->NewStringUTF(env, entry->d_name);
        (*env)->SetObjectArrayElement(env, result, index, filename);
        index++;
    }
    
    closedir(dir);
    printf("Listed %d items in directory: %s\n", count, native_path);
    
    (*env)->ReleaseStringUTFChars(env, path, native_path);
    return result;
}

// Optional: JNI_OnLoad function for library initialization
JNIEXPORT jint JNICALL JNI_OnLoad(JavaVM *vm, void *reserved) {
    printf("JNI FileOperations library loaded successfully!\n");
    return JNI_VERSION_1_8;
}

// Optional: JNI_OnUnload function for library cleanup
JNIEXPORT void JNICALL JNI_OnUnload(JavaVM *vm, void *reserved) {
    printf("JNI FileOperations library unloaded.\n");
} 