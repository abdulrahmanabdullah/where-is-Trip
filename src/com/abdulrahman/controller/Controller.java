package com.abdulrahman.controller;

import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import com.abdulrahman.model.Budget;
import com.abdulrahman.model.Mood;
import com.abdulrahman.model.TripTypeClass;
import com.abdulrahman.validation.ErrorDetection;
import javafx.scene.image.ImageView;
import javafx.scene.input.InputMethodTextRun;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.ResourceBundle;

public class Controller{



    //Declare obj of model classes ..
    private Budget mBudget ;
    private Mood mMood ;
    private TripTypeClass mTrip ;


    //Declare obj of ControllerData ...

    ControllerData controllerData  ;

    //Create variable for mes if user input valid number ...
    private final String MESSAGE = "Please insert any numbers ";

    //AnchorPane :
    @FXML private AnchorPane container;

    //TextFailed ..
    @FXML private TextField budgetTxt ;

    //RadioButton
    @FXML
    public RadioButton publicId ;
    public RadioButton enclosedId;
    public RadioButton loveId;
    public RadioButton childId;
    public ToggleGroup moodGroup ;

    //IMageView
    @FXML private ImageView errorImage;


    //TextArea ..
    @FXML private TextArea txtArea ;

    //Labels ..
    @FXML private Label mainTitle;
    @FXML private Label showBudget ;



    //Constructor method ..
    public Controller(){
        mBudget = new Budget();
        mMood = new Mood();
        mTrip = new TripTypeClass();

        controllerData = new ControllerData();

    }





    //fill arguments of textField .. Ok let's call this method setValueInfo() ;

//    private void setValueInfo(){
//        boolean vlidation  = ErrorDetection.isNumber(budgetTxt.getText());
//        if(vlidation){
//            int subBudget = Integer.parseInt(budgetTxt.getText());
//            mBudget.setBudget(subBudget);
//
//        }else {
//
//        }
//        String subMood = enclosedId.getText();
//
//
////        String subTrip = tripTypetxt.getText();
////        mTrip.setTripType(subTrip);
//
//    }

    private void setValueInfo(){
        //Budget ...

        // TODO:create try and catch .. Because if user leave this line empty ... Done .

        try {
            int subBudget = Integer.parseInt(budgetTxt.getText());
            controllerData.validationBudget(subBudget);
            controllerData.setBudget(subBudget);
        }catch (NumberFormatException ex ){
            errorImage.setVisible(true);
            showBudget.setText(controllerData.numberOutRange());
            showBudget.getStyleClass().add("play");


        }
        //Mood
        String strMood = moodGroup.getSelectedToggle().toString();

        controllerData.setMood(strMood);

        //types




    }


    public List<String> showListTrip(int numbers , String status ,String typesList){
        List<String> list = new ArrayList<String>();
        numbers = controllerData.getBudget();
        status = controllerData.getMood();
        typesList = controllerData.getTypes();
        if((numbers >0 && numbers <=100) && (status.equals("happy")) && (typesList.equals("love"))){
            list.add("arguments 1 ");
            list.add("arguments 2 ");
            list.add("arguments 3 ");
            list.add("arguments 4 ");
        }
        else if((numbers >100 && numbers <=200) && (status.equals("happy")) && (typesList.equals("love"))){
            list.add("arguments 5 ");
            list.add("arguments 6 ");
            list.add("arguments 7 ");
            list.add("arguments 8 ");
        }

        else if((numbers >200 && numbers <=300) && (status.equals("happy")) && (typesList.equals("love"))){
            list.add("arguments 9 ");
            list.add("arguments 10 ");
            list.add("arguments 11 ");
            list.add("arguments 12");
        }
        else if((numbers >300 ) && (status.equals("happy")) && (typesList.equals("love"))){
            list.add("arguments 13 ");
            list.add("arguments 14 ");
            list.add("arguments 15 ");
            list.add("arguments 16 ");
        }


        else {
            list.add("null");
        }


        return list;
    }





    //This method w'be take three arguments -> budget and mood and triptype
    //After that , it's should filtered and show list result ..
    public void randomResult(ActionEvent actionEvent) {
        //Here call setter methods ..
        setValueInfo();
        System.out.println("Budget : " + + controllerData.getBudget() + "  And u Mood : -> " + controllerData.getMood() + " " + controllerData.getTypes());
        for(String key : showListTrip(controllerData.getBudget(),controllerData.getMood(),controllerData.getTypes())){

            txtArea.appendText(key + "\n");

        }



}

}
