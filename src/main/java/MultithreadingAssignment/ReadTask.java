package MultithreadingAssignment;

import java.util.Hashtable;

public class ReadTask
{
    private String fileName;
    public ReadTask(String fileName)
    {
        this.fileName = fileName;
    }

    public void runTask(int threadNumber)
    {
        System.out.println("\t\tTerminating thread :"+threadNumber);
        FileReader reader= new FileReader();
        reader.readFile(fileName);
    }
}
