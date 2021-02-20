package conteudo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class ProcessingEmployees {

    public static void main(String[] args) {
        Employee[] employees = {
                new Employee("Jason", "Red", 5000, "IT"),
                new Employee("Pedro", "Henrique", 2000, "it"),
                new Employee("Ashley", "Green", 3587.5, "Sales"),
                new Employee("James", "Indigo", 4700, "Marketing"),
                new Employee("Jason", "Blue", 3200, "Sales"),
                new Employee("Marcus", "Oliver", 5500, "Sales")};

        List<Employee> list = Arrays.asList(employees);

//        System.out.println("Employee list: ");
//        list.stream().forEach(System.out::println);

        Predicate<Employee> fourToSixThousand =
                e -> (e.getSalary() >= 4000 && e.getSalary() <= 6000);

        System.out.printf("%nEmployees earning $4000-$6000 per month sorted by salary:%n");
        list.stream()
                .filter(fourToSixThousand)
                .sorted((Employee::compareTo))
//                .sorted(Comparator.comparing(Employee::getSalary))
                .forEach(System.out::println);

        System.out.printf("%nFirst employee who earns $4000-$6000: %n%s%n",
                list.stream().filter(fourToSixThousand).findFirst().get()
        );

    }

}
