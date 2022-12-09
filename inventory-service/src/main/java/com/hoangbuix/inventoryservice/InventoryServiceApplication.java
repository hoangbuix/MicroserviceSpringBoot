package com.hoangbuix.inventoryservice;

import com.hoangbuix.inventoryservice.enity.InventoryEntity;
import com.hoangbuix.inventoryservice.repository.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadData(InventoryRepository inventoryRepository) {
        return args -> {
            InventoryEntity inventory = new InventoryEntity();
            inventory.setSkuCode("ips_6ss");
            inventory.setQuantity(100);

            InventoryEntity inventory1 = new InventoryEntity();
            inventory1.setSkuCode("ips_6s");
            inventory1.setQuantity(0);

            inventoryRepository.save(inventory);
            inventoryRepository.save(inventory1);
        };
    }

}
