package dev.mytnichenkops.demoproductcatalog.dao;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
@SuperBuilder
@ToString
@NoArgsConstructor
@Getter
@Setter
public class ProductLine<T extends Product> implements Serializable {
    @Id
    @GeneratedValue
    UUID id;
    String productLineName;
    String brand;
    String country;
    Boolean availableOnline;
    Boolean installmentPlan;
    @OneToMany(targetEntity = Product.class, orphanRemoval = true)
    List<T> models;
}
