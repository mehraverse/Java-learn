class MyTask extends Thread {
    @Override
    public void run() {
        // Code that runs on this thread
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + " - Count: " + i);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        MyTask task1 = new MyTask();
        MyTask task2 = new MyTask();

        task1.start(); // Start the first thread
        task2.start(); // Start the second thread
    }
}