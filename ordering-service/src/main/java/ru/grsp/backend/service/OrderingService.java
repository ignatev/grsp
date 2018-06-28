package ru.grsp.backend.service;

import org.springframework.dao.DataAccessException;
import ru.grsp.backend.model.Order;
import ru.grsp.backend.model.Product;

import java.util.Collection;

public interface OrderingService {
    Order findOrderById(int id) throws DataAccessException;
    Collection<Order> findAllOrders() throws DataAccessException;
    void saveOrder(Order order) throws DataAccessException;
    Collection<Integer> findAllProductsByOrderId(Integer id) throws DataAccessException;
    //    void deleteOrder(Order order) throws DataAccessException;
}
