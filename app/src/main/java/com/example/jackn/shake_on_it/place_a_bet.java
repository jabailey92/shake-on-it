package com.example.jackn.shake_on_it;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class place_a_bet extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_a_bet);
    }

    public void clear(View view)
    {
        EditText p1 = (EditText)findViewById(R.id.Player1);
        p1.setText("");
        EditText p2 = (EditText)findViewById(R.id.Player2);
        p2.setText("");
        EditText c = (EditText)findViewById(R.id.Commissioner);
        c.setText("");
        EditText s = (EditText)findViewById(R.id.Stakes);
        s.setText("");
    }
}
