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
android {

    signingConfigs {
        create("release") {
            val storePassword = System.getenv("KEYSTORE_PASSWORD")
                ?: throw GradleException("Missing KEYSTORE_PASSWORD")

            val keyAlias = System.getenv("KEY_ALIAS")
                ?: throw GradleException("Missing KEY_ALIAS")

            val keyPassword = System.getenv("KEY_PASSWORD")
                ?: throw GradleException("Missing KEY_PASSWORD")

            val keystorePath = System.getenv("KEYSTORE_PATH")
                ?: "app/release.jks"

            storeFile = file(keystorePath)
            this.storePassword = storePassword
            this.keyAlias = keyAlias
            this.keyPassword = keyPassword
        }
    }

    buildTypes {
        release {
            signingConfig = signingConfigs.getByName("release")
        }
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