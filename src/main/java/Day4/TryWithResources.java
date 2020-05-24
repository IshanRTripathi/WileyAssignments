package Day4;

import java.io.FileNotFoundException;
import java.io.IOException;

class A implements AutoCloseable
{
    public void close() throws Exception {
        System.out.println("Check A");
    }
}
class B implements AutoCloseable
{
    public void close() throws Exception {
        System.out.println("Check B");
    }
}
public class TryWithResources {
    public static void main(String[] args) throws Exception {
        try(
                A a1= new A();
                B b1= new B();
                )
        {
            System.out.println("Inside the try block");
            System.out.println("TRYING");
            if(2%2==9)
                throw new ClassNotFoundException();
            throw new FileNotFoundException();
        }
        catch (Exception e)
        {
            System.out.println("Inside catch block");
            e.printStackTrace();
        }
    }
}
