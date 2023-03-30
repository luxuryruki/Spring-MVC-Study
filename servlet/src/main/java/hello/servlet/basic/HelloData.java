package hello.servlet.basic;

import lombok.Getter;
import lombok.Setter;

@Getter // setter 자동생성
@Setter //getter 자동생성
public class HelloData {
    private String username;
    private int age;
}
