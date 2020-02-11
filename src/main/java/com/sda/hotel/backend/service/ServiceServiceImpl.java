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
    private ServiceRepository serviceRepositoryJdbc;

    public void setServiceRepositoryJdbc(ServiceRepository serviceRepositoryJdbc) {
        this.serviceRepositoryJdbc = serviceRepositoryJdbc;
    }

    @Override
    public Boolean save(Service service) {
        return serviceRepositoryJdbc.save(service);
    }

    @Override
    public List<Service> findByName(String name) {
        return serviceRepositoryJdbc.findByName(name);
    }

    @Override
    public void delete(int id) {
        serviceRepositoryJdbc.delete(id);
    }

    @Override
    public Service servicewithId(int id) {
        return serviceRepositoryJdbc.servicewithId(id);
    }

    @Override
    public void loadList() {
        serviceRepositoryJdbc.loadList();
    }

    @Override
    public void saveList() {
        serviceRepositoryJdbc.saveList();
    }
}
