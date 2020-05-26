package HRSystem;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class EmployeeManagement {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Employee> employeeList = new ArrayList<>();

    public static void main(String[] args) {
        boolean result= true;
        while (result)
        {
            result= getInputFromUser();
        }
    }

    private static boolean getInputFromUser() {
        System.out.println("Hello Ishan!,\nWhat do you want to do ?"+
                "\n1. Register an employee"+
                "\n2. Remove an employee"+
                "\n3. Update details of an employee"+
                "\n4. Search an employee"+
                "\n5. Get list of employees");
        int input= sc.nextInt();
        switch (input)
        {
            case 1:
                registerEmployee();
                break;
            case 2:
                deleteEmployee();
                break;
            case 3:
                updateDetails();
                break;
            case 4:
                searchEmployee();
                break;
            case 5:
                printEmployees();
                break;
            default:
                System.out.println("Enter correct option !");
                return false;
        }
        return true;
    }

    private static void searchEmployee() {
        System.out.println("1. Search by name"+
                "\n2. Search by ID"+
                "\n3. Search by department"+
                "\nEnter the corresponding number: ");
        int input= sc.nextInt();
        switch (input)
        {
            case 1:
                searchName();
                break;
            case 2:
                searchId();
                break;
            case 3:
                searchByDepartment();
                break;
            default:
                System.out.println("Enter correct input! ");
        }
    }

    private static void updateDetails() {
        System.out.println("1. Update name"+
                "\n2. Update birth"+
                "\n3. Update department"+
                "\n4. Update salary"+
                "\nEnter the corresponding number: ");
        int input= sc.nextInt();
        switch (input)
        {
            case 1:
                updateName();
                break;
            case 2:
                updateBirth();
                break;
            case 3:
                updateDepartment();
                break;
            case 4:
                updateSalary();
                break;
            default:
                System.out.println("Enter correct input! ");
        }
    }

    public static void registerEmployee() {
        System.out.println("First name of new employee?");
        String firstName = sc.nextLine();
        System.out.println("Last name of employee?");
        String lastName = sc.nextLine();
        System.out.println("Salary of new employee?");
        int salary = sc.nextInt();
        sc.nextLine();
        System.out.println("Which gender do the employee have?");
        String gender = sc.nextLine();
        System.out.println("Date of birth of the new employee? (YY/MM/DD)");
        String birthday = sc.nextLine();
        System.out.println("Which department?");
        System.out.println("1:Management");
        System.out.println("2:Development");
        int department = sc.nextInt();
        sc.nextLine();
        if (department == 1) {
            System.out.println("Is the new employee 1:Secretary or 2:Manager?");
            int mChoice = sc.nextInt();
            sc.nextLine();
            String departmentName = "Management";
            if (mChoice == 1) {
                Secretary s = new Secretary(firstName, lastName, salary, gender, birthday, departmentName);
                employeeList.add(s);
                System.out.println("Secretary created");
            } else if (mChoice == 2) {
                Manager m = new Manager(firstName, lastName, salary, gender, birthday, departmentName);
                employeeList.add(m);
                System.out.println("Manager created");
            } else {
                System.out.println("Invalid choice.");
            }

        } else if (department == 2) {
            System.out.println("Is the new employee 1:Technician or 2:Programmer?");
            int dChoice = sc.nextInt();
            sc.nextLine();
            String departmentName = "Development";
            if (dChoice == 1) {
                Technician t = new Technician(firstName, lastName, salary, gender, birthday, departmentName);
                employeeList.add(t);
                System.out.println("Technician created");
            } else if (dChoice == 2) {
                Programmer p = new Programmer(firstName, lastName, salary, gender, birthday, departmentName);
                employeeList.add(p);
                System.out.println("Programmer created");
            } else {
                System.out.println("Invalid choice");
            }
        }

    }

    public static void deleteEmployee() {
        System.out.println("Id of employee to be removed:");
        int delete = sc.nextInt();
        sc.nextLine();
        Iterator<Employee> b = employeeList.iterator();
        while(b.hasNext()) {
            if(b.next().getId() == delete){
                b.remove();
                int update = Employee.getNumberOfEmployees();
                Employee.setNumberOfEmployees(--update);
                System.out.println("Employee is fired");
            }
        }
    }

    public static void updateName() {
        System.out.println("Id of employee to be updated:");
        int rename = sc.nextInt();
        sc.nextLine();
        for (Employee employee1 : employeeList) {
            if(employee1.getId() == rename) {
                System.out.println("New first name?");
                String fn = sc.nextLine();
                System.out.println("New last name?");
                String ln = sc.nextLine();
                employee1.setName(fn + ln);
//                employee1.setFirstName(fn);
//                employee1.setLastName(ln);
                System.out.println("Employee name updated.");
            }else {
                System.out.println("Employee not found.");
            }
        }
    }

    public static void updateBirth() {
        System.out.println("Id of employee to be updated:");
        int newBirth = sc.nextInt();
        sc.nextLine();
        for (Employee employee1 : employeeList) {
            if(employee1.getId() == newBirth) {
                System.out.println("New date of birth?");
                String birth = sc.nextLine();
                employee1.setBirthday(birth);
                System.out.println("Birthday updated.");
            }
        }
    }
    public static void updateDepartment() {
        System.out.println("Id of employee to be updated:");
        int newDep = sc.nextInt();
        sc.nextLine();
        for (Employee employee1 : employeeList) {
            if(employee1.getId() == newDep) {
                System.out.println("New department?");
                String department = sc.nextLine();
                if(department.equals( "Managment")) {
                    employee1.setDepartment("Managment");
                }else
                    employee1.setDepartment("Development");
            }System.out.println("Employees department updated");
        }
    }

    public static void updateSalary() {
        System.out.println("Id of employee to be updated:");
        int newSalary = sc.nextInt();
        sc.nextLine();
        for (Employee employee1 : employeeList) {
            if(employee1.getId() == newSalary) {
                System.out.println("New Salary?");
                int salary = sc.nextInt();
                sc.nextLine();
                employee1.setSalary(salary);
                System.out.println("Salary updated.");
            }
        }
    }

    public static  void searchName() {
        System.out.println("Name of employee?");
        String fullName = sc.nextLine();

        int idx = fullName.lastIndexOf(' ');
        if(idx == -1)
            throw new IllegalArgumentException("Only a single name" + fullName);
        String firstName = fullName.substring(0, idx);
        String surName = fullName.substring(idx + 1);


        for (Employee employee : employeeList) {
            if((employee.getFirstName().equalsIgnoreCase(firstName)) && (employee.getLastName().equalsIgnoreCase(surName))) {

                System.out.println(employee);
            }else
                System.out.println("Employee not found");

        }
    }

    public static void searchId() {
        System.out.println("Id on employee?");
        int findId = sc.nextInt();
        sc.nextLine();
        for (Employee employee : employeeList) {
            if(employee.getId() == findId) {
                System.out.println(employee);
            }else {
                System.out.println("Employee not found");
            }
        }
    }

    public static void searchByDepartment() {
        System.out.println("Which department ( Management / Development)?");
        String findDepartment = sc.nextLine();

        for (Employee employee : employeeList) {
            if(employee.getDepartment().equals(findDepartment)) {
                System.out.println(employee);
            }else {
                System.out.println("Department not found");
            }
        }
    }

    public static void printEmployees() {
        for (Employee employee : employeeList) {

            if (employee instanceof Manager) {
                System.out.println(employee + " Manager");

            } else if (employee instanceof Programmer) {
                System.out.println(employee + " Programmer");
            }
            if (employee instanceof Secretary) {
                System.out.println(employee + " Secretary");
            }
            if (employee instanceof Technician) {
                System.out.println(employee + "  Technician");
            }
        }


    }

}
