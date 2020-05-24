package Day4;

import java.io.*;
import java.util.Scanner;

class MyFileReader{
    MyFileReader()
    {}
    public static void main(String[] args) throws IOException {
        Scanner sc= new Scanner(System.in);

        readAndPrint();
        writeMyFile();
        System.out.println("Read the written file? ");
        String input= sc.nextLine();
        if(input.equals("y"))
            readMyFile();
    }

    private static void readMyFile() throws FileNotFoundException {
        try(BufferedReader bufferedReader= new BufferedReader(new FileReader(new File("C:\\Users\\itripathi\\Desktop\\FileWriterFile.txt"))))
        {
            String buffer;
            while((buffer= bufferedReader.readLine())!=null)
            {
                if(buffer.startsWith("This is line : "))
                {
                    System.out.println(buffer);
                }
                else
                {
                    int line= Integer.parseInt(buffer.substring(buffer.indexOf(':')+1, buffer.length()).trim());
                    throw new BadLineException("Unexpected string found at line "+line, buffer);
                }
            }
        } catch (BadLineException e) {
            System.out.println("Bad Line found at line: "+e.getBadLine());
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }

    private static void writeMyFile() throws IOException {
        try(FileWriter fileWriter= new FileWriter(new File("C:\\Users\\itripathi\\Desktop\\FileWriterFile.txt"));
            BufferedWriter bufferedWriter= new BufferedWriter(fileWriter);
        ){
//            StringBuffer stringBuffer= new StringBuffer();
            for(int i=0; i<100; i++)
            {
                bufferedWriter.append("This is line : "+i).append("\n");
            }
        }
    }

    private static void readAndPrint() throws IOException {
//        FileReader fileReader= null;
//        BufferedReader bufferedReader= null;
        try(FileReader fileReader = new FileReader(new File("C:\\Users\\itripathi\\Desktop\\FileReaderFile.txt"));
            BufferedReader bufferedReader = new BufferedReader(fileReader);
        ) {
            String buffer;
            while((buffer= bufferedReader.readLine())!=null)
            {
                System.out.println(buffer);
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}