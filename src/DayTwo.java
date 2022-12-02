import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class DayTwo {
    public static void dayTwoQuestionOne(){
        try {
            File myObj = new File("C:\\Users\\dayat\\IdeaProjects\\AdventCalender\\src\\day2data.txt");
            //File myObj = new File("C:\\Users\\dayat\\IdeaProjects\\AdventCalender\\src\\test.txt");
            Scanner myReader = new Scanner(myObj);
            Long total = 0l;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                char first = data.charAt(0);
                char second = data.charAt(data.length()-1);
                total += result(first,second);
            }
            System.out.println(total);
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void dayTwoQuestionTwo(){
        try {
            File myObj = new File("C:\\Users\\dayat\\IdeaProjects\\AdventCalender\\src\\day2data.txt");
            //File myObj = new File("C:\\Users\\dayat\\IdeaProjects\\AdventCalender\\src\\test.txt");
            Scanner myReader = new Scanner(myObj);
            Long total = 0l;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                char first = data.charAt(0);
                char second = data.charAt(data.length()-1);
                total += resultTwo(first,second);
            }
            System.out.println(total);
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static Long result(char a, char b){
        Long score = Long.valueOf(0);
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        map.put('A','R');
        map.put('B','P');
        map.put('C','C');
        map.put('X','R');
        map.put('Y','P');
        map.put('Z','C');
        if (map.get(b) == map.get(a)){
            if(map.get(b) == 'R'){
                score = 3l+1l;
            }else if(map.get(b) == 'P'){
                score = 3l+2l;
            }else{
                score = 3l+3l;
            }
        }else if(map.get(b) == 'R'){
            if(map.get(a) == 'P'){
                score = 0l + 1l;
            }
            else{
                score = 6l + 1l;
            }
        }else if(map.get(b) == 'P'){
            if(map.get(a) == 'C'){
                score = 0l + 2l;
            }
            else{
                score = 6l + 2l;
            }
        }else{
            if(map.get(a) == 'R'){
                score = 0l + 3l;
            }
            else{
                score = 6l +3l;
            }
        }


        return score;
    }

    public static Long resultTwo(char a, char b){
        Long score = Long.valueOf(0);
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        map.put('A','R');
        map.put('B','P');
        map.put('C','C');
        if (b == 'Y'){
            if(map.get(a) == 'R'){
                score = 3l+1l;
            }else if(map.get(a) == 'P'){
                score = 3l+2l;
            }else{
                score = 3l+3l;
            }
        }else if(b == 'X'){
            if(map.get(a) == 'R'){
                score = 0l + 3l;
            } else if (map.get(a) == 'P') {
                score = 0l + 1l;
            } else{
                score = 0l + 2l;
            }
        }else {
            if (map.get(a) == 'R') {
                score = 6l + 2l;
            }else if (map.get(a) == 'P') {
                score = 6l + 3l;
            } else {
                score = 6l + 1l;
            }
        }
        return score;
    }
}
