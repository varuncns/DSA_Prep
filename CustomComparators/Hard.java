package CustomComparators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class HardComparator implements Comparator<List<Integer>>{
    @Override
    public int compare(List<Integer>a,List<Integer>b){
        int compareVal=b.get(1)-a.get(1);
        if(compareVal!=0){
            return compareVal;
        }
        else{
            return a.get(0)-b.get(0);
        }
    }
}
public class Hard {
    public static void main(String[] args) {
        List<List<Integer>> matrix = new ArrayList<>();
        matrix.add(Arrays.asList(1, 2));
        matrix.add(Arrays.asList(3, 4));
        matrix.add(Arrays.asList(2, 3));
        matrix.add(Arrays.asList(2, 2));
        Collections.sort(matrix,new HardComparator());
        System.out.println(matrix);
    }
}
