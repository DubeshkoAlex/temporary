package Cars;

import carClasses.BusinessClass;

import java.util.Objects;

public class BusinessCar extends Car{
    private BusinessClass businessClass;
    private boolean wiFi;
    private int climateControlZonesCount;
    private boolean armrest;

    public BusinessCar(String brand, String model, int maxLoadCapacity, double priceForKm, double cost, double fuelConsumption, double maxSpeed, int releaseYear, BusinessClass businessClass, boolean wiFi, int climateControlZonesCount, boolean armrest) {
        super(brand, model, maxLoadCapacity, priceForKm, cost, fuelConsumption, maxSpeed, releaseYear);
        this.businessClass = businessClass;
        this.wiFi = wiFi;
        this.climateControlZonesCount = climateControlZonesCount;
        this.armrest = armrest;
    }

    public BusinessClass getBusinessClass() {
        return businessClass;
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
        return wiFi == that.wiFi && climateControlZonesCount == that.climateControlZonesCount && armrest == that.armrest && businessClass == that.businessClass;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), businessClass, wiFi, climateControlZonesCount, armrest);
    }

    @Override
    public String toString() {
        return super.toString().replace("}",", businessClass=" + businessClass +
                ", wiFi=" + wiFi +
                ", climateControlZonesCount=" + climateControlZonesCount +
                ", armrest=" + armrest +
                "}");
    }
}
