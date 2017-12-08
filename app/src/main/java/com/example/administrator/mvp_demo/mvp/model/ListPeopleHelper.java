package com.example.administrator.mvp_demo.mvp.model;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by administrator on 12/8/17.
 */

public class ListPeopleHelper {
     List<People> peopleList;
     OnloadPeopleResult onloadPeopleResult;
     public void  setOnloadPeopleResult(OnloadPeopleResult onloadPeopleResult){
         this.onloadPeopleResult=onloadPeopleResult;
     }
     public List<People> parseJson(String respone) throws JSONException {
         peopleList=new ArrayList<>();
         JSONObject object=new JSONObject(respone);
         Log.d("respone", "parseJson: "+object);
         JSONArray array=new JSONArray(object.getString("results"));
         for(int i=0;i<array.length();i++){
             People people=new People();
             people.setGender(parseJsonObject(array.get(i).toString(),"gender"));
             people.setPhone(parseJsonObject(array.get(i).toString(),"phone"));
             Name name=new Name();
             name.setFirst(parseJsonObject(parseJsonObject(array.get(i).toString(),"name"),"first"));
             name.setTitle(parseJsonObject(parseJsonObject(array.get(i).toString(),"name"),"title"));
             people.setName(name);
             Picture picture=new Picture();
             picture.setMedium(parseJsonObject(parseJsonObject(array.get(i).toString(),"picture"),"medium"));
             people.setPicture(picture);
             peopleList.add(people);
         }
         return peopleList;
     }
    public String getPeoplefromServer(String api){
        try {
            URL url=new URL(api);
            HttpURLConnection httpURLConnection=(HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestProperty("Content-Type","application/json");
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setDoInput(true);
            InputStream is=httpURLConnection.getInputStream();
            BufferedReader reader=new BufferedReader(new InputStreamReader(is));
            String line="";
            StringBuilder result=new StringBuilder();
            while ((line=reader.readLine())!=null){
                result.append(line);
            }
            httpURLConnection.disconnect();
            is.close();
            reader.close();
            return result.toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
       return null;
    }
    public String parseJsonObject(String value,String key){
        try {
            JSONObject object1=new JSONObject(value);
            return object1.getString(key);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
    public void getListPeople(){
        onloadPeopleResult.onLoadSuccess(peopleList);
    }
}
