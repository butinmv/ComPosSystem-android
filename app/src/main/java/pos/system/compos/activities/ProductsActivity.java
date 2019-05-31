package pos.system.compos.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

import pos.system.compos.POJO.Product;
import pos.system.compos.R;

public class ProductsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_activity);

        Bundle arguments = getIntent().getExtras();
        ArrayList<Product> products = null;
        if (arguments != null) {
            products = (ArrayList<Product>) arguments.getSerializable("products");
        }
        TextView tv = (TextView) findViewById(R.id.textView);
        int index = 0;
        String text = "";
        for (Product product: products) {
            text += product.getName() + "\n";
            index++;
        }
        tv.setText(text);
    }
}
