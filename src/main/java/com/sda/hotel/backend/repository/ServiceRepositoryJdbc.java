/*
 * Created by Dmitry Scherbakov on 11.02.2020, 13:35
 */

package com.sda.hotel.backend.repository;

import com.sda.hotel.backend.annotation.Autowired;
import com.sda.hotel.backend.dao.OrderDao;
import com.sda.hotel.backend.dao.ServiceDao;
import com.sda.hotel.backend.domain.Service;

import java.util.List;

public class ServiceRepositoryJdbc implements ServiceRepository {
    @Autowired
    ServiceDao serviceDao;
    @Autowired
    OrderDao orderDao;

    public void setServiceDao(ServiceDao serviceDao) {
        this.serviceDao = serviceDao;
    }

    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @Override
    public boolean save(Service service) {
        return serviceDao.create(service);
    }

    @Override
    public List<Service> findByName(String name) {

        return null;
    }

    @Override
    public void delete(int id) {
        serviceDao.delete(id);
    }

    @Override
    public Service servicewithId(int id) {
        return serviceDao.getEntityById(id);
    }

    @Override
    public void saveList() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void loadList() {
        throw new UnsupportedOperationException();
    }
}
