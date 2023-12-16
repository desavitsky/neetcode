package desavitsky.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class Task1046 {
    public int lastStoneWeight(int[] stones) {
        var heap = new PriorityQueue<Integer>(stones.length, Collections.reverseOrder());
        for (var stone: stones) heap.add(stone);
        while (heap.size() > 1) {
            var first = heap.remove();
            var second = heap.remove();
            if (!first.equals(second)) heap.add(Math.abs(first - second));
        }
        return heap.isEmpty() ? 0 : heap.peek();
    }
}
