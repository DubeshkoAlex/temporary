package Cars;

import carClasses.FamilyClass;

import java.util.Objects;

public class FamilyCar extends Car{
    private FamilyClass familyClass;
    private int babySeatCount;
    private int tabletsCount;

    public FamilyCar(String brand, String model, int maxLoadCapacity, double priceForKm, double cost, double fuelConsumption, double maxSpeed, int releaseYear, FamilyClass familyClass, int babySeatCount, int tabletsCount) {
        super(brand, model, maxLoadCapacity, priceForKm, cost, fuelConsumption, maxSpeed, releaseYear);
        this.familyClass = familyClass;
        this.babySeatCount = babySeatCount;
        this.tabletsCount = tabletsCount;
    }

    public FamilyClass getFamilyClass() {
        return familyClass;
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
        return babySeatCount == familyCar.babySeatCount && tabletsCount == familyCar.tabletsCount && familyClass == familyCar.familyClass;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), familyClass, babySeatCount, tabletsCount);
    }

    @Override
    public String toString() {
        return super.toString().replace("}",", familyClass=" + familyClass +
                ", babySeatCount=" + babySeatCount +
                ", tabletsCount=" + tabletsCount +
                "}");
    }
}
