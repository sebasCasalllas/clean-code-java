package org.example.clean.rectareas07;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class InputEvents {

    private HtmlElement htmlElement;
    private InputAttributes inputAttributes;

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
