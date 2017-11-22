import org.omg.CORBA.INTERNAL;

public class AppWindows implements Runnable {

        public void run() {
            for (int i = 1; i < 10; i++) {
                System.out.println("Currently the thread" + " " + Thread.currentThread().getName() + " " + "is running");
                if(Thread.currentThread().getName().equals("Testcase1")){
                    try{
                        System.out.println(Thread.currentThread().getName()+ " " + "Thread is sleeping");
                        Thread.sleep(1000);
                    }
                    catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }

        }
    }


