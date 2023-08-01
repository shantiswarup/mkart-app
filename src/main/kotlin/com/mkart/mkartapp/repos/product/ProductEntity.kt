package com.mkart.mkartapp.repos.product

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "products")
data class ProductEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long?,
    @Column(name = COL_PRODUCT_NAME, nullable = false) val productName: String,
    @Column(name = COL_PRODUCT_DESC, nullable = false) val productDesc: String
) {
    companion object {
        const val COL_PRODUCT_NAME = "product_name"
        const val COL_PRODUCT_DESC = "product_desc"
    }
}