package dev.mytnichenkops.demoproductcatalog.model.refrigerator;

import dev.mytnichenkops.demoproductcatalog.model.Product;

public interface Refrigerator extends Product {
    Integer getChambers();
    CompressorType getCompressorType();
}
