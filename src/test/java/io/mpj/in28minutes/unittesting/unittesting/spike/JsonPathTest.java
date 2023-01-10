package io.mpj.in28minutes.unittesting.unittesting.spike;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class JsonPathTest {

    @Test
    public void learning() {
        String responseFromService = "[" +
                "{\"id\": 1000, \"name\": \"Pencil\", \"quantity\": 5}," +
                "{\"id\": 1001, \"name\": \"Pen\", \"quantity\": 15}," +
                "{\"id\": 1002, \"name\": \"Eraser\", \"quantity\": 10}," +
                "]";

        DocumentContext context = JsonPath.parse(responseFromService);
        int length = context.read("$.length()");
        assertThat(length).isEqualTo(3);

        System.out.println(context.read("$..id").toString());
        List<Integer> ids = context.read("$..id");
        assertThat(ids).containsExactly(1000,1001,1002);

        System.out.println(context.read("$.[1]").toString());
        System.out.println(context.read("$.[0:2]").toString());
        System.out.println(context.read("$.[?(@.name=='Eraser')]").toString());
        System.out.println(context.read("$.[?(@.quantity==5)]").toString());
    }
}
