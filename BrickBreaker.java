import javax.print.DocFlavor;
import javax.sound.sampled.Line;
import java.io.UnsupportedEncodingException;

public class BrickBreaker {

    static int Y = 0;

    public static void shooterControl(char input){
        System.out.println("Getting the shooter loaded...");
        if(input == 'e'){
            Informacion.continueGame = false;
            System.out.println("EXITING GAME...");
        }
        else if(input == 'a' && (Informacion.ROW_CURRENT_Y-2) > 0) {
            Informacion.GAMEPLAY[14][Informacion.ROW_CURRENT_Y - 2] = '\u2B1B';
            Informacion.GAMEPLAY[14][Informacion.ROW_CURRENT_Y - 1] = '\u2B1B';
            Informacion.GAMEPLAY[14][Informacion.ROW_CURRENT_Y] = '\u2B1B';
            Informacion.ROW_CURRENT_Y -= 1;
        }
        else if(input == 'd' && (Informacion.ROW_CURRENT_Y + 2) < Informacion.GAMEPLAY[14].length){
            Informacion.GAMEPLAY[14][Informacion.ROW_CURRENT_Y] = '\u2B1B';
            Informacion.GAMEPLAY[14][Informacion.ROW_CURRENT_Y + 1] = '\u2B1B';
            Informacion.GAMEPLAY[14][Informacion.ROW_CURRENT_Y + 2] = '\u2B1B';
            Informacion.ROW_CURRENT_Y += 1;
        }
        else
            System.out.println("Hey! Be carefull you are going outside the arena!");
    }
    public static void lanuchControl(char input){

        int x = 2; //this int fast forwards if the input does not specified, like if 'x' is pressed to shoot a blank.
        char load = '.';
        if (input == 'w') {
            Informacion.shots += 1;
            x = 400;
            load = '#';
            //this will check if there is a 'ITEM' in it's trajectory
            if(HURDEL()){

                Informacion.LOCATOR[Y][0] = 15;
                Informacion.LOCATOR[Y][1] = 0; //in order to remove that item.
                /*
                    the item will be removed as the hurdle is true and a user has decided to shoot to bring down the
                    target.
                 */
                Informacion.brickPoint +=1;
                Informacion.COMPLETED += 1;
            }

            if(Informacion.THINKER() && HURDEL()){
                Informacion.REWARD();
                Informacion.newReward = true;
            }

        }

        else if(input == 's'){
            x = 400;
            Informacion.shots += 1;
            load = '\u2B1B';
            //this will check if there is a 'BRICK' in it's trajectory
            if(HURDEL()){
                Informacion.brickPoint += 1;
                Informacion.LOCATOR[Y][0] = 15;
                Informacion.LOCATOR[Y][1] = 0; //in order to remove that item.
                Informacion.COMPLETED += 1;
            }

        }

        for(int a = 12; a > Informacion.extent; a--){

            Informacion.GAMEPLAY[a+1][Informacion.ROW_CURRENT_Y] = a < 12 ? '.' : '#';
            //the above line resets the trail of the shot
            Informacion.GAMEPLAY[a][Informacion.ROW_CURRENT_Y] = load;
            //the above line shoots the load i.e if it's a grabber or it's a shot
            try{
                Thread.sleep(x);
            }catch (Exception ex){
                ex.printStackTrace();
            }
            System.out.flush();
            Informacion.printArray(false);

        }
    }
    public static boolean HURDEL(){
        boolean check = false;
        for(int y = 0; y < 3; y++){
                if(Informacion.ROW_CURRENT_Y == Informacion.LOCATOR[y][1]){
                    System.out.println();
                    //here a brick point will be added without considering if the subject in the trajectory is a brick or an
                    //item. Incase it's an item the reward system will automatically remove the point.
                    //This function will also upadate the araay storing user progress and will later flush them into
                    // the text file gerneated for the user THANKS BYE :* :


                    Informacion.extent = (Informacion.LOCATOR[y][0]-1);
                    Y = y;
                    check = true;
                    break;
                }
                else
                    Informacion.extent = 1;
        }
        return check;
    }

}
