/*
 * Created by Dmitry Scherbakov on 11.02.2020, 13:35
 */

package com.sda.hotel.backend.repository;

import com.sda.hotel.backend.domain.Service;

import java.util.List;

public class ServiceRepositoryJdbc implements ServiceRepository {
    @Override
    public Service save(Service service) {
        return null;
    }

    @Override
    public List<Service> findByName(String name) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Service servicewithId(int id) {
        return null;
    }

    @Override
    public void saveList() {

    }

    @Override
    public void loadList() {

    }
}
