package application;

import entities.LegalPerson;
import entities.PhysicalPerson;
import entities.TaxPayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<TaxPayer> list = new ArrayList<>();

        System.out.print("Enter the number of tax payers: ");
        int n = sc.nextInt();

        for (int i=1; i<=n; i++) {
            System.out.println("Tax payer #" + i + " data:");
            System.out.print("Individual or company (i/c)? ");
            char ch = sc.next().charAt(0);
            sc.nextLine();
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Annual income: ");
            double annualIncome = sc.nextDouble();
            if (ch == 'i') {
                System.out.print("Health expenditures: ");
                double healthExpenditures = sc.nextDouble();

                list.add(new PhysicalPerson(name, annualIncome, healthExpenditures));
            } else {
                System.out.print("Number of employees: ");
                int employees = sc.nextInt();

                list.add(new LegalPerson(name, annualIncome, employees));
            }
        }

        System.out.println();
        System.out.println("TAXES PAID:");
        for (TaxPayer taxPayer: list) {
            System.out.printf("%s: $ %.2f%n", taxPayer.getName(), taxPayer.tax());
        }

        System.out.println();
        double sum = 0.0;
        for (TaxPayer taxPayer: list) {
            sum += taxPayer.tax();
        }

        System.out.println("TOTAL TAXES: $" + String.format("%.2f", sum));


        sc.close();
    }
}
