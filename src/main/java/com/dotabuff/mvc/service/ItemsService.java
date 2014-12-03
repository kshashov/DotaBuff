package com.dotabuff.mvc.service;

import com.dotabuff.mvc.model.Item;
import com.dotabuff.mvc.utils.DictionaryUtilService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * User: kish0713
 * Date: 03.12.14
 */
@Component
public class ItemsService {
    private List<Item> items;
    private DictionaryUtilService dictionaryUtilService;

    @PostConstruct
    private void initItems(){
        items = new ArrayList<Item>();
        JSONParser parser = new JSONParser();
        Object obj = null;
        try {
            obj = parser.parse(new FileReader("../resources/items.json"));
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (ParseException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        JSONObject jsonObject = (JSONObject) ((JSONObject) obj).get("result");
        JSONArray jsonArray = (JSONArray) jsonObject.get("items");
        for (int i = 0; i < jsonArray.size(); i++){
            Item item = new Item();
            JSONObject itemJson = (JSONObject) jsonArray.get(i);
            item.setId((String) itemJson.get("id"));
            item.setName((String) itemJson.get("name"));
            items.add(i, item);
        }
    }

    @Autowired
    public ItemsService(DictionaryUtilService dictionaryUtilService){
        dictionaryUtilService = dictionaryUtilService;
    }

    public Item getItem(int id){
        if (id > 0 && id < items.size()){
            return items.get(id);
        }
        return null;
    }
}
