package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class StartUITest {
    @Test
    public void whenReplaceItem() {
        Tracker tracker = new Tracker();
        Item item2 = tracker.add(new Item("kek"));
        Item item = tracker.add(new Item("Replaced item"));
        int itemID = item.getId();
        int item2ID = item2.getId();
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[] {"0" , replacedName, "1"}
        );
        UserAction[] actions = {
                new ReplaceAction(),
                new ExitAction()
        };
        new StartUI().init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        /* Добавим в tracker новую заявку */
        Item item = tracker.add(new Item("Deleted item"));
        /* Входные данные должны содержать ID добавленной заявки item.getId() */
        Input in = new StubInput(
                new String[] {"0" /* входные параметры для DeleteAction */, "1"}
        );
        UserAction[] actions = {
                new DeleteAction(),
                new ExitAction()
        };
        new StartUI().init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }
}
