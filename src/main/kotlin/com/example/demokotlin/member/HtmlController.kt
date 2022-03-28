package com.example.demokotlin.member

import com.example.demokotlin.blog.*
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import kotlin.random.Random


@Controller
class HtmlController (
    val userRepository: User2Repository,
    val articleRepository: ArticleRepository
        ) {

    @GetMapping("blog")
    fun blog(model: Model) : String {
        model["title"] = "blog"

        val nextInt = Random(1000).nextInt()
        val user = User("springjuergen" + nextInt,
            "juergen" + nextInt,
            "Heller" + nextInt,
            ""
            )


        userRepository.save(user);

        val findByLogin = userRepository.findAllProjectedBy(UserInfo::class.java)
        for (userInfo in findByLogin) {
            println("userRepository = ${userInfo.firstname}")
            println("userRepository = ${userInfo.lastname}")
        }

        return "blog"
    }
}
