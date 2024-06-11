import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.maxBy;

public class SortListDemo {

    public static void main(String[] args) {

        //Primitive Type Sorting
        List<Integer> list = new ArrayList<>();
        list.add(8);
        list.add(3);
        list.add(12);
        list.add(4);

        Collections.sort(list);//ASSENDING Collections.reverse(list);
        System.out.println(list);

        list.stream().sorted(Comparator.reverseOrder()).forEach(s -> System.out.println(s));//descending

        //Custom Object
        List<Employee> employees = DataBase.getEmployees();

        //Old - Method1
        Collections.sort(employees, new Comparator<Employee>() {

            @Override
            public int compare(Employee o1, Employee o2) {
                return (int) (o1.getSalary() - o2.getSalary());// ascending
            }
        });
        //old -Method2
        Collections.sort(employees, (o1, o2) -> (int) (o1.getSalary() - o2.getSalary()));

        //New - Method3
        employees.stream().sorted((o1,o2) -> (int)(o2.getSalary()-o1.getSalary())).forEach(System.out::println);
        //New - Method4
        employees.stream().sorted(Comparator.comparing(emp -> emp.getSalary())).forEach(System.out::println);
        //New - Method5
        employees.stream().sorted(Comparator.comparing(Employee::getSalary)).forEach(System.out::println);

        //selecting top salary employee for each department
        //Approach 1
        Map<String, Employee> topEmployees = allEmployees.stream()
                                                        .collect(
                                                            groupingBy(
                                                                        e -> e.department,
                                                                        collectingAndThen(maxBy(comparingInt(e -> e.salary)), Optional::get) 
                                                            ));

        //Approach 2
        Map<String, Employee> topEmployees =
                                        allEmployees.stream()
                                                .collect(    
                                                    Collectors.toMap(
                                                    e -> e.department,
                                                    e -> e,
                                                    BinaryOperator.maxBy(Comparator.comparingInt(e -> e.salary)) 
                                                ));

        

    }

}
