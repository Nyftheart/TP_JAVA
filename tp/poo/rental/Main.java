package tp.poo.rental;

public class Main {
    public static <Optional> void main(String[] args) {

        CarRental rental = new CarRental();

        System.out.println("Voitures à vendre:");
        for (Car car : rental.toSell()) {
            System.out.println(car);
        }

        Optional carOptional = (Optional) CarRental.findACarByModel("Renault Clio");
        if (((java.util.Optional<?>) carOptional).isPresent()) {
            Car car = (Car) ((java.util.Optional<?>) carOptional).get();
            System.out.println("Voiture trouvée : " + car);
        } else {
            System.out.println("Aucune voiture trouvée");
        }
    }
}





