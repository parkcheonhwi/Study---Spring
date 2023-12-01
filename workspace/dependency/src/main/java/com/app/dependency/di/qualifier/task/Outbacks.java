package com.app.dependency.di.qualifier.task;

import lombok.Data;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Data
@Primary
public class Outbacks implements Resturant {
    public int steak=Resturant.steak+10000;
    @Override
    public boolean isSaladbar() {
        return false;
    }
}
