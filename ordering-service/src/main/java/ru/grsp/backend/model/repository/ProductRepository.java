package ru.grsp.backend.model.repository;

import org.springframework.data.repository.CrudRepository;
import ru.grsp.backend.model.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {
}
