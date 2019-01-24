import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

public class Informacion {
    static String name = "JOE HONEY SINGS";
    static boolean newUser = true;
    static String[] currentArray = new String[5];
    static char GAMEPLAY[][] = new char [16][32];
    static int LOCATOR[][] = new int[3][2];
    static boolean hurdles = true;
    static int extent = 0;
    static int shots = 0;
    static int rewardCount = 0;
    static int COMPLETED = 0;
    static int brickPoint = 0;
    static boolean newReward = false;
    static int THINKERCOUNTER = 1;
    static int ROW_CURRENT_Y; //.. this holds the value of the breaker in terms of at which colum it's there rn.
    static boolean continueGame = true;
    final static String[] REWARDS = {"Starbucks Coffee Mug", "Lafeo_007's signature", "Source-code"};
    public Informacion(){
        ROW_CURRENT_Y = 14;
        for(int a = 0; a < 16; a++) {
            for (int b = 0; b < 32; b++) {
                if(b>0 && b<31 && a!=0 && a!=13){
                    GAMEPLAY[a][b] = '.';
                }
                else {
                    GAMEPLAY[a][b] = '#';
                }
                if(a>13)
                    GAMEPLAY[a][b] = '\u058D';

            }
        }
    }
    public static void check(){
        if(COMPLETED == 3){
            System.out.println("Congrats all the bricks and item are collected! LET's SEE YOUR GAME STATS...");
            ParserAndUserProgress.STATS();

            COMPLETED = 0;
            Informacion.hurdles = true;
        }
    }
    public static void print(boolean nextLine, int delayInt, String load)throws UnsupportedEncodingException{
        for(int x = 0; x < load.length(); x++ ){

            System.out.print(load.charAt(x));
            
            try{
                Thread.sleep(delayInt);
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
        if(nextLine)
            System.out.println();
    }
    public void checkArray(){
        for(int a = 0; a < 16; a++) {
            for (int b = 0; b < 32; b++) {
                System.out.print(GAMEPLAY[a][b]);
            }
            System.out.println();
        }
    }

    public static void printArray(boolean delay){
        for(int a = 0; a < 16; a++) {
            for (int b = 0; b < 32; b++) {
                if(delay){
                    try{
                        Thread.sleep(100);
                    }catch(Exception ex){
                        ex.printStackTrace();
                    }
                }
                else
                System.out.print(GAMEPLAY[a][b]);
            }
            System.out.println();
        }

    }
    public static void itemCumBrickGernerator(){
        for(int y = 0; y < 3; y++){
            for(int x = 0; x < 2; x++){
                if(y==0) {
                    LOCATOR[y][x] = (int) (Math.random() * 10) + 3;//since the colums of the array in the game is fixed
                    System.out.print(LOCATOR[x][y]);
                }
                else {
                    LOCATOR[y][x] = (int) (Math.random() * 10) + 3;//since the rows of the array in the game is fixed
                    System.out.print(LOCATOR[y][x]);
                }

            }
            System.out.println();

        }
    }
    public void reset(){
        /*his method resets the entire depeding on the current information of the items
        located, brick located, and the current shoot
        */
        for(int a = 0; a < 16; a++) {
            for (int b = 0; b < 32; b++) {
                if(b>0 && b<31 && a!=0 && a!=13){
                    GAMEPLAY[a][b] = '.';
                }
                else {
                    GAMEPLAY[a][b] = '#';
                }
                if(a>13)
                    GAMEPLAY[a][b] = '\u058D';

            }
        }
        Informacion.GAMEPLAY[14][Informacion.ROW_CURRENT_Y] = '\u23f9';
        //the above statement sets the position of the middle part of the shooter
        Informacion.GAMEPLAY[LOCATOR[0][0]][LOCATOR[0][1]] = '?';
        Informacion.GAMEPLAY[LOCATOR[1][0]][LOCATOR[1][1]] = '?';
        Informacion.GAMEPLAY[LOCATOR[2][0]][LOCATOR[2][1]] = '?';

    }
    public static boolean THINKER() {
        boolean x = false;
        Informacion.THINKERCOUNTER += 1;
        int y = 0;
        /*if (user_login > 2) {
            y += 1;
        }
        */
        if (Informacion.THINKERCOUNTER % 6 == 0) {
            y += 1;
        }
        if(y == 2){
            x = true;
        }
        return x;
    }
    public static void REWARD(){ /*true and false for if an item or brick is in the trajectory
                                           and type 1 = item and type 0 = brick*/
        System.out.println("You have earned an item!");
        //here one brick point will be removed and an item point will be added in the string and be rewritten in the array
        // which is storing everything and which will later flush it's contents an a file to save user progress.
        Informacion.brickPoint -= 1; //this will remove one point from the brickPoint because that apparently was a collectible.

        //below this we will have how an item is stored for the user and how an item is decided.
        int DECIDER = 0;
        DECIDER = (int) (DECIDER = (Math.random()*10) <=5 ? DECIDER : 0);

        rewardCount += 1;
        ParserAndUserProgress.currentProgress[3] += (REWARDS[DECIDER]+"/"); //the last item here can cause a problem as the last
        //                                                                   item will also be accounted for '/' in split.
        //this is done so that the number is updated since we reduced a brick count.

        newReward = false;
    }
    public static void currentUserArrayUpdate(){
        ParserAndUserProgress.currentProgress[0] = Informacion.name;
        ParserAndUserProgress.currentProgress[1] = Integer.toString(shots);
        ParserAndUserProgress.currentProgress[2] = Integer.toString(brickPoint);
        ParserAndUserProgress.currentProgress[3] = Integer.toString(rewardCount);
    }

}
