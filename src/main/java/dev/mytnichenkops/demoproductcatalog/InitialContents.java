package dev.mytnichenkops.demoproductcatalog;

import dev.mytnichenkops.demoproductcatalog.dao.ProductLine;
import dev.mytnichenkops.demoproductcatalog.dao.Tv;
import dev.mytnichenkops.demoproductcatalog.dao.Vacuum;
import dev.mytnichenkops.demoproductcatalog.model.tv.DisplayType;
import dev.mytnichenkops.demoproductcatalog.repository.ProductLineRepository;
import dev.mytnichenkops.demoproductcatalog.repository.ProductRepository;
import jakarta.annotation.PostConstruct;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InitialContents {

    Logger logger = LogManager.getLogger();
    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductLineRepository productLineRepository;

    @PostConstruct
    void postConstruct() {
        List<Tv> models = new ArrayList<>();
        models.add(Tv.builder()
                .color("черный")
                .price(1100000000)
                .name("2002")
                .productCode("2002")
                .inStock(true)
                .category("категория")
                .displayType(DisplayType.PLASMA)
                .build());
        productRepository.saveAll(models);
        ProductLine<Tv> tvProductLine = ProductLine.<Tv>builder()
                .productLineName("серия 2000")
                .availableOnline(true)
                .country("Корея")
                .brand("Panasonic")
                .installmentPlan(true)
                .models(models)
                .build();
        productLineRepository.save(tvProductLine);
        models.add(Tv.builder()
                .color("black")
                .inStock(false)
                .price(123243443)
                .name("2002a")
                .category("категория")
                .displayType(DisplayType.LED)
                .size("70x150")
                .productCode("2002a")
                .build());
        productRepository.saveAll(models);
        tvProductLine.setModels(models);
        logger.info(tvProductLine);
        logger.info(productLineRepository.save(tvProductLine));

        List<Vacuum> vacuums = new ArrayList<>();
        vacuums.add(Vacuum.builder()
                .color("серебристый")
                .inStock(false)
                .price(12345)
                .size("20x20x90")
                .productCode("2323213")
                .name("dyson PRO 200")
                .build());
        productRepository.saveAll(vacuums);
        ProductLine<Vacuum> vacuumProductLine = ProductLine.<Vacuum>builder()
                .productLineName("Dyson PRO series")
                .availableOnline(true)
                .country("Китай")
                .brand("Dyson")
                .installmentPlan(true)
                .models(vacuums)
                .build();
        productLineRepository.save(vacuumProductLine);
    }
}
