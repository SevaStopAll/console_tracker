package ru.job4j.tracker;

public class ValidateInput extends ConsoleInput {

    @Override
    public int askInt(String question) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = super.askInt(question);
                invalid = false;
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter validate data again");
            } catch (ArrayIndexOutOfBoundsException ae) {
                System.out.println("Please enter the correct option");
            }
        } while (invalid);
        return value;
    }
}
