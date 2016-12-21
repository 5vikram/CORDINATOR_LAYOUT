package com.example.root.viewpager;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by root on 25/8/16.
 */
public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {

    private List<Item> mItems;
    private Context context;

    public ItemAdapter(Context context1,List<Item> items) {
        this.mItems = items;
        this.context=context1;

    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.pager_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Item item=mItems.get(position);
       holder. imageView.setImageResource(item.getDrawableResource());
        holder.textView.setText(item.getName());
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder  {

        public ImageView imageView;
        public TextView textView;
        public Item item;

        public ViewHolder(View itemView) {
            super(itemView);

            imageView = (ImageView) itemView.findViewById(R.id.imageView);
            textView=(TextView)itemView.findViewById(R.id.name);

        }

    }


}