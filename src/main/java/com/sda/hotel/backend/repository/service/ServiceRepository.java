/*
 * Created by Dmitry Scherbakov on 18.02.2020, 3:31
 */

/*
 * Created by Dmitry Scherbakov in 09.12.2019, 15:29
 */

package com.sda.hotel.backend.repository.service;

import com.sda.hotel.backend.annotation.Component;
import com.sda.hotel.backend.domain.Service;

import java.util.List;

@Component
public interface ServiceRepository {
    boolean save(Service service);

    List<Service> findByName(String name);

    void delete(int id);

    Service servicewithId(int id);

    void saveList();

    void loadList();
}
