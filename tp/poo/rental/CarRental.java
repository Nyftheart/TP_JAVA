package tp.poo.rental;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CarRental {
    private static List<Car> carList;

    public CarRental() {
        this.carList = new ArrayList<>();
    }

    public void add(Car car) {
        carList.add(car);
    }
    public void remove(Car car) {
        carList.remove(car);
    }

    public static Optional<Car> findACarByModel(String model) {
        for (Car car : carList) {
            if (car.getModel().equals(model)) {
                return Optional.of(car);
            }
        }
        return Optional.empty();
    }

    public List<Car> toSell() {
        List<Car> carsToSell = new ArrayList<>();
        int currentYear = LocalDate.now().getYear();
        for (Car car : carList) {
            if (!car.isCamel() && currentYear - car.getYear() >= 2) {
                carsToSell.add(car);
            } else if (car.isCamel() && currentYear - car.getYear() >= 5) {
                carsToSell.add(car);
            }
        }
        return carsToSell;
    }

}
