package com.example.aplicacionparalau;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class SimpleAdapter extends ArrayAdapter<Product> {
    private List<Product> itemList;
    private Context context;
    public SimpleAdapter(List<Product> itemList, Context ctx){
        super(ctx, android.R.layout.simple_list_item_1, itemList);
        this.itemList = itemList;
        this.context = ctx;
    }
    public int getCount(){
        if(itemList != null){
            return itemList.size();
        }
        return 0;
    }
    public Product getItem(int position) {
        if (itemList != null)
            return itemList.get(position);
        return null;
    }

    public long getItemId(int position) {
        if (itemList != null)
            return itemList.get(position).hashCode();
        return 0;
    }

    @SuppressLint("SetTextI18n")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;
        if(v == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.list_item, null);
        }
        Product product = itemList.get(position);
        TextView id = (TextView) v.findViewById(R.id.wTitle);
        id.setText(product.getTitle());

        TextView likes = (TextView) v.findViewById(R.id.wLikes);
        likes.setText("Stock: " + product.getLikes());

        ImageView imageView = (ImageView) v.findViewById(R.id.wImage);
        int aleatory = ThreadLocalRandom.current().nextInt(1, 10 + 1);
        switch (aleatory){
            case 1:imageView.setImageResource(R.drawable.img1); break;
            case 2:imageView.setImageResource(R.drawable.img2); break;
            case 3:imageView.setImageResource(R.drawable.img3); break;
            case 4:imageView.setImageResource(R.drawable.img4); break;
            case 5:imageView.setImageResource(R.drawable.img5); break;
            case 6:imageView.setImageResource(R.drawable.img6); break;
            case 7:imageView.setImageResource(R.drawable.img7); break;
            case 8:imageView.setImageResource(R.drawable.img8); break;
            case 9:imageView.setImageResource(R.drawable.img9); break;
            case 10:imageView.setImageResource(R.drawable.img10); break;

        }


        return v;
    }
    public List<Product> getItemList(){
        return itemList;
    }
    public void setItemList(List<Product> itemList){
        this.itemList = itemList;
    }
}
