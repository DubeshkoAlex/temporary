package Cars;

import carClasses.EconomyClass;

import java.util.Objects;

public class EconomyCar extends Car {
    private EconomyClass carClass;

    public EconomyCar(String brand, String model, int maxLoadCapacity, double priceForKm, double cost, double fuelConsumption, double maxSpeed, int releaseYear, EconomyClass carClass) {
        super(brand, model, maxLoadCapacity, priceForKm, cost, fuelConsumption, maxSpeed, releaseYear);
        this.carClass = carClass;
    }

    public EconomyClass getCarClass() {
        return carClass;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        EconomyCar that = (EconomyCar) o;
        return Objects.equals(carClass, that.carClass);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), carClass);
    }

    @Override
    public String toString() {
        return super.toString().replace("}",",carClass='" + carClass + "\'}");
    }
}
