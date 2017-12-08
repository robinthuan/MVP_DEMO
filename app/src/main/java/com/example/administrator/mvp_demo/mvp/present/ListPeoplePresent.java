package com.example.administrator.mvp_demo.mvp.present;

import com.example.administrator.mvp_demo.mvp.model.ListPeopleHelper;
import com.example.administrator.mvp_demo.mvp.model.OnloadPeopleResult;
import com.example.administrator.mvp_demo.mvp.model.People;
import com.example.administrator.mvp_demo.mvp.view.ListPeopeleView;

import java.util.List;

/**
 * Created by administrator on 12/8/17.
 */

public class ListPeoplePresent implements OnloadPeopleResult {

    ListPeopeleView view;
    ListPeopleHelper listPeopleHelper;

    public ListPeoplePresent(ListPeopeleView view, ListPeopleHelper listPeopleHelper) {
        this.view = view;
        this.listPeopleHelper = listPeopleHelper;
        listPeopleHelper.setOnloadPeopleResult(this);
    }

    @Override
    public void onLoadSuccess(List<People> list) {

        view.displaylistPeople(list);
    }

    @Override
    public void onLoadFail(String error) {

    }
}
