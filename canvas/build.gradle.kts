/*
 * Copyright (c) 2023. JetBrains s.r.o.
 * Use of this source code is governed by the MIT license that can be found in the LICENSE file.
 */

plugins {
    kotlin("multiplatform")
}

val kotlinLoggingVersion = extra["kotlinLogging_version"] as String

kotlin {
    js() {
        browser {}
    }

    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":commons"))
                implementation(project(":datamodel"))
                
                implementation("io.github.microutils:kotlin-logging:$kotlinLoggingVersion")
            }
        }
    }
}