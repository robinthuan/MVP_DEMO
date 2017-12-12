package com.example.administrator.mvp_demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.administrator.mvp_demo.mvp.adapter.RecylerAdapter;
import com.example.administrator.mvp_demo.mvp.model.ListPeopleHelper;
import com.example.administrator.mvp_demo.mvp.model.OnloadPeopleResult;
import com.example.administrator.mvp_demo.mvp.model.People;
import com.example.administrator.mvp_demo.mvp.present.ListPeoplePresent;
import com.example.administrator.mvp_demo.mvp.view.ListPeopeleView;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements ListPeopeleView, RecylerAdapter.OnResultClickListener {
    ListPeopleHelper listPeopleHelper;
    ListPeoplePresent listPeoplePresent;
    ArrayList<People> list;
    @BindView(R.id.recylerView)
    RecyclerView recyclerView;
    RecylerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        list = new ArrayList<>();
        listPeopleHelper = new ListPeopleHelper();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                String respone = listPeopleHelper.getPeoplefromServer("https://api.randomuser.me/?results=50&nat=en");
                try {
                    listPeopleHelper.parseJson(respone);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                listPeopleHelper.getListPeople();
            }
        });
        thread.start();
        listPeoplePresent = new ListPeoplePresent(this, listPeopleHelper);


    }


    @Override
    public void displaylistPeople(List<People> peopleList) {

        list = (ArrayList<People>) peopleList;
        adapter = new RecylerAdapter(list, this);
        runOnUiThread(new Runnable() {
            @Override
            public void run() {

                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(adapter);
            }
        });

    }

    @Override
    public void clickListener(int positon) {

    }
}
