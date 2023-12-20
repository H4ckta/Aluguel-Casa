package rent.controllers;

import rent.entities.House;
import rent.entities.Renting;
import rent.entities.Tenant;
import rent.services.interfaces.IRentalService;

import java.util.ArrayList;
import java.util.List;

public class RentController {
    private final List<Renting> rentings;
    private final List<House> houses;

    private final IRentalService iRentalService;

    public RentController(IRentalService iRentalService) {
        this.iRentalService = iRentalService;
        rentings = new ArrayList<>();
        houses = new ArrayList<>();
    }

    public void registerHouse(){
        House house = iRentalService.registerHouse();
        houses.add(house);
    }

    public void freeHouses(){
        iRentalService.printFreeHouses(houses);
    }

    public void rentingHouse(){
        House houseByAddress = iRentalService.findByAddress(houses);
        Tenant tenant = iRentalService.getTenantForRenting();
        Renting renting = iRentalService.rentingHouse(houseByAddress, tenant);
        rentings.add(renting);
    }

    public List<Renting> getRentings() {
        return rentings;
    }
}
