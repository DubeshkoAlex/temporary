package utils;


import Cars.*;
import carClasses.BusinessClass;
import carClasses.ComfortClass;
import carClasses.EconomyClass;
import carClasses.FamilyClass;

import java.io.*;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ReaderFile {

    private static final String CARS_PATH = "C:/javaprojects/Collections_MainTask/src/Cars.txt";
    private List<String> listFile = new ArrayList<>();
    public List<Car> fileCars = new ArrayList<>();;

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
            switch (CarType.valueOf(substring[0])){
                case ECONOMY_CAR:
                    fileCars.add(new EconomyCar(
                            substring[1],
                            substring[2],
                            Integer.parseInt(substring[3]),
                            Double.parseDouble(substring[4]),
                            Double.parseDouble(substring[5]),
                            Double.parseDouble(substring[6]),
                            Double.parseDouble(substring[7]),
                            Integer.parseInt(substring[8]),
                            EconomyClass.valueOf(substring[9]))
                    );
                    break;
                case FAMILY_CAR:
                    fileCars.add(new FamilyCar(
                            substring[1],
                            substring[2],
                            Integer.parseInt(substring[3]),
                            Double.parseDouble(substring[4]),
                            Double.parseDouble(substring[5]),
                            Double.parseDouble(substring[6]),
                            Double.parseDouble(substring[7]),
                            Integer.parseInt(substring[8]),
                            FamilyClass.valueOf(substring[9]),
                            Integer.parseInt(substring[10]),
                            Integer.parseInt(substring[11]))
                    );
                    break;
                case COMFORT_CAR:
                    fileCars.add(new ComfortCar(
                            substring[1],
                            substring[2],
                            Integer.parseInt(substring[3]),
                            Double.parseDouble(substring[4]),
                            Double.parseDouble(substring[5]),
                            Double.parseDouble(substring[6]),
                            Double.parseDouble(substring[7]),
                            Integer.parseInt(substring[8]),
                            ComfortClass.valueOf(substring[9]),
                            Integer.parseInt(substring[10]),
                            Boolean.parseBoolean(substring[11]))
                    );
                    break;
                case BUSINESS_CAR:
                    fileCars.add(new BusinessCar(
                            substring[1],
                            substring[2],
                            Integer.parseInt(substring[3]),
                            Double.parseDouble(substring[4]),
                            Double.parseDouble(substring[5]),
                            Double.parseDouble(substring[6]),
                            Double.parseDouble(substring[7]),
                            Integer.parseInt(substring[8]),
                            BusinessClass.valueOf(substring[9]),
                            Boolean.parseBoolean(substring[10]),
                            Integer.parseInt(substring[11]),
                            Boolean.parseBoolean(substring[12]))
                    );
                    break;
                default: throw new IOException("Wrong value");
            }
        }

        System.out.println(fileCars);



    }
}
