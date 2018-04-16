package kostin.controller;


import kostin.model.Image;
import kostin.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class ImageController {

    private ImageService imageService;

    @Autowired
    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @RequestMapping("/image/{id}")
    public byte[] getImage(@PathVariable Integer id) {//REST Endpoint.

       return imageService.getImage(id);
    }



    @RequestMapping(value = "/image", //
            method = RequestMethod.POST, //
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public Integer addImage(@RequestBody Image image) {

        return imageService.createImage(image);

    }

    // URL:
    // http://localhost:8080/SpringMVCRESTful/employee
    // http://localhost:8080/SpringMVCRESTful/employee.xml
    // http://localhost:8080/SpringMVCRESTful/employee.json


    // URL:
    // http://localhost:8080/SpringMVCRESTful/employee/{empNo}

    //TODO implement if need
    @RequestMapping(value = "/image/{id}", //
            method = RequestMethod.DELETE, //
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public void deleteImage(@PathVariable("id") Integer id) {
        ;
    }

}
