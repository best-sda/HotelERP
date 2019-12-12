/*
 * Created by Dmitry Scherbakov in 09.12.2019, 15:29
 */

package com.sda.hotel.backend.repository;

import com.sda.hotel.backend.domain.Service;
import com.sda.hotel.backend.exeption.EntityNotFoundExeption;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ServiceRepositoryImpl implements ServiceRepository {
    private List<Service> services = new ArrayList<>();
    @Override
    public Service save(Service service) {
        services.add(service);
        return service;
    }
    @Override
    public List <Service> findByName(String name) {
        return services.stream().filter(services -> name != null && services.getServiceName().startsWith(name))
                .collect(Collectors.toList());
    }

    @Override
    public void delete(int id) {
        services.stream().filter(service -> service.getId().equals(id)).findFirst()
                .orElseThrow(EntityNotFoundExeption::new);
        services.remove(id);
    }

    @Override
    public Service servicewithId(int id) {
        return services.stream().filter(service -> service.getId().equals(id)).findFirst()
                .orElseThrow(EntityNotFoundExeption::new);
    }
}
