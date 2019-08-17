package text1;

/**
 * @author chensiqi
 * @version 1.0
 * @ClassName text1.Product
 * @date 2019/8/16
 * @description 商品类
 **/
public class  Product {
    private Integer ProId;
    private  String proName;
    private  Float proPrice;

    public Product() {
    }

    public Product(Integer proId, String proName, Float proPrice) {
        ProId = proId;
        this.proName = proName;
        this.proPrice = proPrice;
    }

    public Integer getProId() {
        return ProId;
    }

    public void setProId(Integer proId) {
        ProId = proId;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public Float getProPrice() {
        return proPrice;
    }

    public void setProPrice(Float proPrice) {
        this.proPrice = proPrice;
    }

    @Override
    public String toString() {
        return "text1.Product{" +
                "ProId=" + ProId +
                ", proName='" + proName + '\'' +
                ", proPrice=" + proPrice +
                '}';
    }
}
