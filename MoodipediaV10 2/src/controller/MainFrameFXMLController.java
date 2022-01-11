/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.QuestionList;
import model.Account;
import model.Model;
import model.Store;
import model.Journal;
import model.Question;
import model.Answer;

/**
 * FXML Controller class
 *
 * @author jcswa
 */
public class MainFrameFXMLController implements Initializable {

    @FXML
    private TitledPane title;
    @FXML
    private AnchorPane anchor;
    @FXML
    private Button prevDate;
    @FXML
    private Button nextDate;
    @FXML
    private TextArea journalText;
    @FXML
    private Button addImage;
    @FXML
    private Button journalSave;
    @FXML
    private TextField a4;
    @FXML
    private TextField a1;
    @FXML
    private TextField a2;
    @FXML
    private TextField a3;
    @FXML
    private TextField a5;
    @FXML
    private Button questionSave;
    @FXML
    private Button date;
    @FXML
    private Label questionsTitle;
    @FXML
    private Label journalTitle;
    @FXML
    private Label q1;
    @FXML
    private Label q5;
    @FXML
    private Label q4;
    @FXML
    private Label q3;
    @FXML
    private Label q2;
    @FXML
    private Button moodButton;
    @FXML
    private Label moodLegend;
    @FXML
    private Label calendarMonth;
    @FXML
    private GridPane calendarPane;
    @FXML
    private Button settingsButton;
    @FXML
    private Button accountButton;
    @FXML
    private Label goalsTitle;
    @FXML
    private Label friLabel;
    @FXML
    private Hyperlink forgotPwLink;
    
    QuestionList QL;
    
    @FXML 
    private ChoiceBox moodColorPicker;
    @FXML
    private Label moodColorLabel;
    
    private Journal currentJournal;
   
    private Answer answer1;
    private Answer answer2;
    private Answer answer3;
    private Answer answer4;
    private Answer answer5;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
      // currentJournal = Store.getInstance().getCurrentJournal();
       
  
        String [] monthName = {"January", "February",
                "March", "April", "May", "June", "July",
                "August", "September", "October", "November",
                "December"};

        Calendar cal = Calendar.getInstance();
        String month = monthName[cal.get(Calendar.MONTH)];
        int date;
        date = Calendar.DATE;
        
        //System.out.println("Month name: " + month);
        calendarMonth.setText(month+" "+date);
        
        //This items are for configuring the ChoiceBox example
    
        //moodColorLabel.setText("");
        moodColorPicker.getItems().add("happy");
        moodColorPicker.getItems().add("sadness");
        moodColorPicker.getItems().addAll("elated","afraid","sick","depressed","anxious","calm");

