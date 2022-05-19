package entities;

public class PhysicalPerson extends TaxPayer{

    private Double healthExpenses;

    public PhysicalPerson() {
    }

    public PhysicalPerson(String name, Double annualIncome, Double healthExpenses) {
        super(name, annualIncome);
        this.healthExpenses = healthExpenses;
    }

    public Double getHealthExpenses() {
        return healthExpenses;
    }

    public void setHealthExpenses(Double healthExpenses) {
        this.healthExpenses = healthExpenses;
    }


    @Override
    public double tax() {

        double basicTax;

        if (getAnnualIncome() < 2000.00) {
            basicTax = getAnnualIncome() * 0.15;
        } else {
            basicTax = getAnnualIncome() * 0.25;
        }
        basicTax -= getHealthExpenses() * 0.5;

        if (basicTax < 0.0) {
            basicTax = 0.0;
        }

        return basicTax;
    }
}
