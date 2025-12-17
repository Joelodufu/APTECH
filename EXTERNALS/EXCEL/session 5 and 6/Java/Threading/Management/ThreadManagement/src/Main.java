public class Main {
    public static void main(String[] args) {
        DaemonWorker dw1 = new DaemonWorker();
        dw1.setDaemon(true);
        dw1.start();

        System.out.println("Main user thread process working");
        if (dw1.isDaemon()) {
            System.out.println("Daemon thread running in background");
        } else {
            System.out.println("Another User Thread is running in background");
        }
        try {
            Thread.sleep(5000);
            int counter = 1;

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // start counting from 1 to a million
        int counter = 1;
        while (counter <= 10) {

            System.out.println("Count: " + counter);
            counter++;
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        System.out.println("Main user thread DONE!");

    }
}

class DaemonWorker extends Thread {
    @Override
    public void run() {
        int proccessCount = 1;
        while (proccessCount <= 6) {
            System.out.println("Daemon Thread Running process: " + proccessCount);

            try {

                Thread.sleep(1000);
                proccessCount += 1;
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}