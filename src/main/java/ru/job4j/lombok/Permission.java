package ru.job4j.lombok;

import lombok.*;

import java.util.List;

@Builder(builderMethodName = "of")
@ToString
@Getter
public class Permission {
    private int id;
    private String name;
    private List<String> rules;
}

class Main {
    public static void main(String[] args) {
        Permission test = Permission.of()
                .id(1)
                .name("aaa")
                .rules(List.of("create", "delete"))
                .build();
        System.out.println(test);
    }
}
