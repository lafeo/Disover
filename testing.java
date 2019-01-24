/*
    @author: Raayaan Sahu
    @About: Discover: A Brick Breaker Sequel
                Please refer to Guide#Introduction to know more about this game.
 */


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.BreakIterator;
import java.util.*;
public class testing {
    public static void main(String args[]) throws UnsupportedEncodingException {
        /*
        \u058D
        '\u1699' sqaure
        '\u20E0' stop sign
        '\u2b1b' //black spot
        '\u25CF' black ball
         */
        Informacion i = new Informacion();
        System.out.println("TECH LOG = ENTER ID TO ENTER SYSTEM");
        if(new Scanner(System.in).next().trim().equals("6IX9INE")){
            System.out.println("Entering SYSTEM");
            try {
                SYSTEM.LOGS();
            }catch (IOException ex){
                ex.printStackTrace();
            }
            System.exit(0);
        }
        try {
            Introduction.feed();

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        ParserAndUserProgress.ADDER(Informacion.name);
        ParserAndUserProgress.resume();

        while(Informacion.continueGame) {
            if (Informacion.hurdles) {
                Informacion.itemCumBrickGernerator();
                Informacion.hurdles = false;
            }
            i.reset();
            Informacion.printArray(false);
            System.out.println("A - LEFT | D - RIGHT | E - EXIT | \n" +
                                "(Choose the direction OR PRESS ANY KEY TO NOT MOVE and press ENTER to submit DECISION)");
            BrickBreaker.shooterControl(new Scanner(System.in).next().trim().toLowerCase().charAt(0));

            BrickBreaker.HURDEL();

            System.out.println("W - GRAB | S - SHOOT | X - BLANK-SHOT \n(Choose the correct SHOT and press ENTER to submit DECISION)");
            BrickBreaker.lanuchControl(new Scanner(System.in).next().trim().toLowerCase().charAt(0));
            if(Informacion.newReward) {
                Informacion.REWARD();
            }
            Informacion.currentUserArrayUpdate();
            Informacion.check();//check whether current level is completed or not.
        }
        ParserAndUserProgress.currentUser();
        Informacion.print(true, 50, "We have updated the system! You can safely close the game, COME AGAIN" +
                                               "\n BYE, "+Informacion.name);
    }
}
