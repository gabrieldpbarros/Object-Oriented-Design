import products.*;

public class Main {
    public static void main(String[] args) {
        // PEDIDO 1: CAFÉ EXPRESSO
        var pedido1 = new Espresso();
        System.out.println("PEDIDO 1");
        System.out.println("Preço: " + pedido1.returnPrice());
        System.out.println("Descrição: " + pedido1.getDescription());

        // PEDIDO 2: LATTE MACCHIATO
        var pedido2 = new MilkTopping(new Espresso());
        System.out.println("PEDIDO 2");
        System.out.println("Preço: " + pedido2.returnPrice());
        System.out.println("Descrição: " + pedido2.getDescription());

        // PEDIDO 3: CAPPUCCINO
        var pedido3 = new Cappuccino();
        System.out.println("PEDIDO 3");
        System.out.println("Preço: " + pedido3.returnPrice());
        System.out.println("Descrição: " + pedido3.getDescription());

        // PEDIDO 4: MOCHA
        var pedido4 = new ChocolateTopping(new MilkTopping(new Espresso()));
        System.out.println("PEDIDO 4");
        System.out.println("Preço: " + pedido4.returnPrice());
        System.out.println("Descrição: " + pedido4.getDescription());

        // PEDIDO 5: CAPPUCCINO COM CHANTILLY
        var pedido5 = new ChantillyTopping(new Cappuccino());
        System.out.println("PEDIDO 5");
        System.out.println("Preço: " + pedido5.returnPrice());
        System.out.println("Descrição: " + pedido5.getDescription());

        // PEDIDO 6: CHÁ COM CANELA
        var pedido6 = new CinnamonTopping(new Tea());
        System.out.println("PEDIDO 6");
        System.out.println("Preço: " + pedido6.returnPrice());
        System.out.println("Descrição: " + pedido6.getDescription());

        // PEDIDO 7: CHÁ COM LEITE E CHOCOLATE
        var pedido7 = new ChocolateTopping(new MilkTopping(new Tea()));
        System.out.println("PEDIDO 7");
        System.out.println("Preço: " + pedido7.returnPrice());
        System.out.println("Descrição: " + pedido7.getDescription());

        // PEDIDO 8: CAPPUCCINO COM TUDO
        var pedido8 = new ChantillyTopping(new ChocolateTopping(new CinnamonTopping(new MilkTopping(new Cappuccino()))));
        System.out.println("PEDIDO 8");
        System.out.println("Preço: " + pedido8.returnPrice());
        System.out.println("Descrição: " + pedido8.getDescription());
    }
}
