package com.example.jackn.shake_on_it;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class place_a_bet extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_a_bet);
    }
    public void goToMenu (View view){
        Intent intent = new Intent (place_a_bet.this, home.class);
        startActivity(intent);
    }

    final static String fileName = "data.txt";
    final static String path = Environment.getExternalStorageDirectory() + "/files/" ;
    final static String TAG = "PLACE_A_BET";

    public void placeABet(View view){
        Log.d(TAG, "running");
        EditText p1 = findViewById(R.id.Player1);
        EditText p2 = findViewById(R.id.Player2);
        EditText stakes = findViewById(R.id.Stakes);
        String player1 = p1.getText().toString();
        String player2 = p2.getText().toString();
        String stakes_str = stakes.getText().toString();
        Log.d(TAG, "P1" + player1);
        if((player1.matches("")) || (player2.matches("")) || (stakes_str.matches(""))){
            Toast t = Toast.makeText(this, "Complete the form before placing the bet", Toast.LENGTH_LONG);
            t.show();
        } else {
            saveToFile("{" + player1 + "," + player2 + "," + stakes_str + "}");
        }

        p1.setText("");
        p2.setText("");
        stakes.setText("");
        Toast t2 = Toast.makeText(this, "Bet placed!", Toast.LENGTH_LONG);
        t2.show();

        goToMenu(view);
    }

    public static boolean saveToFile( String data){
        Log.d(TAG, "WE get here");
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd_HHmmss");
        Date d = new Date(System.currentTimeMillis());
        String timestamp = sd.format(d);
        try {
            File folder = new File(path);
            Boolean success = true;
            if(!folder.exists()){
                Log.d(TAG, "Log folder doesnt exist...");
                success = folder.mkdir();
            }else{
                Log.d(TAG, "Folder already exists");
            }

            if(success){
                Log.d(TAG, "Folder created: " + path);
            } else{
                Log.d(TAG, "Folder not created :O");
            }
            File file = new File(path + fileName);
            if (!file.exists()) {
                file.createNewFile();
                Log.d(TAG, "file exists");
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file,true);
            fileOutputStream.write((timestamp + data + System.getProperty("line.separator")).getBytes());

            return true;
        }  catch(FileNotFoundException ex) {
            Log.d(TAG, ex.getMessage());
        }  catch(IOException ex) {
            Log.d(TAG, ex.getMessage());
        }
        return  false;


    }
    public void clear(View view)
    {
        EditText p1 = (EditText)findViewById(R.id.Player1);
        p1.setText("");
        EditText p2 = (EditText)findViewById(R.id.Player2);
        p2.setText("");
        EditText s = (EditText)findViewById(R.id.Stakes);
        s.setText("");
    }
}
