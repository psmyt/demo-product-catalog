package dev.mytnichenkops.demoproductcatalog;

import dev.mytnichenkops.demoproductcatalog.dao.Product;
import dev.mytnichenkops.demoproductcatalog.dao.ProductLine;
import dev.mytnichenkops.demoproductcatalog.repository.ProductLineRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
public class RestController {

    Logger log = LogManager.getLogger(RestController.class);
    @Autowired
    ProductLineRepository productLineRepository;

    @GetMapping(path = "/productLine/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<? extends Product> getModels(@PathVariable UUID id) {
        log.info("ищем по id " + id.toString());
        Optional<List<? extends Product>> result = productLineRepository.findById(id)
                .map(ProductLine::getModels);
        log.info(result);
        if (!result.isPresent())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND); // можно было бы упростить используя orElseThrow()
        else return result.get();
    }

}
