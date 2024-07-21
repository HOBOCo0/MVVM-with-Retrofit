plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    id("kotlin-kapt")
}

android {
    namespace = "com.example.mvvm_rrtrofit_room"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.mvvm_rrtrofit_room"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    //coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.9.0-RC")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.9.0-RC")

    // retrofit
    implementation ("com.squareup.retrofit2:retrofit:2.11.0")
    // gson convertor
    implementation ("com.squareup.retrofit2:converter-gson:2.11.0")

    val lifecycle_version = "2.8.3"

    // ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version")
    // to use live data
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version")

    val room_version = "2.6.1"
    // for room-DB
    implementation("androidx.room:room-runtime:$room_version")
    //Kotlin Extensions and Coroutines support for Room
    implementation("androidx.room:room-ktx:$room_version")
    // for kapt (this is an annotation processor )
    kapt("androidx.room:room-compiler:$room_version")
}