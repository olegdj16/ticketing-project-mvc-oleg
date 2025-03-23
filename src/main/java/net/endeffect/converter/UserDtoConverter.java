package net.endeffect.converter;

import net.endeffect.dto.UserDto;
import net.endeffect.service.UserService;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

// we need these converter while working with thymeleaf
@Component
@ConfigurationPropertiesBinding
public class UserDtoConverter implements Converter<String, UserDto> {

    UserService userService;

    public UserDtoConverter(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDto convert(String source) {
        return userService.findById(source);
    }

}
