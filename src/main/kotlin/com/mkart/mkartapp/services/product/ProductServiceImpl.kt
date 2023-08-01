package com.mkart.mkartapp.services.product

import com.mkart.mkartapp.models.exceptions.ProductNotFoundException
import com.mkart.mkartapp.repos.product.ProductEntity
import com.mkart.mkartapp.repos.product.ProductRepo
import org.springframework.stereotype.Service
import kotlin.jvm.Throws

@Service
class ProductServiceImpl(private val productRepo: ProductRepo) : ProductService {
    override fun save(productEntity: ProductEntity): ProductEntity {
        return productRepo.save(productEntity)
    }

    @Throws(ProductNotFoundException::class)
    override fun getById(id: Long): ProductEntity {
        val maybeProduct = productRepo.findById(id)
        if (maybeProduct.isEmpty) throw ProductNotFoundException(id)
        else return maybeProduct.get()
    }
}