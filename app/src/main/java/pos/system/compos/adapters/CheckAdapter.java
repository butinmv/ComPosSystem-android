package pos.system.compos.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import pos.system.compos.POJO.ProductInCheck;
import pos.system.compos.R;

public class CheckAdapter extends  RecyclerView.Adapter<CheckAdapter.CheckViewHolder> {
    List<ProductInCheck> productsInCheck;

    public CheckAdapter(List<ProductInCheck> productsInCheck) {
        this.productsInCheck = productsInCheck;
    }

    @NonNull
    @Override
    public CheckViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        Context context = parent.getContext();
        int layoutIdForListItem = R.layout.check_item;

        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(layoutIdForListItem, parent, false);

        return new CheckViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CheckViewHolder checkViewHolder, int position) {
        checkViewHolder.bind(position);
    }

    @Override
    public int getItemCount() {
        if (productsInCheck == null)
            return 0;
        return productsInCheck.size();
    }

    class CheckViewHolder extends RecyclerView.ViewHolder {
        TextView tvProductName;
        TextView tvProductCost;
        TextView tvProductCount;

        public CheckViewHolder(@NonNull View itemView) {
            super(itemView);

            tvProductName = itemView.findViewById(R.id.tv_product_in_check_name);
            tvProductCost = itemView.findViewById(R.id.tv_product_in_check_cost);
            tvProductCount = itemView.findViewById(R.id.tv_count_product_in_check);
        }

        void bind(int indexProduct) {
            tvProductName.setText(productsInCheck.get(indexProduct).getName());
            tvProductCost.setText(String.valueOf(productsInCheck.get(indexProduct).getRetailPrice()));
            tvProductCount.setText(String.valueOf(productsInCheck.get(indexProduct).getCount()));
        }
    }
}
