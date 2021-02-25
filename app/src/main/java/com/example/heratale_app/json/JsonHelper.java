package com.example.heratale_app.json;

import android.content.Context;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JsonHelper {
    private String program;
    private String student;
    private Context context;

    public JsonHelper(String stu, Context conte) {
        this.program = "5c047ec0aa4bc8db2980b139";
        this.student = stu;
    }

    public void sendFocusItem(int timesTillCorrect, int secondsSpentOnQuestion, String focusID) {
        JSONObject jsonObject = new JSONObject();

        try {
            jsonObject.put("student", this.student);
            jsonObject.put("program", this.program);
            jsonObject.put("focus_item", focusID);
            jsonObject.put("correct_on", timesTillCorrect);
            jsonObject.put("time_spent", secondsSpentOnQuestion);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        // Convert JsonObject to String Format
        String userString = jsonObject.toString();
        // Define the File Path and its Name
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
