package com.mkart.mkartapp.repos.user

import com.mkart.mkartapp.repos.user.UserEntity.Companion.COL_EMAIL
import com.mkart.mkartapp.repos.user.UserEntity.Companion.COL_USER_NAME
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import jakarta.persistence.UniqueConstraint


@Entity
@Table(
    name = "users",
    uniqueConstraints = [UniqueConstraint(columnNames = arrayOf(COL_USER_NAME, COL_EMAIL))]
    )
data class UserEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long?,
    @Column(name = COL_FIRST_NAME, nullable = false) val firstName: String,
    @Column(name = COL_LAST_NAME, nullable = false) val lastName: String,
    @Column(name = COL_USER_NAME, nullable = false) val username: String,
    @Column(name = COL_PASSWORD, nullable = false) val password: String,
    @Column(name = COL_EMAIL, nullable = false) val email: String,
) {
    companion object {
        const val COL_USER_NAME = "username"
        const val COL_EMAIL = "email"
        const val COL_FIRST_NAME = "first_name"
        const val COL_LAST_NAME = "last_name"
        const val COL_PASSWORD = "password"
    }
}