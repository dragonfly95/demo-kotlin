package com.example.demokotlin.blog

import org.springframework.data.jpa.repository.JpaRepository
import java.util.*
import kotlin.reflect.KClass

interface ArticleRepository: JpaRepository<Article, Long> {
    fun findBySlug(slug: String): Article?
    fun findAllByOrderByAddedAtDesc(): Iterable<Article>
}

//interface UserRepository: JpaRepository<User, Long> {
//    fun findByLogin(login1: String): UserInfo2 ?
//}
interface User2Repository : JpaRepository<User?, Long?> {
//    fun findByLogin(login: String?): User?
//    fun findAllBy(): List<UserInfo>
    fun <T> findAllProjectedBy(projectionClass: Class<T>?): Collection<T>

}

class UserInfo (
    val firstname: String,
    val lastname: String
        )