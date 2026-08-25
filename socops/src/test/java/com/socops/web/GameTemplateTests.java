package com.socops.web;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

/** Validates the static accessibility contract for the Scavenger Hunt UI. */
class GameTemplateTests {

    @Test
    @DisplayName("Game page offers the Scavenger Hunt checklist and progress meter")
    void gamePageOffersScavengerHuntChecklistAndProgress() throws IOException {
        String template = new String(new ClassPathResource("templates/game.html")
                .getInputStream().readAllBytes(), StandardCharsets.UTF_8);

        assertAll(
                () -> assertTrue(template.contains("id=\"scavengerModeButton\""),
                        "The lobby should offer a Scavenger Hunt mode control"),
                () -> assertTrue(template.contains("id=\"scavengerList\""),
                        "The active game should provide a container for the checklist"),
                () -> assertTrue(template.contains("type=\"checkbox\""),
                        "The checklist should use native checkbox controls"),
                () -> assertTrue(template.contains("id=\"scavengerProgress\""),
                        "The active game should expose the Scavenger Hunt progress meter"),
                () -> assertTrue(template.contains("<progress"),
                        "Progress should use a semantic progress element"));
    }
}