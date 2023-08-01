package com.mkart.mkartapp.controllers

import com.mkart.mkartapp.repos.user.UserEntity
import com.mkart.mkartapp.services.user.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/user")
class UserController(private val userServices: UserService) {

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): ResponseEntity<UserEntity> {
        return userServices.getById(id).map {
            ResponseEntity.ok().body(it)
        }.orElse(ResponseEntity.notFound().build())
    }
}