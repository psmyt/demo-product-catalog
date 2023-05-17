package dev.mytnichenkops.demoproductcatalog.dao;

import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@SuperBuilder
@NoArgsConstructor
public class Vacuum extends Product {
    Double dustBagSize;
    Integer numberOfModes;
}
