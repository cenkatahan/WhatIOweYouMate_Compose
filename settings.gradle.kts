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

rootProject.name = "WhatIOweYouMate_Compose"
include(":app")
include(":core")
include(":feature")
include(":feature:home")
include(":feature:add")
include(":feature:update")
include(":feature:summary")
