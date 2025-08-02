package CustomComparators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



class CustomComparatorMap2 implements Comparator<Map.Entry<String, Integer>> {
    @Override
    public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
        int diff = e2.getValue() - e1.getValue(); // Descending by score
        if (diff != 0) {
            return diff;
        } else {
            return e1.getKey().compareTo(e2.getKey()); // Ascending by name
        }
    }
}
public class Better1 {
    public static void main(String[] args) {
        Map<String, Integer> playerScores = new HashMap<>();
        playerScores.put("Alice", 50);
        playerScores.put("Bob", 75);
        playerScores.put("Charlie", 75);
        playerScores.put("Dave", 60);
        playerScores.put("Eve", 50);
        List<Map.Entry<String,Integer>> entries = new ArrayList<>(playerScores.entrySet());
        Collections.sort(entries,new CustomComparatorMap2());
        System.out.println(entries);
    }
}
