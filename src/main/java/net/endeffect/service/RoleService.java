package net.endeffect.service;

import net.endeffect.dto.RoleDTO;
import net.endeffect.dto.UserDTO;

import java.util.List;

public interface RoleService extends CrudService<RoleDTO, String>{

//    T save(RoleDTO role);
//    RoleDTO findById(Long id); // this is id (primary key) from RoleDTO, we chose it because it is unique. id will be created auto by Postgres
//    List<RoleDTO> findAll(); // will return List of RolesDTO
//    void delete(RoleDTO role);
//    void deleteById(Long id);

}
