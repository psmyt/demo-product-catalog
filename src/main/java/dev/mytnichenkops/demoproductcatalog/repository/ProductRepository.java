package dev.mytnichenkops.demoproductcatalog.repository;

import dev.mytnichenkops.demoproductcatalog.dao.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

@org.springframework.stereotype.Repository
public interface ProductRepository extends CrudRepository<Product, UUID> {
}
