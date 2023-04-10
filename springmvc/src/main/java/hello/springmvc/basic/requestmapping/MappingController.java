package hello.springmvc.basic.requestmapping;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class MappingController {

    @RequestMapping(value = "/hello-basic",method = RequestMethod.GET)
    public String helloBasic(){
        log.info("helloBasic");
        return "ok";

    }


    //pathVariable
    @GetMapping("/mapping/{userId}")
    public String mappingPath(@PathVariable("userId") String data){ // 변수명이 path와 같으면 ()생략 가능 //@PathVariable String userId 이렇게 사용 가능
        log.info("mappingPath userId = {}",data);
        return "ok";

    }

    //pathVariable 다중 매핑
    @GetMapping("/mapping/users/{userId}/orders/{orderId}")
    public String mappingPath(@PathVariable String userId,
                              @PathVariable Long orderId){ // 변수명이 path와 같으면 ()생략 가능 //@PathVariable String userId 이렇게 사용 가능
        log.info("mappingPath userId = {}, orderId={}",userId, orderId);
        return "ok";

    }

    //파라미터 조건 매핑
    @GetMapping(value = "/mapping-param", params = "mode=debug") //파라미터 정보가 있어야 get가능
    public String mappingParam(){
        log.info("mappingParam");
        return "ok";
    }

    //헤더 추가 매핑
    @GetMapping(value = "/mapping-header", headers = "mode=debug") //헤더 정보가 있어야 get가능
    public String mappingHeader(){
        log.info("mappingHeader");
        return "ok";
    }

    //미디어 타입 매핑
//    consumes = "application/json"
//    consumes = "!application/json"
//    consumes = "application/*"
//    consumes = "*\/*"
//    MediaType.APPLICATION_JSON_VALUE
    @PostMapping(value = "/mapping-consume", consumes = "application/json") //미디어타입 content-type가 있어야 post가능
    public String mappingConsumes(){
        log.info("mappingConsumes");
        return "ok";
    }
    /**
     * Accept 헤더 기반
     * produces = "text/html"
     * produces = "!text/html"
     * produces = "text/*"
     * produces = "*\/*"
     */
    @PostMapping(value = "/mapping-produce", produces = "text/html") //미디어타입 Accept가 있어야 post가능
    public String mappingProduces(){
        log.info("mappingProduces");
        return "ok";
    }

}
