package ru.grsp.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ru.grsp.backend.model.Product;
import ru.grsp.backend.model.repository.OrderRepository;
import ru.grsp.backend.model.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping(path = "orderProducts")
    public @ResponseBody
    Optional<Product> getAllOrderProducts() {
        return productRepository.findById(75);
    }

    @GetMapping(path = "products-by-order")
    public @ResponseBody
    List<Integer> getProductsByOrderId(@RequestParam("id") Integer id) {
        return orderRepository.findProductIdByOrderId(id);
    }

}
