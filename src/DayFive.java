import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Scanner;

public class DayFive {
    public static void dayFivePartOne(){
        try {
            File myObj = new File("C:\\Users\\dayat\\IdeaProjects\\AdventCalender\\src\\day5data.txt");
            Scanner myReader = new Scanner(myObj);
            String data = null;
            HashMap<Integer, ArrayDeque> arrayDequeHashMap = new HashMap<>();
            int numOfDeque = 1;
            data = myReader.nextLine();
            int index = 2;
            while( index < data.length()){
                numOfDeque += 1;
                index +=4;
            }
            for (int i = 0; i < numOfDeque; i++){
                arrayDequeHashMap.put(i,new ArrayDeque<>());
            }
            index = 2;
            int i = 0;
            while(index < data.length()){
                String input = data.substring((i * 4) , (i * 4) + 3);
                if (input.charAt(0) == '[') {
                    arrayDequeHashMap.get(i).addFirst(input);

                }
                index += 4;
                i++;
            }
            while(myReader.hasNextLine()) {
                data = myReader.nextLine();
                if (data.substring(0,2).equals(" 1")){
                    break;
                }else {
                    index = 2;
                    i = 0;
                    while(index < data.length()){
                        String input = data.substring(i * 4, (i * 4) + 3);
                        if (input.charAt(0) == '[') {
                            arrayDequeHashMap.get(i).addFirst(input);

                        }
                        index += 4;
                        i++;
                    }
                }
            }
            myReader.nextLine();

            while(myReader.hasNextLine()) {
                data = myReader.nextLine();
                String temp = data.substring(data.indexOf(" ") + 1);
                int one = Integer.parseInt(data.substring(data.indexOf(" ") + 1).substring(0, temp.indexOf(" ")));
                temp = data.substring(data.indexOf(" ") + 1).substring(temp.indexOf(" ") + 1);
                temp = temp.substring(temp.indexOf(" ") + 1).substring(0);
                int two = Integer.parseInt(temp.substring(0, temp.indexOf(" "))) - 1;
                temp = temp.substring(temp.indexOf(" ") + 1);
                int three = Integer.parseInt(temp.substring(temp.indexOf(" ") + 1)) - 1;

                arrayDequeHashMap = move(arrayDequeHashMap,one,two,three);
            }
            String ans = "";
            for (int j = 0; j<numOfDeque; j++ ){
                ans += arrayDequeHashMap.get(j).getLast().toString().substring(1,2);
            }
            System.out.println(ans);
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void dayFivePartTwo(){
        try {
            File myObj = new File("C:\\Users\\dayat\\IdeaProjects\\AdventCalender\\src\\day5data.txt");
            Scanner myReader = new Scanner(myObj);
            String data = null;
            HashMap<Integer, ArrayDeque> arrayDequeHashMap = new HashMap<>();
            int numOfDeque = 1;
            data = myReader.nextLine();
            int index = 2;
            while( index < data.length()){
                numOfDeque += 1;
                index +=4;
            }
            for (int i = 0; i < numOfDeque; i++){
                arrayDequeHashMap.put(i,new ArrayDeque<>());
            }
            index = 2;
            int i = 0;
            while(index < data.length()){
                String input = data.substring((i * 4) , (i * 4) + 3);
                if (input.charAt(0) == '[') {
                    arrayDequeHashMap.get(i).addFirst(input);

                }
                index += 4;
                i++;
            }
            while(myReader.hasNextLine()) {
                data = myReader.nextLine();
                if (data.substring(0,2).equals(" 1")){
                    break;
                }else {
                    index = 2;
                    i = 0;
                    while(index < data.length()){
                        String input = data.substring(i * 4, (i * 4) + 3);
                        if (input.charAt(0) == '[') {
                            arrayDequeHashMap.get(i).addFirst(input);

                        }
                        index += 4;
                        i++;
                    }
                }
            }
            myReader.nextLine();

            while(myReader.hasNextLine()) {
                data = myReader.nextLine();
                String temp = data.substring(data.indexOf(" ") + 1);
                int one = Integer.parseInt(data.substring(data.indexOf(" ") + 1).substring(0, temp.indexOf(" ")));
                temp = data.substring(data.indexOf(" ") + 1).substring(temp.indexOf(" ") + 1);
                temp = temp.substring(temp.indexOf(" ") + 1).substring(0);
                int two = Integer.parseInt(temp.substring(0, temp.indexOf(" "))) - 1;
                temp = temp.substring(temp.indexOf(" ") + 1);
                int three = Integer.parseInt(temp.substring(temp.indexOf(" ") + 1)) - 1;

                arrayDequeHashMap = movetwo(arrayDequeHashMap,one,two,three);
            }
            String ans = "";
            for (int j = 0; j<numOfDeque; j++ ){
                ans += arrayDequeHashMap.get(j).getLast().toString().substring(1,2);
            }
            System.out.println(ans);
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static HashMap<Integer, ArrayDeque> move(HashMap<Integer, ArrayDeque> h,int quantity,int from, int to){
        for (int i = 0; i < quantity; i++){
            h.get(to).addLast(h.get(from).removeLast());
        }
        return h;
    }
    public static HashMap<Integer, ArrayDeque> movetwo(HashMap<Integer, ArrayDeque> h,int quantity,int from, int to){
        ArrayDeque temp = new ArrayDeque<String>();
        for (int i = 0; i < quantity; i++){
            temp.addFirst(h.get(from).removeLast());
        }

        h.get(to).addAll(temp);


        return h;
    }
}
