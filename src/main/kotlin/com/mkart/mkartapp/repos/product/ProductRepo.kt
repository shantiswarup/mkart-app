package com.mkart.mkartapp.repos.product

import org.springframework.data.repository.CrudRepository

interface ProductRepo: CrudRepository<ProductEntity, Long> {

}