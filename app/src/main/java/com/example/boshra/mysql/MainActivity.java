package com.example.boshra.mysql;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText name;
    EditText age;
    Button Login;
    Button register;
    Button save;
    Button delete;
String username,userage;
    int nametouch=0;
    int agetouch=0;
    backgroundtask obj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = (EditText) findViewById(R.id.name);
        age = (EditText) findViewById(R.id.age);
        Login = (Button) findViewById(R.id.login);
        register = (Button) findViewById(R.id.register);
       save = (Button) findViewById(R.id.Sc);
        delete = (Button) findViewById(R.id.del);

save.setVisibility(View.GONE);
        delete.setVisibility(View.GONE);

        name.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                touchhighlight(name);
                agetouch=0;
                if(nametouch==0) {
                    nametouch++;
                    return true;
                }else{

                    return false;
                }

            }
        });
        age.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                touchhighlight(age);
                nametouch=0;
                if(agetouch==0) {
                    agetouch++;
                    return true;
                }else{

                    return false;
                }

            }
        });

        delete.setOnClickListener(new View.OnClickListener() {//save comes after login
            @Override
            public void onClick(View view) {
                username=name.getText().toString();
                userage=age.getText().toString();
                obj =new backgroundtask(MainActivity.this);
                obj.execute("delete",username,userage,"na");


            }
        });
       save.setOnClickListener(new View.OnClickListener() {//save comes after login
            @Override
            public void onClick(View view) {
               String newusername=name.getText().toString();

                obj =new backgroundtask(MainActivity.this);
                obj.execute("update",username,userage,newusername);


            }
        });

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                save.setVisibility(View.VISIBLE);
                delete.setVisibility(View.VISIBLE);

                username=name.getText().toString();
                userage=age.getText().toString();
                obj =new backgroundtask(MainActivity.this);
                obj.execute("login",username,userage,"na");


            }
        });


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
username=name.getText().toString();
                userage=age.getText().toString();
                obj =new backgroundtask(MainActivity.this);
                obj.execute("register",username,userage,"na","na");

            }
        });
    }




    public void touchhighlight(EditText editText){
                editText.requestFocus();
                editText.selectAll();
                editText.setSelectAllOnFocus(true);

    }
}
