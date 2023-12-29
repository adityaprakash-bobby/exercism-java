package org.example;

public class SalaryCalculator {
    public double salaryMultiplier(int daysSkipped) {
        return daysSkipped >= 5 ? 0.85 : 1.0D;
    }

    public int bonusMultiplier(int productsSold) {
        return productsSold >= 20 ? 13 : 10;
    }

    public double bonusForProductsSold(int productsSold) {
        return bonusMultiplier(productsSold) * productsSold;
    }

    public double finalSalary(int daysSkipped, int productsSold) {
        double calculatedSalary = 1000 * salaryMultiplier(daysSkipped) + bonusForProductsSold(productsSold);

        return calculatedSalary <= 2000 ? calculatedSalary : 2000;
    }
}
