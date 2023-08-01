package com.mkart.mkartapp.models.dtos

data class CreateUserDto(
    val firstName: String,
    val lastName: String,
    val username: String,
    val password: String,
    val email: String
)