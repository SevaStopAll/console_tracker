package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class StartUI {
    Item item = new Item();

    public static void main(String[] args) {
        StartUI startUI = new StartUI();
        LocalDateTime currentDateTime = startUI.item.getCreated();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String currentDateTimeFormat = currentDateTime.format(formatter);
        System.out.println(currentDateTimeFormat);
    }
}
