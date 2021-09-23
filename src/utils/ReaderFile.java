package utils;

import cars.*;
import carsEnum.BodyCar;
import carsEnum.CarType;

import java.io.*;
import java.util.*;

public class ReaderFile {

    private static final String CARS_PATH = "src/resources/Cars.txt";
    private List<String> File = new ArrayList<>();
    public List<Car> cars = new ArrayList<>();;

    private void readFile() throws IOException {
        Reader file = new FileReader(CARS_PATH);
        BufferedReader bufferedReader = new BufferedReader(file);
        String line = bufferedReader.readLine();
        while (line != null){
            File.add(line);
            line = bufferedReader.readLine();
        }
    }

    public void carBuilder() throws IOException {
        readFile();
        String[] substring;
        String delimeter = ",";

        for (String s: File) {
            substring = s.split(delimeter);
            switch (CarType.valueOf(substring[0])){
                case ECONOMY_CAR:
                    cars.add(new EconomyCar(
                            substring[1],
                            substring[2],
                            Integer.parseInt(substring[3]),
                            Double.parseDouble(substring[4]),
                            Double.parseDouble(substring[5]),
                            Double.parseDouble(substring[6]),
                            Integer.parseInt(substring[7]),
                            Integer.parseInt(substring[8]),
                            BodyCar.valueOf(substring[9]),
                            Boolean.parseBoolean(substring[10]))
                    );
                    break;
                case FAMILY_CAR:
                    cars.add(new FamilyCar(
                            substring[1],
                            substring[2],
                            Integer.parseInt(substring[3]),
                            Double.parseDouble(substring[4]),
                            Double.parseDouble(substring[5]),
                            Double.parseDouble(substring[6]),
                            Integer.parseInt(substring[7]),
                            Integer.parseInt(substring[8]),
                            BodyCar.valueOf(substring[9]),
                            Integer.parseInt(substring[10]),
                            Integer.parseInt(substring[11]))
                    );
                    break;
                case COMFORT_CAR:
                    cars.add(new ComfortCar(
                            substring[1],
                            substring[2],
                            Integer.parseInt(substring[3]),
                            Double.parseDouble(substring[4]),
                            Double.parseDouble(substring[5]),
                            Double.parseDouble(substring[6]),
                            Integer.parseInt(substring[7]),
                            Integer.parseInt(substring[8]),
                            BodyCar.valueOf(substring[9]),
                            Integer.parseInt(substring[10]),
                            Boolean.parseBoolean(substring[11]))
                    );
                    break;
                case BUSINESS_CAR:
                    cars.add(new BusinessCar(
                            substring[1],
                            substring[2],
                            Integer.parseInt(substring[3]),
                            Double.parseDouble(substring[4]),
                            Double.parseDouble(substring[5]),
                            Double.parseDouble(substring[6]),
                            Integer.parseInt(substring[7]),
                            Integer.parseInt(substring[8]),
                            BodyCar.valueOf(substring[9]),
                            Boolean.parseBoolean(substring[10]),
                            Integer.parseInt(substring[11]),
                            Boolean.parseBoolean(substring[12]))
                    );
                    break;
                default: throw new IOException("Wrong value");
            }
        }

        System.out.println(cars);

    }

    public void carMapBuilder() throws IOException{
        Map<String,String> economyCar = new LinkedHashMap<>();
        String[] economyCarFieldName = {"brand","model","maxLoadCapacity","priceForKm","priceForKm","cost","fuelConsumption","maxSpeed","releaseYear","bodyCar"};
        for (int i = 0; i < economyCarFieldName.length; i++) {
            economyCar.put(economyCarFieldName[i],null);
        }
        economyCar.put("brand",null);
        economyCar.put("model","b");


        economyCar.replace("brand","hi");
        for (String k:economyCar.keySet()) {
            System.out.println(economyCar.get(k));
        }












    }

    public void buildCar() throws IOException {
        readFile();
        String delimeter = ",";
        for (int i = 0; i < File.size(); i++) {
            String[] car = File.get(i).split(delimeter);
            switch (CarType.valueOf(car[0])){
                case ECONOMY_CAR:
                    Map<String,String> economyMap = new HashMap<>();
                    for (int j = 1; j < car.length; j++) {

                    }
            }
        }




    }

}
