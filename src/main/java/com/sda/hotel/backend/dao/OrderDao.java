/*
 * Created by Dmitry Scherbakov on 11.02.2020, 1:25
 */

package com.sda.hotel.backend.dao;

import com.sda.hotel.backend.annotation.Component;
import com.sda.hotel.backend.domain.Order;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class OrderDao extends AbstractDaoImpl<Order, Integer> {

    private static final String GET_ALL_ORDERS = "SELECT * FROM hotel.hotel._order ;";
    private static final String GET_ORDER_BY_ID = "select * from hotel.hotel._order where id = ?;";
    private static final String CREATE_ORDER =
            "insert into hotel.hotel._order (date_arival, date_depart, paid, id_guest,id_room,  id_service) VALUES (?, ?, ?, ?, ?, ?);";
    private static final String DELETE_ORDER = "delete from hotel.hotel._order where id = ?;";
    private static final String UPDATE_ORDER = "update hotel.hotel._order SET date_arival = ?, date_depart = ? + paid = ? where id = ?;";
    private Logger logger = LogManager.getLogger(OrderDao.class);

    @Override
    public List<Order> getAll() {
        List<Order> orders = new ArrayList<>();
        PreparedStatement preparedStatement = getPrepareStatement(GET_ALL_ORDERS);
        try {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Order order = new Order();
                order.setId(resultSet.getInt(1));
                order.setDateArival(resultSet.getDate(2).toLocalDate());
                order.setDateDepart(resultSet.getDate(3).toLocalDate());
                order.setPaid(resultSet.getBoolean(4));
                order.setServiceId(resultSet.getInt(7));
                order.setGuestId(resultSet.getInt(5));
                order.setRoomId(resultSet.getInt(6));
                orders.add(order);
            }
        } catch (SQLException e) {
            logger.error(e);
        } finally {
            closePrepareStatement(preparedStatement);
        }
        return orders;
    }

    @Override
    public Order getEntityById(Integer id) {
        PreparedStatement preparedStatement = getPrepareStatement(GET_ORDER_BY_ID);
        try {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Order order = new Order();
                order.setId(resultSet.getInt(1));
                order.setDateArival(resultSet.getDate(2).toLocalDate());
                order.setDateDepart(resultSet.getDate(3).toLocalDate());
                order.setPaid(resultSet.getBoolean(4));
                order.setServiceId(resultSet.getInt(7));
                order.setGuestId(resultSet.getInt(5));
                order.setRoomId(resultSet.getInt(6));
                return order;
            }
        } catch (SQLException e) {
            logger.error(e);
        } finally {
            closePrepareStatement(preparedStatement);
        }
        return null;
    }

    @Override
    public Order update(Order entity) {
        PreparedStatement preparedStatement = getPrepareStatement(UPDATE_ORDER);
        try {
            preparedStatement.setDate(1, Date.valueOf(entity.getDateArival()));
            preparedStatement.setDate(2, Date.valueOf(entity.getDateDepart()));
            preparedStatement.setBoolean(3, entity.getPaid());
            preparedStatement.setInt(4, entity.getId());
            return getEntityById(entity.getId());
        } catch (SQLException e) {
            logger.error(e);
        }
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        PreparedStatement preparedStatement = getPrepareStatement(DELETE_ORDER);
        try {
            preparedStatement.setInt(1, id);
            preparedStatement.executeQuery();
            return true;
        } catch (SQLException e) {
            logger.error(e);
            return false;
        } finally {
            closePrepareStatement(preparedStatement);
        }
    }

    @Override
    public boolean create(Order entity) {
        PreparedStatement preparedStatement = getPrepareStatement(CREATE_ORDER);
        try {
            preparedStatement.setDate(1, Date.valueOf(entity.getDateArival()));
            preparedStatement.setDate(2, Date.valueOf(entity.getDateDepart()));
            preparedStatement.setBoolean(3, entity.getPaid());
            preparedStatement.setInt(4, entity.getGuestId());
            preparedStatement.setInt(5, entity.getRoomId());
            if (entity.getServiceId() == null) {
                preparedStatement.setNull(6, Types.INTEGER);
            } else {
                preparedStatement.setInt(6, entity.getServiceId());
            }


            preparedStatement.executeQuery();
            return true;
        } catch (SQLException e) {
            logger.error(e);
            return false;
        } finally {
            closePrepareStatement(preparedStatement);
        }
    }
}
