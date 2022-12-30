package io.mpj.in28minutes.unittesting.unittesting.business;

public class SomeBusinessImpl {
    public int calculateSum(int[] data) {
        int sum = 0;
        for (int value:data) {
            sum += value;
        }
        return sum;
    }
}
