import cars.Car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TaxiPark {
    private List<? extends Car> cars;

    public TaxiPark(List<? extends Car> cars){
        this.cars = new ArrayList<>(cars);
    }

    public List<? extends Car> getCars(){
        return cars;
    }

    public double countCostAllCars(){
        double sum = 0;
        for (Car car:cars) {
            sum+=car.getCost();
        }
        return sum;
    }

    public void sortByFuelConsumption(){
        Collections.sort(cars,
                (Comparator<Car>) (o1,o2) -> {
                    if((o1.getFuelConsumption() - o2.getFuelConsumption())<0)
                        return -1;
                    if((o1.getFuelConsumption() - o2.getFuelConsumption())>0)
                        return 1;
                    return 0;
                });
    }

    public List<? extends Car> getCarsWithRangedSpeed(int startSpeed, int finishSpeed){
        List<Car> resultCars = new ArrayList<>();
        for (Car car:cars) {
            if(car.getMaxSpeed()>=startSpeed && car.getMaxSpeed()<=finishSpeed){
                resultCars.add(car);
            }
        }
        return resultCars;
    }

    @Override
    public String toString() {
        return "TaxiPark{" +
                "cars=\n" + cars +
                "}\n";
    }
}
