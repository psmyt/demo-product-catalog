package dev.mytnichenkops.demoproductcatalog.dao;

import dev.mytnichenkops.demoproductcatalog.model.tv.DisplayType;
import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@SuperBuilder
@NoArgsConstructor
public class Tv extends Product {
    String category;
    DisplayType displayType;
}
