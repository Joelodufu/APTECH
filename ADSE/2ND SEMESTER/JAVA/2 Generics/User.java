 public class User {
     String name;
     String userID;
     int age;

     public User(String userID, String name, int age) {
         this.userID = userID;
         this.name = name;
         this.age = age;
     }

     @Override
     public String toString() {
         return (this.name + " is " + this.age + " years old ");
        
     }
 }