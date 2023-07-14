package net.endeffect.service.impl;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import net.endeffect.dto.RoleDTO;
import net.endeffect.service.RoleService;

@Component
public class RoleServiceImpl extends AbstractMapService<RoleDTO,Long> implements RoleService {

    @Override
    public RoleDTO save(RoleDTO object) {
        return super.save(object.getId(), object); // calling 'save' from AbstractMapService with 'super'
    }

    @Override
    public List<RoleDTO> findAll() {
        return super.findAll(); //your responsibility is to find access to 'super' class
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public RoleDTO findById(Long id) {
        return super.findById(id);
    }
}
