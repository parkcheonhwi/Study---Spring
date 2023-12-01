package com.app.dependency.di;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Food {
    private final Knife knife;
}
