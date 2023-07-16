package net.endeffect.converter;

import net.endeffect.dto.RoleDTO;
import net.endeffect.service.RoleService;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@ConfigurationPropertiesBinding // converts String to RoleDTO object
public class RoleDtoConverter implements Converter<String, RoleDTO> { // here we need to pass: <Source, Target>

    RoleService roleService;

    //injection
    public RoleDtoConverter(RoleService roleService) {
        this.roleService = roleService;
    }

    @Override
    public RoleDTO convert(String source) {
        return roleService.findById(Long.parseLong(source));
    }
}
