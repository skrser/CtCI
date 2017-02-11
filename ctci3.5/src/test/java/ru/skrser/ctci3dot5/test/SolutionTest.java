package ru.skrser.ctci3dot5.test;

import org.junit.Test;
import ru.skrser.ctci3dot5.MyQueue;
import ru.skrser.ctci3dot5.Solution;
import ru.skrser.ctci3dot5.Solution2;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.Assert.assertEquals;

public class SolutionTest {


    private void testRandomAddPoll(MyQueue queue) {
        Queue<Integer> referenceQueueImpl = new LinkedList<Integer>();

        for (int i = 0; i < 50; i++) {
            boolean addOperation = Math.random() < 0.5;
            int numOfElements = (int) (Math.random() * 10);

            for (int j = 0; j < numOfElements; j++) {
                if (addOperation || referenceQueueImpl.isEmpty()) {
                    referenceQueueImpl.add(i + j);
                    queue.add(i + j);
                } else {
                    assertEquals((int) referenceQueueImpl.poll(), queue.poll());
                }
            }
        }

        while (!referenceQueueImpl.isEmpty())
            assertEquals((int) referenceQueueImpl.poll(), queue.poll());
    }

    private void testAddPoll(MyQueue queue) {
        Queue<Integer> referenceQueueImpl = new LinkedList<Integer>();
        for (int i = 0; i < 50; i++) {
            referenceQueueImpl.add(i);
            queue.add(i);
        }
        while (!referenceQueueImpl.isEmpty())
            assertEquals((int) referenceQueueImpl.poll(), queue.poll());
    }

    @Test
    public void testSolution() {
        testAddPoll(new Solution());
        testRandomAddPoll(new Solution());
    }

    @Test
    public void testSolution2() {
        testAddPoll(new Solution2());
        testRandomAddPoll(new Solution2());
    }
}
