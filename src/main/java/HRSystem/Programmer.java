package HRSystem;

public class Programmer extends Employee implements IBonusCalculator{

    public Programmer(String fName, String lName, int salary, String gender, String birth, String department) {
        super(fName, lName, salary, gender, birth, department);
    }

    @Override
    public double calculateBonus(int salary) {
        return salary * 0.075;
    }
}
