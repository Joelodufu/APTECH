class DownloadTask extends Thread {

    public void run() {
        for (int i = 0; i <= 5; i++) {
            System.out.println("Downloading..." + (i * 20) + "%");
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

public class DownloadApp {

    public static void main(String[] args) {
        DownloadTask t = new DownloadTask();
        t.start();
    }
}
