public class JoinTimeOutEG {
    public static void main(String[] args) throws InterruptedException {
        Task task1 = new Task();
        task1.setName("Basir's Class work ");
        task1.start();
        task1.join(1000);
        System.out.println("Main thread resumes after " + task1.getName() + " is completed");
    }
}

class Task extends Thread {
    @Override
    public void run() {
        for (int i = 0; i <= 3; i++) {
            System.out.println("From Task : " + getName() + "Count: " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
