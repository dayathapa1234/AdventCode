import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Scanner;

public class DaySix {
    public static void daySixPartOne(){
        try {
            File myObj = new File("C:\\Users\\dayat\\IdeaProjects\\AdventCalender\\src\\day6data.txt");
            Scanner myReader = new Scanner(myObj);
            String data = null;
            int index = 0;
            while(myReader.hasNextLine()) {
                data = myReader.nextLine();
                boolean notsame = false;
                for (int i = 0; i < data.length() - 3; i++){
                    notsame = notSame(data.substring(i,i+4));
                    if (notsame){
                        index = i+4;
                        break;
                    }
                }
                System.out.println(index);
            }

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void daySixPartTwo(){
        try {
            File myObj = new File("C:\\Users\\dayat\\IdeaProjects\\AdventCalender\\src\\day6data.txt");
            Scanner myReader = new Scanner(myObj);
            String data = null;
            int index = 0;
            while(myReader.hasNextLine()) {
                data = myReader.nextLine();
                boolean notsame = false;
                for (int i = 0; i < data.length() - 13; i++){
                    notsame = notSame14(data.substring(i,i+14));
                    if (notsame){
                        index = i+14;
                        break;
                    }
                }
                System.out.println(index);
            }

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public static boolean notSame(String s){

        if(s.charAt(0) == s.charAt(1) || s.charAt(0) == s.charAt(2) || s.charAt(0) == s.charAt(3) ||  s.charAt(1) == s.charAt(2) ||  s.charAt(1) == s.charAt(3) ||  s.charAt(2) == s.charAt(3)){
            return false;
        }else{
            System.out.println(s);
            return true;
        }
    }
    public static boolean notSame14(String s){
        for(int i = 0; i < s.length(); i++){
            char startChar = s.charAt(i);
            for(int j = 1+i; j < (s.length()); j++){
                char tempword = s.charAt(j);
                if (startChar == tempword){
                    return false;
                }
            }
        }
        return true;
    }
}
