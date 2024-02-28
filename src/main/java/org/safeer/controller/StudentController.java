package org.safeer.controller;

import lombok.AllArgsConstructor;
import org.safeer.model.Student;
import org.safeer.model.response.HttpResponse;
import org.safeer.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static java.util.Map.of;
import static org.springframework.http.HttpStatus.*;


import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping("/student")
@AllArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping("/save")
    public ResponseEntity<HttpResponse> saveStudent(@RequestBody Student student){

        try {

            return ResponseEntity.ok().body(
                    HttpResponse.builder()
                            .timeStamp(new Date())
                            .message("Student added")
                            .status(HttpStatus.OK)
                            .data(of("student",studentService.saveStudent(student)))
                            .statusCode(OK.value())
                            .build()
            );
        }
        catch (Exception e){
            return ResponseEntity.ok().body(
                    HttpResponse.builder()
                            .message(e.getMessage())
                            .build()



            );

        }
    }



}
