package com.laioffer.twitch.external;

import com.laioffer.twitch.external.model.Game;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// uses twitch api to get the rest controller
/*
 * Primary role : exposes http endpoint for a client (web browser, CRUD operations)
 * Assumes default behaviour of transforming response objects into JSON or XML - typically Jackson or JSON
 * MVC - Model View Controller
 */
@RestController
public class GameController {

    // cannot be modified after using keyword final
    private final TwitchService twitchService;


    public GameController(TwitchService twitchService) {
        this.twitchService = twitchService;
    }


    // this decorator maps the http get request to specific methods in the controller
    // "/game" should be the relative URL path where the method should be accessible
    @GetMapping("/game")
    public List<Game> getGames(@RequestParam(value = "game_name", required = false) String gameName) {

        if (gameName == null) {
            return twitchService.getTopGames();
        } else {
            return twitchService.getGames(gameName);
        }
    }
}
