package org.example.springmvcproductmanagement.repository;

import org.example.springmvcproductmanagement.entites.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
