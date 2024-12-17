package ru.job4j.pojo;

public class ShopDrop {
    public static Product[] delete(Product[] products, int index) {
        products[index] = null;
        for (int i = index; i < products.length; i++) {
           if (products[i] != products[products.length - 1]) {
                products[i] = products[i + 1];
            }
        }
        products[products.length - 1] = null;
        return products;
    }

    public static void main(String[] args) {
        Product[] products = new Product[4];
        products[0] = new Product("Milk", 10);
        products[1] = new Product("Bread", 4);
        products[2] = new Product("Egg", 19);
        Product[] array = ShopDrop.delete(products, 0);
        for (int j = 0; j < array.length; j++) {
            if (array[j] != null) {
                System.out.println(array[j].getName());
            }
        }
    }
}
