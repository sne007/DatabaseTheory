package com.example.chall.database_theory;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Set;

import static android.widget.Toast.makeText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button a = findViewById(R.id.buttonA);
        final Button b = findViewById(R.id.buttonB);
        final Button c = findViewById(R.id.buttonC);
        final Button d = findViewById(R.id.buttonD);
        final Button e = findViewById(R.id.buttonE);
        final Button f = findViewById(R.id.buttonF);
        final Button semi = findViewById(R.id.buttonSemiColon);
        final Button fd = findViewById(R.id.buttonFd);
        final Button comma = findViewById(R.id.buttonComma);
        final EditText et = findViewById(R.id.relation);
        final EditText et1 = findViewById(R.id.fd);
        View.OnClickListener cl = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button b = (Button)v;
                if(et.hasFocus()){
                    String s = et.getText().toString() + b.getText().toString();
                    et.setText(s);
                    et.setSelection(s.length());
                }
                else if(et1.hasFocus()){
                    String s = et1.getText().toString() + b.getText().toString();
                    et1.setText(s);
                    et1.setSelection(s.length());
                }
            }
        };
        a.setOnClickListener(cl);
        b.setOnClickListener(cl);
        c.setOnClickListener(cl);
        d.setOnClickListener(cl);
        e.setOnClickListener(cl);
        f.setOnClickListener(cl);
        semi.setOnClickListener(cl);
        fd.setOnClickListener(cl);
        comma.setOnClickListener(cl);

    }
}
