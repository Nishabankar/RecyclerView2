package in.nisha.recyclerview2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ProductViewHolder> {
    private ArrayList<Product> products;

    public ProductsAdapter(ArrayList<Product> products) {
        this.products = products;
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder {
        public ImageView imgProduct;
        public TextView txtProductTitle, getTxtProductPrice;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);

            imgProduct = itemView.findViewById(R.id.imgProduct);
            txtProductTitle = itemView.findViewById(R.id.txtProductTitle);
            getTxtProductPrice  = itemView.findViewById(R.id.txtProductPrice);
        }

    }


    @Override
    public int getItemCount() {
        return products.size();
    }


    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.product_view, null);
        return new ProductViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product product = products.get(position);

        holder.imgProduct.setImageResource(product.getImageId());
        holder.txtProductTitle.setText(product.getTitle());
        holder.getTxtProductPrice.setText("Rs." + product.getPrice());

        holder.imgProduct.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(v.getContext(), "Image:" + product.getTitle(), Toast.LENGTH_LONG).show();
                    }
                }
        );


        holder.txtProductTitle.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(v.getContext(), "Title:" + product.getTitle(), Toast.LENGTH_LONG).show();
                    }
                }
        );

    }
}

