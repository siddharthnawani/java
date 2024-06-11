import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Java8Part1 {

    public static void main(String[] args) {

        //count no of characters in a string
        String input="ilovejavatechie";
        Map<String,Long> count=Arrays.stream(input.split(""))
            .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println("No of characters in string "+input+"are : "+count);

        //find all duplicate elements in a string

        List<String> duplicateElements=Arrays.stream(input.split(""))
            .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
            .entrySet().stream()
            .filter(x -> x.getValue() >1)
            .map(Map.Entry :: getKey) // equivalent to x -> x.getKey()
            .collect(Collectors.toList());

        System.out.println("List of duplicate characters are "+duplicateElements);

        //unique element

        List<String> uniqueElements=Arrays.stream(input.split(""))
            .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
            .entrySet().stream()
            .filter(x -> x.getValue() ==1)
            .map(Map.Entry :: getKey) // equivalent to x -> x.getKey()
            .collect(Collectors.toList());

        System.out.println("List of Unique characters are "+uniqueElements);

        //first non repeat element

        String firstunique= Arrays.stream(input.split(""))
            .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()))
            .entrySet().stream()
            .filter(x -> x.getValue() ==1)
            .findFirst().get().getKey();

        System.out.println("First  Unique characters is "+firstunique);

        //Second highest element
        int[] numbers={5,9,11,2,8,21,1};

        Integer secondHighest=Arrays.stream(numbers).boxed()
            .sorted(Comparator.reverseOrder())
            .skip(1)
            .findFirst().get();

        System.out.println("secondHighest is "+secondHighest);

        //find longest string from given array

        String[] strArray={"java","techie","springboot","microservices"};

        String longestString1 = Arrays.stream(strArray)
            .sorted(Comparator.comparingInt(String::length).reversed())
            .collect(Collectors.toList())
            .stream().findFirst().get();

        String  longestString2 = Arrays.stream(strArray)
            .max(Comparator.comparingInt(String::length)).get();

        String longestString3=Arrays.stream(strArray)
                .reduce((w1,w2)-> w1.length() > w2.length() ? w1 :w2)
                    .get();

        System.out.println("longest String is "+longestString1);
        System.out.println("longest String is "+longestString2);
        System.out.println("longest String is "+longestString3);

        //find all elements who starts with 1

        List<String> numberWith1 = Arrays.stream(numbers)
            .boxed()
            .map(s -> s + "")//convert integers to string
            .filter(s -> s.startsWith("1"))
            .collect(Collectors.toList());

        System.out.println("Numbers with  is "+numberWith1);

        //String .join example

        //print this 1-2-3-4
        List<String> listNumbers = Arrays.asList("1", "2", "3", "4");
        System.out.println("Numbers appended with - "+ String.join("-",listNumbers));

        //skip & Limit examples

        //print 2-9
        IntStream.rangeClosed(1,10)
            .skip(1)
            .limit(8)
            .forEach(System.out::print);

        List<Integer> result = IntStream.rangeClosed(1, 10)
            .skip(1)  // Skip the first element
            .limit(8) // Limit to the next 8 elements
            .boxed()  // Convert IntStream to Stream<Integer>
            .collect(Collectors.toList()); // Collect to List

        System.out.println("\nNumbers from 2-9 "+result);


        //map & flat map example
    }
}





