package Heap_PriorityQueue;

import java.util.*;

/**
 * Time Complexity: O(log n)
 * Space Complexity: O(2n)
 */

public class MedianFinder {

    PriorityQueue<Integer> leftMaxHeap; // for getting the largest element in left half
    PriorityQueue<Integer> rightMinHeap; // for getting the smallest element in right half

    public MedianFinder() {
        leftMaxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        rightMinHeap = new PriorityQueue<>();
    }

    // O(log N)
    public void addNum(int num) {
        if (leftMaxHeap.isEmpty() || num < leftMaxHeap.peek()) {
            leftMaxHeap.offer(num);
        } else {
            rightMinHeap.offer(num);
        }

        // always maintain left heap size one grater than right heap size
        // or both are of equal size
        if (leftMaxHeap.size() > rightMinHeap.size() + 1) {
            rightMinHeap.offer(leftMaxHeap.poll());
        } else if (rightMinHeap.size() > leftMaxHeap.size()) {
            leftMaxHeap.offer(rightMinHeap.poll());
        }
    }

    // O(1)
    public double findMedian() {
        // if even
        if (leftMaxHeap.size() == rightMinHeap.size()) {
            return (leftMaxHeap.peek() + rightMinHeap.peek()) / 2.0;
        }

        // if odd
        return leftMaxHeap.peek();
    }


    public static void main(String[] args) {
        run();
    }

    public static void run() {
        MedianFinder mf = new MedianFinder();
        mf.addNum(1);
        mf.addNum(2);
        System.out.println(mf.findMedian()); // 1.5
        mf.addNum(3);
        System.out.println(mf.findMedian()); // 2.0
    }
}
