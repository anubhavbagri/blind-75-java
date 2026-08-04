package Arrays_and_Hashing;

import java.util.*;

/**
 * Time Complexity: O(n log k)
 * Space Complexity: o(n)
 */

class Pair {
    int key;
    int freq;

    public Pair(int key, int freq) {
        this.key = key;
        this.freq = freq;
    }
}

public class TopKFrequent {

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[k];
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        // min heap based on freq
        PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> Integer.compare(p1.freq, p2.freq));
        for(var e : map.entrySet()){
            pq.offer(new Pair(e.getKey(), e.getValue()));
            if(pq.size() > k)   pq.poll();
        }
        int x = 0;
        while(pq.size() > 0){
            res[x++] = pq.poll().key;
        }
        return res;
    }

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        int[] a = {1, 1, 1, 2, 2, 3};
        System.out.println(Arrays.toString(topKFrequent(a, 2)));
    }
}
