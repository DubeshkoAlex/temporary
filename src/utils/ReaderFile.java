package utils;


import Cars.FamilyCar;
import Cars.CarType;
import java.io.*;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ReaderFile {

    private static final String CARS_PATH = "C:/javaprojects/Collections_MainTask/src/Cars.txt";
    private List<String> listFile = new ArrayList<>();

    private void readFile() throws IOException {
        Reader file = new FileReader(CARS_PATH);
        BufferedReader bufferedReader = new BufferedReader(file);
        String line = bufferedReader.readLine();
        while (line != null){
            listFile.add(line);
            line = bufferedReader.readLine();
        }
    }

    public void carBuilder() throws IOException {
        readFile();
        String[] substring;
        String delimeter = ",";
        for (String s: listFile) {
            substring = s.split(delimeter);



            System.out.println(FamilyCar.class.getSimpleName().toLowerCase(Locale.ROOT));
        }


    }
}
