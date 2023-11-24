package com.m2.tiila.meteo.buisenes;

import com.m2.tiila.meteo.entity.CityEntitiy;
import com.m2.tiila.meteo.exception.FunctionalException;
import com.m2.tiila.meteo.repository.CityRepository;
import jakarta.inject.Inject;
import org.springframework.stereotype.Component;

import static com.m2.tiila.meteo.mapper.mapper.todto;

@Component
public class CityBusiness {

    @Inject
    private CityRepository cityRepository;
    public void createCity(CityEntitiy cetyentity){
        if(cetyentity.getId() != null){
            this.cityRepository.createcity(todto(cetyentity));

        }else {
            throw new FunctionalException(null,"id ne peut pas etre null");
        }
    }


}
