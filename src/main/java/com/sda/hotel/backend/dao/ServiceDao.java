/*
 * Created by Dmitry Scherbakov on 11.02.2020, 1:24
 */

package com.sda.hotel.backend.dao;

import com.sda.hotel.backend.domain.Service;

import java.util.List;

public class ServiceDao extends AbstractDaoImpl<Service, Integer> {
    @Override
    public List<Service> getAll() {
        return null;
    }

    @Override
    public Service getEntityById(Integer id) {
        return null;
    }

    @Override
    public Service update(Service entity) {
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public boolean create(Service entity) {
        return false;
    }
}
