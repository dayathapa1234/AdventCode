import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class DaySeven {
    public static void DaySevenQuestionOne(){
        try {
            File myObj = new File("C:\\Users\\dayat\\IdeaProjects\\AdventCalender\\src\\day7data.txt");
            Scanner myReader = new Scanner(myObj);
            String path = "/home";
            List<String> commands = new ArrayList<>();
            Map<String,Integer> dirSize = new HashMap<>();
            dirSize.put(path,0);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                commands.add(data);
            }
            for (String command: commands){
                if (command.charAt(0) == '$'){
                    if (command.substring(2,4).equals("ls")){
                        continue;
                    } else if (command.substring(2,4).equals("cd")) {
                        if (command.substring(5,6).equals("/")){
                            path = "/home";
                        } else if (command.length() > 6 && command.substring(5,7).equals("..")) {
                            path = path.substring(0,path.lastIndexOf("/"));
                        }else{
                            String dirname = command.substring(5);
                            path = path+"/"+dirname;
                            dirSize.put(path,0);
                        }
                    }
                }
                else if (command.substring(0,3).equals("dir")) {
                    continue;
                }else{
                    int size = Integer.parseInt(command.substring(0,command.indexOf(" ")));
                    String dir = path;
                    int count = 0;
                    for( char c: dir.toCharArray()){
                        if (c == '/'){
                            count += 1;
                        }
                    }
                    for (int i = 0; i < count; i++){
                        int temp = dirSize.get(dir) + size;
                        dirSize.put(dir,temp);
                        dir = dir.substring(0,dir.lastIndexOf("/"));
                    }
                }

            }
            int total = 0;
            for (int i: dirSize.values()){
                if (i <= 100000){
                    total += i;
                }
            }
            System.out.println(total);
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void DaySevenQuestionTwo(){
        try {
            File myObj = new File("C:\\Users\\dayat\\IdeaProjects\\AdventCalender\\src\\day7data.txt");
            Scanner myReader = new Scanner(myObj);
            String path = "/home";
            List<String> commands = new ArrayList<>();
            Map<String,Integer> dirSize = new HashMap<>();
            dirSize.put(path,0);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                commands.add(data);
            }
            for (String command: commands){
                if (command.charAt(0) == '$'){
                    if (command.substring(2,4).equals("ls")){
                        continue;
                    } else if (command.substring(2,4).equals("cd")) {
                        if (command.substring(5,6).equals("/")){
                            path = "/home";
                        } else if (command.length() > 6 && command.substring(5,7).equals("..")) {
                            path = path.substring(0,path.lastIndexOf("/"));
                        }else{
                            String dirname = command.substring(5);
                            path = path+"/"+dirname;
                            dirSize.put(path,0);
                        }
                    }
                }
                else if (command.substring(0,3).equals("dir")) {
                    continue;
                }else{
                    int size = Integer.parseInt(command.substring(0,command.indexOf(" ")));
                    String dir = path;
                    int count = 0;
                    for( char c: dir.toCharArray()){
                        if (c == '/'){
                            count += 1;
                        }
                    }
                    for (int i = 0; i < count; i++){
                        int temp = dirSize.get(dir) + size;
                        dirSize.put(dir,temp);
                        dir = dir.substring(0,dir.lastIndexOf("/"));
                    }
                }

            }
            int limit = 30000000 - (70000000 - dirSize.get("/home"));
            Map<String,Integer> validDirs = new HashMap<>();
            for (String key: dirSize.keySet()){
                if (limit <= dirSize.get(key)){
                    validDirs.put(key,dirSize.get(key));
                }
            }
            int min = 999999999;
            int total = 0;
            for (String key: validDirs.keySet()){
                if (validDirs.get(key) - limit < min){
                    min = validDirs.get(key) - limit;
                    total = validDirs.get(key);
                }
            }
            System.out.println(total);
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
