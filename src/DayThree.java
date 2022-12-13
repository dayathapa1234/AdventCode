import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class DayThree {
    private static final  String PRIORITY="?abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static void dayThreeQuestionOne(){

        try {
            File myObj = new File("C:\\Users\\dayat\\IdeaProjects\\AdventCalender\\src\\day3data.txt");
            Scanner myReader = new Scanner(myObj);
            Integer score = 0;
            while (myReader.hasNextLine()) {
                int lengthOfString;
                String data = myReader.nextLine();
                String comp1 = data.substring(0,data.length()/2);
                String comp2 = data.substring(data.length()/2);

                String duplicateItems = findDuplicateItem(comp1,comp2);
                int prio = getPriority(duplicateItems.substring(0,1));
                score += prio;
            }
            System.out.println(score);
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void dayThreeQuestionTwo(){
        try {
            File myObj = new File("C:\\Users\\dayat\\IdeaProjects\\AdventCalender\\src\\day3data.txt");
            Scanner myReader = new Scanner(myObj);
            Integer score = 0;
            int i = 0;
            String comp1 = null;
            String comp2= null;
            String comp3= null;
            while (myReader.hasNextLine()) {
                i++;
                String data = myReader.nextLine();
                if (i%3 == 1){
                    comp1 = data;
                } else if(i%3 == 2){
                    comp2 = data;
                }
                if (i>2 && i%3 ==0){
                    comp3 = data;
                    String duplicateItems = findDuplicateItem(comp1,comp2);
                    duplicateItems = findDuplicateItem(duplicateItems,comp3);
                    int prio = getPriority(duplicateItems.substring(0,1));
                    score += prio;
                }
            }
            System.out.println(score);
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    static String findDuplicateItem(String one, String two){
        String ans = "";

        for (int i = 0; i<one.length();i++){
            String current = one.substring(i,i+1);
            if (two.indexOf(current) != -1){
                ans += current;
            }
        }
        return ans;
    }

    private static int getPriority(String item){
        return PRIORITY.indexOf(item);
    }
}

