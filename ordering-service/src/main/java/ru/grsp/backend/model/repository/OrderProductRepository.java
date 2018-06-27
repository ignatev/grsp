package ru.grsp.backend.model.repository;

import org.springframework.data.repository.CrudRepository;
import ru.grsp.backend.model.OrderProduct;

public interface OrderProductRepository extends CrudRepository<OrderProduct, Integer> {

}
