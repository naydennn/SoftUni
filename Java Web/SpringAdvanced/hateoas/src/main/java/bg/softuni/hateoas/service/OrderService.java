package bg.softuni.hateoas.service;

import bg.softuni.hateoas.model.dto.OrderDTO;

import java.util.List;

public interface OrderService {
    List<OrderDTO> getOrders(Long studentId);
}
