package com.unionsystems.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import com.unionsystems.model.TestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @Author Obiora
 */
@RequestMapping("/template")
@RestController
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
public class UploadController {

    @PostMapping(value = "/upload")
    public ResponseEntity createMandateInBulk( @RequestParam("file") MultipartFile file){

        if(file.isEmpty()){
            return ResponseEntity.badRequest().body("File Must not be null");
        }
            return ResponseEntity.ok(new TestEntity());

    }
}
