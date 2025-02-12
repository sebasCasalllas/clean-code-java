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

    class InputAttributes {
        private String value;
        private String placeholder;

        public InputAttributes(String value, String placeholder) {
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

    class InputEvents {
        private HtmlElement htmlElement;
        private InputAttributes inputAttributes;

        public InputEvents(String value, String placeholder, String id) {
            this.htmlElement = new HtmlElement(id, HtmlType.INPUT);
            this.inputAttributes = new InputAttributes(value, placeholder);
        }

        public void setFocus() {
            System.out.println("Input " + htmlElement.getId() + " is now focused.");
        }

        public String getValue() {
            return inputAttributes.getValue();
        }

        public boolean isActive() {
            return true; // Simulación de estado activo
        }

        public void removeValue() {
            inputAttributes.setValue("");
            System.out.println("Value removed from input " + htmlElement.getId());
        }

        @Override
        public String toString() {
            return "InputEvents{" +
                    "id='" + htmlElement.getId() + '\'' +
                    ", type=" + htmlElement.getType() +
                    ", value='" + inputAttributes.getValue() + '\'' +
                    ", placeholder='" + inputAttributes.getPlaceholder() + '\'' +
                    '}';
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
