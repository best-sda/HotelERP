/*
 * Created by Dmitry Scherbakov in 09.12.2019, 15:24
 */

package com.sda.hotel.backend.service;

import com.sda.hotel.backend.annotation.Component;
import com.sda.hotel.backend.domain.Service;

import java.util.List;

@Component
public interface ServiceService {
    Service save(Service service);

    List <Service> findByName(String name);

    void delete(int id);

    Service servicewithId(int id);

    void loadList();

    void saveList();

}
