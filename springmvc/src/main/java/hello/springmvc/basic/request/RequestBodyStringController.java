package hello.springmvc.basic.request;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.nio.charset.StandardCharsets;

@Slf4j
@Controller
public class RequestBodyStringController {

    @PostMapping("/requst-body-string-v1")
    public void requestBodyString(HttpServletRequest request,
                                  HttpServletResponse response) throws IOException {
        ServletInputStream inputStream = request.getInputStream();
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);//스트림은 바이트 코드이기 때문에 항상 어떤 문자로 받을것인지 지정해줘야함

        log.info("messageBody = {}",messageBody);
        response.getWriter().write("ok");
    }

    @PostMapping("/requst-body-string-v2")
    public void requestBodyStringV2(InputStream inputStream,
                                    Writer responseWriter) throws IOException {
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);//스트림은 바이트 코드이기 때문에 항상 어떤 문자로 받을것인지 지정해줘야함

        log.info("messageBody = {}",messageBody);
        responseWriter.write("ok");
    }

    @PostMapping("/requst-body-string-v3")
    public HttpEntity<String > requestBodyStringV3(HttpEntity<String> entity) throws IOException {

        String messageBody = entity.getBody();

        log.info("messageBody = {}",messageBody);
        return  new HttpEntity<>("ok");
    }

    @ResponseBody
    @PostMapping("/requst-body-string-v4")
    public String requestBodyStringV4(@RequestBody String messageBody) throws IOException {

        log.info("messageBody = {}",messageBody);
        return  "ok";
    }
}
