public class SolidExample {
    public static void main(String[] args) {
        Product product = new Product(1, "Laptop ");
        ProductRepository repository = new ProductRepository();
        repository.save(product);

    }
}

// SRP
class Product {
    private int id;
    private String name;

    public Product(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}

class ProductRepository {
    public void save(Product product) {
        System.out.println("Product saved =" + product.getName());
    }
}

// OCP
abstract class Discount {
    public abstract double apply(double price);
}

class PercentageDiscount extends Discount {
    private double percentge;

    public PercentageDiscount(double percentge) {
        this.percentge = percentge;
    }

    @Override
    public double apply(double price) {
        return price - (price * (percentge / 100));
    }

}

class fixedPAmountDiscount extends Discount {
    private double amount;

    public fixedPAmountDiscount(double amount) {
        this.amount = amount;
    }

    @Override
    public double apply(double price) {
        return price - amount;
    }
}

// LSP
class Payment {
    public void pay(double amount) {
        System.out.println("Paid" + amount);
    }
}

class CreditCardPayment extends Payment {
    @Override
    public void pay(double amount) {
        System.out.println("Credit card payment made for" + amount);
    }
}

class PayPalPayment extends Payment {
    @Override
    public void pay(double amount) {
        System.out.println("PayPal payment made for" + amount);
    }
}

// ISP
interface Printable {
    void printInvoice();
}

class Invoice implements Printable {

    @Override
    public void printInvoice() {
        System.out.println("Invoice Printed");
    }

}

// DIP

interface NotificationService {
    void sendNotification(String message);
}

class EmailNotificationService implements NotificationService {

    @Override
    public void sendNotification(String message) {
        System.out.println("Email sent: " + message);
    }

}

class Order {
    private NotificationService notificationService;

    public Order(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public void placeOrder(Product order) {
        // Place order logic here
        System.out.println("Order successfully placed");
        notificationService.sendNotification("Order placed for product: " + order.getName());
    }
}