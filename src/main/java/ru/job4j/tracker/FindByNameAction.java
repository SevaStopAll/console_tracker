package ru.job4j.tracker;

public class FindByNameAction implements UserAction {

    @Override
    public String name() {
        return "Find by Name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Find by name ===");
        String name = input.askStr("Enter name ");
        Item[] items = tracker.findByName(name);
        if (items.length > 0) {
            for (Item item : items) {
                System.out.println(item);
            }
        } else {
            System.out.println("Заявки с именем " + name + " не найдены.");
        }
        return true;
    }
}
