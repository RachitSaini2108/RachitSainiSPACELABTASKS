package com.example.spacelabtasks;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> taskList;
    private ArrayAdapter<String> taskAdapter;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.taskList);

        taskList = new ArrayList<>();
        taskAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, taskList);
        listView.setAdapter(taskAdapter);
        checkListVIew();
        
    }

    private void checkListVIew() {
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "Task Deleted!", Toast.LENGTH_LONG).show();
                taskList.remove(position);
                taskAdapter.notifyDataSetChanged();
                return true;
            }
        });
    }

    public void addTaskToList(View view)
    {
        EditText input = findViewById(R.id.textAdd);
        String Task  = input.getText().toString();
        if(!(Task.equals("")))
        {
            taskAdapter.add(Task);
            input.setText("");
        }
        else {
            Toast.makeText(getApplicationContext(), "NO Task added!", Toast.LENGTH_LONG).show();
        }
    }

}