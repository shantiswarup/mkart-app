package com.mkart.mkartapp.models.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason = "Product not found")
data class ProductNotFoundException(private val id: Long): RuntimeException("Product with id $id not found")