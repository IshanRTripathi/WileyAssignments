package HRSystem;

public class Manager extends Employee implements IBonusCalculator{

    public Manager(String fName, String lName, int salary, String gender, String birth, String department) {
        super(fName, lName, salary, gender, birth, department);
    }

    @Override
    public double calculateBonus(int salary) {
        return salary * 0.07;
    }
}

