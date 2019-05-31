package pos.system.compos.POJO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProductInCheck {
    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("retailPrice")
    @Expose
    private Double retailPrice;

    @SerializedName("count")
    @Expose
    private Integer count;

    public ProductInCheck(String name, Double retailPrice, Integer count) {
        this.name = name;
        this.retailPrice = retailPrice;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(Double retailPrice) {
        this.retailPrice = retailPrice;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
