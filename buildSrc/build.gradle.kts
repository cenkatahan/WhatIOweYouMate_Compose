plugins {
    `kotlin-dsl`
    id("com.google.dagger.hilt.android") version "2.44" apply false
}

repositories {
    google()
    mavenCentral()
}

//dependencies {
//    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.8.10")
//    implementation("com.android.tools.build:gradle:8.1.1")
//}