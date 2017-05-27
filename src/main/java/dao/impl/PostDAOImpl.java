package dao.impl;

import dao.PostDAO;
import dataModel.Post;
import util.DBHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by nane on 5/26/17.
 */
public class PostDAOImpl implements PostDAO {

    public boolean addPost(Post post) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        String sql = "INSERT INTO post(user_id, apparea_id, date_time, title, content) " +
                " VALUE(?,?,?,?,?)";
        try (Connection conn = DBHelper.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, post.getUser().getId());
            stmt.setLong(2, post.getAppArea().getId());
            stmt.setString(3, dateFormat.format(date));
            stmt.setString(4, post.getTitle());
            stmt.setString(5, post.getContent());

            stmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean updatePost(Post post) {
        return false;
    }

    @Override
    public boolean deletePost(long id) {
        return false;
    }

    @Override
    public List<Post> getAllPosts() {
        return null;
    }

    @Override
    public List<Post> getPostsByUserId(long userId) {
        return null;
    }

    @Override
    public List<Post> getByTitle(String title) {
        return null;
    }
}
