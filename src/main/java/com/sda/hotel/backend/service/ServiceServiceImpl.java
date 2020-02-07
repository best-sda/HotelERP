/*
 * Created by Dmitry Scherbakov in 09.12.2019, 15:24
 */

package com.sda.hotel.backend.service;

import com.sda.hotel.backend.annotation.Autowired;
import com.sda.hotel.backend.annotation.Component;
import com.sda.hotel.backend.domain.Service;
import com.sda.hotel.backend.repository.ServiceRepository;

import java.util.List;

@Component
public class ServiceServiceImpl implements ServiceService {
    @Autowired
    private ServiceRepository serviceRepository;

    public void setServiceRepository(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    @Override
    public Service save(Service service) {
        return serviceRepository.save(service);
    }

    @Override
    public List<Service> findByName(String name) {
        return serviceRepository.findByName(name);
    }

    @Override
    public void delete(int id) {
        serviceRepository.delete(id);
    }

    @Override
    public Service servicewithId(int id) {
        return serviceRepository.servicewithId(id);
    }

    @Override
    public void loadList() {
        serviceRepository.loadList();
    }

    @Override
    public void saveList() {
        serviceRepository.saveList();
    }
}
