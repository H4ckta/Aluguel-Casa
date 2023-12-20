package rent;

import rent.controllers.RentController;
import rent.services.impl.RentService;

public class MainRent {
    public static void main(String[] args) {
        RentController rentController = new RentController(new RentService());

        rentController.registerHouse();
        rentController.registerHouse();

        rentController.freeHouses();

        rentController.rentingHouse();
    }
}
