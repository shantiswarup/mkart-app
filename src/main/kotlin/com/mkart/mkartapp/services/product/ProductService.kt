package com.mkart.mkartapp.services.product

import com.mkart.mkartapp.repos.product.ProductEntity

interface ProductService {
    fun save(productEntity: ProductEntity): ProductEntity
    fun getById(id: Long): ProductEntity
}