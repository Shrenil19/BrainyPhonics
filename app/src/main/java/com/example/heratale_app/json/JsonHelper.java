package com.example.heratale_app.json;

import android.content.Context;
import android.util.Log;

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

    public JsonHelper(String stu, Context conte) {
        this.program = "5c047ec0aa4bc8db2980b139";
        this.student = stu;
        this.context = conte;
    }

    public void initJson(String stuID) {
        File file = new File(context.getFilesDir(),"storage.json");
        if(!file.exists()) {


            JSONObject topLvl;
            String userString = "";

            try { //write to object
                topLvl = new JSONObject();
                topLvl.put("focus_items", new JSONArray());

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
        // This responce will have Json Format String
        return stringBuilder.toString();
    }

}
