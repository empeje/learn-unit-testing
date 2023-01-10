package io.mpj.in28minutes.unittesting.unittesting.controller;

import io.mpj.in28minutes.unittesting.unittesting.business.ItemBusinessService;
import io.mpj.in28minutes.unittesting.unittesting.model.Item;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ItemController.class)
public class ItemControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ItemBusinessService businessService;

    @Test
    public void dummyItem_basic() throws Exception {
        // call GET "/dummy-item" application/json
        RequestBuilder request = MockMvcRequestBuilders
                .get("/dummy-item")
                .accept(MediaType.APPLICATION_JSON);;
        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":1,\"name\":\"Ball\",\"price\":10}"))
                .andReturn();

        JSONAssert.assertEquals("{\"id\":1,\"name\":\"Ball\",\"price\":10}", result.getResponse().getContentAsString(), false);
    }
    @Test
    public void itemForBusinessService_basic() throws Exception {
        when(businessService.retrieveHarcodedItem()).thenReturn(new Item(1, "Ball", 10, 100));
        // call GET "/dummy-item" application/json
        RequestBuilder request = MockMvcRequestBuilders
                .get("/item-from-business-service")
                .accept(MediaType.APPLICATION_JSON);;
        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":1,\"name\":\"Ball\",\"price\":10}"))
                .andReturn();

        JSONAssert.assertEquals("{\"id\":1,\"name\":\"Ball\",\"price\":10}", result.getResponse().getContentAsString(), false);
    }
    @Test
    public void retrieveAllItems_basic() throws Exception {
        when(businessService.retrieveAllItems()).thenReturn(Arrays.asList(
                new Item(1, "Ball", 10, 100),
                new Item(2, "Ball", 10, 100)
        ));
        // call GET "/dummy-item" application/json
        RequestBuilder request = MockMvcRequestBuilders
                .get("/all-items-from-database")
                .accept(MediaType.APPLICATION_JSON);;
        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("[{\"id\":1,\"name\":\"Ball\",\"price\":10}, {}]"))
                .andReturn();

        JSONAssert.assertEquals("[{\"id\":1,\"name\":\"Ball\",\"price\":10}, {}]", result.getResponse().getContentAsString(), false);
    }
    @Ignore
    public void addItem_basic() throws Exception {
        when(businessService.retrieveAllItems()).thenReturn(Arrays.asList(
                new Item(1, "Ball", 10, 100),
                new Item(2, "Ball", 10, 100)
        ));
        // call GET "/dummy-item" application/json
        RequestBuilder request = MockMvcRequestBuilders
                .post("/items")
                .content("put your content here")
                .accept(MediaType.APPLICATION_JSON);;
        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("[{\"id\":1,\"name\":\"Ball\",\"price\":10}, {}]"))
                .andReturn();

        JSONAssert.assertEquals("[{\"id\":1,\"name\":\"Ball\",\"price\":10}, {}]", result.getResponse().getContentAsString(), false);
    }

}
