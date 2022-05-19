package entities;

public class LegalPerson extends TaxPayer {

    private Integer employees;

    public LegalPerson() {
    }

    public LegalPerson(String name, Double annualIncome, Integer employees) {
        super(name, annualIncome);
        this.employees = employees;
    }

    public Integer getEmployees() {
        return employees;
    }

    public void setEmployees(Integer employees) {
        this.employees = employees;
    }

    @Override
    public double tax() {

        if (employees > 10) {
            return getAnnualIncome() * 0.14;
        } else {
            return getAnnualIncome() * 0.16;
        }

    }
}
