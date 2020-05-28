package JDBCAssignment;

import java.io.*;
import java.sql.*;
import java.util.*;

public class JDBCAssignment {
    private static final String TABLE_NAME = "";

    public static void main(String[] args) throws IOException {
        connectToDatabase();
    }

    private static void viewAllRecords(Statement statement) throws SQLException {
        String sql= "Select * from studenttable";
        ResultSet resultSet= statement.executeQuery(sql);
        while (resultSet.next())
        {
            System.out.println(resultSet.getString(1)+" "+resultSet.getString(2)+" "+resultSet.getString(3));
        }
    }

    private static void deleteTable(Statement statement) throws SQLException {
        String sql= "Delete from studenttable where ";
        System.out.println("Enter field to delete \n1. Name\n2. RollNumber\n3. Percentage");
        int option= Integer.parseInt(String.valueOf(new Scanner(System.in).nextLine()));
        String field="";
        switch (option)
        {
            case 1:
                field="Name";
                break;
            case 2:
                field="RollNumber";
                break;
            case 3:
                field="percentage";
                break;
            default:
                System.out.println("Enter valid input");
                return;
        }
        System.out.println("Enter "+field+" to delete ");
        String value= new Scanner(System.in).nextLine();
        if(field.equalsIgnoreCase("name"))
            sql+=field+" = '"+value+"'";
        else
        {
            sql+=field+" = "+value;
        }

        statement.executeUpdate(sql);
        System.out.println("Remaining values in the table :");
        viewAllRecords(statement);
    }

    private static void updateTable(Statement statement) throws SQLException {
        System.out.println("Enter number corresponding to:\n1. Update Name\n2. Update RollNumber\n3. Percentage");
        int option= Integer.parseInt(String.valueOf(new Scanner(System.in).nextLine()));
        String field="";
        switch (option)
        {
            case 1:
                field="Name";
                break;
            case 2:
                field="RollNumber";
                break;
            case 3:
                field="percentage";
                break;
            default:
                System.out.println("Enter valid input");
                return;
        }
        System.out.println("Enter new values\nName: ");
        String name= new Scanner(System.in).nextLine();
        System.out.println("RollNumber: ");
        String rollnumber= new Scanner(System.in).nextLine();
        System.out.println("Percentage: ");
        String percentage= new Scanner(System.in).nextLine();

        String value="";
        if(field.equalsIgnoreCase("name"))
            value= name;
        else if(field.equalsIgnoreCase("rollnumber"))
            value=rollnumber;
        else
            value= percentage;
        String query= "Update studentTable set "+field+" = '"+value+"' where ";
        if(field.equalsIgnoreCase("name"))
            query+= "rollnumber = "+rollnumber+" and percentage = "+percentage;
        else if(field.equalsIgnoreCase("rollnumber"))
            query+= "Name = '"+name+"' and percentage = "+percentage;
        else
            query+= "rollnumber = "+Integer.parseInt(rollnumber)+" and Name = '"+name+"'";

        statement.executeUpdate(query);
    }

    private static void insertIntoTable(Statement statement) throws SQLException {
        System.out.println("Inserting into DB");
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter name: ");
        String name=  sc.nextLine();
        System.out.println("Enter roll: ");
        String roll=  sc.nextLine();
        System.out.println("Enter percentage: ");
        String percentage=  sc.nextLine();
        String query= "INSERT INTO studentTable( Name, RollNumber, Percentage) VALUES ('"+name+"' ,'"+Integer.parseInt(roll)+"' ,'"+Float.parseFloat(percentage)+"')";
        statement.executeUpdate(query);
    }

    private static void connectToDatabase() {
        String url= "jdbc:mysql://localhost:3306/wileyDatabase";
        String username="root";
        String password="ishanr786";

        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection= DriverManager.getConnection(url, username, password);
            Statement statement= connection.createStatement();
            System.out.println("Connection Established !");
//            String sql= "select * from studentTable;";
//            ResultSet result= statement.executeQuery(sql);
            getInputFromUser(statement);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private static void getInputFromUser(Statement statement) throws SQLException {
        Scanner sc = new Scanner(System.in);
        int option= 0;
        while(option!=5) {
            System.out.println("Enter option\n1. Insert\n2. Update\n3. Delete\n4. View Records\n5. Exit");
            option= sc.nextInt();
            switch (option)
            {
                case 1:
                    insertIntoTable(statement);
                    break;
                case 2:
                    updateTable(statement);
                    break;
                case 3:
                    deleteTable(statement);
                    break;
                case 4:
                    viewAllRecords(statement);
                    break;
                case 5:
                    System.out.println("Exiting !");
                    break;
                default:
                    System.out.println("Enter valid input ");
            }
        }
    }
}