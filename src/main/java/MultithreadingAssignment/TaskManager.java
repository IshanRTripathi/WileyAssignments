package MultithreadingAssignment;

import java.util.Hashtable;
import java.util.List;
import java.util.Vector;
public class TaskManager
{    /** Meaningless tasks to run in parallel */
    private final List<ReadTask> tasks;
    Hashtable<String, Integer> hashtable;

    public TaskManager()
    {
        this.tasks = new Vector<>();
    }


    public void addTask(ReadTask t)
    {
        tasks.add(t);
    }

    public void runTasks(int threadNumber)
    {
        System.out.println("Running thread "+threadNumber);
        Thread currentThread = new Thread(()->
        {
            ReadTask t = null;
            while(true)
            {
                synchronized (tasks)
                {
                    if(!tasks.isEmpty())
                        t = tasks.remove(0);
                }
                if(t == null)
                {
                    break;
                }
                else
                {
                    t.runTask(threadNumber);
                    t = null;
                }
            }
        });
        currentThread.start();
    }
}
