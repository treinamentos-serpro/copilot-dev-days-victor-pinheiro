package com.socops.web;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.socops.data.IcebreakerPrompts;
import com.socops.model.BingoCell;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/** Validates the REST contract used by the Scavenger Hunt mode. */
@WebMvcTest(BingoRestController.class)
class BingoRestControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("Scavenger Hunt returns every bingo prompt as an unchecked list item")
    void scavengerHuntListUsesEveryBingoPromptWithoutFreeCell() throws Exception {
        String responseBody = mockMvc.perform(get("/api/scavenger-hunt/fresh-list"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andReturn()
                .getResponse()
                .getContentAsString();

        List<BingoCell> huntItems = objectMapper.readValue(responseBody,
                new TypeReference<List<BingoCell>>() { });

        assertEquals(IcebreakerPrompts.ALL_PROMPTS.size(), huntItems.size(),
                "The hunt should show every question used by bingo");
        assertEquals(Set.copyOf(IcebreakerPrompts.ALL_PROMPTS),
                huntItems.stream().map(BingoCell::prompt).collect(Collectors.toSet()),
                "The hunt prompts should exactly match the bingo prompt catalogue");
        assertEquals(huntItems.size(), huntItems.stream().map(BingoCell::id).collect(Collectors.toSet()).size(),
                "Each hunt item should have a unique id for its checkbox");

        for (BingoCell item : huntItems) {
            assertFalse(item.freeCell(), "Scavenger Hunt must not include a free cell");
            assertFalse(item.selected(), "Every hunt item must begin unchecked");
        }
    }
}