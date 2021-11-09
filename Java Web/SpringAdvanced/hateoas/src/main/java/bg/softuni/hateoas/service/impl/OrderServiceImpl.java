package bg.softuni.hateoas.service.impl;

import bg.softuni.hateoas.model.dto.OrderDTO;
import bg.softuni.hateoas.model.mapping.OrderMapper;
import bg.softuni.hateoas.repository.OrderRepository;
import bg.softuni.hateoas.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    public OrderServiceImpl(OrderRepository orderRepository, OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
    }

    @Override
    public List<OrderDTO> getOrders(Long studentId) {
        return orderRepository.findAllByStudentId(studentId).
                stream().
                map(orderMapper::mapOrderToOrderDto).
                collect(Collectors.toList());
    }
}
