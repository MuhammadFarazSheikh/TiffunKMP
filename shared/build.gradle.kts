import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidMultiplatformLibrary)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
    alias(libs.plugins.kotlinSerialization)
    id("org.jetbrains.kotlin.native.cocoapods")
}

group = "com.androidengineer.tiffunapp"
version = "1.0-SNAPSHOT"

compose.resources {
    packageOfResClass = "tiffunapp.shared.generated.resources"
}

kotlin {
    cocoapods {
        summary = "Shared module"
        homepage = "https://github.com/your-repo"
        ios.deploymentTarget = "15.0" // Ensure this matches your iOS project
        podfile = project.file("../iosApp/Podfile")

        framework {
            baseName = "Shared"
            isStatic = true
        }

        pod("GoogleMaps") {
            version = "9.0.0"
        }
    }

    listOf(
        iosArm64(),
        iosSimulatorArm64()
    )
    
    androidLibrary {
       namespace = "com.androidengineer.tiffunapp.shared"
       compileSdk = libs.versions.android.compileSdk.get().toInt()
       minSdk = libs.versions.android.minSdk.get().toInt()
    
       compilerOptions {
           jvmTarget = JvmTarget.JVM_11
       }
       androidResources {
           enable = true
       }
       withHostTest {
           isIncludeAndroidResources = true
       }
    }
    
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(libs.compose.runtime)
                implementation(libs.compose.foundation)
                implementation(libs.compose.material3)
                implementation(libs.compose.ui)
                implementation(libs.compose.components.resources)
                implementation(libs.compose.uiToolingPreview)
                implementation(libs.androidx.lifecycle.viewmodelCompose)
                implementation(libs.androidx.lifecycle.runtimeCompose)
                implementation(libs.komposecountrycodepicker)
                implementation(libs.navigation.compose)
                implementation(libs.kotlinx.serialization.json)
                implementation(libs.kmp.maps.compose)
                implementation(libs.ktor.client.core)
                implementation(libs.ktor.client.content.negotiation)
                implementation(libs.ktor.serialization.kotlinx.json)
                implementation(libs.koin.core)
                implementation(libs.koin.compose)
                implementation(libs.koin.compose.viewmodel)
            }
        }

        val androidMain by getting {
            dependencies {
                implementation(libs.ktor.client.cio)
            }
        }

        val iosMain by creating {
            dependsOn(commonMain)
            dependencies {
                implementation(libs.ktor.client.darwin)
            }
        }
        val iosArm64Main by getting {
            dependsOn(iosMain)
        }
        val iosSimulatorArm64Main by getting {
            dependsOn(iosMain)
        }
    }
}

dependencies {
    androidRuntimeClasspath(libs.compose.uiTooling)
}