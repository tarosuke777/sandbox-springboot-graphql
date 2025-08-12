package com.example.graphqlserver;

import java.util.Arrays;
import java.util.List;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

@Controller
public class HeroController {
    @QueryMapping
    public Hero hero() {
        return new Hero("Superman");
    }

    // @SchemaMapping
    // public Friend[] friends(Hero hero) {
    // return new Friend[] {new Friend("Batman"), new Friend("aquaman")};
    // }

    @SchemaMapping
    public List<Friend> friends(Hero hero) {
        return Arrays.asList(new Friend("Batman"), new Friend("aquaman"));
    }
}
