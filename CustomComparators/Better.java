package CustomComparators;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 🔹 2. Relative Medium – Sort Integers by Frequency
// Problem:
// Given an array of integers, sort the unique elements based on their frequency in ascending order.
// If two numbers have the same frequency, sort them by increasing numeric value.

// Input: [4, 5, 6, 5, 4, 3]


// Expected Output (unique sorted elements): [3, 6, 4, 5]

class CustomComparatorMap implements Comparator<Integer>{
    private Map<Integer, Integer> freqMap;

    public CustomComparatorMap(Map<Integer,Integer>freqMap){
        this.freqMap = freqMap;
    }
    
    @Override
    public int compare(Integer a1,Integer a2){
        if(freqMap.get(a1)-freqMap.get(a2)!=0){
            return freqMap.get(a1)-freqMap.get(a2);
        }
        else{
            return a1.compareTo(a2);
        }
    }
}

public class Better {
    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 5, 4, 3,2,2,1,1,1,1};

        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        List<Integer> unique = new ArrayList<>(freqMap.keySet());
        Collections.sort(unique,new CustomComparatorMap(freqMap));
        System.out.println(unique);
    }
}
