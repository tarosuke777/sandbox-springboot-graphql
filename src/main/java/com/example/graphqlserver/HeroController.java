package com.example.graphqlserver;

import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class HeroController {
    @QueryMapping
    public Hero hero() {
        return new Hero("Superman");
    }
}
