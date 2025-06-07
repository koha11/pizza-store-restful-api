package io.github.koha11.pizza_store_pos.controller;

import io.github.koha11.pizza_store_pos.entity.parameter.ConfigParameter;
import io.github.koha11.pizza_store_pos.entity.parameter.DefaultSurcharge;
import io.github.koha11.pizza_store_pos.service.ConfigParameterService;
import io.github.koha11.pizza_store_pos.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Parameter;

@RestController
@RequestMapping("/config-params")
public class ConfigParameterController extends GenericController<ConfigParameter>{

    @Autowired
    private ConfigParameterService configParameterService;

    public ConfigParameterController(GenericService<ConfigParameter> genericService) {
        super(genericService);
    }

    @GetMapping("/surcharge")
    public DefaultSurcharge getDefaultConfig() {
        return configParameterService.getDefaultSurcharge();
    }
}
