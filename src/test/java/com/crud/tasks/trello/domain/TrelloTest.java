package com.crud.tasks.trello.domain;

import com.crud.tasks.domain.Trello;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class TrelloTest {
    @Test
    public void testGettersAfterNoArgsConstructor() {
        //Given
        Trello trello =new Trello();

        // When and Then
        assertNull(trello.getBoard());
        assertNull(trello.getCard());
    }

    @Test
    public void testGettersAfterAllArgsConstructor() {
        Trello trello =new Trello(1,3);

        // When and Then
        assertEquals(1,trello.getBoard().intValue());
        assertEquals(3,trello.getCard().intValue());
    }

}
