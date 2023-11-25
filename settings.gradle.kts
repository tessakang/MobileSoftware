pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "MobileSoftware"
include(":app")
include(":note10")
include(":practice01")
include(":app:note07")
include(":practice01:lab11")
include(":lab11")
include(":lab03")
include(":lab03_1")
include(":lab03_2")
include(":mobilesoftware_12")
