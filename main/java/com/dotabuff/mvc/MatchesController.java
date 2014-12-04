package com.dotabuff.mvc;

import com.dotabuff.mvc.model.Match;
import com.dotabuff.mvc.model.Player;
import com.dotabuff.mvc.service.MatchesService;
import com.dotabuff.mvc.utils.UtilsHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Locale;

/**
 * Created by kirill on 24.11.2014.
 */
@Controller
public class MatchesController {
    private final MatchesService matchesService;

    @Autowired
    public MatchesController(MatchesService matchesService) {
        this.matchesService = matchesService;
    }


    /**
     * Simply selects the home view to render by returning its name.
     */
    @RequestMapping(value = {"/matches/{matchId}"}, method = RequestMethod.GET)
    public ModelAndView player(@PathVariable String matchId, Locale locale) {
        ModelAndView mv = new ModelAndView("match");
        mv.addObject("matchId", matchId);
        mv.addObject("match", matchesService.getFullMatch(locale, matchId));
        mv.addObject("urls", UtilsHelper.getUrls());
        return mv;
    }

    @RequestMapping(value = {"/matches"}, method = RequestMethod.GET)
    public ModelAndView searchPlayer(Model model) {
        ModelAndView mv =  new ModelAndView("search_match", "match", new Match());
        mv.addObject("urls", UtilsHelper.getUrls());
        return mv;
    }

    @RequestMapping(value = {"/matches"}, method = RequestMethod.POST)
    public String searchPlayerWithId(@ModelAttribute("match") Match match, BindingResult result, Model model) {
        if (result.hasErrors()) return "redirect:/matches/";
        return "redirect:/matches/"+match.getId();
    }

}
