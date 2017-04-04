package com.abdulrahman.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import javax.swing.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by abdulrahman on 4/4/2017.
 */
public class ControllerData {

    private int budget ;
    private String mood ;
    private String types ;


    String messageNumber = "Your number out of the range , set three digits number ";



    public ControllerData(){

    }

    //pass validation to get budget .

    public int validationBudget(int input){
        String regx = "[\\d]{0,3}";
        Pattern pattern = Pattern.compile(regx);
        Matcher matcher = pattern.matcher(Integer.toString(input));
        boolean isValidation = matcher.matches();
            if(isValidation){
                    return input;
            }else{
                return  0 ;
            }
 }

    public String numberOutRange(){
        return messageNumber;
    }

    public int getBudget() {
        return validationBudget(budget);
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }

    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
    }
}
