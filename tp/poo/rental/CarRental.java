package tp.poo.rental;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CarRental {
    private static List<Car> carList;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Car car : carList) {
            sb.append(car.getModel()).append(" ").append(car.getYear()).append("\n");
        }
        return sb.toString().trim();
    }

    public CarRental() {
        this.carList = new ArrayList<>();
    }

    public void add(Car car) {
        if (car == null)
        {
            throw new NullPointerException();
        }
        carList.add(car);
    }
    public void remove(Car car) {
        if (!carList.contains(car)) {
            throw new IllegalStateException();
        }
        carList.remove(car);
    }

    public static Optional<Car> findACarByModel(String model) {
        for (Car car : carList) {
            if (car.getModel().equals(model) && car.getYear() == car.getYear()) {
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
