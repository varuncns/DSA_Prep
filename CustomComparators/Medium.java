package CustomComparators;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class CustomComparatorMap1 implements Comparator<Integer>{
    Map<Integer,Integer> freqMap= new HashMap<>();

    public CustomComparatorMap1( Map<Integer,Integer> freqMap){
        this.freqMap=freqMap;
    }

    @Override
    public int compare(Integer i1,Integer i2){
        int compare = freqMap.get(i1)-freqMap.get(i2);
        if(compare!=0){
            return compare;
        }
        else{
            return i1-i2;
        }
    }
}
public class Medium {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 3, 2};
        Map<Integer,Integer> feMap = new HashMap<>();
        for(int num:nums){
            feMap.put(num,feMap.getOrDefault(num, 0)+1);
        }
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        Collections.sort(list,new CustomComparatorMap1(feMap));
        System.out.println(list);
    }
}
