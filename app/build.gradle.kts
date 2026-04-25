plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.github.jenish094.p_stream_androidtv"
    compileSdk {
        version = release(36)
    }

    defaultConfig {
        applicationId = "com.github.jenish094.p_stream_androidtv"
        minSdk = 23
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

    }
    signingConfigs {
        create("release") {
            val keystoreFile = file("release.jks")

            storeFile = keystoreFile
            storePassword = System.getenv("KEYSTORE_PASSWORD")
            keyAlias = System.getenv("KEY_ALIAS")
            keyPassword = System.getenv("KEY_PASSWORD")
        }
    }
    buildTypes {
        release {
            isMinifyEnabled = false
            signingConfig = signingConfigs.getByName("release")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation("androidx.appcompat:appcompat:1.6.1")
}