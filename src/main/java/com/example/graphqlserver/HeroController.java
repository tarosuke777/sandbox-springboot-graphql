package com.example.graphqlserver;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

@Controller
public class HeroController {
    @QueryMapping
    public Hero hero() {
        return new Hero("Superman");
    }

    @MutationMapping
    public Hero addHero(@Argument String name) {
        return new Hero(name);
    }

    // @SchemaMapping
    // public Friend[] friends(Hero hero) {
    // return new Friend[] {new Friend("Batman"), new Friend("aquaman")};
    // }

    @SchemaMapping
    public List<Friend> friends(Hero hero, @Argument int limit) {
        // 全ての友達のリストを準備します
        List<Friend> allFriends =
                Arrays.asList(new Friend("Batman"), new Friend("aquaman"), new Friend("Superman"));

        // limit引数を使って、リストを指定された件数に制限します
        if (limit <= 0) {
            return allFriends; // limitが0以下の場合は全件返します
        }

        return allFriends.stream().limit(limit).collect(Collectors.toList());
    }


}
