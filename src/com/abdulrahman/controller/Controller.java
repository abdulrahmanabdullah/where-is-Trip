package com.abdulrahman.controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import com.abdulrahman.model.Budget;
import com.abdulrahman.model.Mood;
import com.abdulrahman.model.TripTypeClass;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.lang.reflect.InvocationTargetException;
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
    @FXML
    private ImageView doneImage;
    public ImageView errorImage;


    //TextArea ..
    @FXML private TextArea txtArea ;

    //Labels ..
    @FXML private Label mainTitle;
    @FXML private Label showBudget ;



    //Constructor method ..
    public Controller(){
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
                boolean compareInteger = controllerData.compareInteger(Integer.toString(subBudget));
                         if(compareInteger){
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
                            errorImage.setVisible(true);
                            showBudget.setText("we can accept three digit ");
                        }
           }

            // if user input empty value or insert any char .
        }catch (NumberFormatException ex ){
            // first hold true image
            doneImage.setVisible(false);
            // show error image
            errorImage.setVisible(true);
            // show message about the error .
            showBudget.setText("set number Please .");
            // call style error class .
            showBudget.getStyleClass().add("error");
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Dialog ");
            alert.setHeaderText("Set any number please ..!  ");
            alert.showAndWait();


        }


        //Mood
//        checkMood();


        //types
        checkTypes();


    }

    // check mood status , if user check public return true , if check enclosed return false ..
    public boolean checkMood(){
        boolean checker ;
            if(publicId.isSelected()){
                controllerData.setMood("public");
                checker = true;
            }else {
                controllerData.setMood("enclosed");
                checker = false;
            }

        return checker;
    }

    // check tripTypes status , if user check with-love return true , if check with-child return false ..
    public boolean checkTypes(){
        boolean checker ;
        if(loveId.isSelected()){
            controllerData.setTypes("with-love");
            checker = true;
        }else{
            controllerData.setTypes("with-child");
            checker = false ;
        }
        return checker;
    }


    // putting three arguments to this method because , i want pass getter method from class controllerData .
    public List<String> showListTrip(int numbers , String mood ,String tripType){
        List<String> list = new ArrayList<String>();
        // get budget ..
        numbers = controllerData.getBudget();
        // get mood .
        boolean check = checkMood() ;
        // get tripTypes
        boolean chekType = checkTypes();

        // compare for check and checkType is true or not .
        if((numbers >0 && numbers <=100) && (check == true) && (chekType == true) ){
            list.add("arguments 1 ");
            list.add("arguments 2 ");
            list.add("arguments 3 ");
            list.add("arguments 4 ");
        }
        else if((numbers >100 && numbers <=200) && (check == true) && ( chekType == false )){
            list.add("arguments 5 ");
            list.add("arguments 6 ");
            list.add("arguments 7 ");
            list.add("arguments 8 ");
        }

        else if((numbers >100 && numbers <=200) && (check == false) && ( chekType == true )){
            list.add("arguments 9 ");
            list.add("arguments 10 ");
            list.add("arguments 11 ");
            list.add("arguments 12 ");
        }

        else if((numbers >100 && numbers <=200) && (check == false) && ( chekType == false )){
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
    public void randomResult(ActionEvent actionEvent)  {
        //Here call setter methods ..
        setValueInfo();
        System.out.println("Budget : " + + controllerData.getBudget() + "  And u Mood : -> " + controllerData.getMood() + " " + controllerData.getTypes());
        for(String key : showListTrip(controllerData.getBudget(),controllerData.getMood(),controllerData.getTypes())){

            txtArea.appendText(key + "\n" );

        }



}

}
//        String strMood = publicId.getText();
//        controllerData.setMood(strMood);

//        moodGroup.selectedToggleProperty().addListener(
//                (ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) -> {
//                    if (moodGroup.getSelectedToggle() != null) {
//                        String s = moodGroup.getSelectedToggle().getUserData().toString();
////                            controllerData.setMood(s);
//                        System.out.println(moodGroup.getSelectedToggle().getUserData().toString());
//
//                        System.out.println(1);
//                    }
//                });