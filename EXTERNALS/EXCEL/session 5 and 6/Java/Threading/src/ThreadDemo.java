class Task1 extends Thread {
    public void run() {
        for (int i = 0; i <= 5; i++) {
            System.out.println("Task 1 - Count: " + i);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

class Task2 extends Thread {

    public void run() {
        for (int i = 0; i <= 5; i++) {
            System.out.println("Task 2 - Count: " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

}

public class ThreadDemo {

    public static void main(String[] args) {

        Task1 tsk1 = new Task1();
        Task2 tsk2 = new Task2();
        tsk1.start();
        tsk2.start();

    }

}
