package rent.services.impl;

import rent.entities.House;
import rent.entities.Renting;
import rent.entities.Tenant;
import rent.services.interfaces.IRentalService;

import java.util.List;
import java.util.Scanner;

public class RentService implements IRentalService {

    Scanner scanner = new Scanner(System.in);
    @Override
    public House registerHouse() {
        House house = new House();

        System.out.println("Enter the address: ");
        house.setAddress(scanner.nextLine());
        System.out.println("Enter the value: ");
        house.setValue(scanner.nextDouble());
        scanner.nextLine();
        house.setRented(false);

        return house;
    }

    @Override
    public void printFreeHouses(List<House> houses) {
        for (House house : houses){
            if (!house.isRented())
                System.out.println(house.getAddress());
        }
    }

    @Override
    public Renting rentingHouse(House house, Tenant tenant) {
        Renting renting = new Renting();

        if (house.isRented()) {
            System.out.println("Casa já está alugada.");
        } else if (tenant.getMonthlyRent() < house.getValue()) {
            System.out.println("Renda insuficiente.");
        } else {
            renting.setHouse(house);
            renting.setTenant(tenant);
        }
        return renting;
    }

    @Override
    public void cancelRent(Renting renting) {

    }

    @Override
    public House findByAddress(List<House> houses) {
        System.out.println("Digite o endereço: ");
        String address = scanner.nextLine();
        for (House house : houses){
            if (address.equals(house.getAddress())) return house;
        }

        System.out.println("Endereço " + address + " não encontrado.");
        return null;
    }

    @Override
    public Tenant getTenantForRenting() {
        Tenant tenant = new Tenant();
        System.out.println("Digite o nome: ");
        tenant.setName(scanner.nextLine());
        System.out.println("Digite a renda mensal: ");
        tenant.setMonthlyRent(scanner.nextDouble());
        return tenant;
    }


}
