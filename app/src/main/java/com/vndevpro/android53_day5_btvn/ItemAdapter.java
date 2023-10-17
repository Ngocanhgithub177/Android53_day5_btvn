package com.vndevpro.android53_day5_btvn;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder>{
    private List<Item> mListItems;

    public ItemAdapter(List<Item> mListItems) {
        this.mListItems = mListItems;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
       Item item = mListItems.get(position);
       if(item == null){
           return;
       }
       holder.tvName.setText(item.getName());
    }

    @Override
    public int getItemCount() {
        if(mListItems != null){
            return mListItems.size();
        }
        return 0;
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder{
        TextView tvName;
        LinearLayout foreGround;
        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            foreGround = itemView.findViewById(R.id.layout_foreground);

        }
    }
    public void removeItem(int index){
        mListItems.remove(index);
        notifyItemRemoved(index);
    }
    public void undoItem(Item item, int index){
        mListItems.add(index,item);
        notifyItemInserted(index);
    }
}
