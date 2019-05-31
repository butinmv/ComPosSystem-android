package pos.system.compos.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import pos.system.compos.POJO.Product;
import pos.system.compos.R;
import pos.system.compos.adapters.ProductAdapter;

public class ProductsActivity extends AppCompatActivity {

    private RecyclerView productList;
    List<Product> products;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_activity);

        Bundle arguments = getIntent().getExtras();
        products = new ArrayList<>();
        if (arguments != null) {
            products = (ArrayList<Product>) arguments.getSerializable("products");
        }

        productList = (RecyclerView) findViewById(R.id.rv_product);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        productList.setLayoutManager(layoutManager);
        ProductAdapter productAdapter = new ProductAdapter(products);
        productList.setAdapter(productAdapter);
    }
}
