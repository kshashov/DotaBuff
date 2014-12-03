package com.dotabuff.mvc.utils;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.ejb.Init;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by kirill on 22.11.2014.
 */

@Component
@Scope(value = "singleton")
public class DictionaryUtilService {
    public static List<String> heroes;
    public static List<String> locHeroes;
    public static List<String> lobbies;
    public static List<String> leaverStatus;
    public static List<String> gameMode;

    @PostConstruct
    public static void initHeroes(){
        heroes = new ArrayList<String>(150);
        heroes.add(0, "empty");
        heroes.add(1,"antimage");
        heroes.add(2,"axe");
        heroes.add(3,"bane");
        heroes.add(4,"bloodseeker");
        heroes.add(5,"crystal_maiden");
        heroes.add(6,"drow_ranger");
        heroes.add(7,"earthshaker");
        heroes.add(8,"juggernaut");
        heroes.add(9,"mirana");
        heroes.add(10,"nevermore");
        heroes.add(11,"morphling");
        heroes.add(12,"phantom_lancer");
        heroes.add(13,"puck");
        heroes.add(14,"pudge");
        heroes.add(15,"razor");
        heroes.add(16,"sand_king");
        heroes.add(17,"storm_spirit");
        heroes.add(18,"sven");
        heroes.add(19,"tiny");
        heroes.add(20,"vengefulspirit");
        heroes.add(21,"windrunner");
        heroes.add(22,"zuus");
        heroes.add(23,"kunkka");
        heroes.add(24,"");
        heroes.add(25,"lina");
        heroes.add(26,"lion");
        heroes.add(27,"shadow_shaman");
        heroes.add(28,"slardar");
        heroes.add(29,"tidehunter");
        heroes.add(30,"witch_doctor");
        heroes.add(31,"lich");
        heroes.add(32,"riki");
        heroes.add(33,"enigma");
        heroes.add(34,"tinker");
        heroes.add(35,"sniper");
        heroes.add(36,"necrolyte");
        heroes.add(37,"warlock");
        heroes.add(38,"beastmaster");
        heroes.add(39,"queenofpain");
        heroes.add(40,"venomancer");
        heroes.add(41,"faceless_void");
        heroes.add(42,"skeleton_king");
        heroes.add(43,"death_prophet");
        heroes.add(44,"phantom_assassin");
        heroes.add(45,"pugna");
        heroes.add(46,"templar_assassin");
        heroes.add(47,"viper");
        heroes.add(48,"luna");
        heroes.add(49,"dragon_knight");
        heroes.add(50,"dazzle");
        heroes.add(51,"rattletrap");
        heroes.add(52,"leshrac");
        heroes.add(53,"furion");
        heroes.add(54,"life_stealer");
        heroes.add(55,"dark_seer");
        heroes.add(56,"clinkz");
        heroes.add(57,"omniknight");
        heroes.add(58,"enchantress");
        heroes.add(59,"huskar");
        heroes.add(60,"night_stalker");
        heroes.add(61,"broodmother");
        heroes.add(62,"bounty_hunter");
        heroes.add(63,"weaver");
        heroes.add(64,"jakiro");
        heroes.add(65,"batrider");
        heroes.add(66,"chen");
        heroes.add(67,"spectre");
        heroes.add(68,"doom_bringer");
        heroes.add(69,"ancient_apparition");
        heroes.add(70,"ursa");
        heroes.add(71,"spirit_breaker");
        heroes.add(72,"gyrocopter");
        heroes.add(73,"alchemist");
        heroes.add(74,"invoker");
        heroes.add(75,"silencer");
        heroes.add(76,"obsidian_destroyer");
        heroes.add(77,"lycan");
        heroes.add(78,"brewmaster");
        heroes.add(79,"shadow_demon");
        heroes.add(80,"lone_druid");
        heroes.add(81,"chaos_knight");
        heroes.add(82,"meepo");
        heroes.add(83,"treant");
        heroes.add(84,"ogre_magi");
        heroes.add(85,"undying");
        heroes.add(86,"rubick");
        heroes.add(87,"disruptor");
        heroes.add(88,"nyx_assassin");
        heroes.add(89,"naga_siren");
        heroes.add(90,"keeper_of_the_light");
        heroes.add(91,"wisp");
        heroes.add(92,"visage");
        heroes.add(93,"slark");
        heroes.add(94,"medusa");
        heroes.add(95,"troll_warlord");
        heroes.add(96,"centaur");
        heroes.add(97,"magnataur");
        heroes.add(98,"shredder");
        heroes.add(99,"bristleback");
        heroes.add(100,"tusk");
        heroes.add(101,"skywrath_mage");
        heroes.add(102,"abaddon");
        heroes.add(103,"elder_titan");
        heroes.add(104,"legion_commander");
        heroes.add(105,"techies");
        heroes.add(106,"ember_spirit");
        heroes.add(107,"earth_spirit");
        heroes.add(108,"");
        heroes.add(109,"terrorblade");
        heroes.add(110,"phoenix");
        heroes.add(111,"oracle");
    }

