package org.example.clean.rectareas07;

import org.example.clean.Tareas07;

public class MainTareas {

    public static void main(String[] args) {

        InputEvents nameField = new InputEvents("Fernando", "Enter first name", "txtName");

        System.out.println(nameField);
        nameField.setFocus();
        nameField.removeValue();
        System.out.println("Value after removal: " + nameField.getValue());
    }
}
