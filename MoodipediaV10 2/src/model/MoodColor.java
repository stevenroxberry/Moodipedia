

package model;

import java.awt.Color;
import java.util.HashMap;

public class MoodColor{
    
    String mood;
    Color color;
    HashMap<Integer, MoodColor> moodColor;
    
    
public MoodColor(String m, Color c){
    this.mood=m;
    this.color=c;

}

public MoodColor(){
    
    moodColor = new HashMap<Integer, MoodColor>();
    
    MoodColor red = new MoodColor("Anger", Color.RED);
     MoodColor blue = new MoodColor("Sadness", Color.BLUE);
      MoodColor afraid = new MoodColor("Afraid", Color.MAGENTA);
       MoodColor happiness = new MoodColor("Happiness", Color.YELLOW);
        MoodColor sick = new MoodColor("Sick", Color.green);
         MoodColor depressed = new MoodColor("Depressed", Color.black);
          MoodColor elated = new MoodColor("Elated", Color.ORANGE);
           MoodColor calm = new MoodColor("Calm", Color.WHITE);
            MoodColor anxious = new MoodColor("Anxious", Color.PINK);
               
   moodColor.put(1, red);
   moodColor.put(2, blue);
   moodColor.put(3, afraid);
   moodColor.put(4, happiness);
   moodColor.put(5, sick);
   moodColor.put(6, depressed);
   moodColor.put(7, elated);
   moodColor.put(8, calm);
   moodColor.put(9, anxious);
}

}