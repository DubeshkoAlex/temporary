import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import Planes.*;
import models.MilitaryType;

public class Airport {
    private List<? extends Plane> planes;

    public Airport(List<? extends Plane> planes) {
        this.planes = planes;
    }

    public List<? extends Plane> getPlanes() {
        return planes;
    }

    /*private List<? extends Plane> getListOfRequiredTypeOfPlanes(String className) {
        List<Plane> requiredTypeOfPlane = new ArrayList<>();

        for (Plane iterablePlane: planes) {
            if((iterablePlane.getClass().getSimpleName()).equals(className)){
                requiredTypeOfPlane.add(iterablePlane);
            }
        }
        return  requiredTypeOfPlane;
    }*/


    public enum PlaneTypes {
        Military,
        Passenger,
        Experimental
    }

    private <T> List<T extends Plane> getListOfRequiredTypeOfPlanes(Class<T> tClass) {
        List<T> requiredTypeOfPlane = new ArrayList<>();


        for (int i = 0; i < planes.size(); i++) {
            if((planes.get(i).getClass()).equals(tClass)){
                requiredTypeOfPlane.add(planes.get(i));
            }
        }

        return  requiredTypeOfPlane;
    }

    public List<PassengerPlane> getPassengerPlane() {
        return this.getListOfRequiredTypeOfPlanes(PassengerPlane.class);
    }









    private List<MilitaryPlane> getListOfRequiredTypeOfMilitaryPlane(MilitaryType typeOfMilitaryPlane){
        List<MilitaryPlane> militaryPlanes = getMilitaryPlanes();
        List<MilitaryPlane> requiredMilitaryPlanes = new ArrayList<>();
        for (MilitaryPlane militaryPlane: militaryPlanes) {
            if(militaryPlane.getMilitaryType() == typeOfMilitaryPlane){
                requiredMilitaryPlanes.add(militaryPlane);
            }
        }
        return requiredMilitaryPlanes;
    }

    // переделать
    @SuppressWarnings("unchecked")
    public List<PassengerPlane> getPassengerPlanes() {
        return (List<PassengerPlane>) getListOfRequiredTypeOfPlanes(PassengerPlane.class.getSimpleName());
    }

    @SuppressWarnings("unchecked")
    public List<MilitaryPlane> getMilitaryPlanes() {
         return (List<MilitaryPlane>) getListOfRequiredTypeOfPlanes(MilitaryPlane.class.getSimpleName());
    }

    @SuppressWarnings("unchecked")
    public List<ExperimentalPlane> getExperimentalPlanes() {
        return (List<ExperimentalPlane>) getListOfRequiredTypeOfPlanes(ExperimentalPlane.class.getSimpleName());
    }

    public PassengerPlane getPassengerPlaneWithMaxPassengersCapacity() {
        List<PassengerPlane> passengerPlanes = getPassengerPlanes();
        return Collections.max(passengerPlanes, new Comparator<PassengerPlane>() {
            @Override
            public int compare(PassengerPlane o1, PassengerPlane o2) {
                return o1.getPassengersCapacity() - o2.getPassengersCapacity();
            }
        });
    }

    // переделать
    public List<MilitaryPlane> getTransportMilitaryPlanes() {
        return getListOfRequiredTypeOfMilitaryPlane(MilitaryType.TRANSPORT);
    }

    public List<MilitaryPlane> getBomberMilitaryPlanes() {
        return getListOfRequiredTypeOfMilitaryPlane(MilitaryType.BOMBER);
    }

    public List<MilitaryPlane> getFighterMilitaryPlanes() {
        return getListOfRequiredTypeOfMilitaryPlane(MilitaryType.FIGHTER);
    }

    public Airport sortByMaxDistance() {
        Collections.sort(planes, new Comparator<Plane>() {
            @Override
            public int compare(Plane o1, Plane o2) {
                return o1.getMaxFlightDistance() - o2.getMaxFlightDistance();
            }
        });
        return this;
    }

    public Airport sortByMaxSpeed() {
        Collections.sort(planes, new Comparator<Plane>() {
            @Override
            public int compare(Plane o1, Plane o2) {
                return o1.getMaxSpeed() - o2.getMaxSpeed();
            }
        });
        return this;
    }

    public Airport sortByMaxLoadCapacity() {
        Collections.sort(planes, new Comparator<Plane>() {
            @Override
            public int compare(Plane o1, Plane o2) {
                return o1.getMaxLoadCapacity() - o2.getMaxLoadCapacity();
            }
        });
        return this;
    }

    @Override
    public String toString() {
        return "Airport{" +
                "Planes=" + planes.toString() +
                '}';
    }
}
