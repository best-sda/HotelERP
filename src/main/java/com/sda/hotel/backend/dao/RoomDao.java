/*
 * Created by Dmitry Scherbakov on 11.02.2020, 1:23
 */

package com.sda.hotel.backend.dao;

import com.sda.hotel.backend.annotation.Component;
import com.sda.hotel.backend.domain.Room;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class RoomDao extends AbstractDaoImpl<Room, Integer> {

    public static final String GET_ALL_ROOMS = "SELECT * FROM hotel.hotel.room;";
    public static final String GET_ROOM_BY_ID = "select * from hotel.hotel.room where id = ?;";
    public static final String CREATE_ROOM =
            "insert into hotel.hotel._order (id, room_number, status, bizy, cost) VALUES (?, ?, ?, ?, ?);";
    public static final String DELETE_ROOM = "delete from hotel.hotel.room where id = ?;";
    public static final String UPDATE_ROOM = "update hotel.hotel.room SET room_number = ?, status = ?, bizy = ?, cost = ? where id = ?;";
    Logger logger = LogManager.getLogger(RoomDao.class);

    @Override
    public List<Room> getAll() {
        List<Room> rooms = new ArrayList<>();
        PreparedStatement preparedStatement = getPrepareStatement(GET_ALL_ROOMS);
        try {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Room room = new Room();
                room.setId(resultSet.getInt(1));
                room.setRoomNumber(resultSet.getInt(2));
                room.setStatus(resultSet.getString(3));
                room.setBusy(resultSet.getBoolean(4));
                room.setCost(resultSet.getInt(5));
                rooms.add(room);
            }
        } catch (SQLException e) {
            logger.error("sql query exeption" + e);
        } finally {
            closePrepareStatement(preparedStatement);
        }
        return rooms;
    }

    @Override
    public Room getEntityById(Integer id) {
        PreparedStatement preparedStatement = getPrepareStatement(GET_ROOM_BY_ID);
        try {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Room room = new Room();
                room.setId(resultSet.getInt(1));
                room.setRoomNumber(resultSet.getInt(2));
                room.setStatus(resultSet.getString(3));
                room.setBusy(resultSet.getBoolean(4));
                room.setCost(resultSet.getInt(5));
                return room;
            }
        } catch (SQLException e) {
            logger.error("sql query exeption" + e);

        } finally {
            closePrepareStatement(preparedStatement);
        }
        return null;
    }

    @Override
    public Room update(Room entity) {
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        PreparedStatement preparedStatement = getPrepareStatement(DELETE_ROOM);
        try {
            preparedStatement.setInt(1, id);
            preparedStatement.executeQuery();
            return true;
        } catch (SQLException e) {
            logger.error("sql query exeption" + e);
            return false;
        } finally {
            closePrepareStatement(preparedStatement);
        }
    }

    @Override
    public boolean create(Room entity) {
        PreparedStatement preparedStatement = getPrepareStatement(CREATE_ROOM);
        try {
            preparedStatement.setInt(1, entity.getId());
            preparedStatement.setInt(2, entity.getRoomNumber());
            preparedStatement.setString(3, entity.getStatus());
            preparedStatement.setBoolean(4, entity.getBusy());
            preparedStatement.setInt(5, entity.getCost());
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
