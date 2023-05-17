package dev.mytnichenkops.demoproductcatalog.model.computer;

import dev.mytnichenkops.demoproductcatalog.model.Product;

public interface Computer extends Product {
    CPU getCpu();
    Category getCategory();
}
