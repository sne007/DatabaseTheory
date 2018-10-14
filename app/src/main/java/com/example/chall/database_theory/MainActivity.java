package com.example.chall.database_theory;

import android.content.Context;
import android.content.Intent;
import android.icu.text.IDNA;
import android.icu.text.IDNA.Info;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
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

    private View parent_view;
    String attr,fds;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        parent_view = findViewById(android.R.id.content);

        EditText ett = findViewById(R.id.materialTextFieldRelation);
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
                    attr = et.getText().toString() + b.getText().toString(); ;
                    et.setText(attr);
                    et.setSelection(attr.length());
                }
                else if(et1.hasFocus()){
                    fds = et1.getText().toString() + b.getText().toString();
                    et1.setText(fds);
                    et1.setSelection(fds.length());
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

        Button go = findViewById(R.id.buttonGo);

        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attr = et.getText().toString();
                fds = et1.getText().toString();
                try {
                    final Set<Attribute> attrs = Attribute.getSet(attr);
                    final Set<FuncDep> fdset = FuncDep.getSet(fds);
                    Algos.closure(attrs,fdset);
                    Algos.keys(attrs,fdset);
                    Algos.check3NF(attrs,fdset);
                    Algos.checkBCNF(attrs,fdset);
                    Algos.minimalBasis(fdset);
                    Relation rel = new Relation(attrs, fdset);
                    rel.decomposeToBCNF();
                    rel.decomposeTo3NF();
                    startActivity(new Intent(MainActivity.this, Details.class).putExtra("details",attr + "#" + fds));
                }
                catch (Exception e){
                    Snackbar.make(parent_view, "Recheck the correctness of attributes and FDs", Snackbar.LENGTH_LONG).show();
                }
            }
        });
    }
}
