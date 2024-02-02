plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
}

android {
    namespace = "com.feylabs.core"
    compileSdk = 33

    defaultConfig {
        minSdk = 24

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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    implementation("androidx.core:core-ktx:1.7.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.8.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    // Kotlin Coroutines for asynchronous programming
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.1")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.2")



    // Fragment KTX for simplifying Fragment development
    api("androidx.fragment:fragment-ktx:1.5.0")

    // Room Dependencies
    api("androidx.room:room-runtime:2.4.2")
    api("androidx.room:room-ktx:2.4.2")
    kapt("androidx.room:room-compiler:2.4.2")

    // Picasso for loading and caching images
    api("com.squareup.picasso:picasso:2.8")
    api("com.github.bumptech.glide:glide:4.12.0")

    // Retrofit for making implementation requests
    api("com.squareup.retrofit2:retrofit:2.9.0")

    // Gson converter for Retrofit to handle JSON response data
    api("com.squareup.retrofit2:converter-gson:2.9.0")
    // OkHttp for handling HTTP requests and caching
    api("com.squareup.okhttp3:okhttp:4.9.2")

    api("com.jakewharton.timber:timber:4.7.1")

    // Interceptor
    api("com.squareup.okhttp3:logging-interceptor:4.7.2")

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-play-services:1.1.1")
}