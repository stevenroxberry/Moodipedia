/*
File name: Store.java
Short description:
IST 261 Assignment:
@author jcswa
@version 1.01 Dec 6, 2020
 */
package model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.ListIterator;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Store {

    private static Store INSTANCE = new Store();
    private static final String JSON_FILE_PATH = "accounts.json";
    //  private static final String JSON_FILE_PATH1 = "journal.json";
    private String currentAccountId;
    // private int currentJournalId = -1;
    //  private int currentAnswerId = -1;
    // private int currentQuestionId = -1;


    private Store() {
    }

    public static Store getInstance() {
        return INSTANCE;
    }

    //--------------Account GSON---------------------
    public void addAccount(Account account) {
        AccountList accountList = getAccountListFromJson();
        if (accountList == null)
            accountList = new AccountList();
        accountList.getAccountList().add(account);
        saveAccountList(accountList);
    }

    private void saveAccountList(AccountList accountList) {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        try {
            FileWriter fileWriter = new FileWriter(JSON_FILE_PATH);
            gson.toJson(accountList, fileWriter);
            fileWriter.close();
        } catch (IOException ex) {
            Logger.getLogger(Store.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setCurrentAccountId(String id) {
        currentAccountId = id;
    }

    public Account getCurrentAccount() {
        for (Account account : getAccountListFromJson().getAccountList()) {
            if (account.getId().equals(currentAccountId)) {
                return account;
            }
        }
        return null;
    }

    public AccountList getAccountListFromJson() {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();


        try {
            Reader reader = Files.newBufferedReader(Paths.get(JSON_FILE_PATH));
            return gson.fromJson(reader, AccountList.class);
        } catch (IOException ex) {
            Logger.getLogger(Store.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void saveAccount(Account account) {
        AccountList accountList = getAccountListFromJson();
        List<Account> accounts = accountList.getAccountList();
        ListIterator<Account> iterator = accounts.listIterator();

        while (iterator.hasNext()) {
            Account acc = iterator.next();
            if (acc.getId().equals(account.getId())) {
                iterator.set(account);
                break;
            }
        }
        saveAccountList(accountList);
    }

    /*
    //------------------------Journal GSON-------------
     public void addJournal(Journal journal) {
        JournalList journalList;
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        try {
            journalList = getJournalListFromJson();
            if (journalList == null)
                journalList = new JournalList();
            journalList.getJournalList().add(journal);
            FileWriter fileWriter = new FileWriter(JSON_FILE_PATH);
            gson.toJson(journalList, fileWriter);
            fileWriter.close();
        } catch (IOException ex) {
            Logger.getLogger(Store.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
         public void setCurrentJournalId(int id) {
        if (id > 0) {
            currentJournalId = id;
        }
    }
     
      public Journal getCurrentJournal() {
        for (Journal journal : getJournalListFromJson().getJournalList()) {
            if (journal.getId() == currentJournalId) {
                return journal;
            }
        }
        return null;
    }

      
       private JournalList getJournalListFromJson() {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();       
        try {
            Reader reader = Files.newBufferedReader(Paths.get(JSON_FILE_PATH));
            return gson.fromJson(reader, JournalList.class);
        } catch (IOException ex) {
            Logger.getLogger(Store.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
       
       //----------------------Answer GSON------------------
       public void addAnswer(Answer answer) {
        AnswerList answerList;
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        try {
            answerList = getAnswerListFromJson();
            if (answerList == null)
                answerList = new AnswerList();
            answerList.getAnswerList().add(answer);
            FileWriter fileWriter = new FileWriter(JSON_FILE_PATH);
            gson.toJson(answerList, fileWriter);
            fileWriter.close();
        } catch (IOException ex) {
            Logger.getLogger(Store.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       
       public void setCurrentAnswerId(int id) {
        if (id > 0) {
            currentAnswerId = id;
        }
    }

    public Answer getCurrentAnswer() {
        for (Answer answer : getAnswerListFromJson().getAnswerList()) {
            if (answer.getId() == currentAnswerId) {
                return answer;
            }
        }
        return null;
    }
       
           
    private AnswerList getAnswerListFromJson() {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();        
        try {
            Reader reader = Files.newBufferedReader(Paths.get(JSON_FILE_PATH));
            return gson.fromJson(reader, AnswerList.class);
        } catch (IOException ex) {
            Logger.getLogger(Store.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    //----------------------Questions GSON------------
    
    public void addQuestion(Question question) {
        QuestionList questionList;
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        try {
            questionList = getQuestionListFromJson();
            if (questionList == null)
                questionList = new QuestionList();
            questionList.getQuestionList().add(question);
            FileWriter fileWriter = new FileWriter(JSON_FILE_PATH);
            gson.toJson(questionList, fileWriter);
            fileWriter.close();
        } catch (IOException ex) {
            Logger.getLogger(Store.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setCurrentQuestionId(int id) {
        if (id > 0) {
            currentQuestionId = id;
        }
    }

    public Question getCurrentQuestion() {
        for (Question question : getQuestionListFromJson().getQuestionList()) {
            if (question.getId() == currentQuestionId) {
                return question;
            }
        }
        return null;
    }
    
    private QuestionList getQuestionListFromJson() {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();             
        try {
            Reader reader = Files.newBufferedReader(Paths.get(JSON_FILE_PATH));
            return gson.fromJson(reader, QuestionList.class);
        } catch (IOException ex) {
            Logger.getLogger(Store.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
*/

}
