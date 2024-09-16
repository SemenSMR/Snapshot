package org.example;

import java.util.Stack;

public class Caretaker {
    private Stack<Snapshot> history = new Stack<>();

    public void save(Snapshot snapShot) {
        history.push(snapShot);
    }

    public Snapshot undo() {
        if (!history.isEmpty()) {
            return history.pop();
        }
        return null;
    }
}
