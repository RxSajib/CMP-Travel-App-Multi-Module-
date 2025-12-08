plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidKotlinMultiplatformLibrary)
    alias(libs.plugins.androidLint)
}

kotlin {
    jvm()
    // Target declarations - add or remove as needed below. These define
    // which platforms this KMP module supports.
    // See: https://kotlinlang.org/docs/multiplatform-discover-project.html#targets
    androidLibrary {
        namespace = "com.sajib.presentation"
        compileSdk = 36
        minSdk = 24

        withHostTestBuilder {
        }

        withDeviceTestBuilder {
            sourceSetTreeName = "test"
        }.configure {
            instrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        }
    }

    listOf(
        iosArm64(),
        iosSimulatorArm64()
    ).forEach{ iosTarget ->
        iosTarget.binaries.framework {
            baseName = "presentation"
            isStatic = true
        }
    }


    sourceSets {
        val commonMain by getting
        val androidMain by getting
        val jvmMain by getting   // ← Add JVM source set
        val iosMain by creating {
            dependsOn(commonMain)
        }
        commonMain {
            dependencies {
                implementation(libs.kotlin.stdlib)

                implementation(project(":domain"))
                implementation(libs.kotlinx.coroutines.core)
                implementation(libs.androidx.lifecycle.viewmodelCompose)
            }
        }
    }

}