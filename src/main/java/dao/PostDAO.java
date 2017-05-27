package dao;

import dataModel.Post;
import util.DBHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

/**
 * Created by nane on 5/26/17.
 */
public class PostDAO {

    public static boolean addPost(Post post) {
        long date = new Date().getTime() / 10000;
        String sql = "INSERT INTO post(user_id, apparea_id, date_time, title, content) " +
                " VALUE(?,?,?,?,?,?,?)";
        try (Connection conn = DBHelper.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, post.getUserId());
            stmt.setLong(2, post.getAppAreaId());
            stmt.setLong(3, date);
            stmt.setString(4, post.getTitle());
            stmt.setString(5, post.getContent());

            stmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
