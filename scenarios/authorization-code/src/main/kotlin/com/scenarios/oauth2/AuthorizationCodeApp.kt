package com.scenarios.oauth2

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class AuthorizationCodeApp

fun main(args: Array<String>) {
    runApplication<AuthorizationCodeApp>(*args)
}