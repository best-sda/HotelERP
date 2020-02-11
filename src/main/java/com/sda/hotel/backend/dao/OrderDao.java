/*
 * Created by Dmitry Scherbakov on 11.02.2020, 1:25
 */

package com.sda.hotel.backend.dao;

import com.google.common.collect.Ordering;
import com.sda.hotel.backend.domain.Guest;
import com.sda.hotel.backend.domain.Order;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDao extends AbstractDaoImpl<Order, Integer> {

    public static final String GET_ALL_ORDERS = "SELECT * FROM hotel.hotel._order ;";
    public static final String GET_ORDER_BY_ID = "select * from hotel.hotel._order where id = ?;";
    public static final String CREATE_ORDER =
            "insert into hotel.hotel._order (id, date_arival, date_depart, paid, id_guest,id_room,  id_service) VALUES (?, ?, ?, ?, ?, ?, ?) ";
    public static final String DELETE_ORDER = "delete from hotel.hotel._order where id = ?;";
    public static final String UPDATE_ORDER = "update hotel.hotel._order SET date_arival = ?, date_depart = ? + paid = ? where id = ?;";
    @Override
    public List<Order> getAll() {
        List<Order> orders = new ArrayList<>();
        PreparedStatement preparedStatement = getPrepareStatement(GET_ALL_ORDERS);
        try {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Order order = new Order();
                order.setId(resultSet.getInt(1));
                order.setDateArival(resultSet.getString(2));
                order.setDateDepart(resultSet.getString(3));
                order.setPaid(resultSet.getBoolean(4));
                order.setServiceId(resultSet.getInt(7));
                order.setGuestId(resultSet.getInt(5));
                order.setRoomId(resultSet.getInt(6));
                orders.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
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
                order.setDateArival(resultSet.getString(2));
                order.setDateDepart(resultSet.getString(3));
                order.setPaid(resultSet.getBoolean(4));
                order.setServiceId(resultSet.getInt(7));
                order.setGuestId(resultSet.getInt(5));
                order.setRoomId(resultSet.getInt(6));
                return order;
            }
        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            closePrepareStatement(preparedStatement);
        }
        return null;
    }

    @Override
    public Order update(Order entity) {
        PreparedStatement preparedStatement = getPrepareStatement(UPDATE_ORDER);
        try {
            preparedStatement.setString(1, entity.getDateArival());
            preparedStatement.setString(2, entity.getDateDepart());
            preparedStatement.setBoolean(3, entity.getPaid());
            preparedStatement.setInt(4, entity.getId());
            return getEntityById(entity.getId());
        } catch (SQLException e) {
            e.printStackTrace();
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
            e.printStackTrace();
            return false;
        } finally {
            closePrepareStatement(preparedStatement);
        }
    }

    @Override
    public boolean create(Order entity) {
        PreparedStatement preparedStatement = getPrepareStatement(CREATE_ORDER);
        try {
            preparedStatement.setInt(1, entity.getId());
            preparedStatement.setString(2, entity.getDateArival());
            preparedStatement.setString(3, entity.getDateDepart());
            preparedStatement.setBoolean(4, entity.getPaid());
            preparedStatement.setInt(5, entity.getGuestId());
            preparedStatement.setInt(6, entity.getRoomId());
            preparedStatement.setInt(7, entity.getServiceId());

            preparedStatement.executeQuery();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            closePrepareStatement(preparedStatement);
        }
    }
}
