package com.example.spesuez.Evaluation.helpers;

import java.io.Serializable;

public class Member implements Serializable {

    private String id;
    private String name;
    private String password;
    private String img_source;
    public enum Faculty{
        PETROLEUM_AND_MINING_ENGINEERING,POLITICS_AND_ECONOMIC,EDUCATION,ARTS,BUSINESS,MASS_COMMUNICATION,SCIENCE,ENGINEERING,MEDICINE,
        COMPUTER_SCIENCE,FISHERIES}
    private Faculty faculty;
    public enum Committee {
       ECHO,IR,HRM,HRD,LOGISTICS,ORGANIZING,EXTRACURRICULAR,OFFLINE_MARKETING,SOCIAL_MEDIA,MULTIMEDIA, ANDROID_APP,IT_WEB,ACADEMY
        ,E4ME,BD
    }
    private Committee committee;
    public enum Gender{MALE,FEMALE}
    private Gender gender;
    public enum Position{MEMBER,HEAD, VICE_MANAGER, MANAGER,VICE_PRESIDENT,PRESIDENT}
    private Position position;
    public enum AcademicYear{Y1,Y2,Y3,Y4,Y5,Y6,Y7}
    private AcademicYear academic_year;

    public Member() {
    }

    public Member(String id, String name, String password, String img_source, Faculty faculty, Committee committee, Gender gender, Position position, AcademicYear academic_year) {

        this.id = id;
        this.name = name;
        this.password = password;
        this.img_source = img_source;
        this.faculty = faculty;
        this.committee = committee;
        this.gender = gender;
        this.position = position;
        this.academic_year = academic_year;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImg_source() {
        return img_source;
    }

    public void setImg_source(String img_source) {
        this.img_source = img_source;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public Committee getCommittee() {
        return committee;
    }

    public void setCommittee(Committee committee) {
        this.committee = committee;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public AcademicYear getAcademic_year() {
        return academic_year;
    }

    public void setAcademic_year(AcademicYear academic_year) {
        this.academic_year = academic_year;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", img_source='" + img_source + '\'' +
                ", faculty=" + faculty +
                ", committee=" + committee +
                ", gender=" + gender +
                ", position=" + position +
                ", academic_year=" + academic_year +
                '}';
    }
}
