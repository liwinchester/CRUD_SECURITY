package hiber.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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

   @Column(name = "password")
   private String password;

   @ManyToMany(fetch = FetchType.EAGER)
   @JoinTable(name = "user_roles",
           joinColumns = @JoinColumn(name = "user_id"),
           inverseJoinColumns = @JoinColumn(name = "role_id"))
   private Set<Role> roles = new HashSet<>();

   public User() {

   }

   public User(String name, String lastName, String userName, String password, Set<Role> roles) {
      this.name = name;
      this.lastName = lastName;
      this.userName = userName;
      this.password = password;
      this.roles = roles;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public Set<Role> getRoles() {
      return roles;
   }

   public void setRoles(Set<Role> roles) {
      this.roles = roles;
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
