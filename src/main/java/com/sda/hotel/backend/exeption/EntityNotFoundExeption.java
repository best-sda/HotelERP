/*
 * Created by Dmitry Scherbakov in 08.12.2019, 21:51
 */

package com.sda.hotel.backend.exeption;

public class EntityNotFoundExeption extends RuntimeException {
   private Integer id;

    public EntityNotFoundExeption(){
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
