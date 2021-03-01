package conteudo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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
                list.stream()
                        .filter(fourToSixThousand)
                        .findFirst()
                        .get()
        );

        Function<Employee, String> findByFirstName = Employee::getFirstName;
        Function<Employee, String> findBySecondName = Employee::getSecondName;

        Comparator<Employee> comparator =
                Comparator.comparing(findBySecondName).thenComparing(findByFirstName);

        System.out.printf("%nEmployee in ascending order by last name than first: %n");
        list.stream()
                .sorted(comparator)
                .forEach(System.out::println);

        System.out.printf("%nEmployee in descending order by last name than first: %n");
        list.stream()
                .sorted(comparator.reversed())
                .forEach(System.out::println);

        System.out.printf("%nUnique employee last name:%n");
        list.stream()
                .map(Employee::getSecondName)
                .distinct()
                .sorted()
                .forEach(System.out::println);

        System.out.printf("%ngroup by department:%n");
        Map<String, List<Employee>> groupedByDepartment = list.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));

        groupedByDepartment.forEach((key, value) -> {
            System.out.printf("%ndepartment: %s%n%n", key);
            value.forEach(employee -> System.out.printf("%s ", employee.getName()));
        });

        System.out.printf("%n%nNumber of employees in each department:%n");
        Map<String, Long> employeeByDepartment = list.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.counting()));

        employeeByDepartment
                .forEach((key, value) -> System.out.printf("%s has %d employees%n", key, value));

        System.out.printf("%nsum of salaries(sum): %.2f",
                list.stream().mapToDouble(Employee::getSalary).sum()
        );

        System.out.printf("%nsum of salaries(reduce): %.2f",
                list.stream().map(Employee::getSalary).reduce(0.0, (x, y) -> x + y));



    }

}
