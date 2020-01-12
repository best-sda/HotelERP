/*
 * Created by Dmitry Scherbakov in 15.12.2019, 21:22
 */

package com.sda.hotel.backend.service;

import com.sda.hotel.backend.annotation.Component;

@Component
public interface UtilsService {
    void saveBase();

    void loadFile();
}
