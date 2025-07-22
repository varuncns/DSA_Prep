package JavaCore.Streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExample {

    public int normalMethod(ArrayList<Integer> salaryList){
        int count=0;
        for(int salary:salaryList){
            if(salary>3000){
                count++;
            }
        }
        return count;
    }

    public long streamExample(ArrayList<Integer> salaryList){
        return salaryList.stream().filter((Integer sal)-> sal>3000).count();
    }

    public void streamSalary(ArrayList<Integer> sArrayList){
        List<Integer> streamIntegers = sArrayList.stream().filter((Integer val)-> val>=5000).collect(Collectors.toList());
        System.out.println(streamIntegers);
    }

    public void mapStream(ArrayList<Integer> sArrayList){
        List<Integer> mapIntegers = sArrayList.stream().map((Integer val)->val*2).toList();
        System.out.println(mapIntegers);
    }

    public void linearArray(List<List<String>>matrix){
        Stream<String> arrayStream = matrix.stream().flatMap((List<String> mat)->mat.stream());
        List<String> arrayList=arrayStream.collect(Collectors.toList());
        System.out.println("Stream "+arrayStream);
        System.out.println("List "+arrayList);
    }

    public void capsLinearArray(List<List<String>> matrix){
        List<String> arrayList = matrix.stream().flatMap((List<String> mat)->mat.stream().map((String val)-> val.toUpperCase()))
        .collect(Collectors.toList());
        System.out.println(arrayList);
    }

    public void distinctLinearArray(List<Integer> sIntegers){
        List<Integer> vaList = sIntegers.stream().distinct().toList();
        System.out.println(vaList);
    }

    public void sortStream(List<Integer> sIntegers){
        List<Integer> sortedList =sIntegers.stream().sorted().toList();
        System.out.println("Ascending Order: "+ sortedList);
        List<Integer> descList = sIntegers.stream().sorted((Integer val1,Integer val2)->(val2-val1)).toList();
        System.out.println("Descending Order: "+descList);
    }

    public void peekStream(List<Integer> sIntegers){
        System.out.print("Peek Stream: ");
        sIntegers.stream().filter((Integer val)->(val<1000)).peek((Integer val)-> System.out.print(val+" ")).toList();
    }

    public void limitStream(List<Integer> sIntegers){
        List<Integer> limIntegers= sIntegers.stream().limit(3).toList();
        System.out.println("limit Stream: "+limIntegers);
    }


    public void skipStream(List<Integer> sIntegers){
        List<Integer> skIntegers = sIntegers.stream().skip(2).toList();
        System.out.println("skip stream "+skIntegers);
    }

    public void maptoInt(){
        List<String> numbers = Arrays.asList("2","1","33","4");
        IntStream numberStream = numbers.stream().mapToInt((String val)->Integer.parseInt(val));
        // because of intStream we are able to use primitives inside peek.
        //peek is generic functional interface and generics only work with wrapper classes.
        numberStream.peek((int val)-> System.out.println(val)).toArray();
    }

    public void seqeunceOfStreams(){

        List<Integer> numbers = Arrays.asList(2, 1, 4, 7, 10);

        Stream<Integer> numbersStream = numbers.stream()
            .filter((Integer val) -> val >= 3)
            .peek((Integer val) -> System.out.println("after filter: " + val))
            .map((Integer val) -> (val * -1))
            .peek((Integer val) -> System.out.println("after negating: " + val))
            .sorted()
            .peek((Integer val) -> System.out.println("after Sorted: " + val));

        List<Integer> filteredNumberStream = numbersStream.collect(Collectors.toList());

        System.out.println(filteredNumberStream);
    }

    public void allMatchStream(){
        List<Integer> numbers = Arrays.asList(2, 3, 4, 7, 10);
        boolean hasallMatch = numbers.stream().allMatch((Integer value)->value>1);
        System.out.println(hasallMatch);
    }

    public void anyMatchStream(){
        List<Integer> numbers = Arrays.asList(2, 3, 4, 7, 10);
        boolean anyMatch = numbers.stream().anyMatch((Integer val)->val>10);
        System.out.println(anyMatch);

        boolean noneMatch = numbers.stream().noneMatch((Integer val)->val>10);
        System.out.println("None Match: "+noneMatch);
    }

    public void findFirstAny(){
        List<Integer> numbers = Arrays.asList(2, 3, 4, 7, 10);
        Optional<Integer> firstValue = numbers.stream().filter((Integer val)->val>9).findFirst();
        System.out.println(firstValue.get());

        Optional<Integer> anyValue = numbers.stream().filter((Integer val)->val>6).findAny();
        System.out.println(anyValue);
    }

    public void minAndMaxOperator(){
        List<Integer> numbers = Arrays.asList(2, 3, 4, 7, 10);
        //Ascending Order
        Optional<Integer> valMin = numbers.stream().filter((Integer i3)->i3>4).min((Integer i1,Integer i2)->i1-i2);
        System.out.println(valMin.get());

        //Descending Order
        Optional<Integer> valMax = numbers.stream().filter((Integer i3)->i3>4).max((Integer i1,Integer i2)->i2-i1);
        System.out.println(valMax.get());
    }


    public void parallelStreamANDsequentialStream(){
        List<Integer> numbers = Arrays.asList(11, 22, 33, 44, 55, 66, 77, 88, 99, 110);

        // Sequential processing
        long sequentialProcessingStartTime = System.currentTimeMillis();

        numbers.stream()
               .map((Integer val) -> val * val)
               .forEach((Integer val) -> System.out.println(val));

        System.out.println("Sequential processing Time Taken: " +
                (System.currentTimeMillis() - sequentialProcessingStartTime) + " millisecond");

        // Parallel processing
        long parallelProcessingStartTime = System.currentTimeMillis();

        numbers.parallelStream()
               .map((Integer val) -> val * val)
               .forEach((Integer val) -> System.out.println(val));

        System.out.println("Parallel processing Time Taken: " +
                (System.currentTimeMillis() - parallelProcessingStartTime) + " millisecond");
    }


    public static void main(String[] args) {
        // obj creation

        StreamExample sExample = new StreamExample();
        ArrayList<Integer> salaryList = new ArrayList<>(Arrays.asList(3000,4100,5000,2000,400,5600,1000,2000,1000));
        salaryList.add(4009);


        //iterative count
        int count = sExample.normalMethod(salaryList);
        System.out.println("Normal Method : "+count );

        //stream count
        long sCount = sExample.streamExample(salaryList);
        System.out.println("Stream Method :"+sCount);

        //return salary array
        sExample.streamSalary(salaryList);

        //map function
        sExample.mapStream(salaryList);


        //flatMap Function
        List<List<String>> list = new ArrayList<>();

        list.add(Arrays.asList("a", "b", "c"));
        list.add(Arrays.asList("d", "e", "f"));
        list.add(Arrays.asList("g", "h", "i"));


        sExample.linearArray(list);


        //flatMap with map Function
        sExample.capsLinearArray(list);
        sExample.distinctLinearArray(salaryList);
        sExample.sortStream(salaryList);

        //peekStream
        sExample.peekStream(salaryList);

        //limitStream
        sExample.limitStream(salaryList);

        //skipStream
        sExample.skipStream(salaryList);

        //maptoInt() stream check for long and double also
        sExample.maptoInt();

        //sequenceofStreams
        sExample.seqeunceOfStreams();


        //terminaloperations
        sExample.allMatchStream();
        sExample.anyMatchStream();
        sExample.minAndMaxOperator();
        sExample.findFirstAny();


        //parallelStream
        sExample.parallelStreamANDsequentialStream();

    }

}
