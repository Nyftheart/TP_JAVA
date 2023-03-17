package tp.poo.rental;

import java.util.Objects;

public class Car {
    private String model;
    private int year;
    private boolean isCamel;

    public Car(String model, int year) {
        if (model == null) {
            throw new NullPointerException();
        }
        this.model = model;
        this.year = year;
        this.isCamel = false;
    }

    public Car(int year, boolean isCamel) {
        this.year = year;
        this.isCamel = isCamel;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public boolean isCamel() {
        return isCamel;
    }

    @Override
    public String toString() {
        if (isCamel) {
            return "camel " + year;
        } else {
            return model + " (" + year + ")";
        }
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return year == car.year && Objects.equals(model, car.model);
    }

}
