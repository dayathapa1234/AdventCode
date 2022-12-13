import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DayFour {
    public static void dayFourQuestionOne(){
        try {
            File myObj = new File("C:\\Users\\dayat\\IdeaProjects\\AdventCalender\\src\\day4data.txt");
            Scanner myReader = new Scanner(myObj);
            String data = null;
            int score = 0;
            int maximum = 0;
            while(myReader.hasNextLine()){
                data = myReader.nextLine();
                int one1 = Integer.parseInt(data.substring(0,data.indexOf("-")));
                int one2 = Integer.parseInt(data.substring(data.indexOf("-")+1,data.indexOf(",")));
                int two1 = Integer.parseInt(data.substring(data.indexOf(",")+1).substring(0,data.substring(data.indexOf(",")).indexOf("-")-1));
                int two2 = Integer.parseInt(data.substring(data.indexOf(",")+1).substring(data.substring(data.indexOf(",")).indexOf("-")));
                int[] arr = {one1,one2,two1,two2};
                for (int i:arr){
                    if (i > maximum){
                        maximum = i;
                    }
                }
                String timesheet1 = "";
                String timesheet2 = "";
                for (int i = 1; i<=maximum;i++){
                    if (i>=one1 && i<=one2){
                        timesheet1 += i;
                    }else{
                        timesheet1 += ".";
                    }
                    if (i>=two1 && i<=two2){
                        timesheet2 += i;
                    }else{
                        timesheet2 += ".";
                    }
                }
                System.out.println(timesheet1 +"  " + one1 + "-" + one2);
                System.out.println(timesheet2 +"  " + two1 + "-" + two2);
                System.out.println("");
                if (isInside(one1,one2,two1,two2)) {
                    score++;
                }
            }
            System.out.println(score);

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void dayFourQuestionTwo(){
        try {
            File myObj = new File("C:\\Users\\dayat\\IdeaProjects\\AdventCalender\\src\\day4data.txt");
            Scanner myReader = new Scanner(myObj);
            String data = null;
            int score = 0;
            while(myReader.hasNextLine()){
                data = myReader.nextLine();
                int one1 = Integer.parseInt(data.substring(0,data.indexOf("-")));
                int one2 = Integer.parseInt(data.substring(data.indexOf("-")+1,data.indexOf(",")));
                int two1 = Integer.parseInt(data.substring(data.indexOf(",")+1).substring(0,data.substring(data.indexOf(",")).indexOf("-")-1));
                int two2 = Integer.parseInt(data.substring(data.indexOf(",")+1).substring(data.substring(data.indexOf(",")).indexOf("-")));

                if (doesIntersect(one1,one2,two1,two2)) {
                    score++;
                }
                System.out.println(one1 + "-" + one2);
                System.out.println(two1 + "-" + two2);
                System.out.println(doesIntersect(one1,one2,two1,two2));
            }
            System.out.println(score);

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static boolean isInside(int one1, int one2, int two1, int two2){

        if (one2-one1 >= two2-two1){
            if (two1 >= one1 && two2 <= one2){
                return true;
            }
            else{
                return false;
            }
        }else{
            if (one1 >= two1 && one2 <= two2){
                return true;
            }
            else{
                return false;
            }
        }
    }

    public static boolean doesIntersect(int one1, int one2, int two1, int two2){

        if ((two1 >= one1 && two1 <= one2) ||(two2 >= one1 && two2 <= one2) ){
            return true;

        } else if ((one1 >= two1 && one1 <= two2) ||(one2 >= two1 && one2 <= two2) ) {
            return true;
        } else{

            return false;

        }
    }
}
