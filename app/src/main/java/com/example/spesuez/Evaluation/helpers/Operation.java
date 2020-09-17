package com.example.spesuez.Evaluation.helpers;

import java.io.Serializable;

public class Operation implements Serializable {

    private String id;
    private  String member_id;
    private String name;
    private String value;
    public enum Committee {
        ECHO,IR,HRM,HRD,LOGISTICS,ORGANIZING,EXTRACURRICULAR,OFFLINE_MARKETING,SOCIAL_MEDIA,MULTIMEDIA, ANDROID_APP,IT_WEB,ACADEMY
        ,E4ME,BD

    }
    private Committee committee;
    public enum Type{POSITIVE_NOTE,NEGATIVE_NOTE,TASK, MEETING }
    private Type type;
    public enum Month{_1,_2,_3,_4,_5,_6,_7,_8,_9,_10,_11,_12};
    private Month month;
    public Operation() {
    }

    public Operation(String id, String member_id, String operation_Name, String value, Committee committee, Type type, Month month) {
        this.id = id;
        this.member_id = member_id;
        this.name = operation_Name;
        this.value = value;
        this.committee = committee;
        this.type = type;
        this.month = month;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMember_id() {
        return member_id;
    }

    public void setMember_id(String member_id) {
        this.member_id = member_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String operation_Name) {
        this.name = operation_Name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Committee getCommittee() {
        return committee;
    }

    public void setCommittee(Committee committee) {
        this.committee = committee;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Month getMonth() {
        return month;
    }

    public void setMonth(Month month) {
        this.month = month;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "id='" + id + '\'' +
                ", member_id='" + member_id + '\'' +
                ", operation_Name='" + name + '\'' +
                ", value='" + value + '\'' +
                ", committee=" + committee +
                ", type=" + type +
                ", month=" + month +
                '}';
    }
}
