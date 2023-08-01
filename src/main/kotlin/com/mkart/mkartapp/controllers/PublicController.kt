package com.mkart.mkartapp.controllers

import com.mkart.mkartapp.models.dtos.CreateUserDto
import com.mkart.mkartapp.repos.user.UserEntity
import com.mkart.mkartapp.services.user.UserServicesImpl
import org.springframework.http.ResponseEntity
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/public")
class PublicController(private val userServices: UserServicesImpl, private val passwordEncoder: PasswordEncoder) {
    @PostMapping("/user")
    fun save(@RequestBody dto: CreateUserDto): ResponseEntity<String> {
        return try {
            val resp = userServices.save(
                UserEntity(
                    id = null,
                    firstName = dto.firstName,
                    lastName = dto.lastName,
                    username = dto.username,
                    password = passwordEncoder.encode(dto.password),
                    email = dto.email
                )
            )
            ResponseEntity.ok().body("User saved with id ${resp.id}")
        } catch (e: IllegalArgumentException) {
            ResponseEntity.badRequest().body(e.localizedMessage)
        } catch (e: Exception) {
            ResponseEntity.internalServerError().body(e.localizedMessage)
        }
    }
}