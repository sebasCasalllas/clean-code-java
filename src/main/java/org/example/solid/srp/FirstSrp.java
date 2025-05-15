package org.example.solid.srp;

public class FirstSrp {

    // Clase que representa un producto
    static class Product {
        private int id;
        private String name;

        public Product(int id, String name) {
            this.id = id;
            this.name = name;
        }

        // Getters (y setters si es necesario)
        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "Product { id=" + id + ", name='" + name + "' }";
        }
    }

    // Clase que simula el ProductBloc
    static class ProductBloc {

        public void loadProduct(int id) {
            // Simula obtener el producto
            System.out.println("Producto: { id=" + id + ", name='OLED TV' }");
        }

        public void saveProduct(Product product) {
            // Simula guardar en base de datos
            System.out.println("Guardando en base de datos: " + product);
        }

        // No es responsabilidad del producto
        public void notifyClients() {
            System.out.println("Enviando correo a los clientes");
        }

        // No tiene relación con el producto no debería estar en ete bloc
        public void onAddToCart(int productId) {
            System.out.println("Agregando al carrito " + productId);
        }
    }

    public static void main(String[] args) {
        ProductBloc productBloc = new ProductBloc();

        productBloc.loadProduct(10);
        productBloc.saveProduct(new Product(10, "OLED TV"));
        productBloc.notifyClients();
        productBloc.onAddToCart(10);
    }
}
