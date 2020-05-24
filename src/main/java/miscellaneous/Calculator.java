package miscellaneous;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n1, n2, op=0;

        while(op!=5) {
            System.out.println("Enter 1st number");
            n1 = sc.nextInt();

            System.out.println("Enter 2st number");
            n2 = sc.nextInt();

            System.out.println("Enter Arithmetic operation");
            System.out.println("1. Add\n2. Sub\n3. Mul\n4. Divide\n5. Exit");
            op = sc.nextInt();

            switch (op)
            {
                case 1:
                    System.out.println(add(n1, n2));
                    break;
                case 2:
                    System.out.println(subtract(n1, n2));
                    break;
                case 3:
                    System.out.println(multiply(n1, n2));
                    break;
                case 4:
                    System.out.println(divide(n1, n2));
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Enter Valid Operand");
            }
        }
    }
    static int add(int n1, int n2)
    {
        return n1+n2;
    }
    static int subtract(int n1, int n2)
    {
        return n1-n2;
    }
    static int multiply(int n1, int n2)
    {
        return n1*n2;
    }

    static int divide(int n1, int n2)
    {
        int result=0;
        try{
           result= n1/n2 ;
        }
        catch (Exception e)
        {
            System.out.println("Exception : "+e.getMessage());
        }
        return result;
    }
}
