package dev.mytnichenkops.demoproductcatalog.model;

import java.util.List;

public interface ProductLine<T extends Product> {
    String getName();
    Country getCountry();
    Brand getBrand();
    Boolean getAvailableOnline();
    Boolean getInstallmentPlan();
    List<T> getModels();
}
