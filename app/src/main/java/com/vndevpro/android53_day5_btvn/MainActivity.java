package com.vndevpro.android53_day5_btvn;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ItemListener{
private RecyclerView rcvItem;
private ItemAdapter adapter;
private List<Item> mListItems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rcvItem = findViewById(R.id.rcvItem);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcvItem.setLayoutManager(linearLayoutManager);
        mListItems = getListItems();
        adapter = new ItemAdapter(mListItems);
        rcvItem.setAdapter(adapter);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        rcvItem.addItemDecoration(itemDecoration);
        ItemTouchHelper.SimpleCallback simpleCallback = new RecycleViewItem(0,ItemTouchHelper.LEFT,this);
        new ItemTouchHelper(simpleCallback).attachToRecyclerView(rcvItem);
    }
    private List<Item> getListItems(){
      List<Item> list = new ArrayList<>();
      for (int i=0 ; i<20; i++){
          list.add(new Item("Item" + ( i + 1)));
      }
      return  list;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder) {
      if(viewHolder instanceof ItemAdapter.ItemViewHolder){
          String nameItemDelete = mListItems.get(viewHolder.getAdapterPosition()).getName();
          Item itemDelete = mListItems.get(viewHolder.getAdapterPosition());
          int indexDelete = viewHolder.getAdapterPosition();
          adapter.removeItem(indexDelete);
      }
    }
}