package dev.mytnichenkops.demoproductcatalog.repository;

import dev.mytnichenkops.demoproductcatalog.dao.Product;
import dev.mytnichenkops.demoproductcatalog.dao.ProductLine;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

@org.springframework.stereotype.Repository
public interface ProductLineRepository extends CrudRepository<ProductLine<? extends Product>, UUID> {

}
