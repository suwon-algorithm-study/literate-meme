package yeonuk.programmers.두_큐_합_같게_만들기;

import java.util.LinkedList;
import java.util.Queue;

/*
[case2]
<0>
1 2 1 2         // 6
1 10 1 2        // 14

<1>pop
1 2 1 2         // 6
10 1 2          // 13
1   ->  1

<2>insert
1 2 1 2 1       // 7
10 1 2          // 13

<3>pop
1 2 1 2 1       // 7
1 2             // 3
10  ->  2

<4>insert
1 2 1 2 1 10    // 17
1 2             // 3

<5>pop
10    // 10
1 2             // 3
1 2 1 2 1   ->  7

<6>insert
10              // 10
1 2 1 2 1 2 1   // 10

----------------------------------------------

[case3]
<0>
1 1    // 2
1 5    // 6

<1>pop
1 1    // 2
5    // 5
1

<2>insert
1 1 1   // 3
5       // 5

<3>pop
1 1 1   // 3
0       // 0    -> -1
5
 */
public class Solution {

    public int solution(int[] queue1, int[] queue2) {
        Queue<Long> firstQueue = createQueue(queue1);
        Queue<Long> secondQueue = createQueue(queue2);

        long firstSumValue = calculateSum(firstQueue);
        long secondSumValue = calculateSum(secondQueue);

        int count = 0;
        int totalSize = firstQueue.size() + secondQueue.size();

        while (firstSumValue != secondSumValue) {
            if (firstSumValue > secondSumValue) {
                Long firstValue = firstQueue.poll();
                firstSumValue -= firstValue;
                secondQueue.offer(firstValue);
                secondSumValue += firstValue;
            } else {
                Long secondValue = secondQueue.poll();
                secondSumValue -= secondValue;
                firstQueue.offer(secondValue);
                firstSumValue += secondValue;
            }

            count++;
            if (count > totalSize * 2) {
                return -1;
            }
        }

        return count;
    }

    private long calculateSum(Queue<Long> queue) {
        return queue.stream()
                .mapToLong(it -> it)
                .sum();
    }

    private Queue<Long> createQueue(int[] values) {
        Queue<Long> queue = new LinkedList<>();
        for (int value : values) {
            queue.offer((long) value);
        }
        return queue;
    }
}
