package ibm.labs.kc.order.command.dto;

import org.junit.Test;

public class CreateOrderRequestTest {

    @Test
    public void testValidateOK() {
        CreateOrderRequest cor = new CreateOrderRequest();
        cor.setExpectedDeliveryDate("2019-01-15T17:48Z");
        cor.setPickupDate("2019-01-14T17:48Z");
        cor.setProductID("myProductID");
        cor.setQuantity(100);
        CreateOrderRequest.validate(cor);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValidateBadExpectedDeliveryDate() {
        CreateOrderRequest cor = new CreateOrderRequest();
        cor.setExpectedDeliveryDate("2019-01-15T17");
        cor.setPickupDate("2019-01-14T17:48Z");
        cor.setProductID("myProductID");
        cor.setQuantity(100);
        CreateOrderRequest.validate(cor);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValidateBadPickupDate() {
        CreateOrderRequest cor = new CreateOrderRequest();
        cor.setExpectedDeliveryDate("2019-01-15T17:48Z");
        cor.setPickupDate("2019-01-15T17");
        cor.setProductID("myProductID");
        cor.setQuantity(100);
        CreateOrderRequest.validate(cor);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValidateQuantity() {
        CreateOrderRequest cor = new CreateOrderRequest();
        cor.setExpectedDeliveryDate("2019-01-15T17:48Z");
        cor.setPickupDate("2019-01-14T17:48Z");
        cor.setProductID("myProductID");
        cor.setQuantity(-100);
        CreateOrderRequest.validate(cor);
    }
}