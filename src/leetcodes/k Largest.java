// import java.util.Arrays;
// import java.util.Map;

// class Solution {
    
//     public static int[] topKFrequent(int[] nums, int k) {
//         Map<Integer,Integer> frequencyMap = new HashMap<Integer,Integer>();
//         for(int num : nums) {
//             frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
//         }
        
//         PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
//                 (a, b) -> a.getValue() - b.getValue()
//         );
        
//         for(Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
//             pq.offer(entry);
//             if(pq.size() > k) {
//                 pq.poll();
//             }
//         }
        
//         int[] result = new int[k];
//         for(int i = k - 1; i >= 0; i--) {
//             result[i] = pq.poll().getKey();
//         }
        
//         Arrays.sort(result);
//         return result;


//     }

//     public static void main(String[] args) {
//         Solution sol = new Solution();
//         int nums[] = { 1,1,1,2,2,3 };
//         int k = 2;
//         System.out.println(topKFrequent(nums, k));
        
//     }
// }


// ? using bucket sort
import java.util.*;

class Solution {

    public static int[] topKFrequent(int[] nums, int k) {
        // Step 1: Build the frequency map
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] bucket = new List[nums.length + 1];
        for (int i = 0; i <= nums.length; i++) {
            bucket[i] = new ArrayList<>();
        }

        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            int frequency = entry.getValue();
            int number = entry.getKey();
            bucket[frequency].add(number);
        }

        List<Integer> resultList = new ArrayList<>();
        for (int i = nums.length; i >= 0 && resultList.size() < k; i--) {
            if (!bucket[i].isEmpty()) {
                resultList.addAll(bucket[i]);
            }
        }

        // Convert the resultList to an array
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = resultList.get(i);
        }

        // Optional: Sort the result if required
        Arrays.sort(result);

        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int nums[] = {1, 1, 1, 2, 2, 3};
        int k = 2;
        System.out.println(Arrays.toString(topKFrequent(nums, k)));
    }
}
