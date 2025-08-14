#include <jni.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "HelloJNI.h"

// Implementation of native method sayHello()
JNIEXPORT void JNICALL Java_HelloJNI_sayHello(JNIEnv *env, jobject obj) {
    printf("Hello from C! This is a native method call.\n");
}

// Implementation of native method add()
JNIEXPORT jint JNICALL Java_HelloJNI_add(JNIEnv *env, jobject obj, jint a, jint b) {
    printf("Adding %d + %d in native code\n", a, b);
    return a + b;
}

// Implementation of native method getMessage()
JNIEXPORT jstring JNICALL Java_HelloJNI_getMessage(JNIEnv *env, jobject obj) {
    const char *message = "Hello from native C code!";
    return (*env)->NewStringUTF(env, message);
}

// Implementation of native method printArray()
JNIEXPORT void JNICALL Java_HelloJNI_printArray(JNIEnv *env, jobject obj, jintArray array) {
    jsize length = (*env)->GetArrayLength(env, array);
    jint *elements = (*env)->GetIntArrayElements(env, array, NULL);
    
    printf("Array from Java (length: %d): ", length);
    for (int i = 0; i < length; i++) {
        printf("%d ", elements[i]);
    }
    printf("\n");
    
    // Release the array elements
    (*env)->ReleaseIntArrayElements(env, array, elements, JNI_ABORT);
}

// Implementation of native method createArray()
JNIEXPORT jintArray JNICALL Java_HelloJNI_createArray(JNIEnv *env, jobject obj, jint size) {
    jintArray result = (*env)->NewIntArray(env, size);
    jint *elements = (*env)->GetIntArrayElements(env, result, NULL);
    
    // Fill the array with values
    for (int i = 0; i < size; i++) {
        elements[i] = (i + 1) * 10; // Create values: 10, 20, 30, ...
    }
    
    // Commit the changes back to the Java array
    (*env)->ReleaseIntArrayElements(env, result, elements, 0);
    
    printf("Created array of size %d in native code\n", size);
    return result;
}

// Implementation of native method calculateAverage()
JNIEXPORT jdouble JNICALL Java_HelloJNI_calculateAverage(JNIEnv *env, jobject obj, jdoubleArray numbers) {
    jsize length = (*env)->GetArrayLength(env, numbers);
    jdouble *elements = (*env)->GetDoubleArrayElements(env, numbers, NULL);
    
    double sum = 0.0;
    for (int i = 0; i < length; i++) {
        sum += elements[i];
    }
    
    double average = sum / length;
    
    printf("Calculated average of %d numbers in native code\n", length);
    
    // Release the array elements
    (*env)->ReleaseDoubleArrayElements(env, numbers, elements, JNI_ABORT);
    
    return average;
}

// Optional: JNI_OnLoad function for library initialization
JNIEXPORT jint JNICALL JNI_OnLoad(JavaVM *vm, void *reserved) {
    printf("JNI library loaded successfully!\n");
    return JNI_VERSION_1_8;
}

// Optional: JNI_OnUnload function for library cleanup
JNIEXPORT void JNICALL JNI_OnUnload(JavaVM *vm, void *reserved) {
    printf("JNI library unloaded.\n");
} 