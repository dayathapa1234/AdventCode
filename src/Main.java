import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        question1();
    }

    public static void question1(){
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
}