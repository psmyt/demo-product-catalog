package dev.mytnichenkops.demoproductcatalog;

import dev.mytnichenkops.demoproductcatalog.dao.ProductLine;
import dev.mytnichenkops.demoproductcatalog.dao.Tv;
import dev.mytnichenkops.demoproductcatalog.dao.Vacuum;
import dev.mytnichenkops.demoproductcatalog.model.tv.DisplayType;
import dev.mytnichenkops.demoproductcatalog.repository.ProductLineRepository;
import dev.mytnichenkops.demoproductcatalog.repository.ProductRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class DemoProductCatalogApplicationTests {

    @PersistenceContext
    EntityManager manager;

    @Autowired
    ProductLineRepository lineRepository;

    @Autowired
    ProductRepository productRepository;

    Logger logger = LogManager.getLogger();

    @Test
    void contextLoads() {
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
        logger.info(lineRepository.save(tvProductLine));
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
        logger.info(lineRepository.save(tvProductLine));
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
        logger.info(lineRepository.save(vacuumProductLine));
    }
}
