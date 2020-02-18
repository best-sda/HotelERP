/*
 * Created by Dmitry Scherbakov on 11.02.2020, 1:20
 */

/*
 * Created by Dmitry Scherbakov on 10.02.2020, 21:45
 */

package com.sda.hotel.backend.dao;

import com.sda.hotel.backend.annotation.Component;
import com.sda.hotel.backend.domain.Guest;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class GuestDao extends AbstractDaoImpl<Guest, Integer> {

    private static final String GET_ALL_GUESTS = "SELECT * FROM hotel.hotel.guest ;";
    private static final String GET_GUEST_BY_ID = "select * from hotel.hotel.guest where id = ?";
    private static final String CREATE_GUEST =
            "insert into hotel.hotel.guest (last_name, first_name, cert_number, phone_number) VALUES (?, ?, ?,?);";
    private static final String DELETE_GUEST = "delete from hotel.hotel.guest where id = ?";
    private static final String UPDATE_GUEST = "update hotel.hotel.guest SET last_name = ?,first_name = ? + cert_number = ?, phone_number = ? where id = ?";
    private Logger logger = LogManager.getLogger(GuestDao.class);

    @Override
    public List getAll() {
        List<Guest> guests = new ArrayList<>();
        PreparedStatement preparedStatement = getPrepareStatement(GET_ALL_GUESTS);
        try {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Guest guest = new Guest();
                guest.setId(resultSet.getInt(1));
                guest.setLastName(resultSet.getString(2));
                guest.setFirstName(resultSet.getString(3));
                guest.setCertNumber(resultSet.getInt(4));
                guest.setPhoneNumber(resultSet.getString(5));
                guests.add(guest);
            }
        } catch (SQLException e) {
            logger.error("SQL query failed" + e);
        } finally {
            closePrepareStatement(preparedStatement);
        }
        return guests;
    }

    @Override
    public Guest getEntityById(Integer id) {
        PreparedStatement preparedStatement = getPrepareStatement(GET_GUEST_BY_ID);
        try {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Guest guest = new Guest();
                guest.setId(resultSet.getInt(1));
                guest.setLastName(resultSet.getString(2));
                guest.setFirstName(resultSet.getString(3));
                guest.setCertNumber(resultSet.getInt(4));
                guest.setPhoneNumber(resultSet.getString(5));
                return guest;
            }
        } catch (SQLException e) {
            logger.error("SQL query failed" + e);

        } finally {
            closePrepareStatement(preparedStatement);
        }
        return null;
    }

    @Override
    public Guest update(Guest entity) {
        PreparedStatement preparedStatement = getPrepareStatement(UPDATE_GUEST);
        try {
            preparedStatement.setString(1, entity.getLastName());
            preparedStatement.setString(2, entity.getFirstName());
            preparedStatement.setInt(3, entity.getCertNumber());
            preparedStatement.setString(4, entity.getPhoneNumber());
            preparedStatement.setInt(5, entity.getId());
            return getEntityById(entity.getId());
        } catch (SQLException e) {
            logger.error("SQL query failed" + e);
        }
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        PreparedStatement preparedStatement = getPrepareStatement(DELETE_GUEST);
        try {
            preparedStatement.setInt(1, id);
            preparedStatement.executeQuery();
            return true;
        } catch (SQLException e) {
            logger.error("SQL query failed" + e);
            return false;
        } finally {
            closePrepareStatement(preparedStatement);
        }
    }

    @Override
    public boolean create(Guest entity) {
        PreparedStatement preparedStatement = getPrepareStatement(CREATE_GUEST);
        try {
            preparedStatement.setString(1, entity.getLastName());
            preparedStatement.setString(2, entity.getFirstName());
            preparedStatement.setInt(3, entity.getCertNumber());
            preparedStatement.setString(4, entity.getPhoneNumber());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            logger.error("SQL query failed" + e);
            return false;
        } finally {
            closePrepareStatement(preparedStatement);
        }
    }


}
