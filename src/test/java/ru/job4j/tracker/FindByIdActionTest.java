package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class FindByIdActionTest {

    @Test
    public void whenFind() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item test = new Item("New item name");
        tracker.add(test);
        String replacedName = "New item name";
        FindByIdAction find = new FindByIdAction(out);

        Input input = mock(Input.class);

        when(input.askInt(any(String.class))).thenReturn(1);
        when(input.askStr(any(String.class))).thenReturn(replacedName);

        find.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo("=== Find by id ===" + ln + test + ln);
        assertThat(tracker.findAll().get(0)).isEqualTo(test);
    }

    @Test
    public void whenNotFound() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item test = new Item("New item name");
        tracker.add(test);
        String replacedName = "New item name";
        FindByIdAction find = new FindByIdAction(out);

        Input input = mock(Input.class);

        when(input.askInt(any(String.class))).thenReturn(2);
        when(input.askStr(any(String.class))).thenReturn(replacedName);

        find.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo("=== Find by id ===" + ln + "Item with id: 2 not found." + ln);
        assertThat(tracker.findAll().get(0)).isEqualTo(test);

    }

}