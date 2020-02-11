/*
 * Created by Dmitry Scherbakov on 11.02.2020, 1:24
 */

package com.sda.hotel.backend.dao;

import com.sda.hotel.backend.domain.Guest;
import com.sda.hotel.backend.domain.Service;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.net.ServerSocket;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceDao extends AbstractDaoImpl<Service, Integer> {
    public static final String GET_ALL_SERVICES = "SELECT * FROM hotel.hotel.service ;";
    public static final String GET_SERVICE_BY_ID = "select * from hotel.hotel.service where id = ?;";
    public static final String CREATE_SERVICE =
            "insert into hotel.hotel._order (id, name, description, cost_service) VALUES (?, ?, ?, ?); ";
    public static final String DELETE_SERVICE = "delete from hotel.hotel.service where id = ?;";
    public static final String UPDATE_SERVICE = "update hotel.hotel._order SET date_arival = ?, date_depart = ? + paid = ? where id = ?;";
    Logger logger = LogManager.getLogger(ServiceDao.class);
    @Override
    public List<Service> getAll() {
        List<Service> services = new ArrayList<>();
        PreparedStatement preparedStatement = getPrepareStatement(GET_ALL_SERVICES);
        try {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Service service = new Service();
                service.setId(resultSet.getInt(1));
                service.setName(resultSet.getString(2));
                service.setDescription(resultSet.getString(3));
                service.setCost(resultSet.getInt(4));
                services.add(service);
            }
        } catch (SQLException e) {
            logger.error("sql query error" + e);
        } finally {
            closePrepareStatement(preparedStatement);
        }
        return services;
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
        PreparedStatement preparedStatement = getPrepareStatement(DELETE_SERVICE);
        try {
            preparedStatement.setInt(1, id);
            preparedStatement.executeQuery();
            return true;
        } catch (SQLException e) {
            logger.error("sql query error" + e);
            return false;
        } finally {
            closePrepareStatement(preparedStatement);
        }
    }

    @Override
    public boolean create(Service entity) {
        return false;
    }
}
