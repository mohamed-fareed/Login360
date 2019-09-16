object Config {
    val minSdk = 15
    val compileSdk = 29
    val targetSdk = 29
    val buildToolsVersion = "29.0.1"
}

object Versions {
    // tools
    val kotlin = "1.3.50"
    val gradleandroid = "3.5.0"

    // google
    val androidx_core = "1.1.0"
    val androidx_appcompat = "1.1.0"
    val androidx_constraintlayout = "1.1.3"
    val androidx_material = "1.0.0-rc01"
    val androidx_lifecycle = "2.2.0-alpha01"

    // testing
    val junit = "4.12"
    val androidx_runner = "1.2.0"
    val androidx_espresso = "3.2.0"

    // retrofit
    val retrofit = "2.6.1"
    val logging_interceptor = "4.0.1"

    // Rx
    val rx_java = "2.2.12"
    val rx_android = "2.1.1"

    // room
    val room_version = "2.1.0"

    // koin
    val koin_version = "2.0.1"
}

object Deps {
    val tools_gradleandroid = "com.android.tools.build:gradle:${Versions.gradleandroid}"
    val tools_kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    val kotlin_stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"

    val androidx_core = "androidx.core:core-ktx:${Versions.androidx_core}"
    val androidx_appcompat = "androidx.appcompat:appcompat:${Versions.androidx_appcompat}"
    val androidx_constraintlayout =
        "androidx.constraintlayout:constraintlayout:${Versions.androidx_constraintlayout}"
    val androidx_material = "com.google.android.material:material:${Versions.androidx_material}"
    val androidx_lifecycle =
        "androidx.lifecycle:lifecycle-extensions:${Versions.androidx_lifecycle}"
    val androidx_viewmodel =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.androidx_lifecycle}"

    val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    val retrofit_rxjava_adapter = "com.squareup.retrofit2:adapter-rxjava2:${Versions.retrofit}"
    val gson_converter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    val logging_interceptor =
        "com.squareup.okhttp3:logging-interceptor:${Versions.logging_interceptor}"

    val rx_java = "io.reactivex.rxjava2:rxjava:${Versions.rx_java}"
    val rx_android = "io.reactivex.rxjava2:rxandroid:${Versions.rx_android}"

    val koin = "org.koin:koin-android:${Versions.koin_version}"
    val koin_scope = "org.koin:koin-androidx-scope:${Versions.koin_version}"
    val koin_viewmodel = "org.koin:koin-androidx-viewmodel:${Versions.koin_version}"

    val room = "androidx.room:room-runtime:${Versions.room_version}"
    val room_processor = "androidx.room:room-compiler:${Versions.room_version}"
    val room_ktx = "androidx.room:room-ktx:${Versions.room_version}"

    val testlib_junit = "junit:junit:${Versions.junit}"
    val testandroidx_runner = "androidx.test:runner:${Versions.androidx_runner}"
    val testandroidx_espresso = "androidx.test.espresso:espresso-core:${Versions.androidx_espresso}"
}