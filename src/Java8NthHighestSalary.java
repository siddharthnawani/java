import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Java8NthHighestSalary {

    public static void main(String[] args) {
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("anil", 1000);
        map1.put("bhavna", 1300);
        map1.put("micael", 1500);
        map1.put("tom", 1600);//output
        map1.put("ankit", 1200);
        map1.put("daniel", 1700);
        map1.put("james", 1400);

        //this will fail when there are duplicate values in salary
        System.out.println(getNthHighestSalary(2, map1));

        Map<String, Integer> map2 = new HashMap<>();
        map2.put("anil", 1000);
        map2.put("ankit", 1200);
        map2.put("bhavna", 1200);
        map2.put("james", 1200);
        map2.put("micael", 1000);
        map2.put("tom", 1300);
        map2.put("daniel", 1300);

        System.out.println("Wrong answer "+getNthHighestSalary(3, map2));
        System.out.println(getDynamicNthHighestSalary(3, map2));


    }

    //this will fail when there are duplicate salaries
    public static Map.Entry<String,Integer> getNthHighestSalary(int num, Map<String, Integer> map) {
        return map.entrySet().stream()
            .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
            .collect(Collectors.toList()) //List<Entry<String, Integer>>
            .get(num-1); //since index is 0 based
    }

    //grouping : <salary> , <list names>
    public static Map.Entry<Integer, List<String>> getDynamicNthHighestSalary(int num, Map<String, Integer> map) {
        return map.entrySet()
            .stream()
            .collect(Collectors.groupingBy(
                                    Map.Entry::getValue,
                                    Collectors.mapping(Map.Entry::getKey, Collectors.toList())
            ))
            .entrySet()
            .stream()
            .sorted(Collections.reverseOrder(Map.Entry.comparingByKey()))
            .collect(Collectors.toList())
            .get(num - 1);
    }



}
