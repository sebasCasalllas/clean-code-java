package org.example.clean.rectareas07;

import lombok.ToString;

@ToString
public class InputEvents {

    public HtmlElement htmlElement;
    public InputAttributes inputAttributes;

    public InputEvents(String value, String placeholder, String id) {
        this.htmlElement = new HtmlElement(id, HtmlType.INPUT);
        this.inputAttributes = new InputAttributes(value, placeholder);
    }

    public void setFocus() {
        System.out.println("Input");
    }

    public String getValue() {
        return "";
    }

    public boolean isActive() {
        return true; // Simulación de estado activo
    }

    public void removeValue() {
        System.out.println("Value removed from input " );
    }
}
