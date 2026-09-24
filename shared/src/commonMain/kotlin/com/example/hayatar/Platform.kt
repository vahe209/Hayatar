package com.example.hayatar

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform