package ru.grsp.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ru.grsp.backend.model.Product;
import ru.grsp.backend.model.repository.ProductRepository;

import java.util.Optional;

@RestController
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping(path = "orderProducts")
    public @ResponseBody
    Optional<Product> getAllOrderProducts() {
        return productRepository.findById(75);
    }

}
