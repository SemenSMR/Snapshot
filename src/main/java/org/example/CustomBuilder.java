package org.example;

public class CustomBuilder {
    private StringBuilder stringBuilder;
    private  Caretaker caretaker;

    public CustomBuilder() {
        this.stringBuilder = new StringBuilder();
        this.caretaker = new Caretaker();
    }

    public void saveState(){
        caretaker.save(new Snapshot(stringBuilder.toString()));
    }

    public  CustomBuilder append(String str){
        saveState();
        stringBuilder.append(str);
        return this;
    }
    public CustomBuilder insert(int index, String str) {
        saveState();
        stringBuilder.insert(index, str);
        return this;
    }
    public CustomBuilder delete(int start, int end) {
        saveState();
        stringBuilder.delete(start, end);
        return this;
    }
    public void undo() {
        Snapshot snapshot = caretaker.undo();
        if (snapshot != null) {
            stringBuilder = new StringBuilder(snapshot.getState());
        } else {
            System.out.println("Нечего отменять.");
        }
    }
    @Override
    public String toString() {
        return stringBuilder.toString();
    }
}
