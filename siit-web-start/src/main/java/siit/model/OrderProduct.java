package siit.model;

public class OrderProduct {
    private Integer id;
    private Integer orderId;
    private Integer productId;
    private Double quantity;
    private Product product;
    private Double value;


    public OrderProduct(Integer id, Integer orderId, Integer productId, Double quantity) {
        this.id = id;
        this.orderId = orderId;
        this.productId = productId;
        this.quantity = quantity;
        this.value = 0.0;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
        this.value = getQuantity() * product.getPrice();
    }

    public Double getValue() {
        return value;
    }

    public Integer getProductId() {
        return productId;
    }

    public Integer getId() {
        return id;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public Double getQuantity() {
        return quantity;
    }
}
