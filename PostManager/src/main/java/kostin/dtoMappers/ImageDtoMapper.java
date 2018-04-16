package kostin.dtoMappers;

import kostin.dto.ImageDto;
import kostin.model.Image;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ImageDtoMapper {



    ImageDtoMapper INSTANCE = Mappers.getMapper( ImageDtoMapper.class );

    ImageDto imageToImageDto(Image image);

    Image imageDtoToImage(ImageDto imageDto );
}
