package com.seven.wonders.controller;

import com.seven.wonders.core.Application;
import com.seven.wonders.core.Session;
import com.seven.wonders.pojo.entity.Game;
import com.seven.wonders.pojo.enumer.GameStatus;
import com.seven.wonders.pojo.entity.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

/**
 * Created by Pavel Ruban on 04.02.2017.
 * Contoller for Login From
 */

@Scope(scopeName = "prototype")
@Controller
public class LoginController {

    private String port;

    @Autowired
    private Application application;

    @Autowired
    private Session session;

    @RequestMapping(value = "/newgame/create", method = {RequestMethod.GET,RequestMethod.POST})
    public String newGame(@RequestParam("game_name") String gameName,
                          @RequestParam("player_name") String playerName) {
        Player player = new Player();
        player.setName(playerName);
        player.setAdmin(true);
        session.setCurrentPlayer(player);

        Game newGame = new Game();
        newGame.setName(gameName);
        newGame.setNumber(1);
        newGame.setStatus(GameStatus.NEW);

        ArrayList<Player> players = newGame.getPlayers();
        if (players == null) {
            players = new ArrayList<>();
        }
        players.add(player);
        newGame.setPlayers(players);

        application.getAllGames().put((application.getAllGames().size() + 1) + "", newGame);
        session.setCurrentGameId(application.getAllGames().size() + "");
        return "redirect:/newgame";
    }

    public String enterGame() {
        return "";
    }

    @RequestMapping(value = "/login", method = {RequestMethod.GET,RequestMethod.POST})
    public String login(Model model){
        model.addAttribute("allGames", application.getAllGames().values());
        return "login";
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }
}
