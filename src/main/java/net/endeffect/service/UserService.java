package net.endeffect.service;

import net.endeffect.dto.UserDTO;

import java.util.List;

public interface UserService extends CrudService<UserDTO, String> {

    List<UserDTO> findManagers();


}
