package com.example.administrator.mvp_demo.mvp.model;

import java.util.List;

/**
 * Created by administrator on 12/8/17.
 */

public interface OnloadPeopleResult {
    void onLoadSuccess(List<People> list);
    void onLoadFail(String error);
}
