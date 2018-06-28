package ru.grsp.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import ru.grsp.backend.model.Order;
import ru.grsp.backend.model.Product;
import ru.grsp.backend.model.repository.OrderProductRepository;
import ru.grsp.backend.model.repository.ProductRepository;

import java.util.Collection;

@Service
public class OrderingServiceImpl implements OrderingService {

    private OrderProductRepository orderProductRepository;
    private ProductRepository productRepository;

    @Autowired
    public OrderingServiceImpl(OrderProductRepository orderProductRepository, ProductRepository productRepository) {
        this.orderProductRepository = orderProductRepository;
        this.productRepository = productRepository;
    }

    @Override
    public Order findOrderById(int id) throws DataAccessException {
        return null;
    }

    @Override
    public Collection<Order> findAllOrders() throws DataAccessException {
        return null;
    }

    @Override
    public void saveOrder(Order order) throws DataAccessException {

    }

    @Override
    public Collection<Integer> findAllProductsByOrderId(Integer id) throws DataAccessException {
        return orderProductRepository.findAllProductsByOrderId(id);
    }
}
