package dao.interfaces;

import dataModel.AppArea;
import dataModel.User;

import java.util.List;

/**
 * Created by nane on 5/27/17.
 */
public interface UserDAO {

    boolean addUser(User user);

    boolean subscribeToArea(User user, AppArea appArea);

    List<User> getUserByName(String name);

}
