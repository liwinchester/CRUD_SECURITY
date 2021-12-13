package hiber.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column(name = "name")
   private String name;

   @Column(name = "lastName")
   private String lastName;

   @Column(name = "userName")
   private String userName;

   public User() {

   }

   public User(String name, String lastName, String userName) {
      this.name = name;
      this.lastName = lastName;
      this.userName = userName;
   }

   public long getId() {
      return id;
   }

   public void setId(long id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getLastName() {
      return lastName;
   }

   public void setLastName(String lastName) {
      this.lastName = lastName;
   }

   public String getUserName() {
      return userName;
   }

   public void setUserName(String userName) {
      this.userName = userName;
   }

   @Override
   public String toString() {
      return "User{" +
              "id=" + id +
              ", name='" + name + '\'' +
              ", lastName='" + lastName + '\'' +
              ", userName='" + userName + '\'' +
              '}';
   }
}
