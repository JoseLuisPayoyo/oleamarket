package com.oleamarket.config;

import com.oleamarket.entity.Role;
import com.oleamarket.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class DataInitializer implements CommandLineRunner {
    
    private final RoleRepository roleRepository;
    
    @Override
    public void run(String... args) {
        // Crear roles si no existen
        if (!roleRepository.existsByName(Role.RoleName.ROLE_USER)) {
            Role userRole = new Role();
            userRole.setName(Role.RoleName.ROLE_USER);
            roleRepository.save(userRole);
            log.info("Rol ROLE_USER creado");
        }
        
        if (!roleRepository.existsByName(Role.RoleName.ROLE_ADMIN)) {
            Role adminRole = new Role();
            adminRole.setName(Role.RoleName.ROLE_ADMIN);
            roleRepository.save(adminRole);
            log.info("Rol ROLE_ADMIN creado");
        }
        
        log.info("Inicialización de datos completada");
    }
}