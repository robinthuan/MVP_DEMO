package com.example.administrator.mvp_demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.administrator.mvp_demo.mvp.model.ListPeopleHelper;
import com.example.administrator.mvp_demo.mvp.model.OnloadPeopleResult;
import com.example.administrator.mvp_demo.mvp.model.People;
import com.example.administrator.mvp_demo.mvp.present.ListPeoplePresent;
import com.example.administrator.mvp_demo.mvp.view.ListPeopeleView;

import org.json.JSONException;

import java.util.List;

public class MainActivity extends AppCompatActivity implements ListPeopeleView {
    ListPeopleHelper listPeopleHelper;
    ListPeoplePresent listPeoplePresent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listPeopleHelper=new ListPeopleHelper();

    Thread thread=new Thread(new Runnable() {
        @Override
        public void run() {
        String respone=listPeopleHelper.getPeoplefromServer("https://api.randomuser.me/?results=1&nat=en");
            try {
                listPeopleHelper.parseJson(respone);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            listPeopleHelper.getListPeople();        }
    });
    thread.start();
        listPeoplePresent=new ListPeoplePresent(this,listPeopleHelper);
    }


    @Override
    public void displaylistPeople(List<People> peopleList) {
        Log.d("Phone:", "displaylistPeople: "+peopleList.get(0).getPhone());
    }
}
