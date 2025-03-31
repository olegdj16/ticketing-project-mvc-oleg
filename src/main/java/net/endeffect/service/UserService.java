package net.endeffect.service;

import net.endeffect.dto.UserDto;

import java.util.List;

public interface UserService extends CrudService<UserDto, String> {

    // we dont need these because we are extending CrudService

//    UserDto save(UserDto user);
//    UserDto findById(String username);
//    List<UserDto> findAll();
//    void delete(UserDto user);
//    void deleteById(String username);

    // part 4, 2nd hour
    List<UserDto> findManagers();
    List<UserDto> findEmployees();

}
