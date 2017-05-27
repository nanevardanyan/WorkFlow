package dao;

import dataModel.Post;

import java.util.List;

/**
 * Created by nane on 5/27/17.
 */
public interface PostDAO {

    boolean addPost(Post post);

    boolean updatePost(Post post);

    boolean deletePost(long id);

    List<Post> getAllPosts();

    List<Post> getPostsByUserId(long userId);

    List<Post> getByTitle(String title);

}
