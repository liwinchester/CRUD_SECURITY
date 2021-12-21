package hiber.dao;

import hiber.model.Role;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @PersistenceContext
   private EntityManager em;

   @Override
   public void addUser(User user) {
      em.persist(user);
   }

   @Override
   public void updateUser(User user) {
      em.merge(user);
   }

   @Override
   public void removeUser(long id) {
      User user = (User) em.find(User.class, id);
      em.remove(user);
   }

   @Override
   public User getUserById(long id) {
      return (User) em.find(User.class, id);
   }

   @Override
   public List<User> listUser() {
      return em.createQuery("select u from User u").getResultList();
   }

   @Override
   public List<Role> listRoles() {
      return em.createQuery("FROM Role", Role.class).getResultList();
   }

   @Override
   public User getUserByName(String name) {
      return em.createQuery("select u from User u where u.userName=:username", User.class).setParameter("username", name).getSingleResult();
   }

   @Override
   public Role getRoleByName(String name) {
      return em.createQuery("select r from Role r where r.role=:rolename", Role.class).setParameter("rolename", name).getSingleResult();
   }
}
