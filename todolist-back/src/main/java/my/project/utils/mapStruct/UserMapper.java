package my.project.utils.mapStruct;

import my.project.domain.dto.User;
import my.project.domain.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = TodoMapper.class, componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(source = "entityList", target = "listTodo")
    User toDTO(UserEntity userEntity);

    @Mapping(source = "listTodo", target = "entityList")
    UserEntity toEntity(User user);
}
