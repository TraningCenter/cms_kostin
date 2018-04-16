package kostin.controller;

import kostin.dto.TextDto;
import kostin.service.GoogleDriveService;
import kostin.service.ImageBufferService;
import kostin.service.ImageCompareService;
import kostin.service.TextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class TextController {

     private TextService textService;

     private GoogleDriveService driveService;

     private ImageCompareService imageCompareService;

     private ImageBufferService imageBufferService;

     @Autowired
    public TextController(TextService textService, GoogleDriveService driveService, ImageCompareService imageCompareService,ImageBufferService imageBufferService) {
        this.textService = textService;
        this.driveService=driveService;
        this.imageCompareService=imageCompareService;
        this.imageBufferService=imageBufferService;
    }



    @RequestMapping("/text/{id}")
    public TextDto getText(@PathVariable Integer id) {//REST Endpoint.


        return textService.getText(id);
    }



    @RequestMapping(value = "/text", //
            method = RequestMethod.POST, //
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public Integer addText(@RequestBody TextDto text) {

        return textService.createText(text);

    }

    // URL:
    // http://localhost:8080/SpringMVCRESTful/employee
    // http://localhost:8080/SpringMVCRESTful/employee.xml
    // http://localhost:8080/SpringMVCRESTful/employee.json
    @RequestMapping(value = "/text", //
            method = RequestMethod.PUT, //
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public void updateText(@RequestBody TextDto text) {

        textService.updateText(text);
    }

    // URL:
    // http://localhost:8080/SpringMVCRESTful/employee/{empNo}
    @RequestMapping(value = "/text/{id}", //
            method = RequestMethod.DELETE, //
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public void deleteText(@PathVariable("id") Integer id) {
        textService.deleteText(id);
    }


}
