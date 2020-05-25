package HRSystem;

public class Technician extends Employee implements IBonusCalculator{

    public Technician(String fName, String lName, int salary, String gender, String birth, String department) {
        super(fName, lName, salary, gender, birth, department);
    }

    @Override
    public double calculateBonus(int salary) {
        return salary * 0.05;
    }
}