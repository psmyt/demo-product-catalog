package dev.mytnichenkops.demoproductcatalog.dao;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@Entity
@SuperBuilder
@ToString
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class Product {
    @Id
    @GeneratedValue
    UUID id;
    String name;
    String productCode;
    Boolean inStock;
    Integer price;
    String color;
    String size;
}
