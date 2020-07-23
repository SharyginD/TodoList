package my.project.utils.mapStruct;

import my.project.domain.dto.Todo;
import my.project.domain.entity.TodoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TodoMapper {

    TodoMapper INSTANCE = Mappers.getMapper(TodoMapper.class);

    Todo toDTO(TodoEntity todoEntity);

    TodoEntity toEntity(Todo todo);


}
