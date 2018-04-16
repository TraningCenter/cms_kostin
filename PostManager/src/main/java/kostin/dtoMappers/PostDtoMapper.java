package kostin.dtoMappers;


import kostin.dto.PostDto;
import kostin.model.Post;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PostDtoMapper {

    PostDtoMapper INSTANCE = Mappers.getMapper( PostDtoMapper.class );

    PostDto postToPostDto(Post post);

    Post postDtoToPost(PostDto postDto );

}
