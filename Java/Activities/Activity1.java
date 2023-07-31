package activities;
public class Activity1 {

    public static void main(String[] args) {
        Car brezza = new Car();
        brezza.name = "Vitara Brezza";
        brezza.color = "Red & Black";
        brezza.transmission = "Automatic";
        brezza.make = 2018;

        brezza.displayCharacteristics();
        brezza.accelarate();
        brezza.brake();
    }
}
