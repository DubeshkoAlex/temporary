package Cars;

import CarsEnum.BodyCar;

import java.util.Objects;

public class FamilyCar extends Car{
    private int babySeatCount;
    private int tabletsCount;

    public FamilyCar(String brand, String model, int maxLoadCapacity, double priceForKm, double cost, double fuelConsumption, double maxSpeed, int releaseYear, BodyCar bodyCar, int babySeatCount, int tabletsCount) {
        super(brand, model, maxLoadCapacity, priceForKm, cost, fuelConsumption, maxSpeed, releaseYear, bodyCar);
        this.babySeatCount = babySeatCount;
        this.tabletsCount = tabletsCount;
    }

    public int getBabySeatCount() {
        return babySeatCount;
    }

    public int getTabletsCount() {
        return tabletsCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        FamilyCar familyCar = (FamilyCar) o;
        return babySeatCount == familyCar.babySeatCount && tabletsCount == familyCar.tabletsCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), babySeatCount, tabletsCount);
    }

    @Override
    public String toString() {
        return super.toString().replace("}",", babySeatCount=" + babySeatCount +
                ", tabletsCount=" + tabletsCount +
                "}");
    }
}
