package es.guepardito.logic;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    // Constants
    public static int HANGED_NUM = 0;
    public static final int WIDTH = 600;
    public static final int HEIGHT = 800;
    
    // variables
    public static String secretWord;
    public static StringBuilder actualWord;
    public static boolean gameOver;
    public static int letters;
    public static ArrayList<Character> characterList = new ArrayList<>();

    public static boolean tryChar(char letr) {
        boolean found = false;
        for (int i = 0; i < secretWord.length(); i++) {
            if (secretWord.charAt(i) == letr && actualWord.charAt(i) == '_') {
                actualWord.setCharAt(i, letr);
                letters--;
                found = true;
            }
        }
        return found;
    }
}
