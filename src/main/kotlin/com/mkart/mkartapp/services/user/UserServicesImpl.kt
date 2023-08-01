package com.mkart.mkartapp.services.user

import com.mkart.mkartapp.repos.user.UserEntity
import com.mkart.mkartapp.repos.user.UserRepo
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import java.util.Optional

@Service
class UserServicesImpl(private val userRepo: UserRepo) : UserService {
    @Throws(IllegalArgumentException::class)
    override fun save(userEntity: UserEntity): UserEntity {
        try {
            return userRepo.save(userEntity.copy())
        } catch (e: Exception) {
            throw IllegalArgumentException(e.message)
        }

    }

    override fun getById(id: Long): Optional<UserEntity> {
        return userRepo.findById(id)
    }

    override fun getUserCount(): Int {
        return userRepo.findAll().count()
    }

    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(username: String?): UserDetails {
        val mayBeUser = username?.let { userRepo.findByUsername(it) }
        if (mayBeUser == null) {
            throw UsernameNotFoundException("Invalid username or password.")
        } else {
            return User(mayBeUser.username, mayBeUser.password, listOf(SimpleGrantedAuthority("user")))
        }
    }
}