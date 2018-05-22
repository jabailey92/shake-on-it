package com.example.jackn.shake_on_it;

import android.content.Context;
import android.content.Intent;
import android.gesture.Gesture;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;


public class history extends AppCompatActivity implements GestureDetector.OnGestureListener {
    GestureDetector gestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        String line = ReadFile(this);
        updatePageWithInfo(getLine(line, 0));
        Toast t = Toast.makeText(this, getLine(line, 0), Toast.LENGTH_LONG);
        t.show();

        gestureDetector = new GestureDetector(history.this, history.this);
    }

    @Override
    public boolean onFling(MotionEvent motionEvent1, MotionEvent motionEvent2, float x, float y){
        if(motionEvent1.getY() - motionEvent2.getY() > 50){
            Toast.makeText(history.this, "Swiped up", Toast.LENGTH_LONG).show();
            return true;
        }
        return false;
    }

    @Override
    public void onShowPress(MotionEvent motionEvent1){
        // TO DO
    }

    @Override
    public void onLongPress(MotionEvent motionEvent1){
        // TO DO
    }

    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent1){
        // TO DO
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent motionEven1, MotionEvent m2, float f1, float f2){
        // To Do
        return false;
    }

    public boolean onDown(MotionEvent motionEvent1){
        // TO DO
        return false;
    }

    final static String fileName = "data.txt";
    final static String path = Environment.getExternalStorageDirectory() + "/files/";
    final static String TAG = "WHOREALLYCARES";

    public static String ReadFile(Context context) {
        String line = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(path + fileName));
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuilder stringBuilder = new StringBuilder();

            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line + System.getProperty("line.separator"));
            }
            fileInputStream.close();
            line = stringBuilder.toString();

            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            Log.d(TAG, ex.getMessage());
        } catch (IOException ex) {
            Log.d(TAG, ex.getMessage());
        }
        return line;
    }

    public String getLine(String data, int num){
        String[] split = data.split("\n");
        String line = split[num];
        return line;
    }

    public void updatePageWithInfo(String betInfo){
        TextView p1 = findViewById(R.id.Player1_h);
        TextView p2 = findViewById(R.id.Player2_h);
        TextView stakes = findViewById(R.id.Stakes_h);
        betInfo = betInfo.replace("{", " ");
        betInfo = betInfo.replace("}", " ");
        String[] splitInfo = betInfo.split(",");
        p1.setText(splitInfo[0]);
        p2.setText(splitInfo[1]);
        stakes.setText(splitInfo[2]);
    }
}
