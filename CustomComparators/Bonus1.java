package CustomComparators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class CustomComparatorMap3 implements Comparator<Integer>{
     Map<Integer,Integer> freqMap;
     public CustomComparatorMap3( Map<Integer,Integer> freqMap){
        this.freqMap=freqMap;
     }

     @Override
     public int compare(Integer i1,Integer i2){
        int diff = freqMap.get(i2)-freqMap.get(i1);
        if(diff!=0){
            return diff;
        }
        else{
            return i2-i1;
        }
     }
}

public class Bonus1 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(4, 4, 1, 2, 2, 3, 3, 3));
        int k = 2;
        Map<Integer,Integer> freq= new HashMap<>();
        for(int num:list){
            freq.put(num,freq.getOrDefault(num, 0)+1);
        }
        List<Integer> result = new ArrayList<>(freq.keySet());
        Collections.sort(result,new CustomComparatorMap3(freq));
        System.out.println(result.subList(0, k));
    }
}
