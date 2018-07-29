package com.crud.tasks.trello.client;

import com.crud.tasks.domain.TrelloBoardDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TrelloClient {

   //@Value("${trello.api.endpoint.prod}")
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

        @RequestMapping(method = RequestMethod.GET, value = "getTrelloBoards")

        public List<TrelloBoardDto> getTrelloBoards () {
            List<TrelloBoardDto> trelloBoards = trelloClient.getTrelloBoards().stream().filter("TUTAJ FILTRACJA").collect(Collectors.toList());

            return trelloBoards;

        /*TrelloBoardDto[] boardsResponse = restTemplate.getForObject(url, TrelloBoardDto[].class);

        if (boardsResponse != null)

        {
            return Arrays.asList(boardsResponse);
        }
        return new ArrayList<>();*/
        }
    }

    private URI getTrelloBoardsUrl() {
        return UriComponentsBuilder.fromHttpUrl(trelloApiEndpoint + "/members/annapiwowarczyk1/boards")
                .queryParam("key", trelloAppKey)
                .queryParam("token", trelloToken)
                .queryParam("username", trelloUsername)
                .queryParam("fields", "name,id").build().encode().toUri();
    }

}



