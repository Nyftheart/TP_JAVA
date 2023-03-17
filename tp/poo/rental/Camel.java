package tp.poo.rental;

public class Camel extends Car{

    public Camel(int year) {
        super("",year);
    }

    @Override
    public String toString() {
        return "camel " + getYear();
    }
    public boolean isCamel() {
        return true;
    }

}