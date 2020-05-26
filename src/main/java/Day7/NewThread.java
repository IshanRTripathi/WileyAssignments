package Day7;

class DemoThread extends Thread {
    int v;
    DemoThread(int v)
    {
        this.v= v;
    }
    public synchronized void run(){ // running state     // synchronised makes sure threads execute in the order they are called. This
        Thread thread= new Thread();//                       eliminates the race condition
        thread.start();
        System.out.println("Running new thread");
        System.out.println("Viola !! Thread "+v+" is running with priority :"+this.getPriority());
    } // dead state
}
 public class NewThread
 {
     public static void main(String[] args) {
         DemoThread thread= new DemoThread(1);
//         thread.run();   // this is not recommended because ?


         DemoThread thread2= new DemoThread(3);
         DemoThread thread3= new DemoThread(2);
//         thread2.setPriority(6);
//         thread3.setPriority(10);
         thread.start();
         thread2.start();
         thread3.start();
     }
 }
