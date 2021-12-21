package hiber.dao;

import hiber.model.Role;
import hiber.model.User;

import java.util.List;

public interface UserDao {
   void addUser(User user);

   void updateUser(User user);

   void removeUser(long id);

   User getUserById(long id);

   List<User> listUser();

   List<Role> listRoles();

   User getUserByName(String name);

   Role getRoleByName(String name);
}
