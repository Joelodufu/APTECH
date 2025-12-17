public class Main {

    public static void main(String[] args) {
        DownloadManager download = new DownloadManager(100);
        download.setName("FileDownloader");

        download.start(); // start download

        try {
            Thread.sleep(6000);// let it run for 4 seconds
        } catch (InterruptedException e) {
        }

        System.out.println("User clicked cancel...");
        download.interrupt(); // cancel download
    }
}

class MyThread extends Thread {
    @Override
    public void run() {

        System.out.println("Running in thread: " + Thread.currentThread().getName());
    }
}

class DownloadManager extends Thread {
    private int fileSize;

    public DownloadManager(int fileSize) {
        this.fileSize = fileSize;
    }

    @Override
    public void run() {
        System.out.println(getName() + " Started Downloading...");

        for (int i = 1; i <= fileSize; i += 20) {
            System.out.println(getName() + " Downloaded " + i + "%");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(getName() + " Was interrupted");
                return;
            }
            if (i > 59) {
                System.out.println("Joksokoskoksokdokoksdo");

            }
        }
        System.out.println("Download Completed Succesfully");
    }

}