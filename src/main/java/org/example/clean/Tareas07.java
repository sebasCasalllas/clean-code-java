package org.example.clean;

public class Tareas07 {

    enum HtmlType {
        INPUT, SELECT, TEXTAREA, RADIO
    }

    static class HtmlElement {
        public String id;
        public HtmlType type;

        public HtmlElement(String id, HtmlType type) {
            this.id = id;
            this.type = type;
        }
    }

    static class InputAttributes {
        public String value;
        public String placeholder;

        public InputAttributes(String value, String placeholder) {
            this.value = value;
            this.placeholder = placeholder;
        }
    }

    static class InputEvents {

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

    public static void main(String[] args) {
        InputEvents nameField = new InputEvents("Fernando", "Enter first name", "txtName");

        System.out.println(nameField);
        nameField.setFocus();
        nameField.removeValue();
        System.out.println("Value after removal: " + nameField.getValue());
    }
}
