package Cars;

import java.util.Objects;

public abstract class Car {
    private String brand;
    private String model;
    private int maxLoadCapacity;
    private double priceForKm;
    private double cost;
    private double fuelConsumption;
    private double maxSpeed;
    private int releaseYear;

    public Car(String brand, String model, int maxLoadCapacity, double priceForKm, double cost, double fuelConsumption, double maxSpeed, int releaseYear) {
        this.brand = brand;
        this.model = model;
        this.maxLoadCapacity = maxLoadCapacity;
        this.priceForKm = priceForKm;
        this.cost = cost;
        this.fuelConsumption = fuelConsumption;
        this.maxSpeed = maxSpeed;
        this.releaseYear = releaseYear;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getMaxLoadCapacity() {
        return maxLoadCapacity;
    }

    public double getPriceForKm() {
        return priceForKm;
    }

    public double getCost() {
        return cost;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return maxLoadCapacity == car.maxLoadCapacity && Double.compare(car.priceForKm, priceForKm) == 0 && Double.compare(car.cost, cost) == 0 && Double.compare(car.fuelConsumption, fuelConsumption) == 0 && Double.compare(car.maxSpeed, maxSpeed) == 0 && Objects.equals(brand, car.brand) && Objects.equals(model, car.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, maxLoadCapacity, priceForKm, cost, fuelConsumption, maxSpeed);
    }

    @Override
    public String toString() {
        return "Cars.Car{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", maxLoadCapacity=" + maxLoadCapacity +
                ", priceForKm=" + priceForKm +
                ", cost=" + cost +
                ", fuelConsumption=" + fuelConsumption +
                ", maxSpeed=" + maxSpeed +
                "}\n";
    }
}
