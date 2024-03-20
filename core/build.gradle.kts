plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "com.ata.core"
    compileSdk = 34

    defaultConfig {
        minSdk = 29

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

kapt {
    correctErrorTypes = true
}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")

    api(Dependency.lifecycle_runtime)
    api(Dependency.compose_activity)
    api(platform(Dependency.compose_bom))
    api(Dependency.compose_ui)
    api(Dependency.compose_ui_graphics)
    api(Dependency.compose_ui_tooling_preview)
    api(Dependency.materil3)
    androidTestApi(Dependency.espresso)
    androidTestApi(platform(Dependency.compose_bom))
    androidTestApi(Dependency.jUnit)
    debugApi(Dependency.dbg_compose_ui_tooling)
    debugApi(Dependency.dbg_compose_ui_test_manifest)


    api(Dependency.nav_ui_ktx)
    api(Dependency.nav_fragment_ktx)
    api(Dependency.nav_dynamic)
    api(Dependency.nav_compose)

    api(Dependency.room_runtime)
    annotationProcessor(Dependency.room_compiler)
    kapt(Dependency.room_compiler_kapt)

    api(Dependency.hilt)
    kapt(Dependency.hilt_compiler)
    api(Dependency.hilt_nav)

    api(Dependency.material_extended)

}