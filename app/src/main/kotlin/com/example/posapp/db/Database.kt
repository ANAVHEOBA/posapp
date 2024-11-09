package com.example.posapp.db

import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction
import java.time.LocalDateTime
import org.jetbrains.exposed.sql.Database as ExposedDatabase
import com.example.posapp.model.Product  

object Products : Table() {
    val id = integer("id").autoIncrement()
    val name = varchar("name", 255)
    val price = double("price")
    val stock = integer("stock")
    
    override val primaryKey = PrimaryKey(id)
}

object Sales : Table() {
    val id = integer("id").autoIncrement()
    val timestamp = varchar("timestamp", 50)
    val total = double("total")
    
    override val primaryKey = PrimaryKey(id)
}

object Database {
    fun init() {
        ExposedDatabase.connect(
            url = "jdbc:sqlite:pos.db",
            driver = "org.sqlite.JDBC"
        )
        
        transaction {
            SchemaUtils.create(Products, Sales)
        }
    }
    
    fun addProduct(product: Product): Int {
        return transaction {
            Products.insert {
                it[name] = product.name
                it[price] = product.price
                it[stock] = product.stock
            } get Products.id
        }
    }
    
    fun getProducts(): List<Product> {
        return transaction {
            Products.selectAll().map {
                Product(
                    id = it[Products.id],
                    name = it[Products.name],
                    price = it[Products.price],
                    stock = it[Products.stock]
                )
            }
        }
    }
}