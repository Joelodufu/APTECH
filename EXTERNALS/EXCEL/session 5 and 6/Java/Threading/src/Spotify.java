public class Spotify implements Runnable{
    String thread;
    String song;
    String[] artist;

    public Spotify(String song, String thread){
        this.song = song;
        this.thread = thread;
    }

    // can download music
    public void download(String song) {
        System.out.println("From Thread " + thread + " Downloading " + song);
    }
    // can pause music
    public void pauseMusic(String song){
        System.out.println("From Thread " + thread + "Paused "+ song);
    }
    // can play music

    public void playMusic(String song) {
        System.out.println("From Thread " + thread + " Playing" + song);
    }
    // can search music
    public void searchMusic(String song) {
        System.out.println("From Thread " + thread + " Searching for: " + song);
    }
    @Override
    public void run() {
    
        try {
            this.searchMusic(song);
            Thread.sleep(1000);
            this.download(song);
            Thread.sleep(1000);
            this.playMusic(song);
            Thread.sleep(1000);
            this.pauseMusic(song);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