    @PostConstruct
    public static void initLocHeroes(){
        locHeroes = new ArrayList<String>(150);
        locHeroes.add(0, "empty");
        locHeroes.add(1,"Anti-Mage");
        locHeroes.add(2,"Axe");
        locHeroes.add(3,"Bane");
        locHeroes.add(4,"Bloodseeker");
        locHeroes.add(5,"Crystal Maiden");
        locHeroes.add(6,"Drow Ranger");
        locHeroes.add(7,"Earthshaker");
        locHeroes.add(8,"Juggernaut");
        locHeroes.add(9,"Mirana");
        locHeroes.add(10,"Shadow Fiend");
        locHeroes.add(11,"Morphling");
        locHeroes.add(12,"Phantom Lancer");
        locHeroes.add(13,"Puck");
        locHeroes.add(14,"Pudge");
        locHeroes.add(15,"Razor");
        locHeroes.add(16,"Sand King");
        locHeroes.add(17,"Storm Spirit");
        locHeroes.add(18,"Sven");
        locHeroes.add(19,"Tiny");
        locHeroes.add(20,"Vengeful Spirit");
        locHeroes.add(21,"Windranger");
        locHeroes.add(22,"Zeus");
        locHeroes.add(23,"Kunkka");
        locHeroes.add(24,"");
        locHeroes.add(25,"Lina");
        locHeroes.add(26,"Lion");
        locHeroes.add(27, "Shadow Shaman");
        locHeroes.add(28, "Slardar");
        locHeroes.add(29, "Tidehunter");
        locHeroes.add(30, "Witch Doctor");
        locHeroes.add(31,"Lich");
        locHeroes.add(32,"Riki");
        locHeroes.add(33,"Enigma");
        locHeroes.add(34,"Tinker");
        locHeroes.add(35,"Sniper");
        locHeroes.add(36,"Necrophos");
        locHeroes.add(37,"Warlock");
        locHeroes.add(38,"Beastmaster");
        locHeroes.add(39,"Queen of Pain");
        locHeroes.add(40,"Venomancer");
        locHeroes.add(41,"Faceless Void");
        locHeroes.add(42,"Wraith King");
        locHeroes.add(43,"Death Prophet");
        locHeroes.add(44,"Phantom Assassin");
        locHeroes.add(45,"Pugna");
        locHeroes.add(46,"Templar Assassin");
        locHeroes.add(47,"Viper");
        locHeroes.add(48,"Luna");
        locHeroes.add(49,"Dragon Knight");
        locHeroes.add(50,"Dazzle");
        locHeroes.add(51,"Clockwerk");
        locHeroes.add(52,"Leshrac");
        locHeroes.add(53,"Nature's Prophet");
        locHeroes.add(54,"Lifestealer");
        locHeroes.add(55,"Dark Seer");
        locHeroes.add(56,"Clinkz");
        locHeroes.add(57,"Omniknight");
        locHeroes.add(58,"Enchantress");
        locHeroes.add(59,"Huskar");
        locHeroes.add(60,"Night Stalker");
        locHeroes.add(61,"Broodmother");
        locHeroes.add(62,"Bounty Hunter");
        locHeroes.add(63,"Weaver");
        locHeroes.add(64,"Jakiro");
        locHeroes.add(65,"Batrider");
        locHeroes.add(66,"Chen");
        locHeroes.add(67,"Spectre");
        locHeroes.add(68,"Doom");
        locHeroes.add(69,"Ancient Apparition");
        locHeroes.add(70,"Ursa");
        locHeroes.add(71,"Spirit Breaker");
        locHeroes.add(72,"Gyrocopter");
        locHeroes.add(73,"Alchemist");
        locHeroes.add(74,"Invoker");
        locHeroes.add(75,"Silencer");
        locHeroes.add(76,"Obsidian_destroyer");
        locHeroes.add(77,"Lycan");
        locHeroes.add(78,"Brewmaster");
        locHeroes.add(79,"Shadow Demon");
        locHeroes.add(80,"Lone Druid");
        locHeroes.add(81,"Chaos Knight");
        locHeroes.add(82,"Meepo");
        locHeroes.add(83,"Treant Protector");
        locHeroes.add(84,"Ogre magi");
        locHeroes.add(85,"Undying");
        locHeroes.add(86,"Rubick");
        locHeroes.add(87,"Disruptor");
        locHeroes.add(88,"Nyx Assassin");
        locHeroes.add(89,"Naga Siren");
        locHeroes.add(90,"Keeper of the Light");
        locHeroes.add(91,"Io");
        locHeroes.add(92,"Visage");
        locHeroes.add(93,"Slark");
        locHeroes.add(94,"Medusa");
        locHeroes.add(95,"Troll Warlord");
        locHeroes.add(96,"Centaur Warrunner");
        locHeroes.add(97,"Magnus");
        locHeroes.add(98,"Timbersaw");
        locHeroes.add(99,"Bristleback");
        locHeroes.add(100,"Tusk");
        locHeroes.add(101,"Skywrath Mage");
        locHeroes.add(102,"Abaddon");
        locHeroes.add(103,"Elder Titan");
        locHeroes.add(104,"Legion Commander");
        locHeroes.add(105,"Techies");
        locHeroes.add(106,"Ember Spirit");
        locHeroes.add(107,"Earth Spirit");
        locHeroes.add(108,"");
        locHeroes.add(109,"Terrorblade");
        locHeroes.add(110,"Phoenix");
        locHeroes.add(111,"Oracle");
    }

