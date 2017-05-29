package dao.impl;

import dao.UserDAO;
import dataModel.AppArea;
import dataModel.User;
import dbConstants.DataBaseConstants;
import util.DBHelper;

import javax.jws.soap.SOAPBinding;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Karen on 5/27/2017.
 */
public class UserDAOImpl implements UserDAO {
    @Override
    public boolean addUser(User user) {
        final String sql = "INSERT INTO work_flow.user (first_name, last_name, email, passcode, rating) " +
                "VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBHelper.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, user.getFirstName());
            stmt.setString(2, user.getLastName());
            stmt.setString(3, user.getEmail());
            stmt.setString(4, user.getPassword());
            stmt.setInt(5, user.getRating());

            stmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean subscribeToArea(User user, AppArea appArea) {
        final String sql = "INSERT INTO work_flow.user_apparea (user_id, apparea_id) " +
                "VALUES (?, ?)";
        try (Connection conn = DBHelper.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, user.getId());
            stmt.setLong(2, appArea.getId());

            stmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public List<User> getUserByName(String name) {
        return null;
    }

    public static User fromResultSet(User user, ResultSet rs){
        try {
            user.setId(rs.getLong(rs.findColumn(DataBaseConstants.Post.userId)));
            user.setFirstName(rs.getString(rs.findColumn(DataBaseConstants.User.firstName)));
            user.setLastName(rs.getString(rs.findColumn(DataBaseConstants.User.lastName)));
            user.setEmail(rs.getString(rs.findColumn(DataBaseConstants.User.email)));
            user.setRating(rs.getInt(rs.findColumn(DataBaseConstants.User.rating)));

        }catch (SQLException e){
            e.printStackTrace();
        }
        return user;
    }
}
