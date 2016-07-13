package com.example.ashutyagi.foldingcelldemo;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import cn.pedant.SweetAlert.SweetAlertDialog;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements Callback<StoryResponse> {
    RecyclerView recyclerView;
    ArrayList<CellTable> list = new ArrayList<>();
    ArrayList<CellTable> list1 = new ArrayList<>();
    FloatingActionButton fabShare;
    CellAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fabShare = (FloatingActionButton) findViewById(R.id.fab_more);
        if (CheckNetwork.isInternetAvailable(MainActivity.this)) //returns true if internet available
        {

        } else {

            new SweetAlertDialog(this, SweetAlertDialog.ERROR_TYPE)
                    .setTitleText("No Internet Connection Avialable!!")
                    .setContentText("Please Connect to the Internet")
                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sDialog) {
                            sDialog.dismissWithAnimation();
                        }
                    })
                    .show();
        }

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Intent intent = getIntent();
        int i = intent.getIntExtra("CHECK", 0);
        ArrayList<Integer> list = (ArrayList<Integer>) intent.getSerializableExtra("FINAL_CATEGORIES");
        if (i == 0) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://news.vaetas.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            NewsService newsService = retrofit.create(NewsService.class);

            Call<StoryResponse> call = newsService.fetchStories();
            call.enqueue(this);
        } else if (i == 1) {
            if (list.size() == 0) {
                finish();
            } else {
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://news.vaetas.com/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                NewsService newsService = retrofit.create(NewsService.class);
                Call<StoryResponse> call1 = newsService.fetchStoriesByCategory(list);
                call1.enqueue(new Callback<StoryResponse>() {
                    @Override
                    public void onResponse(Call<StoryResponse> call, Response<StoryResponse> response) {
                        ArrayList<CellTable> list1 = new ArrayList<>();
                        for (int i = 0; i < response.body().getData().size(); i++) {
                            Log.d("FETCHALL", String.valueOf(response.body()));
                            CellTable cellTable = new CellTable();
                            cellTable.setTitle("" + response.body().getData().get(i).getTitle().toString());
                            cellTable.setDescription("" + response.body().getData().get(i).getDescription().toString());
                            cellTable.setFullStory("" + response.body().getData().get(i).getArticleLink().toString());
                            cellTable.setImage("" + response.body().getData().get(i).getThumbnailUrl().toString());
                            cellTable.setTime("" + response.body().getData().get(i).getCreatedAt().toString());
                            list1.add(cellTable);
                        }
                        adapter = new CellAdapter(MainActivity.this, list1);
                        recyclerView.setAdapter(adapter);
                        adapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onFailure(Call<StoryResponse> call, Throwable t) {
                        t.getMessage();
                        t.printStackTrace();
                    }
                });
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_categories) {
            Intent intent = new Intent(MainActivity.this, Categories.class);
            startActivityForResult(intent, 1);
            return true;
        } else if (id == R.id.action_refresh) {
            list.clear();
            list1.clear();
            Intent intent = getIntent();
            int i = intent.getIntExtra("CHECK", 0);
            ArrayList<Integer> list = (ArrayList<Integer>) intent.getSerializableExtra("FINAL_CATEGORIES");
            if (i == 0) {
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://news.vaetas.com/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                NewsService newsService = retrofit.create(NewsService.class);

                Call<StoryResponse> call = newsService.fetchStories();
                call.enqueue(this);
            } else if (i == 1) {
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://news.vaetas.com/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                NewsService newsService = retrofit.create(NewsService.class);
                Call<StoryResponse> call1 = newsService.fetchStoriesByCategory(list);
                call1.enqueue(new Callback<StoryResponse>() {
                    @Override
                    public void onResponse(Call<StoryResponse> call, Response<StoryResponse> response) {
                        Log.d("ASDFGH", "ONRESPONSE CALLED in 1  ");
                        for (int i = 0; i < response.body().getData().size(); i++) {
                            Log.d("FETCHALL", String.valueOf(response.body()));
                            CellTable cellTable = new CellTable();
                            cellTable.setTitle("" + response.body().getData().get(i).getTitle().toString());
                            cellTable.setDescription("" + response.body().getData().get(i).getDescription().toString());
                            cellTable.setFullStory("" + response.body().getData().get(i).getArticleLink().toString());
                            cellTable.setImage("" + response.body().getData().get(i).getThumbnailUrl().toString());
                            cellTable.setTime("" + response.body().getData().get(i).getCreatedAt().toString());
                            list1.add(cellTable);
                        }
                        adapter = new CellAdapter(MainActivity.this, list1);
                        recyclerView.setAdapter(adapter);
                        adapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onFailure(Call<StoryResponse> call, Throwable t) {
                        t.getMessage();
                        t.printStackTrace();
                    }
                });
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onResponse(Call<StoryResponse> call, Response<StoryResponse> response) {
        Log.d("ASDFGH", "ONRESPONSE CALLED in 0");
        for (int i = 0; i < response.body().getData().size(); i++) {
            CellTable cellTable = new CellTable();
            cellTable.setTitle("" + response.body().getData().get(i).getTitle().toString());
            cellTable.setDescription("" + response.body().getData().get(i).getDescription().toString());
            cellTable.setFullStory("" + response.body().getData().get(i).getArticleLink().toString());
            cellTable.setImage("" + response.body().getData().get(i).getThumbnailUrl().toString());
            cellTable.setTime("" + response.body().getData().get(i).getCreatedAt().toString());
            list.add(cellTable);
            Log.d("DROP", response.body().getData().get(i).getTitle().toString());
        }
        final CellAdapter adapter = new CellAdapter(this, list);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onFailure(Call<StoryResponse> call, Throwable t) {
        t.getMessage();
        t.printStackTrace();

    }

}
