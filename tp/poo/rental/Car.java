package tp.poo.rental;

public class Car {
    private String model;
    private int year;
    private boolean isCamel;

    public Car(String model, int year) {
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
}
