public class Main {
    public static void main(String[] args) throws InterruptedException {
        // BankAccount account = new BankAccount();

        // Thread t1 = new Thread(() -> {
        // account.withdraw(700);
        // });
        // Thread t2 = new Thread(() -> {
        // account.withdraw(700);
        // });

        // t1.start();
        // t2.start();
        // t1.join();
        // t2.join();
        // System.out.println(account.getAccountBallance());

        SharedData data = new SharedData();

        Thread producer = new Thread(() -> {
            for (int i = 1; i >= 5; i++) {
                data.produce(i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread consume = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                data.consume(i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        producer.start();
        consume.start();
    }
}