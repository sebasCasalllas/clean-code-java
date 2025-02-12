package org.example.cleanCode;

public class Tareas07 {

    enum HtmlType {
        INPUT, SELECT, TEXTAREA, RADIO
    }

    class HtmlElement {
        private String id;
        private HtmlType type;

        public HtmlElement(String id, HtmlType type) {
            this.id = id;
            this.type = type;
        }

        public String getId() {
            return id;
        }

        public HtmlType getType() {
            return type;
        }
    }

    class InputAttributes extends HtmlElement{
        private String value;
        private String placeholder;

        public InputAttributes(String id, HtmlType type, String value, String placeholder) {
            super(id, type);
            this.value = value;
            this.placeholder = placeholder;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getPlaceholder() {
            return placeholder;
        }

        public void setPlaceholder(String placeholder) {
            this.placeholder = placeholder;
        }
    }

    class InputEvents extends InputAttributes {

        public InputEvents(String id, HtmlType type, String value, String placeholder) {
            super(id, type, value, placeholder);
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

    public class Main {
        public static void main(String[] args) {
            InputEvents nameField = new InputEvents("Fernando", "Enter first name", "txtName");

            System.out.println(nameField);
            nameField.setFocus();
            nameField.removeValue();
            System.out.println("Value after removal: " + nameField.getValue());
        }
    }
}
