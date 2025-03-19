package net.endeffect.service.impl;

import net.endeffect.dto.RoleDto;
import net.endeffect.dto.UserDto;
import net.endeffect.service.RoleService;
import net.endeffect.service.UserService;

import java.util.List;

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
    public UserDto findById(String id) {
        return super.findById(id);
    }
}
