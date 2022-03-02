package siit.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import siit.model.OrderProduct;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class OrderProductDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<OrderProduct> getAllBy(Integer customerId, Integer orderId) {
        String sql = "SELECT * FROM orders_products op WHERE op.order_id = ?";
        return jdbcTemplate.query(sql, this::extractOrderProduct, orderId);
    }

    private OrderProduct extractOrderProduct(ResultSet rs, int rowNumb) throws SQLException {
        Integer id = rs.getInt("id");
        Integer orderId = rs.getInt("order_id");
        Integer productId = rs.getInt("product_id");
        Double quantity = rs.getDouble("quantity");
        return new OrderProduct(id, orderId, productId, quantity);
    }
}
