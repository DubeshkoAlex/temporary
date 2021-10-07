import cars.Car;
import utils.JsonUtil;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String filename = "src/main/java/sourceFiles/Cars.json";
        Car car = JsonUtil.fromJsonFile(filename,Car.class);
        System.out.println(car);
    }
}
