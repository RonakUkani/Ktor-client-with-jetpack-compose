plugins {
    alias(libs.plugins.androidLibrary)
}

android {
    namespace = "com.sample.networking"
}

dependencies {
    implementation(libs.networking.ktor.client.android)
    implementation(libs.networking.ktor.client.json)
    implementation(libs.networking.ktor.client.serialization)
    implementation(libs.networking.ktor.client.logging)
}