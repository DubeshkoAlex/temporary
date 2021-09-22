package Cars;

import CarsEnum.BodyCar;

import java.util.Objects;

public class BusinessCar extends Car{
    private boolean wiFi;
    private int climateControlZonesCount;
    private boolean armrest;

    public BusinessCar(String brand, String model, int maxLoadCapacity, double priceForKm, double cost, double fuelConsumption, double maxSpeed, int releaseYear, BodyCar bodyCar, boolean wiFi, int climateControlZonesCount, boolean armrest) {
        super(brand, model, maxLoadCapacity, priceForKm, cost, fuelConsumption, maxSpeed, releaseYear, bodyCar);
        this.wiFi = wiFi;
        this.climateControlZonesCount = climateControlZonesCount;
        this.armrest = armrest;
    }

    public boolean isWiFi() {
        return wiFi;
    }

    public int getClimateControlZonesCount() {
        return climateControlZonesCount;
    }

    public boolean isArmrest() {
        return armrest;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        BusinessCar that = (BusinessCar) o;
        return wiFi == that.wiFi && climateControlZonesCount == that.climateControlZonesCount && armrest == that.armrest;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), wiFi, climateControlZonesCount, armrest);
    }

    @Override
    public String toString() {
        return super.toString().replace("}",", wiFi=" + wiFi +
                ", climateControlZonesCount=" + climateControlZonesCount +
                ", armrest=" + armrest +
                "}");
    }
}
