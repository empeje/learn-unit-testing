package io.mpj.in28minutes.unittesting.unittesting.business;

import io.mpj.in28minutes.unittesting.unittesting.data.SomeDataService;

public class SomeBusinessImpl {
    private SomeDataService someDataService;
    public int calculateSum(int[] data) {
        int sum = 0;
        for (int value:data) {
            sum += value;
        }
        return sum;
    }

    public int calculateSumUsingSomeDataService() {
        int sum = 0;
        int[] data = someDataService.retrieveAllData();
        for (int value:data) {
            sum += value;
        }
        return sum;
    }

    public void setSomeDataService(SomeDataService someDataService) {
        this.someDataService = someDataService;
    }
}
