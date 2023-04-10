package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LogTestController {
//    private final Logger log = LoggerFactory.getLogger(getClass()); // @Slf4j 어노테이션 사용시 이 코드를 대신해 줌

    @RequestMapping("/log-test")
    public String logTest(){
        String name = "String";
        System.out.println("name = " + name);

        //로그 레벨
        log.trace("trace log={}", name);
        log.debug("debug log={}", name); //개발서버에서 개발에 필요한 정보 출력
        log.info("  info log={}", name); //운영에 필요한 정보만 출력
        log.warn("  warn log={}", name);
        log.error("error log={}", name);

        return "ok";
    }
}
