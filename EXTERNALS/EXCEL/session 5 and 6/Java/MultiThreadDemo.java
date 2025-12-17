class Task implements Runnable {
    private String name;

    Task(String name) {
        this.name = name;
    }

    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(name + " running... step " + i);
        }
    }
}

public class MultiThreadDemo {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Task("Thread A"));
        Thread t2 = new Thread(new Task("Thread B"));
        Thread t3 = new Thread(new Task("Thread C"));

        t1.start();
        t2.start();
        t3.start();
    }
}