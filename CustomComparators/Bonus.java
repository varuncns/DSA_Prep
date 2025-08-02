package CustomComparators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class ComparatorBonus implements Comparator<Integer>{
    int pos;
    public ComparatorBonus(int pos){
        this.pos=pos;
    }
    @Override
    public int compare(Integer a,Integer b){
        int distA=Math.abs(pos-a);
        int distB=Math.abs(pos-b);
        int diff = distA-distB;
        if(diff!=0){
            return diff;
        }
        else{
            return a-b;
        }
    }
}
public class Bonus {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(10, 5, 3, 9, 2));
        int k = 7;
        Collections.sort(list,new ComparatorBonus(k));
        System.out.println(list);
    }
}
