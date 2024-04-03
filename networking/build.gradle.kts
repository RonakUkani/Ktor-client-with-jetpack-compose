plugins {
    alias(libs.plugins.jetbrainsKotlinAndroid)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinSerialization)
}

android {
    namespace = "com.sample.networking"
    compileSdk = 34

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    implementation(libs.networking.ktor.client.android)
    implementation(libs.networking.ktor.client.json)
    implementation(libs.networking.ktor.client.serialization)
    implementation(libs.networking.ktor.client.logging)
    implementation(libs.koin.android)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.kotlinx.serialization.core)
}
