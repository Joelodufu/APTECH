import java.util.*;

public class CollectionExample {
    public static void main(String[] args) {
        // define the collection
        Collection<String> fruits = new ArrayList<String>();

        System.out.println("Initital content" + fruits);

        // it is an empty list
        // let us start adding things
        fruits.add("Mango");
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cashew");
        fruits.add("Guava");
        fruits.add("Cucumber");

        // chech content
        System.out.println("After Adding content" + fruits);

        // remove element
        fruits.remove("Banana");


    }
}
