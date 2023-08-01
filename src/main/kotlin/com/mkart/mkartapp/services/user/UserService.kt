package com.mkart.mkartapp.services.user

import com.mkart.mkartapp.repos.user.UserEntity
import org.springframework.security.core.userdetails.UserDetailsService
import java.util.Optional

interface UserService: UserDetailsService {
    fun save(userEntity: UserEntity): UserEntity
    fun getById(id: Long): Optional<UserEntity>
    fun getUserCount(): Int
}