        initializeQuestions();
    }

    private void initializeQuestions() {
        List<Question> questionList = Store.getInstance().getCurrentAccount().getQuestionList().getQuestionList();
        for (int i = 0; i < questionList.size(); i++) {
            Question question = questionList.get(i);
            switch (i) {
                case 0:
                    q1.setText(question.getBody());
                    break;
                case 1:
                    q2.setText(question.getBody());
                    break;
                case 2:
                    q3.setText(question.getBody());
                    break;
                case 3:
                    q4.setText(question.getBody());
                    break;
                case 4:
                    q5.setText(question.getBody());
                    break;
            }
        }
    }

    
    @FXML
    private void displayAccount(ActionEvent e) throws IOException {
        //go the account screen of the logged in user
         System.out.println("Account Button Clicked");
        
        Parent mainFrameParent = FXMLLoader.load(getClass().getResource("/view/Account.fxml"));
        Scene scene = new Scene(mainFrameParent);
       
        // Get the stage information by casting the stage to a node
        Stage accountWindow = (Stage)((Node)e.getSource()).getScene().getWindow();
        
        accountWindow.setScene(scene);
        accountWindow.show();  
//         FXMLLoader loader = new FXMLLoader();
//        loader.setLocation(getClass().getResource("/view/Account.fxml"));
//        Parent signupForm = loader.load();
//        
//        Scene accountDataView = new Scene(signupForm);
//        Stage stage = new Stage();
//        stage.setScene(accountDataView);
//        //access Account Controller and send signup data to Textfields
//        
//        AccountController accControl = loader.getController();
//        accControl.saveAccountData();
//        stage.show();
//        
       
        
    }
    @FXML
    private void displayMCLegend(ActionEvent e) throws IOException {
      //go the account screen of the logged in user
       System.out.println("Mood color legend Button Clicked");

      Parent mainFrameParent = FXMLLoader.load(getClass().getResource("/view/MoodColorLegend.fxml"));
      Scene scene = new Scene(mainFrameParent);

      // Get the stage information by casting the stage to a node
      Stage mcLegendWindow = (Stage)((Node)e.getSource()).getScene().getWindow();

      mcLegendWindow.setScene(scene);
      mcLegendWindow.show();  
      //TODO

  }
    //close legend
     public void exitMCLegend(ActionEvent e) throws IOException{
        System.out.println("Mood Close Button Clicked");
        
        Parent mainFrameParent = FXMLLoader.load(getClass().getResource("/view/MainFrame.fxml"));
        Scene scene = new Scene(mainFrameParent);
       
        // Get the stage information by casting the stage to a node
        Stage mfWindow = (Stage)((Node)e.getSource()).getScene().getWindow();
        
        mfWindow.setScene(scene);
        mfWindow.show(); 
    }
     
      @FXML
    private void displaySettings(ActionEvent e) throws IOException {
      //go the settings screen of the logged in user
       System.out.println("Settings button clicked");

     Parent mainFrameParent = FXMLLoader.load(getClass().getResource("/view/Settings.fxml"));
      Scene scene = new Scene(mainFrameParent);

      // Get the stage information by casting the stage to a node
      Stage settingsWindow = (Stage)((Node)e.getSource()).getScene().getWindow();

      settingsWindow.setScene(scene);
      settingsWindow.show();  
      //TODO

  }


    /**
     * @return the q1
     */
    public Label getQ1() {
        return q1;
    }

    /**
     * @param q1 the q1 to set
     */
    public void setQ1(Label q1) {
        this.q1 = q1;
    }

    /**
     * @return the q5
     */
    public Label getQ5() {
        return q5;
    }

    /**
     * @param q5 the q5 to set
     */
    public void setQ5(Label q5) {
        this.q5 = q5;
    }

    /**
     * @return the q4
     */
    public Label getQ4() {
        return q4;
    }

    /**
     * @param q4 the q4 to set
     */
    public void setQ4(Label q4) {
        this.q4 = q4;
    }

    /**
     * @return the q3
     */
    public Label getQ3() {
        return q3;
    }

    /**
     * @param q3 the q3 to set
     */
    public void setQ3(Label q3) {
        this.q3 = q3;
    }

    /**
     * @return the q2
     */
    public Label getQ2() {
        return q2;
    }

    /**
     * @param q2 the q2 to set
     */
    public void setQ2(Label q2) {
        this.q2 = q2;
    }

    /**
     * @return the currentJournal
     */
    public Journal getCurrentJournal() {
        return currentJournal;
    }

    /**
     * @param currentJournal the currentJournal to set
     */
    public void setCurrentJournal(Journal currentJournal) {
        this.currentJournal = currentJournal;
    }

    /**
     * @return the answer1
     */
    public Answer getAnswer1() {
        return answer1;
    }

    /**
     * @param answer1 the answer1 to set
     */
    public void setAnswer1(Answer answer1) {
        this.answer1 = answer1;
    }

    /**
     * @return the answer2
     */
    public Answer getAnswer2() {
        return answer2;
    }

    /**
     * @param answer2 the answer2 to set
     */
    public void setAnswer2(Answer answer2) {
        this.answer2 = answer2;
    }

    /**
     * @return the answer3
     */
    public Answer getAnswer3() {
        return answer3;
    }

    /**
     * @param answer3 the answer3 to set
     */
    public void setAnswer3(Answer answer3) {
        this.answer3 = answer3;
    }

    /**
     * @return the answer4
     */
    public Answer getAnswer4() {
        return answer4;
    }

    /**
     * @param answer4 the answer4 to set
     */
    public void setAnswer4(Answer answer4) {
        this.answer4 = answer4;
    }

    /**
     * @return the answer5
     */
    public Answer getAnswer5() {
        return answer5;
    }

    /**
     * @param answer5 the answer5 to set
     */
    public void setAnswer5(Answer answer5) {
        this.answer5 = answer5;
    }
 
}

     
     
   