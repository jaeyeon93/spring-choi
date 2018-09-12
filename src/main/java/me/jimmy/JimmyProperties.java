package me.jimmy;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;

@Component
@ConfigurationProperties("jimmy")
@Validated
public class JimmyProperties {

    @NotEmpty
    private String name;

    private int age;

    private String fulllName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFulllName() {
        return fulllName;
    }

    public void setFulllName(String fulllName) {
        this.fulllName = fulllName;
    }
}
