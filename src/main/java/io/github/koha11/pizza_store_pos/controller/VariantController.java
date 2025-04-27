package io.github.koha11.pizza_store_pos.controller;

import io.github.koha11.pizza_store_pos.entity.variant.Variant;
import io.github.koha11.pizza_store_pos.service.VariantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/variants")
public class VariantController {
    @Autowired
    VariantService variantService;

    @GetMapping
    List<Variant> getAll() {
        return variantService.getAll();
    }
}
