package com.dotabuff.mvc.service;

import com.dotabuff.mvc.model.Item;
import com.dotabuff.mvc.utils.DictionaryUtilService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * User: kish0713
 * Date: 03.12.14
 */
@Component
@Scope(value = "singleton")
public class ItemsService {
    private Map<String, Item> items;
    private DictionaryUtilService dictionaryUtilService;
    private Logger logger = Logger.getLogger(getClass().getName());
    @Autowired
    ServletContext servletContext;

    private void initItems() {
        items = new HashMap<String, Item>();
        JSONParser parser = new JSONParser();
        Object obj = null;
        try {
            try {
                obj = parser.parse(new FileReader(servletContext.getRealPath("/WEB-INF/items.json")));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (ParseException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        if (obj != null) {
            JSONObject jsonObject = (JSONObject) ((JSONObject) obj).get("result");
            JSONArray jsonArray = (JSONArray) jsonObject.get("items");
            for (int i = 0; i < jsonArray.size(); i++) {
                Item item = new Item();
                JSONObject itemJson = (JSONObject) jsonArray.get(i);
                item.setId(String.valueOf((Long) itemJson.get("id")));
                item.setName((String) itemJson.get("name"));
                items.put(String.valueOf(itemJson.get("id")), item);
            }


        }
    }

    @Autowired
    public ItemsService(DictionaryUtilService dictionaryUtilService) {
        dictionaryUtilService = dictionaryUtilService;
    }

    public Item getItem(int id) {
        if (items == null) {
            initItems();
        }
        if (id > 0 && id < items.size()) {
            return items.get(String.valueOf(id));
        }
        return null;
    }
}
