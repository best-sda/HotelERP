/*
 * Created by Dmitry Scherbakov on 11.02.2020, 1:19
 */

/*
 * Created by Dmitry Scherbakov on 10.02.2020, 22:55
 */

/*
 * Created by Dmitry Scherbakov on 10.02.2020, 22:15
 */

/*
 * Created by Dmitry Scherbakov on 10.02.2020, 22:14
 */

/*
 * Created by Dmitry Scherbakov on 10.02.2020, 20:45
 */

package com.sda.hotel.backend.dao;

import com.sda.hotel.backend.utils.ConectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class AbstractDaoImpl<E, K> implements AbstractDao<E, K>  {
    private ConectionFactory conectionFactory = ConectionFactory.getInstance();
    private Connection connection = conectionFactory.getConnection();

    // Получение экземпляра PrepareStatement
    public PreparedStatement getPrepareStatement(String sql) {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ps;
    }

    // Закрытие PrepareStatement
    public void closePrepareStatement(PreparedStatement ps) {
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

