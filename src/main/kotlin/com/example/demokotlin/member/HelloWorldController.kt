package com.example.demokotlin.member

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloWorldController {

    @RequestMapping("/")
    fun home(): String {
        return "Hello, world";
    }
}