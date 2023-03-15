package com.example.study_springmvc_feature.basic.response;

import com.example.study_springmvc_feature.basic.HelloData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Controller
public class ResponseBodyController {

    @GetMapping("/response-body-string-v1")
    public void responseBodyV1(HttpServletResponse response) throws IOException {
        response.getWriter().write("ok");
    }
    @GetMapping("/response-body-string-v2")
    public ResponseEntity<String> responseBodyV2(HttpServletResponse response){
        return new ResponseEntity<>("ok", HttpStatus.OK);
    }
    @GetMapping("/response-body-string-v3")
    @ResponseBody
    public String responseBodyV3(){
        return "ok";
    }

    @GetMapping("/response-body-json-v1")
    public ResponseEntity<HelloData> responseBodyJsonV1(){
        HelloData helloData = new HelloData();
        helloData.setUsername("userA");
        helloData.setAge(21);
        return new ResponseEntity<>(helloData,HttpStatus.OK);
    }

    @GetMapping("/response-body-json-v2")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK) // 응답코드 지정
    public HelloData responseBodyJsonV2(){
        HelloData helloData = new HelloData();
        helloData.setUsername("userA");
        helloData.setAge(21);
        return helloData;
    }
}
