@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
  alias(libs.plugins.com.android.application)
  alias(libs.plugins.org.jetbrains.kotlin.android)
  alias(libs.plugins.org.jetbrains.kotlin.parcelize)
  alias(libs.plugins.org.jetbrains.kotlin.kapt)
  alias(libs.plugins.com.google.dagger.hilt.android)
}

android {
  namespace = "com.ericampire.driveclone"
  compileSdk = 33

  defaultConfig {
    applicationId = "com.ericampire.driveclone"
    minSdk = 24
    targetSdk = 33
    versionCode = 1
    versionName = "1.0"

    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    vectorDrawables {
      useSupportLibrary = true
    }
  }

  buildTypes {
    release {
      isMinifyEnabled = false
      proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
    }
  }
  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
  }
  kotlinOptions {
    jvmTarget = "17"
  }
  buildFeatures {
    compose = true
  }
  composeOptions {
    kotlinCompilerExtensionVersion = "1.4.7"
  }
  packaging {
    resources {
      excludes += "/META-INF/{AL2.0,LGPL2.1}"
    }
  }
}

dependencies {

  implementation(libs.core.ktx)
  implementation(libs.lifecycle.runtime.ktx)
  implementation(libs.activity.compose)
  implementation(platform(libs.compose.bom))
  implementation(libs.ui)
  implementation(libs.ui.graphics)
  implementation(libs.ui.tooling.preview)
  implementation(libs.material3)
  implementation(libs.material3.window.size)

  implementation(libs.circuit)

  implementation(libs.hilt.android)
  kapt(libs.hilt.compiler)

  // Test
  testImplementation(libs.junit)
  testImplementation(libs.app.cash.turbine)
  testImplementation(libs.androidx.test.ext.junit)
  testImplementation(platform(libs.compose.bom))
  testImplementation(libs.ui.test.junit4)

  debugImplementation(libs.ui.tooling)
  debugImplementation(libs.ui.test.manifest)
}