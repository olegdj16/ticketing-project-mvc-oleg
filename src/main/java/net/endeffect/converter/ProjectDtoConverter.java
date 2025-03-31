package net.endeffect.converter;

import net.endeffect.dto.ProjectDto;
import net.endeffect.service.ProjectService;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@ConfigurationPropertiesBinding
public class ProjectDtoConverter implements Converter<String, ProjectDto> {

    ProjectService projectService;

    //injection
    public ProjectDtoConverter(ProjectService projectService) {
        this.projectService = projectService;
    }

    @Override
    public ProjectDto convert(String source) {
        return projectService.findById(source);
    }

}
