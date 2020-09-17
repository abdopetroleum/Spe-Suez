package com.example.spesuez.ui.home.events;
import java.io.Serializable;
import java.util.HashMap;
public class Event implements Serializable {
    private String name;
    private String content;
    private String date;
    private boolean checked;
    private String main_img;
    private HashMap<String,String> img_map;
    private int [] a;

    public Event() {

    }
    public void split(){
        String [] splits=this.date.split("/");
        a=new int[splits.length];
        for(int i=0;i<splits.length;i++) {
            a[i]=Integer.parseInt(splits[i]);
        }
    }
    public Event(String name, String content, String date, boolean checked) {
        this.name = name;
        this.content = content;
        this.date = date;
        this.checked = checked;
        String [] splits=date.split("/");
        a=new int[splits.length];
        for(int i=0;i<splits.length;i++) {
            a[i]=Integer.parseInt(splits[i]);
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public String getMain_img() {
        return main_img;
    }

    public void setMain_img(String main_img) {
        this.main_img = main_img;
    }

    public HashMap<String, String> getImg_map() {
        return img_map;
    }

    public void setImg_map(HashMap<String, String> img_map) {
        this.img_map = img_map;
    }

    @Override
    public String toString() {
        return "Event{" +
                "name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", date='" + date + '\'' +
                ", checked=" + checked +
                ", main_img='" + main_img + '\'' +
                ", img_map=" + img_map +
                '}';
    }
    public int getYear() {
        if(date!=null) {
            return a[0];
        }
        return 0;
    }
    public int getMonth() {
        if(date!=null) {
            return a[1]-1;
        }
        return 0;
    }
    public int getDay() {
        if(date!=null) {
            return a[2];
        }
        return 0;
    }
    public int getHour() {
        if(date!=null&&a.length>=4) {
            return a[3];
        }
        return 0;
    }
    public int getMinute() {
        if(date!=null&&a.length>=5) {
            return a[4];
        }
        return 0;
    }
    public int getSecond() {
        if(date!=null&&a.length>=6) {
            return a[5];
        }
        return 0;
    }

}
