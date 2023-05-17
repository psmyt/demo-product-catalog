package dev.mytnichenkops.demoproductcatalog.model.tv;

import dev.mytnichenkops.demoproductcatalog.model.Product;
public interface TV extends Product {
    DisplayType getDisplayType();
    Category getCategory();
}
