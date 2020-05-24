package Day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MyConsoleReader {
    public static void main(String[] args) throws IOException {
        readAndPrint();
    }

    private static void readAndPrint() throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringBuffer stringBuffer= new StringBuffer();

        String input="";
        while(!input.equals("stop"))
        {
            stringBuffer.append(input).append("\n");
            input= br.readLine();
        }
        System.out.println(stringBuffer);
    }
}
