package io.github.koha11.pizza_store_pos.service;

import io.github.koha11.pizza_store_pos.entity.parameter.ConfigParameter;
import io.github.koha11.pizza_store_pos.entity.parameter.DefaultSurcharge;
import io.github.koha11.pizza_store_pos.repository.ConfigParameterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConfigParameterService extends GenericService<ConfigParameter> {

    @Autowired
    ConfigParameterRepository repo;

    public DefaultSurcharge getDefaultSurcharge() {
        var param = getConfigParameterByType("surcharge").getFirst();

        return new DefaultSurcharge(Integer.parseInt(param.getParamValue()), param.getIsParamActive());
    }

    public List<ConfigParameter> getConfigParameterByType(String type) {
        return repo.findAllByTpe(type);
    }
}
