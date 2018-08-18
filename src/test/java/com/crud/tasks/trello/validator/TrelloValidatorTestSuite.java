package com.crud.tasks.trello.validator;

import com.crud.tasks.domain.TrelloBoard;
import com.crud.tasks.domain.TrelloCard;
import com.crud.tasks.domain.TrelloList;
import com.crud.tasks.trello.client.trello.validator.TrelloValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class TrelloValidatorTestSuite {
    @Test
    public void testValidateTrelloBoards() {
        //Given
        TrelloValidator trelloValidator = new TrelloValidator();

        List<TrelloList> trelloLists = new ArrayList<>();
        trelloLists.add(new TrelloList("1", "test_list_1", false));

        List<TrelloBoard> trelloBoards = new ArrayList<>();
        trelloBoards.add(new TrelloBoard("1", "test", trelloLists));
        trelloBoards.add(new TrelloBoard("2", "board", trelloLists));

        //When
        List<TrelloBoard> expectedTrelloBoardList = trelloValidator.validateTrelloBoards(trelloBoards);

        //Then
        assertNotNull(expectedTrelloBoardList);
        assertEquals(1, expectedTrelloBoardList.size());
        expectedTrelloBoardList.forEach(trelloBoard -> {
            assertEquals("2", trelloBoard.getId());
            assertEquals("board", trelloBoard.getName());
        });
    }

    @Test
    public void validateTrelloCard() {
        //Given
        TrelloValidator trelloValidator = new TrelloValidator();
        TrelloCard trelloCard = new TrelloCard("Test", "Testing", "pos", "1");

        //When

        // Then
        trelloValidator.validateCard(trelloCard);
    }

}
