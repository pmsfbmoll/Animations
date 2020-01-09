package com.example.animations;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class QuizMenuActivity extends QuizActivity {
    private ListView lv;
    private String[] items;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_menu);
        this.lv= (ListView)findViewById(R.id.listView);
        items= getResources().getStringArray(R.array.menuArray);
        ArrayAdapter<String> adapt = new ArrayAdapter<String>(this,R.layout.menu_item, items);
        lv.setAdapter(adapt);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView tv = (TextView) view;
                String s = tv.getText().toString();
                if (s.equals(getResources().getStringArray(R.array.menuArray)[0])) {
                    toast("Let's play!");
                } else if (s.equals(getResources().getStringArray(R.array.menuArray)[1]))
                    toast("View High Scores");
                else if (s.equals(getResources().getStringArray(R.array.menuArray)[2])) {
                    toast("Open Settings");
                } else if (s.equals(getResources().getStringArray(R.array.menuArray)[3])) {
                    toast("Show help");
                }
            }
        });
    }

    public void toast(String mensaje){
        Toast toast = Toast.makeText(this, mensaje,Toast.LENGTH_SHORT);
        toast.show();
    }
}
