import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

class  Mythread  implements Callable<String>
{
    public  String call() throws Exception
    {/**/
        for (int x=0;x<10;x++)
        {
                System.out.println(Thread.currentThread().getName());
        }
        return Thread.currentThread().getName();
    }

    public  static void  main(String[] args) throws Exception {
        FutureTask<String> task = new FutureTask<>(new Mythread());
        Runnable run=()->{
            for (int x=0;x<10;x++)
            {
                System.out.println(Thread.currentThread().getName());
                try
                {
                    Thread.sleep(1000);
                }
                catch(InterruptedException  e){
                    e.printStackTrace();;
                }

            }
        };
        new Thread(task).start();
        new Thread(run,"Thread A").start();
        System.out.println("Return Data: " + task.get());
    }

}
