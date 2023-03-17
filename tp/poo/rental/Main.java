package tp.poo.rental;

public class Main {
    public static <Optional> void main(String[] args) {
        Car car1 = new Car("Peugeot 308", 2019);
        Car car2 = new Car("Renault Clio", 2020);
        Car car3= new Car("ford mustang", 2014);
        Camel camel1 = new Camel(2020);
        Camel camel2 = new Camel(2018);

        CarRental rental = new CarRental();
        rental.add(car1);
        rental.add(car2);
        rental.add(car3);
        rental.add(camel1);
        rental.add(camel2);

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





