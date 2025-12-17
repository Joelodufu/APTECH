import java.util.ArrayList;



class Example1 {
    public static void main(String[] args) {
        ArrayList<User> list = new ArrayList<User>();
        list.add(new User("1", "Alice", 30));
        list.add(new User("2", "Bob", 25));
        list.add(new User("3", "Charlie", 35));

        System.out.println(list.get(1).toString());
    }
}
