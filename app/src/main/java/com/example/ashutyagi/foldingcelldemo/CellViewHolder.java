package com.example.ashutyagi.foldingcelldemo;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.ramotion.foldingcell.FoldingCell;

/**
 * Created by Ashu on 7/7/2016.
 */
public class CellViewHolder extends RecyclerView.ViewHolder  {
    TextView textViewTitleUnfolded , textViewDescriptionUnfolded , textViewReadFullStory, textViewTime , textViewReadFullStoryLink;
    TextView textViewTitleFolded , textViewDescriptionFolded;
    ImageView imageViewUnfolded;
    ImageView imageViewFolded;
    ProgressBar progressBar;
    FoldingCell fc;
    public CellViewHolder(final View itemView) {
        super(itemView);
        fc = (FoldingCell)itemView.findViewById(R.id.folding_cell);
        textViewTitleUnfolded = (TextView)itemView.findViewById(R.id.tv_title_unfolded);;
        textViewDescriptionUnfolded = (TextView)itemView.findViewById(R.id.tv_description_unfolded);;
        textViewReadFullStoryLink = (TextView)itemView.findViewById(R.id.tv_fullstory_unfolded_link);;
        textViewReadFullStory = (TextView)itemView.findViewById(R.id.tv_fullstory_unfolded);;
        textViewTime = (TextView)itemView.findViewById(R.id.tv_time_unfolded);
        textViewTitleFolded = (TextView)itemView.findViewById(R.id.tv_title_folded);
        textViewDescriptionFolded = (TextView)itemView.findViewById(R.id.tv_description_folded);
        imageViewUnfolded = (ImageView)itemView.findViewById(R.id.iv_unfolded);
        imageViewFolded = (ImageView)itemView.findViewById(R.id.iv_folded);
        progressBar = (ProgressBar)itemView.findViewById(R.id.progressbar);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fc.toggle(false);
                progressBar.setVisibility(View.GONE);

            }
        });
        textViewReadFullStory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = textViewReadFullStoryLink.getText().toString();
                Log.d("QWE",url);
                Uri webpage = Uri.parse(url);
                Intent i = new Intent(Intent.ACTION_VIEW,webpage);
                v.getContext().startActivity(i);
            }
        });


    }
}
