package MultithreadingAssignment;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Hashtable;

public class FileReader
{
    public Hashtable<String, Integer> hashtable= new Hashtable<>();
    public void readFile(String filePath)
    {
        StringBuilder fileContent = new StringBuilder();

        try
        {
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(new FileInputStream(filePath)));
            String line;

            while ((line = br.readLine()) != null)
            {
                fileContent.append(line);
                String[] result= line.split("//s+");
                for(String s: result)
                {
                    hashtable.put(s, hashtable.getOrDefault(s, 0)+1);
                }
            }
            br.close();
            System.out.println(hashtable);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
