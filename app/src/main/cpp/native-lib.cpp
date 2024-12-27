#include <jni.h>
#include <string>
#include <opencv2/opencv.hpp>
#include <android/log.h>

extern "C"
JNIEXPORT jboolean JNICALL
Java_com_example_nativeapp_MainActivity_initOpenCVSDK(JNIEnv *env, jobject thiz) {
    try {
        const std::string& buildInfo =cv::getBuildInformation();
        __android_log_print(ANDROID_LOG_DEBUG,"OpenCV","Build Info is %s",buildInfo.c_str());
        return JNI_TRUE;
    }
    catch(const cv::Exception& e) {
        __android_log_print(ANDROID_LOG_ERROR, "OpenCV", "Failure while initialising OpenCVSDK .%s",e.err.c_str());
        return JNI_FALSE;
    }
}