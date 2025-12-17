public class Main{
    public static void main(String[] args) {
        Counter sharedCounter = new Counter();

        IncrementCounter task1 = new IncrementCounter(sharedCounter);
        IncrementCounter task2 = new IncrementCounter(sharedCounter);

        task1.start();
        task2.start();

        try {
            task1.join();
            task2.join();
        } catch (InterruptedException e) {
             e.printStackTrace();
        }
        System.out.println(sharedCounter.counter);
    }
}

class Counter {
    int counter =  0;

    public void increment() {
        counter++;
    }
}

class IncrementCounter extends Thread{
    Counter counter;

    public IncrementCounter(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
        counter.increment();
     }
    }
}