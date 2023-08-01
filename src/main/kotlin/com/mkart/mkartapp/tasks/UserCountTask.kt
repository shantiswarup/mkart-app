package com.mkart.mkartapp.tasks

import com.mkart.mkartapp.services.user.UserService
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.runBlocking
import org.springframework.scheduling.annotation.Async
import org.springframework.scheduling.annotation.EnableAsync
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

//@EnableAsync
//@EnableScheduling
//@Component
//class UserCountTask(private val userService: UserService) {
//    @Async
//    @Scheduled(fixedDelay = 3000)
//    fun task() {
//        runBlocking {
//            run()
//        }
//    }
//
//    suspend fun run() = coroutineScope {
//        println(userService.getUserCount())
//    }
//}