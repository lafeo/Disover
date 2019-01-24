import java.io.*;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class SYSTEM {
    public static void LOGS() throws IOException {
        System.out.println("DELETE USER - D | GET RANKING - G");
        switch (new Scanner(System.in).next().trim().toLowerCase().charAt(0)) {
            case 'd':
                System.out.println("USERNAME: ");
                delUser(new Scanner(System.in).next().trim());
                break;
            case 'g':
                getRank();
                break;
            default:
                LOGS();
        }
    }

    protected static void delUser(String username) throws IOException {
        String userPath = username.trim() + ".txt";
        File fCUser = new File(userPath);
        final File USERS = new File("USERS.md");
        FileWriter fw = new FileWriter(USERS, true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter pw = new PrintWriter(bw);
        //FILE WRITER FOR USERS IS MADE WITH NO APPEND

        BufferedReader brUSERS = new BufferedReader(new FileReader(fCUser));
        //FILE READER FOR USERS IS MADED

        String currentLine = "temp";
        int userCount = 0;
        ArrayList<String> temp = new ArrayList<>();
        while ((currentLine = brUSERS.readLine()) != null) {
            System.out.println("Reading Line");
            userCount += 1;
            if (currentLine.trim().equals(username)) {
                System.out.println("FOUND user-name...");
                //NO BREAK STATEMENT HAS BEEN KEPT USER SINCE WE WANT TO GET THE TOTAL COUNT OF USERS
            } else
                temp.add(currentLine.trim());
        }
        System.out.println("Number of users: " + userCount);

        pw = new PrintWriter(new BufferedWriter(new FileWriter("USERS.md", false)));
        pw.print("");
        pw.flush();
        pw.close();

        pw = new PrintWriter(new BufferedWriter(new FileWriter("USERS.md", true)));

        for(int x = 0; x < temp.size(); x++) {
            pw.println(temp.get(x));
        }
        pw.flush();
        pw.close();
    }
    public static void getRank()throws IOException{
        final File USERS = new File("USERS.md");
        BufferedReader brUSERS = new BufferedReader(new FileReader(USERS));
        String currentLine = "temp";
        int userCount = 0;
        ArrayList<String> temp = new ArrayList<>();
        while ((currentLine = brUSERS.readLine()) != null) {
            System.out.println("Reading Line");
            userCount += 1;
                temp.add(currentLine.trim());
        }
        ArrayList <Integer> brickPoints = new ArrayList<Integer>();
        for(int x = 0; x < temp.size(); x++){
            String line = new BufferedReader(new FileReader((temp.get(x).trim()+".txt"))).readLine();
            String lines[] = line.split("\\*", 5);
            brickPoints.add(Integer.parseInt(lines[3]));
        }
       // brickPoints.sort(brickPoints);

        //below we will bubble sort the users

        for(int x = 1; x <brickPoints.size(); x++){
            if(brickPoints.get(x-1)>brickPoints.get(x)){
                int tempINT = brickPoints.get(x);
                brickPoints.remove(x);
                brickPoints.add(x, brickPoints.get(x-1));
                brickPoints.remove(x-1);
                brickPoints.add(x-1, tempINT);

                String tempSTR = temp.get(x);
                temp.remove(x);
                temp.add(x, temp.get(x-1));
                temp.remove(x-1);
                temp.add(x-1, tempSTR);
            }
        }

        System.out.println("RANK");
        int y = 0;
        for(int x = temp.size()-1; x >= 0; x--){
            System.out.println((y)+")\t "+temp.get(x)+": "+brickPoints.get(x));
        }
        {

        }
    }
    }


