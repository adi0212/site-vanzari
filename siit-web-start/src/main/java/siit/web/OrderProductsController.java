package siit.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import siit.model.OrderProduct;
import siit.service.OrderProductService;

import java.util.List;

@RestController
public class OrderProductsController {
    @Autowired
    OrderProductService orderProductService;
    //    http://localhost:8080/api/customers/1/orders/3/products
    @GetMapping("/api/customers/{cId}/orders/{oId}/products")
    public List<OrderProduct> getAllOrderProductsBy(@PathVariable("cId") Integer customerId, @PathVariable("oId") Integer orderId) {
        return orderProductService.getAllBy(customerId, orderId);
    }
}
