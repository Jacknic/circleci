// gradle转kts参考 https://github.com/gradle/kotlin-dsl/tree/master/samples/hello-android
buildscript {
    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:3.4.0")
        classpath(kotlin("gradle-plugin", "1.3.21"))
    }
}


allprojects {
    repositories {
        google()
        jcenter()
    }
}

