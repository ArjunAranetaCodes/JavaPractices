```java
import static org.mockito.Mockito.*;

import org.junit.Test;
import org.mockito.InOrder;

public class OrderServiceTest {

    @Test
    public void testProcessOrder() {
        // Create mock objects
        InventoryService inventoryMock = mock(InventoryService.class);
        PaymentService paymentMock = mock(PaymentService.class);
        ShippingService shippingMock = mock(ShippingService.class);

        // Create the object under test
        OrderService orderService = new OrderService(inventoryMock, paymentMock, shippingMock);

        // Define the order
        Order order = new Order("123", "Product A", 2, 50.00);

        // Execute the method under test
        orderService.processOrder(order);

        // Create an InOrder object
        InOrder inOrder = inOrder(inventoryMock, paymentMock, shippingMock);

        // Verify the order of method calls
        inOrder.verify(inventoryMock).checkStock(order.getProductId(), order.getQuantity());
        inOrder.verify(paymentMock).processPayment(order.getOrderId(), order.getTotalAmount());
        inOrder.verify(inventoryMock).updateStock(order.getProductId(), order.getQuantity());
        inOrder.verify(shippingMock).shipOrder(order);

        // Verify that there are no more interactions with the mocks
        verifyNoMoreInteractions(inventoryMock, paymentMock, shippingMock);
    }
}
```

In this example:

1. We create mock objects for `InventoryService`, `PaymentService`, and `ShippingService`.
2. We instantiate the `OrderService` with these mocks.
3. We create a sample `Order` object.
4. We call the `processOrder` method on our `OrderService`.
5. We create an `InOrder` object using `Mockito.inOrder()`, specifying the mocks we want to verify in order.
6. We use `inOrder.verify()` to check that the methods were called in the expected sequence.
7. Finally, we use `verifyNoMoreInteractions()` to ensure no unexpected calls were made to our mocks.

This script verifies that when processing an order:
1. The inventory is checked first.
2. Then the payment is processed.
3. After that, the inventory is updated.
4. Finally, the order is shipped.
