package com.example.ashutyagi.foldingcelldemo;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ashu on 7/8/2016.
 */
public class CategoriesViewHolder extends RecyclerView.ViewHolder  {
    CheckedTextView checkedTextView;
    TextView textViewId;
  //  List<Integer> idlist = new ArrayList<>();

    public CategoriesViewHolder(final View itemView) {
        super(itemView);
        checkedTextView = (CheckedTextView) itemView.findViewById(R.id.ctv);
        textViewId = (TextView) itemView.findViewById(R.id.tv_id);

    }
}
