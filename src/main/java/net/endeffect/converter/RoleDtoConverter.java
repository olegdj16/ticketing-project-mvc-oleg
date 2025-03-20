package net.endeffect.converter;

import net.endeffect.dto.RoleDto;
import net.endeffect.dto.UserDto;
import net.endeffect.service.RoleService;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

// we need these converter while working with thymeleaf
@Component
@ConfigurationPropertiesBinding
public class RoleDtoConverter implements Converter<String, RoleDto> {

    RoleService roleService;

    public RoleDtoConverter(RoleService roleService) {
        this.roleService = roleService;
    }

    @Override
    public RoleDto convert(String source) {
        return roleService.findById(Long.parseLong(source));
    }

}
