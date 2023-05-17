package dev.mytnichenkops.demoproductcatalog.model.vacuum;

import dev.mytnichenkops.demoproductcatalog.model.Product;

public interface VacuumCleaner extends Product {
    Integer getDustBagSize();
    Integer getNumberOfModes();
}
