package net.endeffect.service.impl;

import net.endeffect.dto.RoleDto;
import net.endeffect.dto.UserDto;
import net.endeffect.service.RoleService;
import net.endeffect.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl  extends AbstractMapService<UserDto, String> implements UserService {

    @Override
    public UserDto save(UserDto object) {
        return super.save(object.getUserName(), object);
    }

    @Override
    public List<UserDto> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(String id) {

        super.deleteById(id);
    }

    @Override
    public void update(UserDto object) {
        super.update(object.getUserName(), object);
    }

    @Override
    public UserDto findById(String id) {
        return super.findById(id);
    }
}
