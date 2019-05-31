package pos.system.compos;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import pos.system.compos.POJO.Category;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>{

    private List<Category> categories;

    public CategoryAdapter(List<Category> categories) {
        this.categories = categories;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutIdForListItem = R.layout.category_item;

        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(layoutIdForListItem, parent, false);

        CategoryViewHolder categoryViewHolder = new CategoryViewHolder(v);
        return categoryViewHolder;
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
        TextView viewHolderIndex;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);

            listItemCategoryView = itemView.findViewById(R.id.tv_category_name);
        }

        void bind(int indexCategory) {
            listItemCategoryView.setText(categories.get(indexCategory).getCategoryName());
        }
    }
}
