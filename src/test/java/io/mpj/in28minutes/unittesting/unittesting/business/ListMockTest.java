package io.mpj.in28minutes.unittesting.unittesting.business;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class ListMockTest {

    private List<String> mock = mock(List.class);;

    @Test
    public void size_basic() {
        when(mock.size()).thenReturn(5);
        assertEquals(5, mock.size());
    }
    @Test
    public void returnDifferentValues() {
        when(mock.size()).thenReturn(5).thenReturn(10);
        assertEquals(5, mock.size());
        assertEquals(10, mock.size());
    }

    @Test
    public void returnWithParameters() {
        when(mock.get(0)).thenReturn("in28minutes");
        assertEquals("in28minutes", mock.get(0));
        assertEquals(null, mock.get(1));
    }

    @Test
    public void returnWithGenericParameters() {
        when(mock.get(anyInt())).thenReturn("in28minutes");
        assertEquals("in28minutes", mock.get(0));
        assertEquals("in28minutes", mock.get(1));
    }

    @Test
    public void verificationBasics() {
        // SUT
        String value1 = mock.get(0);
        String value2 = mock.get(1);

        // Verify
        verify(mock).get(0);
        verify(mock, times(2)).get(anyInt());
        verify(mock, atLeast(1)).get(anyInt());
        verify(mock, atLeastOnce()).get(anyInt());
        verify(mock, atMost(2)).get(anyInt());
        verify(mock, never()).get(2);
    }

    @Test
    public void argumentCapturing() {
        // SUT
        mock.add("SomeString1");
        mock.add("SomeString2");

        // Verification
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mock, times(2)).add(captor.capture());

        assertEquals("SomeString1", captor.getAllValues().get(0));
        assertEquals("SomeString2", captor.getAllValues().get(1));
    }

    @Test
    public void spying() {
        ArrayList arrayListMock = mock(ArrayList.class);

        System.out.println(arrayListMock.get(0)); // returning default value: null
        System.out.println(arrayListMock.size()); // returning default value: 0
        System.out.println(arrayListMock.add("Test 1"));
        System.out.println(arrayListMock.add("Test 2"));
        System.out.println(arrayListMock.size()); //0
        when(arrayListMock.size()).thenReturn(5);
        System.out.println(arrayListMock.size()); //0
    }
}
