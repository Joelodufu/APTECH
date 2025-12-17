class MyRunnable extends  FakeClass implements Runnable{

    public MyRunnable(String name) {
        super(name);
    }

    public void run() {
        System.out.println("Hello from a new thread");
    }

}

 class FakeClass{
     String name;

     public FakeClass(String name) {
         this.name = name;
     }
}

    


public class App {
    public static void main(String[] args) {
        Thread t = new Thread(new MyRunnable(null), "Process1");
        t.start();
    }
}
