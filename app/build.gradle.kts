import org.jetbrains.kotlin.config.KotlinCompilerVersion

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
}

// Android Plugin DSL Reference  https://google.github.io/android-gradle-dsl/current/
android {
    compileSdkVersion(28)
    defaultConfig {
        applicationId = "com.jacknic.circleci"
        minSdkVersion(19)
        targetSdkVersion(28)
        versionCode = 1
        // 语义化版本 2.0.0 | Semantic Versioning  https://semver.org/lang/zh-CN/
        versionName = "0.1.0"
        // 定义输出apk文件名
        setProperty("archivesBaseName", "$applicationId-v$versionName")
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    packagingOptions {
        exclude("kotlin/**")
        exclude("META-INF/**")
    }

    // release签名配置
    signingConfigs.register("release", {
        // 需要配置环境变量windows下 set KEY_PASSWORD=123456;*nix KEY_PASSWORD=123456
        // gradlew.bat assembleRelease
        val pwd = System.getenv("KEY_PASSWORD")
        // 简便操作这里设置成相同的密码，以下属性均可以配置成环境变量或jvm属性
        keyAlias = "key"
        keyPassword = pwd
        storePassword = pwd
        storeFile = File(project.rootDir, "keystore.jks")
    })

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
            signingConfig = signingConfigs["release"]
        }
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to "*.jar")))
    implementation(kotlin("stdlib-jdk7", KotlinCompilerVersion.VERSION))
    implementation("androidx.appcompat:appcompat:1.0.2")
    implementation("androidx.core:core-ktx:1.0.1")
    implementation("androidx.constraintlayout:constraintlayout:1.1.3")

    testImplementation("junit:junit:4.12")
    androidTestImplementation("androidx.test.ext:junit:1.1.0")
    androidTestImplementation("androidx.test:runner:1.1.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.1.1")
}
