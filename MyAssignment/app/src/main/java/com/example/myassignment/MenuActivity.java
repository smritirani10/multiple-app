package com.example.myassignment;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.sql.Array;
import java.util.concurrent.Callable;

public class MenuActivity extends ListActivity {

    String act[] = {"SimpleCalculator","MainActivity","TicTacToe","ScientficCalculator"};
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, act);
        setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        try {
            String s = "com.example.myassignment." + act[position];
            Class c = Class.forName(s);
            Intent intent =new Intent(MenuActivity.this, c);
            startActivity(intent);
        }
        catch (Exception e) {
        }
    }
}