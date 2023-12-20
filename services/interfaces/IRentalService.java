package rent.services.interfaces;

import rent.entities.House;
import rent.entities.Renting;
import rent.entities.Tenant;

import java.util.List;

public interface IRentalService {
    House registerHouse();
    void printFreeHouses(List<House> houses);
    Renting rentingHouse(House house, Tenant tenant);
    void cancelRent(Renting renting);
    House findByAddress(List<House> houses);
    Tenant getTenantForRenting();
}
