package pos.system.compos.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import pos.system.compos.POJO.Product;
import pos.system.compos.POJO.ProductInCheck;
import pos.system.compos.R;
import pos.system.compos.adapters.CheckAdapter;

public class CheckActivity extends AppCompatActivity {

    RecyclerView checkList;
    private static List<ProductInCheck> productsInCheck = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.check_activity);

        productsInCheck.add(new ProductInCheck("Пирог", (double) 23, 6));
        checkList = (RecyclerView) findViewById(R.id.rv_check);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        checkList.setLayoutManager(layoutManager);
        CheckAdapter checkAdapter = new CheckAdapter(productsInCheck);
        checkList.setAdapter(checkAdapter);

        Button bClear = findViewById(R.id.b_clear);
        bClear.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                productsInCheck.clear();
                checkList.getAdapter().notifyDataSetChanged();
            }
        });

        Button bAddProduct = findViewById(R.id.b_add_product);
        bAddProduct.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent categoriesActivityIntent = new Intent(CheckActivity.this, CategoriesActivity.class);
                startActivity(categoriesActivityIntent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        checkList = (RecyclerView) findViewById(R.id.rv_check);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        checkList.setLayoutManager(layoutManager);
        CheckAdapter checkAdapter = new CheckAdapter(productsInCheck);
        checkList.setAdapter(checkAdapter);
    }

    public static void addProduct(Product product) {
        for (ProductInCheck productInCheck: productsInCheck) {
            if (productInCheck.getName().equals(product.getName())) {
                productInCheck.setCount(productInCheck.getCount() + 1);
                return;
            }
        }
        productsInCheck.add(new ProductInCheck(product.getName(), product.getRetailPrice(), 1));
    }
}
