/*
 * Created by Dmitry Scherbakov in 09.12.2019, 15:24
 */

package com.sda.hotel.backend.service;

import com.sda.hotel.backend.domain.Service;
import com.sda.hotel.backend.repository.ServiceRepository;
import com.sda.hotel.backend.repository.ServiceRepositoryImpl;

import java.util.List;

public class ServiceServiceImpl implements ServiceService {
    private ServiceRepository serviceRepository = new ServiceRepositoryImpl();

    @Override
    public Service save(Service service) {
        return serviceRepository.save(service);
    }

    @Override
    public List <Service> findByName(String name) {
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
