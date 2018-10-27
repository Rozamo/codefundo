package com.nullpointers.deepankar.nulldisaster;

public class TodoItem {
    public String Id;

    public TodoItem(String id, String text) {
        Id = id;
        Text = text;
    }

    public String Text;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }
}
