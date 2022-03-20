package siit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import siit.model.OrderProduct;
import siit.db.OrderProductDao;
import siit.model.Product;

import java.util.List;

@Service
public class OrderProductService {
    @Autowired
    OrderProductDao orderProductsDao;
    @Autowired
    ProductService productService;

    public List<OrderProduct> getAllBy(Integer customerId, Integer orderId) {
        List<OrderProduct> orderProducts = orderProductsDao.getAllBy(customerId, orderId);
        for(OrderProduct orderProduct : orderProducts) {
            Product product = productService.getBy(orderProduct.getProductId());
            orderProduct.setProduct(product);
        }
        return orderProducts;
    }
}
