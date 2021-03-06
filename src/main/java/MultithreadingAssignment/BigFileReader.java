package MultithreadingAssignment;


import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;


public class BigFileReader {
    static Hashtable<String, Integer> hashtable;
    public static void main(String[] args)
    {
        System.out.println("Enter\n1. Brute Force\n2. Multithreading\n3. Optimised Multithreading");
        int option= new Scanner(System.in).nextInt();
        switch (option)
        {
            case 1:
                doBruteForce();
                break;
            case 2:
                doMultiThreading();
                break;
            default:
                System.out.println("Enter valid option");
        }
    }

    private static void doBruteForce() {
        ReadTask task= new ReadTask("C:\\Users\\itripathi\\Desktop\\FileReader\\1.txt");
        task.runTask(0);
    }

    static void doMultiThreading()
    {
        List<Integer> x = new ArrayList<>();
        for(int i = 0; i <= 9; i++)
        {
            TaskManager boss = new TaskManager();
            boss.addTask(new ReadTask("C:\\Users\\itripathi\\Desktop\\FileReader\\" + i + ".txt"));
            long startTime = System.nanoTime();
            boss.runTasks(i);
            long endTime = System.nanoTime();
            long durationMS = (endTime - startTime);
            System.out.println("\t"+durationMS+" x10^-6 s for thread "+i);
            x.add(i);
        }
        System.out.println(x);
    }
}

/*

try (
  FileChannel channel = FileChannel.open(path, READ);
  DataInputStream index = new DataInputStream(Channels.newInputStream(channel));
  FileLock lock = channel.lock(0, channel.size(), true);
) {
  int numberOfRecords = index.readInt();

  List<RecordInfo> recordInfos = IntStream.range(0, numberOfRecords).mapToObj(i -> {
    long position = index.readLong();
    long size = index.readLong();
    return new RecordInfo(position, size);
  }).collect(toList());

  recordInfos.stream().map(info -> channel.map(READ_ONLY, info.position(), info.size())).parallel().forEach(record -> {
    // Process the record through a memory-mapped chunk of the file.
  });
}

*/