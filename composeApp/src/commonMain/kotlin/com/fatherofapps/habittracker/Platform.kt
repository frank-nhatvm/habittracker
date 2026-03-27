package com.fatherofapps.habittracker

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform