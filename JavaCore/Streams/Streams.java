package Streams;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Streams {

    // Given a list of integers, return a list of the squares of even numbers.
    public void squareOfEvenNumber() {
        List<Integer> iList = new ArrayList<>(Arrays.asList(2, 1, 3, 4, 5, 7, 8));
        List<Integer> squareOfEven = iList.stream()
                .filter(val -> val % 2 == 0)
                .map(val -> val * val)
                .toList();
        System.out.println(squareOfEven);
    }

    // Count each word
    public void countEachWord() {
        List<String> st = new ArrayList<>(Arrays.asList("Love", "You", "Ammu", "Love", "You", "Session", "Hi", "DDD"));
        Map<String, Long> map = st.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(map);
    }

    // Find first non-repeating character
    public void firstLetter() {
        String a = "hellohoe";
        Optional<Character> result = a.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream()
                .filter(val -> val.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst();
        System.out.println(result.orElse(null));
    }

    // Sort employees by salary descending
    public void sortEmployeesBySalary() {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", 30, 60000),
                new Employee("Bob", 24, 75000),
                new Employee("Charlie", 28, 50000),
                new Employee("Diana", 35, 90000),
                new Employee("Ethan", 32, 80000));

        List<Employee> sortedList = employees.stream().sorted((e1, e2) -> e2.salary - e1.salary).toList();
        sortedList.forEach(e -> System.out.println(e.name + " " + e.salary));
        // Second Highest Salary
        System.out.println(sortedList.stream().skip(1).findFirst().get().salary);
    }

    // findDuplicates
    public void findDuplicate() {
        List<String> names = Arrays.asList("apple", "banana", "apple", "orange", "banana", "grape");
        List<String> duplicateNames = names.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().filter((val) -> val.getValue() > 1).map(Map.Entry::getKey).toList();
        System.out.println(duplicateNames);
    }

    // groupByAge
    public void groupByAge() {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", 30, 60000),
                new Employee("Bob", 24, 75000),
                new Employee("Charlie", 30, 50000),
                new Employee("Diana", 35, 90000),
                new Employee("Ethan", 24, 80000));

        Map<Integer, List<String>> map = employees.stream()
                .collect(Collectors.groupingBy(Employee::getAge,
                        Collectors.mapping(Employee::getName, Collectors.toList())));
        System.out.println(map);
    }

    // singleSentence
    public void singleSentence() {
        List<String> names = Arrays.asList("apple", "banana", "orange", "grape");
        String result = names.stream().collect(Collectors.joining(","));
        System.out.println(result);
    }

    // Given a list of strings (with words separated by commas), flatten them into a
    // single list of words using streams.
    public void stringStream() {
        List<String> lines = Arrays.asList("apple,banana", "orange,grape", "banana,kiwi");
        List<String> result = lines.stream().flatMap(s -> Arrays.stream(s.split(","))).collect(Collectors.toList());
        System.out.println(result);
    }

    // Check if all employees in a list have a salary greater than 50,000 using
    // streams.
    public void allEmployeeSalary() {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", 30, 60000),
                new Employee("Bob", 24, 75000),
                new Employee("Charlie", 28, 50000),
                new Employee("Diana", 35, 90000));

        boolean val = employees.stream().allMatch((Employee e1) -> e1.salary > 50000);
        System.out.println(val);

        // maxSalary
        Optional<Employee> maxSalary = employees.stream().max((Employee e1, Employee e2) -> e1.salary - e2.salary);
        System.out.println(maxSalary.get().salary);
    }

    public void startsWithA() {
        List<String> names = Arrays.asList("Banana", "Apple", "Orange", "Avocado");
        boolean withA = names.stream().anyMatch((String name) -> name.startsWith("A"));
        System.out.println(withA);
    }

    // Given a list of employees, create a Map<String, Double> of employee name to
    // salary using streams.
    public void createMap() {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", 30, 60000),
                new Employee("Bob", 24, 75000),
                new Employee("Charlie", 28, 50000));
        Map<String, Integer> map = employees.stream().collect(Collectors.toMap(Employee::getName, Employee::getSalary));
        System.out.println(map);
    }

    // From a list of employees, return a list of names sorted alphabetically using
    // streams.
    public void sortAlphaByName() {
        List<Employee> employees = Arrays.asList(
                new Employee("Charlie", 28, 50000),
                new Employee("Bob", 24, 75000),
                new Employee("Alice", 30, 60000));
        List<String> sortedNames = employees.stream().map((Employee e1)-> e1.name).sorted().toList();
        System.out.println(sortedNames);
    }

    public static void main(String[] args) {
        Streams st = new Streams();
        st.squareOfEvenNumber();
        st.countEachWord();
        st.firstLetter();
        st.sortEmployeesBySalary();
        st.findDuplicate();
        st.groupByAge();
        st.singleSentence();
        st.stringStream();
        st.allEmployeeSalary();
        st.startsWithA();
        st.createMap();
        st.sortAlphaByName();
    }

    // Inner Employee class
    static class Employee {
        private String name;
        private int age;
        private int salary;

        public Employee(String name, int age, int salary) {
            this.name = name;
            this.age = age;
            this.salary = salary;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public int getSalary() {
            return salary;
        }
    }
}
