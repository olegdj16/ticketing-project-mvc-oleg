package net.endeffect.bootstrap;

import net.endeffect.dto.RoleDto;
import org.springframework.boot.CommandLineRunner;

public class DataGenerator implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {

        RoleDto adminRole = new RoleDto(1L, "Admin");
        RoleDto managerRole = new RoleDto(2L, "Manager");
        RoleDto employeeRole = new RoleDto(3L, "Employee");

    }
}
