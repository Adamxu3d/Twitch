package com.laioffer.twitch.external;

import com.laioffer.twitch.external.model.Game;
import com.laioffer.twitch.model.ItemType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// uses twitch api to get the rest controller
@RestController
public class GameController {

    private ItemType itemType = ItemType.VIDEO;

    // cannot be modified after using keyword final
    private final TwitchService twitchService;


    public GameController(TwitchService twitchService) {
        this.twitchService = twitchService;
    }


    @GetMapping("/game")
    public List<Game> getGames(@RequestParam(value = "game_name", required = false) String gameName) {

        itemType = ItemType.STREAM;

        if (gameName == null) {
            return twitchService.getTopGames();
        } else {
            return twitchService.getGames(gameName);
        }
    }
}
