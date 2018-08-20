package com.crud.tasks.trello.domain;

import com.crud.tasks.domain.CreatedTrelloCardDto;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class CreatedTrelloCardDtoTest {
    @Test
    public void testGettersAfterNoArgsConstructor() {
        // Given
        CreatedTrelloCardDto card = new CreatedTrelloCardDto();

        // When and Then
        assertNull(card.getId());
        assertNull(card.getName());
        assertNull(card.getShortUrl());
    }

    @Test
    public void testGettersAfterAllArgsConstructor() {
        // Given
        CreatedTrelloCardDto card = new CreatedTrelloCardDto("testId", "test_name", "http://test.url", null);
        // When and Then
        assertEquals("testId", card.getId());
        assertEquals("test_name", card.getName());
        assertEquals("http://test.url", card.getShortUrl());
    }

}
