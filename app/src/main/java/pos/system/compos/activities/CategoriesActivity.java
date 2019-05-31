package pos.system.compos.activities;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import pos.system.compos.adapters.CategoryAdapter;
import pos.system.compos.NetworkService;
import pos.system.compos.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import pos.system.compos.POJO.Category;

public class CategoriesActivity extends AppCompatActivity {

    private RecyclerView categoryList;
    List<Category> categories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category_activity);

        categories = new ArrayList<>();

        categoryList = (RecyclerView) findViewById(R.id.rv_categories);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        categoryList.setLayoutManager(layoutManager);
        CategoryAdapter categoryAdapter = new CategoryAdapter(categories, this);
        categoryList.setAdapter(categoryAdapter);

            NetworkService.getInstance().getComposApi().getAllCategory().enqueue(new Callback<List<Category>>() {
                @Override
                public void onResponse(@NonNull Call<List<Category>> call, @NonNull Response<List<Category>> response) {
                    categories.addAll(response.body());
                    categoryList.getAdapter().notifyDataSetChanged();
                }

                @Override
                public void onFailure(@NonNull Call<List<Category>> call,@NonNull Throwable t) {
                    Toast.makeText(CategoriesActivity.this, "An error occurred during networking", Toast.LENGTH_SHORT).show();
                }
            });
    }
}

