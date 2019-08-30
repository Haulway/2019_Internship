package com.example.demo.controller;

import java.io.File;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.Dto.ProfileUploadDTO;
import com.example.demo.pythonInterface.PythonSupport;



import com.example.demo.utils.Base64Utils;


@RestController


public class ProfileController {




    @RequestMapping(value="/upload",method=RequestMethod.POST)
    public void upload(@RequestBody ProfileUploadDTO profile){


        String imgStr = profile.imgStr;

        String basePath = "H://project";
        String filePath = basePath + "/" +"temp"+ ".jpg";

        Base64Utils.createFile(imgStr, new File(filePath));
        PythonSupport temp = new PythonSupport();
//        temp.register(filePath,"1001");
        System.out.println(temp.judgeFace(filePath));
    }
}

