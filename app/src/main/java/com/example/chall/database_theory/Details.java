package com.example.chall.database_theory;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.alespero.expandablecardview.ExpandableCardView;
import com.alespero.expandablecardview.ExpandableCardView.OnExpandedListener;

import java.util.Set;

public class Details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ExpandableCardView card = findViewById(R.id.closure);
        ExpandableCardView card2 = findViewById(R.id.minimal_basis);
        ExpandableCardView card3 = findViewById(R.id.keys);
        ExpandableCardView card4 = findViewById(R.id.violate_3NF);
        ExpandableCardView card5 = findViewById(R.id.violate_BCNF);
        ExpandableCardView card6 = findViewById(R.id.decompose_BCNF);
        ExpandableCardView card7 = findViewById(R.id.decompose_3NF);
        String s = getIntent().getStringExtra("details");
        int split = s.indexOf('#');
        final Set<Attribute> attrs = Attribute.getSet(s.substring(0,split));
        final Set<FuncDep> fds = FuncDep.getSet(s.substring(split+1,s.length()));


        card.setOnExpandedListener(new OnExpandedListener() {
            @Override
            public void onExpandChanged(View v, boolean isExpanded) {
                TextView tv = findViewById(R.id.detail);
                tv.setText(Algos.closure(attrs,fds).toString());
            }
        });

        card2.setOnExpandedListener(new OnExpandedListener() {
            @Override
            public void onExpandChanged(View v, boolean isExpanded) {
                TextView tv = findViewById(R.id.detail);
                tv.setText(Algos.minimalBasis(fds).toString());
            }
        });
        card3.setOnExpandedListener(new OnExpandedListener() {
            @Override
            public void onExpandChanged(View v, boolean isExpanded) {
                TextView tv = findViewById(R.id.detail);
                tv.setText(Algos.keys(attrs,fds).toString());
                Toast.makeText(getApplicationContext(),Algos.keys(attrs,fds).toString(),Toast.LENGTH_LONG).show();
            }
        });
        card4.setOnExpandedListener(new OnExpandedListener() {
            @Override
            public void onExpandChanged(View v, boolean isExpanded) {
                TextView tv = findViewById(R.id.detail);
                tv.setText(Algos.check3NF(attrs,fds).toString());
            }
        });
        card5.setOnExpandedListener(new OnExpandedListener() {
            @Override
            public void onExpandChanged(View v, boolean isExpanded) {
                TextView tv = findViewById(R.id.detail);
                tv.setText(Algos.checkBCNF(attrs,fds).toString());
            }
        });
        card6.setOnExpandedListener(new OnExpandedListener() {
            @Override
            public void onExpandChanged(View v, boolean isExpanded) {
                TextView tv = findViewById(R.id.detail);
                Relation rel = new Relation(attrs, fds);
                Set<Relation> relsIn3NF = rel.decomposeTo3NF();
                tv.setText(relsIn3NF.toString());
            }
        });
        card7.setOnExpandedListener(new OnExpandedListener() {
            @Override
            public void onExpandChanged(View v, boolean isExpanded) {
                TextView tv = findViewById(R.id.detail);
                Relation rel = new Relation(attrs, fds);
                Set<Relation> relsInBCNF = rel.decomposeToBCNF();
                tv.setText(relsInBCNF.toString());
            }
        });
    }
}
