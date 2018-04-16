package kostin.mappers;


import kostin.dto.TextDto;
import kostin.model.Text;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TextMapper {



    TextMapper INSTANCE = Mappers.getMapper( TextMapper.class );

    TextDto textToTextDto(Text text);

    Text textDtoToText(TextDto textDto);


}
