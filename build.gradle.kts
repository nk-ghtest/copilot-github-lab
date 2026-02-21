plugins {
    application
    java
}

repositories {
    mavenCentral()
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

application {
    mainClass.set("lab.App")
}

tasks.withType<JavaCompile>().configureEach {
    options.encoding = "UTF-8"
}
