package ru.job4j.tracker;

public class CreateAction implements UserAction {
    private final Output out;

    public CreateAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Create";
    }

    @Override
    public boolean execute(Input input, Store store) {
        out.println("=== Create a new Item ===");
        String name = input.askStr("Enter name ");
        Item item = new Item(name);
        store.add(item);
        out.println("Добавленная заявка " + item);
        return true;
    }
}
