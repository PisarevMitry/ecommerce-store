package ru.stc.ebpas.crm.core.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.stc.ebpas.crm.core.service.CartService;
import ru.stc.ebpas.crm.core.model.OrderEntity;
import ru.stc.ebpas.crm.core.model.OrderRequestBody;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/cart/")
@CrossOrigin(origins = "*")
public class CartController {
    private final CartService cartService;

    @PostMapping("single")
    String addToCart(@RequestBody OrderRequestBody orderRequestBody) {
        System.out.println("here");
        return cartService.addToCart(orderRequestBody);
    }

    @PostMapping("all")
    String addToCartMultiple(@RequestBody List<OrderRequestBody> orders) {
        return cartService.addToCartMultiple(orders);
    }

    @GetMapping()
    List<OrderEntity> findOrderedProducts() {
        return cartService.findOrderedProducts();
    }
}
