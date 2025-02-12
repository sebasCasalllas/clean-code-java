package org.example.cleanCode;

public class Tareas07 {
    // Definición del tipo de elemento HTML como un Enum
    enum HtmlType {
        INPUT, SELECT, TEXTAREA, RADIO
    }

    // Clase base que representa un elemento HTML genérico
    class HtmlElement {
        private String id;
        private HtmlType type;

        public HtmlElement(String id, HtmlType type) {
            this.id = id;
            this.type = type;
        }

        // Getters
        public String getId() {
            return id;
        }

        public HtmlType getType() {
            return type;
        }
    }

    // Clase que almacena atributos específicos de un input
    class InputAttributes {
        private String value;
        private String placeholder;

        public InputAttributes(String value, String placeholder) {
            this.value = value;
            this.placeholder = placeholder;
        }

        // Getters y Setters
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

    // Clase que maneja eventos y usa composición en lugar de herencia
    class InputEvents {
        private HtmlElement htmlElement;
        private InputAttributes inputAttributes;

        public InputEvents(String value, String placeholder, String id) {
            this.htmlElement = new HtmlElement(id, HtmlType.INPUT);
            this.inputAttributes = new InputAttributes(value, placeholder);
        }

        // Métodos de eventos
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

        // Método para imprimir el estado actual
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

    // Clase principal para probar el código
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
