package com.microservices.inventory_service.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    private static final Map<String, Integer> STOCK = Map.of(
            "iphone", 10,
            "laptop", 0
    );

    @GetMapping("/{product}")
    public ResponseEntity<Boolean> isInStock(@PathVariable String product) {
        int qty = STOCK.getOrDefault(product.toLowerCase(), 0);
        return ResponseEntity.ok(qty > 0);
    }
}

