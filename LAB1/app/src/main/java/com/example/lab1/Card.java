package com.example.lab1;

public class Card {
    private boolean isOpen;
    private boolean isRemoved;
    private String value;

    public Card(String value) {
        this.isOpen = false;
        this.isRemoved = false;
        this.value = value;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public boolean isRemoved() {
        return isRemoved;
    }

    public void setRemoved(boolean removed) {
        isRemoved = removed;
    }

    public String getValue() {
        return value;
    }
}


