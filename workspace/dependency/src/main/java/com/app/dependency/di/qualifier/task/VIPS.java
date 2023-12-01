package com.app.dependency.di.qualifier.task;

import lombok.Data;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Data
@Qualifier("vips")
public class VIPS implements Resturant {
    private int steak=Resturant.steak-20000;
    @Override
    public boolean isSaladbar() {
        return true;
    }
}
