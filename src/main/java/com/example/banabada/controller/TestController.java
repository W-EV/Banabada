package com.example.banabada.controller;

import com.example.banabada.dto.ResponseDTO;
// import com.example.banabada.dto.TestRequestBodyDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("test")
public class TestController {

    @GetMapping
    public String testController() {
        return "Hello World!";
    }

    @GetMapping("/testGetMapping")
    public String testControllerWithPath() {
        return "Hello World! testGetMapping ";
    }

/*
@RestController
public class TestController {
    @GetMapping("/test/testGetMapping")  // localhost:8080/test/testGetMapping
    public String testControllerWithPath() {
        return "Hello World! testGetMapping ";
    }
}
*/

    @GetMapping("/{id}")
    // localhost:8080/test/123
    public String testControllerWithPathVariables(@PathVariable(required = false) int id) {
        return "Hello World! ID " + id;
    }

    // /test경로는 이미 존재하므로 /test/testRequestParam으로 지정했다.
    @GetMapping("/testRequestParam")
    // localhost:8080/testRequestParam?id=123
    public String testControllerRequestParam(@RequestParam(required = false) int id) {
        return "Hello World! ID " + id;
    }


    /*/ /test경로는 이미 존재하므로 /test/testRequestBody로 지정했다.
    @GetMapping("/testRequestBody")
    // 요청에 보내고자 하는 oooDTO가 필요
    // localhost:8080/test/testRequestBody {'id':123, 'message': 'Hello World!'}
    // JSON 형태의 String인 { ... }를 oooDTO로 변환 후 전달
    public String testControllerRequestBody(@RequestBody TestRequestBodyDTO testRequestBodyDTO) {
        return "Hello World! ID " + testRequestBodyDTO.getId() + " Message : " + testRequestBodyDTO.getMessage();
    }

    // ResponseDTO 반환
    @GetMapping("/testResponseBody")
    public ResponseDTO<String> testControllerResponseBody() {
        List<String> list = new ArrayList<>();
        list.add("Hello World! I'm ResponseDTO");
        ResponseDTO<String> response = ResponseDTO.<String>builder().data(list).build();
        return response;
    }


    @GetMapping("/testResponseEntity")
    public ResponseEntity<?> testControllerResponseEntity() {
        List<String> list = new ArrayList<>();
        list.add("Hello World! I'm ResponseEntity. And you got 400!");
        ResponseDTO<String> response = ResponseDTO.<String>builder().data(list).build();
        // return ResponseEntity.badRequest().body(response); // http status를 400로 설정.
        // or 정상적 응답 반환
        return ResponseEntity.ok().body(response);
    }

     */
}
