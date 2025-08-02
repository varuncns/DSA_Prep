package CustomComparators;
// 🔹 1. Easy – Sort Strings by Length
// Problem:
// Given a list of strings, sort them in increasing order of length.
// If two strings have the same length, maintain their original order (i.e., stable sort).

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// Input: ["banana", "apple", "kiwi", "grapes"]
// Expected Output: ["kiwi", "apple", "banana", "grapes"]

class CustomComparator implements Comparator<String>{
    @Override
    public int compare(String s1,String s2){
        return s1.length()-s2.length();
    }
}
public class Easy {
    public static void main(String[] args) {
        List<String> stringStream = new ArrayList<>(Arrays.asList("banana", "apple", "kiwi", "grapes","aang"));

        Collections.sort(stringStream,new CustomComparator());
        System.out.println(stringStream);

    }
}
