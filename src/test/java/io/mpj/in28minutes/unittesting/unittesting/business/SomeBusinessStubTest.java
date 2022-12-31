package io.mpj.in28minutes.unittesting.unittesting.business;

import io.mpj.in28minutes.unittesting.unittesting.data.SomeDataService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SomeDataServiceStubBasic implements SomeDataService {
    @Override
    public int[] retrieveAllData() {
        return new int[] {1, 2, 3};
    }
}
class SomeDataServiceStubEmpty implements SomeDataService {
    @Override
    public int[] retrieveAllData() {
        return new int[] {};
    }
}

class SomeDataServiceStubOneValue implements SomeDataService {
    @Override
    public int[] retrieveAllData() {
        return new int[] {5};
    }
}

public class SomeBusinessStubTest {
    @Test
    public void calculateSumUsingDataService_basic() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        business.setSomeDataService(new SomeDataServiceStubBasic());
        int actualResult = business.calculateSumUsingSomeDataService();
        int expectedResult = 6;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void calculateSum_empty() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        business.setSomeDataService(new SomeDataServiceStubEmpty());
        int actualResult = business.calculateSumUsingSomeDataService();
        int expectedResult = 0;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void calculateSum_oneValue() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        business.setSomeDataService(new SomeDataServiceStubOneValue());
        int actualResult = business.calculateSumUsingSomeDataService();
        int expectedResult = 5;
        assertEquals(expectedResult, actualResult);
    }
}
