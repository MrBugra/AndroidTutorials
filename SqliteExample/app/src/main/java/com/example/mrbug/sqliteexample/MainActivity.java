package com.example.mrbug.sqliteexample;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mrbug.sqliteexample.entities.user;
import com.example.mrbug.sqliteexample.sqlite.sqlitedataaccess;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText textName;
    EditText textSurname;
    Button buttonAdd;
    Button buttonList;
    ListView userListView;
    final Context ctx = this;
    sqlitedataaccess mysqlite;
    List<user> users = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textName= (EditText) findViewById(R.id.txtName);
        textSurname= (EditText) findViewById(R.id.txtSurname);
        buttonAdd= (Button)findViewById(R.id.btnAdd);
        buttonList= (Button)findViewById(R.id.btnList);
        userListView=(ListView) findViewById(R.id.mylistview);

      mysqlite = new sqlitedataaccess(getApplicationContext(),1);

        userListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {

                final user selectedUser =  users.get(position);

                new AlertDialog.Builder(ctx).setTitle("Uyarı")
                .setMessage("id si "+selectedUser.getId()+" olan \n"+selectedUser.toString()+"\n silinsin mi ?")
                .setIcon(R.drawable.ic_launcher_background)
                .setPositiveButton("sil gitsin", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {



                        mysqlite.open();
                        mysqlite.deleteuser(selectedUser);
                        mysqlite.close();
                        ListClick(buttonList);
                        Toast.makeText(getApplicationContext(),"kayıt silindi",Toast.LENGTH_SHORT).show();




                    }
                })
                .setNegativeButton("vazgeçtim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),"iptal ettin",Toast.LENGTH_SHORT).show();
                    }
                }).show()
                ;

            }
        });





    }


    public void Addclick(View v ){
        user adduser= new user(textName.getText().toString(),textSurname.getText().toString());
    try {
        mysqlite.open();
        mysqlite.createuser(adduser);
        mysqlite.close();

    }
    catch(Exception e ){
        Log.e("hataaa", "exception", e);
    }

    }

    public void ListClick(View v){

        try {
        userListView.setAdapter(null);
        mysqlite.open();
        users=mysqlite.getUserlist();
        mysqlite.getUserlist();
        ArrayAdapter<user> myadapt = new ArrayAdapter<user>(ctx, android.R.layout.simple_list_item_1,users);
        userListView.setAdapter(myadapt);
        }
        catch(Exception e ){
            Log.e("hataalist", "exception", e);
        }

    }

}
