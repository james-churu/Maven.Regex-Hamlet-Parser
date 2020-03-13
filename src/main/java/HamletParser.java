import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by thook on 10/7/15.
 */
public class HamletParser {

    private String hamletData;
    private String lookForHamlet = "[Hh][Aa][Mm][Ll][Ee][Tt]";
    private String lookForHoratio =  "[Hh][Oo][Rr][As][Tt][Ii][Oo]";

    public HamletParser(){
        this.hamletData = loadFile();
    }

    private String loadFile(){
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("hamlet.txt").getFile());
        StringBuilder result = new StringBuilder("");

        try(Scanner scanner = new Scanner(file)){
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }

            scanner.close();
        }catch(IOException e){
            e.printStackTrace();
        }

        return result.toString();
    }

    public String getHamletData(){
        return hamletData;
    }
    public void changeHamletToLeon(){
        Pattern pattern = Pattern.compile(lookForHamlet);
        Matcher matcher = pattern.matcher(hamletData);
        hamletData = matcher.replaceAll("Leon");
    }
    public void changeHoratioToTariq(){
        Pattern pattern = Pattern.compile(lookForHoratio);
        Matcher matcher = pattern.matcher(hamletData);
        hamletData = matcher.replaceAll("Tariq");
    }
    public Integer findHoratio(){
        Pattern pattern = Pattern.compile(lookForHoratio);
        Matcher matcher = pattern.matcher(hamletData);

        Integer count = 0;
        while(matcher.find()){
            count++;
        }
        return count;
    }
    public Integer findHamlet(){
        Pattern pattern = Pattern.compile(lookForHamlet);
        Matcher matcher = pattern.matcher(hamletData);
        Integer count = 0;
        while(matcher.find()){
            count++;
        }
        return count;
    }

}
