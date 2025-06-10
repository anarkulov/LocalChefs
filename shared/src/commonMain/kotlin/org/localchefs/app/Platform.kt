package org.localchefs.app

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform