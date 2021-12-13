package hiber.dao;

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

   @Transactional
   @Override
   public void addUser(User user) {
      em.persist(user);
   }

   @Transactional
   @Override
   public void updateUser(User user) {
      em.merge(user);
   }

   @Transactional
   @Override
   public void removeUser(long id) {
      User user = (User) em.find(User.class, id);
      em.remove(user);
   }

   @Transactional
   @Override
   public User getUserById(long id) {
      return (User) em.find(User.class, id);
   }

   @Transactional
   @Override
   public List<User> listUser() {
      return em.createQuery("select u from User u").getResultList();
   }
}
