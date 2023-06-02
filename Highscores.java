import greenfoot.*;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Write a description of class Scoreboard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Highscores  
{
    // instance variables - replace the example below with your own
    private int score;
    private String playerName;

    /**
     * Constructor for objects of class Scoreboard
     */
    public Highscores()
    {
    }


    public void saveHighScore(String playerName, int score) {
        try {
            FileWriter fileWriter = new FileWriter("highscores.txt", true); // true para habilitar el modo de añadir al archivo
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(playerName + " " + score);
            bufferedWriter.newLine();

            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public List<Score> getTopScores() {
        List<Score> scores = new ArrayList<>();

        try {
            FileReader fileReader = new FileReader("highscores.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split(" ");
                if (parts.length == 2) {
                    String playerName = parts[0];
                    int score = Integer.parseInt(parts[1]);
                    scores.add(new Score(playerName, score));
                }
            }

            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Collections.sort(scores, Collections.reverseOrder());
        return scores.subList(0, Math.min(5, scores.size()));
    }
}
