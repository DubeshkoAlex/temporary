import Cars.*;
import carClasses.BusinessClass;
import carClasses.ComfortClass;
import carClasses.EconomyClass;
import carClasses.FamilyClass;
import utils.ReaderFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Runner {

    public static List<Car> cars = Arrays.asList(
            new EconomyCar("Renault","Logan",3,2,10000,8,170, 2014, EconomyClass.SEDAN),
            new EconomyCar("Renault","Logan",3,2,8000,8.5,160, 2012, EconomyClass.SEDAN),
            new EconomyCar("Kia","Ceed",3,2,12000,8,170, 2016, EconomyClass.HATCHBACK),
            new ComfortCar("Volkswagen","Jetta",3,4,18000,9,190, 2019, ComfortClass.SEDAN,4,true),
            new ComfortCar("Volkswagen","Jetta",3,3.5,18000,9,190, 2019, ComfortClass.SEDAN,4,false),
            new ComfortCar("Citroen","C4",3,4,17000,8,185, 2018, ComfortClass.HATCHBACK,4,true),
            new FamilyCar("Volkswagen","Sharan",6,4,25000,12,160, 2020, FamilyClass.MINIVAN,2,2),
            new FamilyCar("Peugeot","806",6,4,20000,12,150, 2020, FamilyClass.MINIVAN,1,2),
            new BusinessCar("Audi","A8",2,7,80000,14,300, 2021, BusinessClass.SEDAN,true,4,true),
            new BusinessCar("Mercedes","W223",2,8,100000,16,350, 2021, BusinessClass.SEDAN,true,4,true)
    );

    public static void main(String[] args) throws IOException {
        ReaderFile readerFile = new ReaderFile();
        readerFile.carBuilder();

    }
}
