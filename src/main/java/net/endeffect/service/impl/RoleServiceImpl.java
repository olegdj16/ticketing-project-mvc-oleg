package net.endeffect.service.impl;

import net.endeffect.dto.RoleDto;
import net.endeffect.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl extends AbstractMapService<RoleDto, Long> implements RoleService {

    @Override
    public RoleDto save(RoleDto object) {
        return super.save(object.getId(), object);
    }

    @Override
    public List<RoleDto> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public RoleDto findById(Long id) {
        return super.findById(id);
    }
}
