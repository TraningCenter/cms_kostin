package kostin.service;



import com.google.api.client.http.InputStreamContent;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.FileList;
import kostin.config.GoogleDriveConfig;
import kostin.dao.TextRepository;
import kostin.dto.TextDto;
import kostin.mappers.TextMapper;
import kostin.model.Text;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.List;




@Service
public class TextService {

    private TextRepository textRepository;

    @Autowired
   public TextService(TextRepository textRepository) {
       this.textRepository=textRepository;
   }

    public Text getTextById(Integer id){
        return textRepository.findOne(id);

    }

    public TextDto getText(Integer id){

       return TextMapper.INSTANCE.textToTextDto(textRepository.findOne(id));

    }

    public Integer createText(TextDto textDto){

        Text text = TextMapper.INSTANCE.textDtoToText(textDto);

        return textRepository.save(text).getId();

    }

    public void updateText(TextDto textDto){

        Text text = TextMapper.INSTANCE.textDtoToText(textDto);

        textRepository.save(text);
    }

    public void deleteText(Integer id){
        textRepository.delete(id);
    }


}
