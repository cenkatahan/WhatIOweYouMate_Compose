buildscript {

    dependencies {
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.51")
    }
}

// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.1.1" apply false
    id("org.jetbrains.kotlin.android") version "1.8.10" apply false
    id("com.google.dagger.hilt.android") version Version.hilt_version apply false
    id("androidx.room") version Version.room_version apply false
}