    @PostConstruct
    public static void initLobbies(){
        lobbies = new ArrayList<String>();
        lobbies.add(0,"Public matchmaking");
        lobbies.add(1,"Practice");
        lobbies.add(2,"Tournament");
        lobbies.add(3,"Tutorial");
        lobbies.add(4,"Co-op with bots");
        lobbies.add(5,"Team match");
        lobbies.add(6,"Solo Queue");
        lobbies.add(7,"Ranked");
        lobbies.add(8,"Solo Mid 1vs1");
    }

    @PostConstruct
    public static void initLeaverStatus(){
        leaverStatus = new ArrayList<String>();
        leaverStatus.add(0,"");
        leaverStatus.add(1,"Leave");
    }

    @PostConstruct
    public static void initGameMode(){
        gameMode = new ArrayList<String>();
        gameMode.add(0,"Unknown");
        gameMode.add(1,"All Pick");
        gameMode.add(2,"Captains Mode");
        gameMode.add(3,"Random Draft");
        gameMode.add(4,"Single Draft");
        gameMode.add(5,"All Random");
        gameMode.add(6,"?? INTRO/DEATH ??");
        gameMode.add(7,"The Diretide");
        gameMode.add(8,"Reverse Captains Mode");
        gameMode.add(9,"Greeviling");
        gameMode.add(10,"Tutorial");
        gameMode.add(11,"Mid Only");
        gameMode.add(12,"Least Played");
        gameMode.add(13,"New Player Pool");
        gameMode.add(14,"Compendium Matchmaking");
        gameMode.add(15,"Custom");
        gameMode.add(16,"Captains Draft");
        gameMode.add(17,"Balanced Draft");
        gameMode.add(18,"Ability Draft");
        gameMode.add(19,"?? Event ??");
        gameMode.add(20,"All Random Death Match");
        gameMode.add(21,"1vs1 Solo Mid");
    }
    public static void init(){
        initHeroes();
    }

    public static final String getGameMode(int mode) {
        try {
            if (mode >= gameMode.size()) {
                mode = mode % (gameMode.size() - 1);
            }
            if (gameMode.get(mode) != null) {
                return gameMode.get(mode);
            }
        } catch (Exception e){

        }

        return "Empty";
    }

    public static String getHero(int heroId) {
        if (heroes.get(heroId) != null) {
            return heroes.get(heroId);
        }

        return "Empty";
    }

    public static String getLocHero(int heroId) {
        if (locHeroes.get(heroId) != null) {
            return locHeroes.get(heroId);
        }

        return "Empty";
    }

    public static String getLobbieType(int type) {
        if (lobbies.get(type) != null) {
            return lobbies.get(type);
        }

        return "Empty";
    }

    public static String getLeaverStatus(int leaver_status) {
        if (leaver_status == 0 || leaver_status == 1) {
            return leaverStatus.get(0);
        }

        if (leaver_status > 1) {
            leaver_status = 1;
        }

        if (leaverStatus.get(leaver_status) != null) {
            return leaverStatus.get(leaver_status);
        }

        return "Empty";
    }
}
