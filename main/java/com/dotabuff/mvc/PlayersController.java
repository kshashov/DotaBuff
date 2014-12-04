package com.dotabuff.mvc;

import com.dotabuff.mvc.model.Match;
import com.dotabuff.mvc.model.Player;
import com.dotabuff.mvc.service.MatchesService;
import com.dotabuff.mvc.service.PlayerService;
import com.dotabuff.mvc.utils.Constants;
import com.dotabuff.mvc.utils.UnirestUtilsService;
import com.dotabuff.mvc.utils.UtilsHelper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Created by kirill on 22.11.2014.
 */
@Controller
public class PlayersController {

    private final MatchesService matchesService;
    private final PlayerService playerService;

    @Autowired
    public PlayersController(MatchesService matchesService, PlayerService playerService) {
        this.matchesService = matchesService;
        this.playerService = playerService;
    }


    /**
     * Simply selects the home view to render by returning its name.
     */
    @RequestMapping(value = {"/players/{playerId}"}, method = RequestMethod.GET)
    public ModelAndView player(@PathVariable String playerId, Locale locale) {
        ModelAndView mv = new ModelAndView("player");
        mv.addObject("playerId", playerId);
        mv.addObject("player", playerService.getPlayer(playerId));
        mv.addObject("urls", UtilsHelper.getUrls());
        mv.addObject("page", "player");
        mv.addObject("matches", matchesService.getLastMatches(locale, playerId, 5));
        return mv;
    }

    @RequestMapping(value = {"/players"}, method = RequestMethod.GET)
    public ModelAndView searchPlayer(Model model) {
        ModelAndView mv =  new ModelAndView("search_player", "player", new Player());
        mv.addObject("page", "players");
        mv.addObject("urls", UtilsHelper.getUrls());
        return mv;
    }

    @RequestMapping(value = {"/players"}, method = RequestMethod.POST)
    public String searchPlayerWithId(@ModelAttribute("player") Player player, BindingResult result, Model model) {
        if (result.hasErrors()) return "redirect:/players/";
        player.setId(player.getId().trim());
        String idStr = "";
        if (!UtilsHelper.isNumeric(player.getId())) {
            try {
                URL url = new URL(player.getId());
                String[] segments = player.getId().split("/");
                idStr = segments[segments.length - 1];

            } catch (MalformedURLException e) {
                Map<String, String> params = new HashMap<String, String>();
                params.put("vanityurl", player.getId());
                HttpResponse<JsonNode> response = UnirestUtilsService.getResolveUrlResponse(params);
                if (response == null) {
                    return "redirect:/players/";
                }

                if (response.getBody().getObject().has("response")) {
                    JSONObject responseJSON = (JSONObject) response.getBody().getObject().get("response");
                    if (responseJSON.getInt("success") == 1) {
                        idStr = responseJSON.getString("steamid");
                    }
                }
            }

            if (idStr.isEmpty() || !UtilsHelper.isNumeric(idStr)) {
                return "redirect:/players/";
            }
            player.setId(idStr);
        }

        if (player.getId().length() == 17) {
            player.setId(UtilsHelper.idTo32(new BigInteger(player.getId())).toString());
        }
        return "redirect:/players/"+player.getId();
    }

}
