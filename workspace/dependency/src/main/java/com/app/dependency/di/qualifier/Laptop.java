package com.app.dependency.di.qualifier;

import lombok.Data;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Data
@Qualifier(value = "laptop")
@Primary
public class Laptop implements Computer {
    @Override
    public int getScreenSize() {
        return 1680;
    }
}
