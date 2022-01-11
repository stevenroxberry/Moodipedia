/*
File name: Answer.java
Short description:
IST 261 Assignment:
@author jcswa
@version 1.01 Nov 18, 2020
*/

package model;

import java.util.ArrayList;

public class Answer{
// Instance Variables -- define your private data
    private ArrayList<Answer>answerList;
     private static int idCounter = 0;
    private int id;


public Answer(){
    
    answerList = new ArrayList<Answer>();
    this.id = idCounter++;
}

    /**
     * @return the answerList
     */
    public ArrayList<Answer> getAnswerList() {
        return answerList;
    }

    /**
     * @param answerList the answerList to set
     */
    public void setAnswerList(ArrayList<Answer> answerList) {
        this.answerList = answerList;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

}