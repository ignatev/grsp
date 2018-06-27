//package ru.grsp.backend.model.repository;
//
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;
//import org.springframework.data.repository.query.Param;
//import ru.grsp.backend.model.Order;
//import ru.grsp.backend.model.OrderProduct;
//
//import java.util.List;
//
//public interface OrderRepository extends CrudRepository<Order, Integer> {
//
//    @Query("SELECT product_id FROM OrderProduct op where op.order_id = :id")
//    List<Integer> findProductIdByOrderId(@Param("id") Integer id);
//
//}
