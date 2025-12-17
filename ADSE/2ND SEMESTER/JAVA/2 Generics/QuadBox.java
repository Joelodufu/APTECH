public class QuadBox<T> {
    T[] items;

    // add four items into the box
    public void addItem(T item) {
        if (items.length < 4) {
            items[items.length] = item;
        } else {
            System.out.println("Box is full");
        }
    }

    // get all items from the box
    public T[] getItems() {
        System.out.println(items);
        return items;
    }
}
