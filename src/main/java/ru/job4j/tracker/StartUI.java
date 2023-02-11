package ru.job4j.tracker;

import ru.job4j.tracker.store.SqlTracker;

import java.util.Arrays;
import java.util.List;

public class StartUI {
    private final Output out;

    public StartUI(Output out) {
        this.out = out;
    }

    public void init(Input input, Store store, List<UserAction> actions) {
        boolean run = true;
        while (run) {
            showMenu(actions);
            int select = input.askInt("Select: ");
            if (select < 0 || select > actions.size()) {
                out.println("Wrong input, you can select: 0 .. " + (actions.size() - 1));
                continue;
            }
            UserAction action = actions.get(select);
            run = action.execute(input, store);
        }
    }

    private void showMenu(List<UserAction> actions) {
        out.println("Menu:");
        for (int index = 0; index < actions.size(); index++) {
            out.println(index + ". " + actions.get(index).name());
        }
    }

    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input input = new ValidateInput(output, new ConsoleInput());
        UserAction[] userActions = {
                new CreateAction(output),
                new CreateManyItems(output),
                new ShowAllAction(output),
                new EditAction(output),
                new DeleteAction(output),
                new DeleteAllItems(output),
                new FindByIdAction(output),
                new FindByNameAction(output),
                new Exit()
        };
        List<UserAction> actions = Arrays.asList(userActions);
        Store tracker = new MemTracker();
        new StartUI(output).init(input, tracker, actions);
    }
}

