public class SalaryCalculator {
    private double SALARY_BASE = 1000.0;

    public double salaryMultiplier(int daysSkipped) {
        return daysSkipped < 5 ? 1.0 : 0.85;
    }

    public int bonusMultiplier(int productsSold) {
        return productsSold >= 20 ? 13 : 10;
    }

    public double bonusForProductsSold(int productsSold) {
        return productsSold * bonusMultiplier(productsSold);
    }

    public double finalSalary(int daysSkipped, int productsSold) {
        double tmpSalary = SALARY_BASE * salaryMultiplier(daysSkipped) + bonusForProductsSold(productsSold);

        return (tmpSalary < 2000) ? tmpSalary : 2000;
    } 
}
