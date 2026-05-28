package stream.api;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class StreamApiJava {

    public static void main(String[] args) {

        List<Integer> num = Arrays.asList(92, 74, 15, 56, 27, 38, 69, 10, 12, 14, 28, 45);

        //filter
        List<Integer> evenList = num.stream().filter(i -> i % 2 == 0).toList();
        System.out.println("Even Number List: " + evenList);

        //map
        List<Integer> multipleTenList = num.stream().map(e -> e * 10).toList();
        System.out.println("Multiple Number by 10: " + multipleTenList);

        //count
        long failCount = num.stream().filter(i -> i < 35).count();
        System.out.println("Failed Count: " + failCount);

        //sorted
        List<Integer> sortedNum = num.stream().sorted().toList();
        System.out.println("Sorted Number List: " + sortedNum);

        //Reverse Sorting
        List<Integer> revSortedNum = num.stream().sorted((a, b) -> b.compareTo(a)).toList();
        //List<Integer> revSortedNum= num.stream().sorted(Comparator.reverseOrder()).toList();
        System.out.println("Reverse sorted Num: " + revSortedNum);

        //sort Arraylist base on Length of String and Alphabetical order
        List<String> name = Arrays.asList("Manthan", "Samiksha", "Harshita", "Aadu", "Dev", "Bhupesh", "Kalpesh", "Arun", "Kantilal");
        List<String> sortByLengthName = name.stream().sorted((a, b) -> a.length() < b.length() ? 1 : a.length() > b.length() ? -1 : 0).toList();
        List<String> sortByAlphabeticalName = name.stream().sorted().toList();
        System.out.println("Sort based on length: " + sortByLengthName);
        System.out.println("Sort based on alphabetical: " + sortByAlphabeticalName);


        //min() & max()
        //min(comparator)-> return the first value from result
        //max(comparator)-> return the last value from result
        int minNum = num.stream().min(Comparator.naturalOrder()).get();
        int maxNum = num.stream().max((a, b) -> a < b ? 1 : a > b ? -1 : 0).get();
        System.out.println("Min result: " + minNum + "\n" + "max result: " + maxNum);


        //forEach
        List<Integer> ls = Arrays.asList(12, 34, 56, 78, 90);
        ls.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);

        //Stream to Array conversion
        List<Integer> numbers = Arrays.asList(12, 33, 34, 45, 47, 56, 78, 90);
        List<Integer> evenNun = numbers.stream().filter(i -> i % 2 == 0).toList();
        Integer[] i = evenNun.toArray(Integer[]::new);
        for (int m : i) {
            System.out.println(m);
        }
        //Array to stream conversion
        Integer[] i2 = {2,4,65,87,4,3,2,11};
        Arrays.stream(i2).sorted(Comparator.reverseOrder()).distinct().forEach(System.out::println);
        Stream.of(i2).filter(i3->i3%2==1).forEach(System.out::println);
    }
}
