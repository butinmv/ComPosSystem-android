package pos.system.compos.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import pos.system.compos.POJO.Category;
import pos.system.compos.POJO.Product;
import pos.system.compos.R;
import pos.system.compos.activities.ProductsActivity;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>{

    private List<Category> categories;
    private Context parent;
    public CategoryAdapter(List<Category> categories, Context parent) {
        this.categories = categories;
        this.parent = parent;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutIdForListItem = R.layout.category_item;

        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(layoutIdForListItem, parent, false);

        return new CategoryViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder categoryViewHolder, int position) {
        categoryViewHolder.bind(position);
    }

    @Override
    public int getItemCount() {
        if (categories == null)
            return 0;
        return categories.size();
    }

    class CategoryViewHolder extends RecyclerView.ViewHolder {

        TextView listItemCategoryView;

        private CategoryViewHolder(@NonNull View itemView) {
            super(itemView);

            listItemCategoryView = itemView.findViewById(R.id.tv_category_name);

            listItemCategoryView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    TextView tv = view.findViewById(R.id.tv_category_name);
                    String categoryName = tv.getText().toString();
                    int positionIndex = getAdapterPosition();
                    Class destinationActivity = ProductsActivity.class;
                    Intent productsActivityIntent = new Intent(parent, destinationActivity);
                    ArrayList<Product> listProducts = null;
                    for (Category category: categories) {
                        if (category.getCategoryName().equals(categoryName)) {
                            listProducts = category.getListProduct();
                            break;
                        }
                    }
                    productsActivityIntent.putExtra("products", listProducts);
                    parent.startActivity(productsActivityIntent);
                }
            });
        }

        void bind(int indexCategory) {
            listItemCategoryView.setText(categories.get(indexCategory).getCategoryName());
        }
    }
}
