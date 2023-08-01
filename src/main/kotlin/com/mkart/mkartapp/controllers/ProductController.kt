package com.mkart.mkartapp.controllers

import com.mkart.mkartapp.models.dtos.CreateProductDto
import com.mkart.mkartapp.repos.product.ProductEntity
import com.mkart.mkartapp.services.product.ProductService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/product")
class ProductController(private val productService: ProductService) {
    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): ProductEntity {
        return productService.getById(id)
    }
    @PostMapping
    fun save(@RequestBody dto: CreateProductDto): ResponseEntity<String> {
        return try{
            val resp = productService.save(ProductEntity(
                id = null,
                productName = dto.productName,
                productDesc = dto.productDesc
            ))
            ResponseEntity.ok().body("Product saved with id ${resp.id}")
        } catch(e: IllegalArgumentException) {
            ResponseEntity.badRequest().body(e.localizedMessage)
        } catch(e: Exception) {
            ResponseEntity.internalServerError().body(e.localizedMessage)
        }
    }
}