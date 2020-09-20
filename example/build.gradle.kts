plugins {
    id("com.android.application")
    kotlin("android")
    id("org.jetbrains.kotlin.android.extensions")
    id("com.google.gms.google-services")
}

androidExtensions { isExperimental = true }

android {
    compileSdkVersion(Project.Android.compileSdkVersion)

    defaultConfig {
        versionName = Library.version
        versionCode = 1
        minSdkVersion(Project.Android.minSdkVersion)
        targetSdkVersion(Project.Android.targetSdkVersion)
        testInstrumentationRunner = Project.Android.testInstrumentationRunner
    }
    packagingOptions {
        exclude("META-INF/*kotlin*")
    }
}

dependencies {
    implementation(project(":survey"))

    /* Kotlin */
    implementation(Deps.Kotlin.stdlib)
    implementation(Deps.Kotlin.reflect)
    implementation(Deps.Kotlin.coroutines)

    /* Android Support */
    implementation(Deps.AndroidSupport.appCompat)
    implementation(Deps.AndroidSupport.constraint)
    implementation("com.google.firebase:firebase-firestore-ktx:21.6.0")
    implementation("com.google.firebase:firebase-database-ktx:19.4.0")
}
