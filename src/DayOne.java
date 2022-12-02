import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DayOne {

    public static void dayOneQuestionOne(){
        try {
            File myObj = new File("C:\\Users\\dayat\\IdeaProjects\\AdventCalender\\src\\data.txt");
            Scanner myReader = new Scanner(myObj);
            long maximum = 0;
            long current = 0;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if (!data.isEmpty()){
                    current += Integer.parseInt(data);
                }
                if (data.isEmpty()) {
                    if (current >= maximum) {
                        maximum = current;
                        current = 0;
                    } else {
                        current = 0;
                    }
                }
            }
            System.out.println(maximum);
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void dayOneQuestionTwo(){
        try {
            File myObj = new File("C:\\Users\\dayat\\IdeaProjects\\AdventCalender\\src\\data.txt");
            Scanner myReader = new Scanner(myObj);
            List<Long> answers = new ArrayList<>();
            Long current = 0l;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if (!data.isEmpty()){
                    current += Integer.parseInt(data);
                }
                if (data.isEmpty()) {
                    answers.add(current);
                    current = 0l;
                }
            }
            //answers = Collections.sort(answers);
            answers.sort((a1, a2) -> a2.compareTo(a1));
            long total = 0l;
            for (int i=0; i<=2; i++){
                total += answers.get(i);
            }
            System.out.println(total);
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}
