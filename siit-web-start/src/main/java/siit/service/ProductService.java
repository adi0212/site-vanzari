package siit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import siit.db.ProductDao;
import siit.model.Product;

@Service
public class ProductService {
    @Autowired
    private ProductDao productDao;

    public Product getBy(Integer productId) {
        return productDao.getBy(productId);
    }
}
