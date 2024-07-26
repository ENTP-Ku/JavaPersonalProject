package com.packt.cardatabase;

import com.packt.cardatabase.domain.Car;
import com.packt.cardatabase.domain.CarRepository;
import com.packt.cardatabase.domain.Owner;
import com.packt.cardatabase.domain.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CardatabaseApplication implements CommandLineRunner {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private OwnerRepository ownerRepository;

    public static void main(String[] args) {
        SpringApplication.run(CardatabaseApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner("John Doe", "123 Elm Street");
        Owner owner2 = new Owner("Jane Smith", "456 Oak Avenue");
        Owner owner3 = new Owner("Alice Johnson", "789 Pine Road");
        Owner owner4 = new Owner("Bob Brown", "101 Maple Lane");
        Owner owner5 = new Owner("Carol White", "202 Birch Blvd");


        ownerRepository.save(owner1);
        ownerRepository.save(owner2);
        ownerRepository.save(owner3);
        ownerRepository.save(owner4);
        ownerRepository.save(owner5);


        carRepository.save(new Car("Toyota", "Corolla", 2020, owner1));
        carRepository.save(new Car("Honda", "Civic", 2019, owner3));
        carRepository.save(new Car("Ford", "Focus", 2021, owner2));
        carRepository.save(new Car("Chevrolet", "Malibu", 2018, owner4));
        carRepository.save(new Car("Nissan", "Altima", 2022, owner1));
        carRepository.save(new Car("Hyundai", "Elantra", 2021, owner1));
        carRepository.save(new Car("Kia", "Soul", 2019, owner2));
        carRepository.save(new Car("Volkswagen", "Jetta", 2020, owner2));
        carRepository.save(new Car("Subaru", "Impreza", 2022, owner1));
        carRepository.save(new Car("Mazda", "3", 2020, owner5));
        carRepository.save(new Car("BMW", "X5", 2023, owner3));
        carRepository.save(new Car("Audi", "A4", 2022, owner4));
        carRepository.save(new Car("Mercedes", "C-Class", 2021, owner5));






    }
}
