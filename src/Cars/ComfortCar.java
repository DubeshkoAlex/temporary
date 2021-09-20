package Cars;

import carClasses.ComfortClass;

import java.util.Objects;

public class ComfortCar extends Car {
    private ComfortClass comfortClass;
    private int airbagCount;
    private boolean conditioner;

    public ComfortCar(String brand, String model, int maxLoadCapacity, double priceForKm, double cost, double fuelConsumption, double maxSpeed, int releaseYear, ComfortClass comfortClass, int airbagCount, boolean conditioner) {
        super(brand, model, maxLoadCapacity, priceForKm, cost, fuelConsumption, maxSpeed, releaseYear);
        this.comfortClass = comfortClass;
        this.airbagCount = airbagCount;
        this.conditioner = conditioner;
    }

    public ComfortClass getComfortClass() {
        return comfortClass;
    }

    public int getAirbagCount() {
        return airbagCount;
    }

    public boolean isConditioner() {
        return conditioner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ComfortCar that = (ComfortCar) o;
        return airbagCount == that.airbagCount && conditioner == that.conditioner && comfortClass == that.comfortClass;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), comfortClass, airbagCount, conditioner);
    }

    @Override
    public String toString() {
        return super.toString().replace("}",", comfortClass=" + comfortClass +
                ", airbagCount=" + airbagCount +
                ", conditioner=" + conditioner +
                "}");
    }
}
