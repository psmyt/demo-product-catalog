package dev.mytnichenkops.demoproductcatalog.model;

public interface Product {
    String getName();
    String getProductCode();
    Boolean getInStock();
    Integer getPrice();
    String getColor();
    Dimensions getDimensions();
}
