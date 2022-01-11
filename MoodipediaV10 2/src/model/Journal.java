/*
File name: Journal.java
Short description:
IST 261 Assignment:
@author jcswa
@version 1.01 Nov 18, 2020
*/

package model;

public class Journal{

     private static int idCounter = 0;
     private int id;
     private String journalEntry;
     
public Journal(String je){
// initialize default values
this.journalEntry = je;
this.id= idCounter++;

}
public Journal(){
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

    /**
     * @return the journalEntry
     */
    public String getJournalEntry() {
        return journalEntry;
    }

    /**
     * @param journalEntry the journalEntry to set
     */
    public void setJournalEntry(String journalEntry) {
        this.journalEntry = journalEntry;
    }

}