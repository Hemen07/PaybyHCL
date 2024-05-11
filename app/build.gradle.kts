plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.devtools.ksp")
    id("kotlin-parcelize")
    id("com.google.dagger.hilt.android")
//    id("org.jetbrains.kotlinx.kover")
}

android {
    namespace = "com.hcl.hclpaybay"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.hcl.hclpaybay"
        minSdk = 28
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

    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")


    // don't you need by viewModels()
    implementation("androidx.activity:activity-ktx:1.9.0")

    // TODO - This part we gonna explore, long time
    val lifecycleVersion = "2.7.0"
    // this one is for viewmodelscope
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycleVersion")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycleVersion")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:$lifecycleVersion")

    // retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    // retrofit-converter-moshi
    implementation("com.squareup.retrofit2:converter-moshi:2.9.0")
    // OkHttp interceptors
    implementation("com.squareup.okhttp3:logging-interceptor:4.11.0")

    // moshi and codegen
    implementation("com.squareup.moshi:moshi-kotlin:1.15.1")
    ksp("com.squareup.moshi:moshi-kotlin-codegen:1.15.1")
    // we may not even need this
    implementation("com.squareup.moshi:moshi-adapters:1.15.1")

    // room
    val roomVersion = "2.6.1"
    implementation("androidx.room:room-runtime:$roomVersion")
    implementation("androidx.room:room-ktx:$roomVersion")
    ksp("androidx.room:room-compiler:$roomVersion")


    // HILT
    implementation("com.google.dagger:hilt-android:2.51")
    ksp("com.google.dagger:hilt-android-compiler:2.51")
    ksp("androidx.hilt:hilt-compiler:1.2.0")


    // mockk - kotlin
    val mockkVersion = "1.13.9"
    testImplementation("io.mockk:mockk:${mockkVersion}")
    // sticking to Junit 4
    testImplementation("junit:junit:4.13.2")
    testImplementation("org.mockito:mockito-core:4.11.0")
    testImplementation("org.mockito.kotlin:mockito-kotlin:4.1.0")

    // coroutine, Test dispatchers, or main thread exception in test
    val coroutinesTestVersion = "1.7.3"
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:$coroutinesTestVersion")
    testImplementation("androidx.arch.core:core-testing:2.2.0")
}