public class App {
    public static void main(String[] args) throws Exception {
        ThreadClass threadObject = new ThreadClass("Example 1", 1);
        ThreadClass threadObject2 = new ThreadClass("Example 2", 2);
        ThreadClass threadObject3 = new ThreadClass("Example 3", 3);

        threadObject3.setPriority(Thread.MAX_PRIORITY);
        threadObject.setPriority(Thread.NORM_PRIORITY);
        threadObject2.setPriority(Thread.MIN_PRIORITY);
        
        System.out.println("Thread 1: "+threadObject.getPriority());
        System.out.println("Thread 2: "+threadObject2.getPriority());
        System.out.println("Thread 3: " + threadObject3.getPriority());
        
        threadObject.start();
        threadObject2.start();
        threadObject3.start();


    }
}

class ThreadClass extends Thread {
    public String name;
    public int id;
    public ThreadClass(String name, int id) {
        this.name = name;
        this.id = id;
    }
    @Override
    public void run(){
        System.out.println("Thread "+ this.id +":"+ this.name + " Is starting...");
        try {
            for (int i = 0; i <= 20; i++) {
                Thread.sleep(500 * i);
                int percent = (int) (((double) i / 20) * 100);
                System.out.println("Thread " + this.id + ":" + this.name + " Is " + percent + "% Completed");
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread " + this.id + ":"+ this.name + "Proccessed successfully !!");
    }
}
