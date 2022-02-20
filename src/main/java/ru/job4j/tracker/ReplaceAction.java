package ru.job4j.tracker;

public class ReplaceAction implements UserAction{

    @Override
    public String name() {
        return "Replace item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Replace item ===");
        Item item1 = tracker.findById(input.askInt("Enter first id: "));
        int id1 = item1.getId();
        Item item2 = tracker.findById(input.askInt("Enter second id: "));
        int id2 = item2.getId();
        if  (tracker.replace(id1, item2) && tracker.replace(id2, item2)) {
            System.out.println("Заявка успешно перемещены.");
        } else {
            System.out.println("Ошибка перемещения заявок.");
        }
        return true;
    }
}
