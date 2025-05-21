package HashMaps;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class intro {
    public static void main(String[] args) {
        int nums[] = {1, 1, 1, 2, 2, 3};
        
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0)+1);
        }
        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>(
            (a,b) -> a.getValue() - b.getValue()
        );
        for(Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            frequencyMap.offer(entry);
            if(pq.size() > 2) {
                pq.poll();
            }
        }

        System.out.println(frequencyMap.keySet());
        System.out.println(frequencyMap.values());

    }
}
