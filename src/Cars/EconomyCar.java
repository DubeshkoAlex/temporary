package Cars;

import CarsEnum.BodyCar;

import java.util.Objects;

public class EconomyCar extends Car {

    private boolean AudioPlayer;

    public EconomyCar(String brand, String model, int maxLoadCapacity, double priceForKm, double cost, double fuelConsumption, double maxSpeed, int releaseYear, BodyCar bodyCar, boolean AudioPlayer) {
        super(brand, model, maxLoadCapacity, priceForKm, cost, fuelConsumption, maxSpeed, releaseYear, bodyCar);
        this.AudioPlayer = AudioPlayer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        EconomyCar that = (EconomyCar) o;
        return AudioPlayer == that.AudioPlayer;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), AudioPlayer);
    }

    @Override
    public String toString() {
        return super.toString().replace("}",", AudioPlayer=" + AudioPlayer +"\'}");
    }
}
