package factory;

import enums.ProductCategory;
import model.product.Clothing;
import model.product.Electronics;
import model.product.Grocery;
import model.product.Product;

public class ProductFactory {

    // Factory Pattern — hides the 'new' keyword from caller
    public static Product create(
            ProductCategory category,
            String id,
            String name,
            double price,
            String... extras
    ) {

        return switch (category) {
            case ELECTRONICS -> new Electronics(
                    id, name, price, extras[0], Integer.parseInt(extras[1])
            );
            case CLOTHING -> new Clothing(
                    id, name, price, extras[0], extras[1]
            );
            case GROCERY -> new Grocery(
                    id, name, price, extras[0], extras[1]
            );
        };
    }
}
