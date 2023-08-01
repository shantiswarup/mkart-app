package com.mkart.mkartapp.repos.user

import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepo : CrudRepository<UserEntity, Long> {
    @Query("SELECT u from UserEntity u where u.username=?1")
    fun findByUsername(username: String): UserEntity?
}