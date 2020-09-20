import org.jetbrains.kotlin.gradle.dsl.KotlinJvmCompile

buildscript {
    repositories {
        mavenCentral()
        jcenter()
        google()
        maven { url = uri("https://repo.quickbirdstudios.com/artifactory/public") }
    }

    dependencies {
        classpath(Deps.Plugins.kotlin)
        classpath("com.google.gms:google-services:4.3.3")
//        classpath 'com.google.gms:google-services:4.3.3'
    }
}

allprojects {
    repositories {
        mavenCentral()
        jcenter()
        google()
    }

    tasks.withType(KotlinJvmCompile::class.java).all {
        kotlinOptions {
            jvmTarget = "1.8"
            freeCompilerArgs = listOf(
                "-Xuse-experimental=kotlin.Experimental",
                "-Xuse-experimental=kotlinx.coroutines.ObsoleteCoroutinesApi",
                "-Xuse-experimental=kotlinx.coroutines.ExperimentalCoroutinesApi",
                "-Xuse-experimental=kotlin.ExperimentalStdlibApi"
            )
        }
    }
}
