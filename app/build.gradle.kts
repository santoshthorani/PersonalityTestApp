plugins {
    id("com.android.application")
    kotlin("android")
    id("androidx.navigation.safeargs.kotlin")
    id("kotlin-android-extensions")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = ConfigData.compileSdkVersion

    defaultConfig {
        minSdk = ConfigData.minSdkVersion
        targetSdk = ConfigData.targetSdkVersion
        versionCode = ConfigData.versionCode
        versionName = ConfigData.versionName
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        signingConfig = signingConfigs.getByName("debug")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        debug {
            applicationIdSuffix = ".debug"
            versionNameSuffix = "-DEV"
            isDebuggable = true
        }
        create("staging") {
            applicationIdSuffix = ".staging"
            versionNameSuffix = "-STG"
            isDebuggable = true
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    // other modules
    implementation(project(":presentation-layer"))
    implementation(project(":domain-layer"))
    implementation(project(":data-layer"))

    implementation(Deps.kotlin)
    implementation(Deps.appCompat)
    implementation(Deps.materialDesign)
    implementation(Deps.constraintLayout)

    // Dependencies for Android Support
    implementation(Deps.materialDesign)
    implementation(Deps.constraintLayout)
    implementation(Deps.annotation)
    implementation(Deps.legacySupport)
    implementation(Deps.recyclerView)
    implementation(Deps.cardView)
    implementation(Deps.ktxCore)
    implementation(Deps.viewBinding)

    // Dependencies for Room
    implementation(Room.runtime)
    implementation(Room.ktx)
    kapt(Room.compiler)
    annotationProcessor(Room.compiler)

    // Dependencies for Hilt
    implementation(Hilt.hilt)
    implementation(Hilt.hiltNavigationGraph)
    kapt(Hilt.hiltCompiler)
    kapt(Hilt.hiltAndroidXCompiler)
    implementation(Hilt.hiltWorker)

    // Dependencies for Testing
    testImplementation(Testing.jUnit)
    androidTestImplementation(Testing.extJUnit)
//    testImplementation(Testing.jUnit)
//    testImplementation(Testing2.mockitoCore)
//    androidTestImplementation(Testing2.testRunner)
//    androidTestImplementation(Testing2.mockito)
//    androidTestImplementation(Testing2.espresso)

    // Ktx
    implementation(Deps.fragmentKtx)

    // Anko
    implementation(KotlinAnko.anko)

    //ViewModel and LifeCycle
    implementation(ViewModelLifeCycle.lifeCycleCommonJava)
    implementation(ViewModelLifeCycle.lifCycleViewModel)
    implementation(ViewModelLifeCycle.lifeCycleLiveData)
    implementation(ViewModelLifeCycle.lifeCycleRuntime)

    //Navigation component
    implementation(Navigation.navigationFrg)
    implementation(Navigation.navigationUI)
    implementation(Navigation.navigationFrgKtx)
    implementation(Navigation.navigationUIKtx)
    implementation(Navigation.navigationDynFeature)

    //Intuit
    implementation(Intuit.sdp)
    implementation(Intuit.ssp)

    implementation(Deps.gson)
}