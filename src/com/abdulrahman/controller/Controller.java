package com.abdulrahman.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import com.abdulrahman.model.Budget;
import com.abdulrahman.model.Mood;
import com.abdulrahman.model.TripTypeClass;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;
import java.util.List;

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
    @FXML private ImageView doneImage;
    public ImageView errorImage;


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


    private void setValueInfo(){
        // TODO:create try and catch .. Because if user leave this line empty ... Done .
        try {
            int subBudget = Integer.parseInt(budgetTxt.getText());
            boolean testValidation = controllerData.compareInput(Integer.toString(subBudget));
            //under this line , confirm and check if input string or digit
            // if digit , check how many digits pass to input .
            // And it's done , yes every thing is okay . *_*
            if(testValidation){
                        if(controllerData.compareInteger(Integer.toString(subBudget))){
                            // after check all statement set value to budget .
                            controllerData.setBudget(subBudget);
                            // hold waring image
                            errorImage.setVisible(false);
                            /// show success image .
                            doneImage.setVisible(true);
                            // call style for budget image ..
                            showBudget.getStyleClass().add("done");
                            // this line for check if statements is fine or not ..
                            showBudget.setText("Yes it's ");

                        }
                        // if user input value over three digit .
                        else{
                            controllerData.setBudget(0);
                            showBudget.setText("we can accept three digit ");
                        }
           }

            // if user input empty value or insert any char .
        }catch (NumberFormatException ex ){
            // first hold true image
            doneImage.setVisible(false);
            //
            errorImage.setVisible(true);
            showBudget.setText("set number Please .");
            showBudget.getStyleClass().add("error");


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
        String testStr  = Integer.toString(20);
//        System.out.println(controllerData.compareInput("asd"));
        System.out.println("Budget : " + + controllerData.getBudget() + "  And u Mood : -> " + controllerData.getMood() + " " + controllerData.getTypes());
        for(String key : showListTrip(controllerData.getBudget(),controllerData.getMood(),controllerData.getTypes())){

            txtArea.appendText(key + "\n");

        }



}

}
