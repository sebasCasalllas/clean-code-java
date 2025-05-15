package org.example.solid.srp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.logging.*;

public class CleanFirstSrp {

    private static final Logger logger = Logger.getLogger("MyClass");

    // Clase que representa un producto
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    static class Product {
        // Getters (y setters si es necesario)
        private int id;
        private String name;

        @Override
        public String toString() {
            return "Product { id=" + id + ", name='" + name + "' }";
        }
    }

    // Centralizar peticipones
    static class ProductService {

        public void getProduct(int id) {
            logger.log(Level.INFO, "Producto {0}, name: OLED Tv", id);
        }

        public void saveProduct(Product product) {
            logger.log(Level.INFO, "Guardando en base de datos {0}", product);
        }
    }

    // Clase que simula el ProductBloc
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    static class ProductBloc {

        private ProductService productService;
        private Mailer mailer;

        public void loadProduct(int id) {
            productService.getProduct(id);
        }

        public void saveProduct(Product product) {
            productService.saveProduct(product);
        }

        public void notifyClients() {
            mailer.sendEmail(List.of("email@mail.com"), "to-client");
        }
    }

    // Para cumplir con una sola responsabilidad por clase
    // Se crea una clase para manejo de carrito
    static class  CartBloc {

        public void addToCart(int productId) {
            logger.log(Level.INFO, "Agregando al carrito {0}", productId);
        }
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    static class Mailer {

        private String masterEmail = "algo@gmail.com";

        public void  sendEmail(List<String> emailList, String template) {
            String mails = String.format("Tipo cliente %s, correos adjuntos %s", template, emailList);
            logger.log(Level.INFO, "Enviando correo a los clientes: {0} ", mails);
        }
    }

    public static void main(String[] args) {

        // Quitar todos los handlers existentes
        Logger rootLogger = Logger.getLogger("");
        Handler[] handlers = rootLogger.getHandlers();
        for (Handler handler : handlers) {
            rootLogger.removeHandler(handler);
        }

        // Crear un nuevo ConsoleHandler sin fecha
        ConsoleHandler handler = new ConsoleHandler();
        handler.setFormatter(new Formatter() {
            @Override
            public String format(LogRecord record) {
                return record.getLevel() + ": " + record.getMessage() + "\n";
            }
        });

        // Agregar handler al logger
        logger.addHandler(handler);
        logger.setUseParentHandlers(false);

        ProductService productService = new ProductService();
        Mailer mailer = new Mailer();
        ProductBloc productBloc = new ProductBloc(
                productService,
                mailer
        );
        CartBloc cartBloc = new CartBloc();

        productBloc.loadProduct(10);
        productBloc.saveProduct(new Product(10, "OLED TV"));
        productBloc.notifyClients();
        cartBloc.addToCart(10);
    }
}
