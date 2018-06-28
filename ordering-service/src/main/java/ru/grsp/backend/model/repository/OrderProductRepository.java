package ru.grsp.backend.model.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.grsp.backend.model.OrderProduct;
import ru.grsp.backend.model.Product;

import java.util.Collection;


public interface OrderProductRepository extends CrudRepository<OrderProduct, Integer> {

    @Query("SELECT productId FROM OrderProduct op where op.orderId = :id")
    Collection<Integer> findAllProductsByOrderId(@Param("id") Integer id);
}
