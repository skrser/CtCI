package ru.skrser.ctci3dot1;

public class Solution {

    private final int STACKS_NUMBER = 3;
    private final int STACK_MAXSIZE = 5;

    private int[] stackIndex = new int[STACKS_NUMBER];
    private Integer[] array = new Integer[STACKS_NUMBER * STACK_MAXSIZE];

    /**
     * Pushes value to stack
     *
     * @param stackNum stack number to be used. Acceptable values: 0..2
     * @param data     to be pushed in stack
     * @throws IndexOutOfBoundsException if stack overflow (more than STACK_MAXSIZE = 5 values)
     * @throws IllegalArgumentException  if stackNum < 0 or > 2
     */
    public void push(int stackNum, int data) {
        checkStackNum(stackNum);
        array[stackIndex[stackNum]++ * STACKS_NUMBER + stackNum] = data;
    }

    private void checkStackNum(int stackNum) {
        if (stackNum < 0 || stackNum > STACKS_NUMBER - 1)
            throw new IllegalArgumentException("Illegal value for stackNum: " + stackNum + ". Should be 0.." + (STACKS_NUMBER - 1));
    }

    /**
     * Pops value from stack
     *
     * @param stackNum stack number to be used. Acceptable values: 0..2
     * @return value from corresponding stack; null if nothing was previously pushed in stack
     * @throws IllegalArgumentException if stackNum < 0 or > 2
     */
    public Integer pop(int stackNum) {
        checkStackNum(stackNum);
        int dataIndex = --stackIndex[stackNum] * STACKS_NUMBER + stackNum;
        if (dataIndex >= 0) {
            int data = array[dataIndex];
            array[dataIndex] = null;
            return data;
        } else {
            stackIndex[stackNum] = 0;
            return null;
        }
    }

    /**
     * Picks value from stack
     *
     * @param stackNum stack number to be used. Acceptable values: 0..2
     * @return value from corresponding stack; null if nothing was previously pushed in stack
     * @throws IllegalArgumentException if stackNum < 0 or > 2
     */
    public Integer pick(int stackNum) {
        checkStackNum(stackNum);
        int dataIndex = (stackIndex[stackNum] - 1) * STACKS_NUMBER + stackNum;
        if (dataIndex >= 0) {
            return array[dataIndex];
        } else {
            return null;
        }
    }


}
