package stream.api;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StreamAPI2 {


    public static void main(String[] args) throws ParseException {
        SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
        Date manthanJoiningDate = date.parse("29-02-2021");
        Date pritamJoiningDate = date.parse("24-12-2023");
        Date guddioiningDate = date.parse("03-11-2022");
        Date surajJoiningDate = date.parse("20-10-2020");
        Date akanshaJoiningDate = date.parse("15-08-2023");
        Date shwetaJoiningDate = date.parse("12-11-2019");


        List<Employee> emp = Arrays.asList(
                new Employee("Manthan", "Pune", 1234, 75000, manthanJoiningDate, "IT"),
                new Employee("Pritam", "Mumbai", 4321, 55000, pritamJoiningDate, "HR"),
                new Employee("Guddi", "Palghar", 4234, 45000, guddioiningDate, "Police"),
                new Employee("Suraj", "Thane", 1634, 60000, surajJoiningDate, "TL"),
                new Employee("Akansha", "Kalyan", 1934, 65000, akanshaJoiningDate, "TL"),
                new Employee("Shweta", "Vashind", 9234, 70000, shwetaJoiningDate, "HR"),
                new Employee("Shantanu", "Benglore", 9934, 70000, shwetaJoiningDate, "IT"),
                new Employee("Mohini", "Pune", 3234, 70000, shwetaJoiningDate, "IT")
        );


        //Employee who has highest salary
        Employee highestSalary1 = emp.stream().max((a, b) -> Double.compare(a.getSalary(), b.getSalary())).get();
        Employee highestSalary2 = emp.stream().max(Comparator.comparingDouble(Employee::getSalary)).get();
        System.out.println(highestSalary1);
        System.out.println(highestSalary2);

        //    Second-Highest salary
        Employee secSalary1 = emp.stream().skip(1).max(Comparator.comparingDouble(Employee::getSalary)).get();
        System.out.println(secSalary1);
        Employee secHigh2 = emp.stream().sorted((a, b) -> Double.compare(b.getSalary(), a.getSalary()))
                .skip(1).findFirst().get();
        Employee secHigh3 = emp.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .skip(1).findFirst().get();
        System.out.println(secHigh2);
        System.out.println(secHigh3);

        //  Most Senior Employee
        Employee seniorEmp = emp
                .stream()
                .min((a, b) -> a.getJoiningDate().compareTo(b.getJoiningDate()))
                .get();
        System.out.println(seniorEmp);

        // count emp on Dept

        Map<String, Long> deptCount = emp.stream().collect(Collectors.groupingBy(Employee::getDept, Collectors.counting()));
        System.out.println(deptCount);


    }
}
