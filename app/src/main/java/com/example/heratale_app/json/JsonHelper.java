package com.example.heratale_app.json;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import static java.sql.DriverManager.println;

public class JsonHelper {
    private String program;
    private String student;
    private Context context;
    private RequestQueue queue;
    private String url;

    public JsonHelper(String stu, Context conte) {
        this.program = "5c047ec0aa4bc8db2980b139";
        this.student = stu;
        this.context = conte;

        //Volley Initiation
        queue = Volley.newRequestQueue(this.context);
        url = "https://teacherportal.hearatale.com/api/"; //CHANGE THIS FOR YOUR USAGE
    }

    public void initJson(String stuID) {
        File file = new File(context.getFilesDir(),"storage.json");
        if(!file.exists()) {


            JSONObject topLvl;
            String userString = "";

            try { //write to object DEFAULT STATE IS HERE
                topLvl = new JSONObject();
                topLvl.put("client_token", "");
                topLvl.put("student_id", "");
                topLvl.put("focus_items", new JSONArray());
                topLvl.put("coins_earned", 0);
                topLvl.put("coins_current", 0);
                topLvl.put("coins_spent", 0);

                userString = topLvl.toString();
            } catch (JSONException e) {
                e.printStackTrace();
            }

            Log.d("QRZY", userString);

            //write object back to json

            FileWriter fileWriter = null;
            try {
                fileWriter = new FileWriter(file);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                bufferedWriter.write(userString);
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public JSONObject retrieveTopLevel() {
        File file = new File(context.getFilesDir(),"storage.json"); //get existing file
        StringBuilder stringBuilder = new StringBuilder();

        try { //parse file
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();
            while (line != null){
                stringBuilder.append(line).append("\n");
                line = bufferedReader.readLine();
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // This response will have Json Format String
        String objString = stringBuilder.toString();
        try {
            JSONObject topLvl = new JSONObject(objString);
            return topLvl;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void sendTopLevel(JSONObject topLvl) {
        String userString = topLvl.toString();

        //write object back to json
        File file = new File(context.getFilesDir(),"storage.json");
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(userString);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendFocusItem(int timesTillCorrect, int secondsSpentOnQuestion, String focusID) {
        File file = new File(context.getFilesDir(),"storage.json"); //get existing file
        StringBuilder stringBuilder = new StringBuilder();

        try { //parse file
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();
            while (line != null){
                stringBuilder.append(line).append("\n");
                line = bufferedReader.readLine();
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // This response will have Json Format String
        String objString = stringBuilder.toString();
        JSONObject topLvl;
        String userString = "";

        try { //write to object
            topLvl = new JSONObject(objString);
            JSONArray items = topLvl.getJSONArray("focus_items");
            JSONObject builder = new JSONObject();

            builder.put("student", this.student);
            builder.put("program", this.program);
            builder.put("focus_item", focusID);
            builder.put("correct_on", timesTillCorrect);
            builder.put("time_spent", secondsSpentOnQuestion);

            items.put(builder);
            topLvl.remove("focus_items");
            topLvl.put("focus_items", items);

            userString = topLvl.toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        //write object back to json
        file = new File(context.getFilesDir(),"storage.json");
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(userString);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String readFocusItem(int id) {
        File file = new File(context.getFilesDir(),"storage.json");
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        StringBuilder stringBuilder = new StringBuilder();
        String line = null;
        try {
            line = bufferedReader.readLine();
            while (line != null){
                stringBuilder.append(line).append("\n");
                line = bufferedReader.readLine();
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // This response will have Json Format String
        return stringBuilder.toString();
    }

    public String[] studentLogin(String id) {
        JSONObject studentID = new JSONObject();
        final String[] stuName = new String[1];

        try {
            studentID.put("id", id);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JsonObjectRequest stuLogRequest = new JsonObjectRequest(Request.Method.POST, url + "session/student", studentID, new Response.Listener<JSONObject>() {


            @Override
            public void onResponse(JSONObject response) {
                JSONObject topLvl = retrieveTopLevel();


                try { //write to object
                    stuName[0] = response.getJSONObject("student").get("student_name").toString();
                    Log.d("ABCX", stuName[0].toString());

                    topLvl.remove("student_id");
                    topLvl.put("student_id", id);
                    topLvl.put("student_name", stuName[0]);

                    topLvl.remove("client_token");
                    topLvl.put("client_token", response.get("token"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                sendTopLevel(topLvl);
                Log.d("ABCY", topLvl.toString());
                return;
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        queue.add(stuLogRequest);
        return stuName;
    }

    public void updateCoins(int earned, int current, int spent) { //relative pos/neg values for updating each or all values, leave 0 if no change
        JSONObject topLvl = retrieveTopLevel();
        Log.d("ABCX", topLvl.toString());

        try { //write to object
            int totEarned = topLvl.getInt("coins_earned");
            int totCurrent = topLvl.getInt("coins_current");
            int totSpent = topLvl.getInt("coins_spent");

            totEarned += earned;
            totCurrent += current;
            totSpent += spent;

            topLvl.remove("coins_earned");
            topLvl.remove("coins_current");
            topLvl.remove("coins_spent");

            topLvl.put("coins_earned", totEarned);
            topLvl.put("coins_current", totCurrent);
            topLvl.put("coins_spent", totSpent);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        sendTopLevel(topLvl);
        Log.d("ABCY", topLvl.toString());
    }

    public String getDisplayName() {
        JSONObject topLvl = retrieveTopLevel();
        //Log.d("ABCX", topLvl.toString());
        String display = "";

        try { //write to object
            display = topLvl.get("student_name").toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        Log.d("ABCY", display);
        return display;
    }

}
