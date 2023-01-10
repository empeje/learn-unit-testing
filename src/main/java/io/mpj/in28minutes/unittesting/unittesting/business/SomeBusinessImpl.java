package io.mpj.in28minutes.unittesting.unittesting.business;

import io.mpj.in28minutes.unittesting.unittesting.data.SomeDataService;

import java.util.Arrays;

public class SomeBusinessImpl {
    private SomeDataService someDataService;
    public int calculateSum(int[] data) {
        return Arrays.stream(data).reduce(Integer::sum).orElse(0);
    }

    public int calculateSumUsingSomeDataService() {
        int[] data = someDataService.retrieveAllData();
        return Arrays.stream(data).reduce(Integer::sum).orElse(0);
    }

    public void setSomeDataService(SomeDataService someDataService) {
        this.someDataService = someDataService;
    }
}
