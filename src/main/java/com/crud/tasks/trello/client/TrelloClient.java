package com.crud.tasks.trello.client;

import com.crud.tasks.domain.TrelloBoardDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class TrelloClient {

   // @Value("${trello.api.endpoint.prod}")
    private String trelloApiEndpoint="https://api.trello.com/1";

   //@Value("${trello.app.key}")
    private String trelloAppKey="b7567eade6ed7da83c59274875a4285b";

   //@Value("${token}")
    private String trelloToken="149742642e9de1de031a05ea2575831c6a2702e3123c6595e1a316f9afd0d7a6";

    //@Value("${trello.app.username}")
    private String trelloUsername="annapiwowarczyk1";


    @Autowired
    private RestTemplate restTemplate;

    public List<TrelloBoardDto> getTrelloBoards() {

        URI url = UriComponentsBuilder.fromHttpUrl(trelloApiEndpoint + "/members" + trelloUsername + "/boards")
                .queryParam("key", trelloAppKey)
                .queryParam("token", trelloToken)
                .queryParam("username", trelloUsername)
                .queryParam("fields", "name,id").build().encode().toUri();

        TrelloBoardDto[] boardsResponse = restTemplate.getForObject(url, TrelloBoardDto[].class);

        if (boardsResponse != null)

        {
            return Arrays.asList(boardsResponse);
        }
        return new ArrayList<>();
    }

}

