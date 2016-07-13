package com.example.ashutyagi.foldingcelldemo;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Ashu on 7/8/2016.
 */
public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesViewHolder> {
    Context c;
    List<CategoryTable> list = new ArrayList<>();
    ArrayList<Integer> idlist = new ArrayList<>();
    int pos=0;
    public CategoriesAdapter(Context c, List<CategoryTable> list) {
        this.c = c;
        this.list = list;
    }

    @Override
    public CategoriesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.category_model, null);
        return new CategoriesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final CategoriesViewHolder holder, final int position) {
        holder.checkedTextView.setText(""+list.get(position).getTitle().toString());
        holder.textViewId.setText(""+list.get(position).getId());
        holder. checkedTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!holder.checkedTextView.isChecked()) {
                    holder.checkedTextView.setChecked(true);
                    idlist.add(pos%5,Integer.parseInt(String.valueOf(holder.textViewId.getText())));
                    pos++;
                    Log.d("added", String.valueOf(idlist));
                } else {
                    holder.checkedTextView.setChecked(false);
                    idlist.remove(pos-1);
                    idlist.add(pos-1,0);
                    pos--;
                    Log.d("removed", String.valueOf(idlist));
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

}
