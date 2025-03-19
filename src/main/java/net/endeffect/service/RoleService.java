package net.endeffect.service;

import net.endeffect.dto.RoleDto;
import net.endeffect.dto.UserDto;

import java.util.List;

public interface RoleService extends CrudService<RoleDto, Long> {

    // we dont need these because we are extending CrudService

//    RoleDto save(RoleDto role);
//    RoleDto findById(Long id);
//    List<RoleDto> findAll();
//    void delete(RoleDto role);
//    void deleteById(String username);

}
