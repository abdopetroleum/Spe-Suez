package com.example.spesuez.ui.home.TipOfTheDay;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class TipofTheDay implements Serializable {
    private String name;
    private String content;
    private HashMap <String,String> images_map;

    public TipofTheDay() {
    }

    public TipofTheDay(String name, String content, HashMap<String, String> images_map) {
        this.name = name;
        this.content = content;
        this.images_map = images_map;
    }

    public TipofTheDay(String name, String content, Set<String> set) {
        this.name = name;
        this.content = content;
        images_map=new HashMap<String, String>();
        ArrayList<String> arrayList=new ArrayList<String>(set);
        for (int i=0;i<set.size();i++){
            images_map.put("_"+i,arrayList.get(i));
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public HashMap<String, String> getImages_map() {
        return images_map;
    }

    public void setImages_map(HashMap<String, String> images_map) {
        this.images_map = images_map;
    }

    @Override
    public String toString() {
        return "TipofTheDay{" +
                "name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", images_map=" + images_map +
                '}';
    }
}
