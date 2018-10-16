package com.snehith.chall.database_theory;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.snehith.chall.database_theory.utils.Tools;
import com.snehith.chall.database_theory.utils.ViewAnimation;

import java.util.Set;

public class Details extends AppCompatActivity {

    private ImageButton togleClosure,togleMinimal,togleKeys,togleCheck3NF,togleCheckBcnf,togleDecompBCNF,togleDecomp3NF;
    private View lytClosure,lytMinimal,lytKeys,lytCheck3Nf,lytCheckBcnf, lytDecompBcnf, lytDecomp3Nf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expansion_panel_basic);
        initComponent();
    }



    private void initComponent() {
        Button hideClosure, hideMinimal,hideKeys, hideCheck3Nf, hideCheckBcnf, hideDecompBcnf, hideDecomp3Nf;
        String s = getIntent().getStringExtra("details");
        int split = s.indexOf('#');
        final Set<Attribute> attrs = Attribute.getSet(s.substring(0,split));
        final Set<FuncDep> fds = FuncDep.getSet(s.substring(split+1,s.length()));

        TextView tv = findViewById(R.id.detail_closure);
        tv.setText(Algos.closure(attrs,fds).toString());
        tv.append("\n \n");
        tv.append("Given is the closure of attributes with respect to the given functional dependencies");

        TextView tv1 = findViewById(R.id.detail_minimal_basis);
        tv1.setText(Algos.minimalBasis(fds).toString());
        tv1.append("\n \n");
        tv1.append("Given is minimal basis of the functional dependencies");


        TextView tv2 = findViewById(R.id.detail_keys);
        tv2.setText(Algos.keys(attrs,fds).toString());
        tv2.append("\n \n");
        tv2.append("Given are the attributes that form keys for the relation");


        TextView tv3 = findViewById(R.id.detail_check_3NF);
        tv3.setText(Algos.check3NF(attrs,fds).toString());


        TextView tv4 = findViewById(R.id.detail_check_BCNF);
        tv4.setText(Algos.checkBCNF(attrs,fds).toString());


        TextView tv5 = findViewById(R.id.detail_decomp_BCNF);
        Relation rel = new Relation(attrs, fds);
        Set<Relation> relsInBCNF = rel.decomposeToBCNF();
        tv5.setText(relsInBCNF.toString());
        tv5.append("\n \n");
        tv5.append("Output format:\n \nFirst, sub attributes are given and then FDs follow from them are given. This happens until all the FDs are in BCNF");


        TextView tv6 = findViewById(R.id.detail_decomp_3NF);
        Set<Relation> relsIn3NF = rel.decomposeTo3NF();
        tv6.setText(relsIn3NF.toString());
        tv6.append("\n \n");
        tv6.append("Output format:\n \nFirst, sub attributes are given and then FDs follow from them are given. This happens until all the FDs are in 3NF");


        // text section
        togleClosure =  findViewById(R.id.bt_toggle_text_closure);
        hideClosure =  findViewById(R.id.bt_hide_text_closure);
        lytClosure =  findViewById(R.id.lyt_expand_text_closure);
        lytClosure.setVisibility(View.GONE);

        togleClosure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleSectionText(togleClosure,lytClosure);
            }
        });

        hideClosure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleSectionText(togleClosure,lytClosure);
            }
        });

        togleKeys =  findViewById(R.id.bt_toggle_text_keys);
        hideKeys =  findViewById(R.id.bt_hide_text_keys);
        lytKeys =  findViewById(R.id.lyt_expand_text_keys);
        lytKeys.setVisibility(View.GONE);

        togleKeys.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleSectionText(togleKeys,lytKeys);
            }
        });

        hideKeys.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleSectionText(togleKeys,lytKeys);
            }
        });



        togleMinimal = (ImageButton) findViewById(R.id.bt_toggle_text_minimal_basis);
        hideMinimal = (Button) findViewById(R.id.bt_hide_text_minimal_basis);
        lytMinimal = (View) findViewById(R.id.lyt_expand_text_minimal_basis);
        lytMinimal.setVisibility(View.GONE);

        togleMinimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleSectionText(togleMinimal,lytMinimal);
            }
        });

        hideMinimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleSectionText(togleMinimal,lytMinimal);
            }
        });


        togleCheck3NF = (ImageButton) findViewById(R.id.bt_toggle_text_check_3NF);
        hideCheck3Nf = (Button) findViewById(R.id.bt_hide_text_check_3NF);
        lytCheck3Nf = (View) findViewById(R.id.lyt_expand_text_check_3NF);
        lytCheck3Nf.setVisibility(View.GONE);

        togleCheck3NF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleSectionText(togleCheck3NF,lytCheck3Nf);
            }
        });

        hideCheck3Nf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleSectionText(togleCheck3NF,lytCheck3Nf);
            }
        });


        togleCheckBcnf = (ImageButton) findViewById(R.id.bt_toggle_text_check_BCNF);
        hideCheckBcnf = (Button) findViewById(R.id.bt_hide_text_check_BCNF);
        lytCheckBcnf = (View) findViewById(R.id.lyt_expand_text_check_BCNF);
        lytCheckBcnf.setVisibility(View.GONE);

        togleCheckBcnf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleSectionText(togleCheckBcnf,lytCheckBcnf);
            }
        });

        hideCheckBcnf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleSectionText(togleCheckBcnf,lytCheckBcnf);
            }
        });


        togleDecomp3NF = (ImageButton) findViewById(R.id.bt_toggle_text_decomp_3NF);
        hideDecomp3Nf = (Button) findViewById(R.id.bt_hide_text_decomp_3NF);
        lytDecomp3Nf = (View) findViewById(R.id.lyt_expand_text_decomp_3NF);
        lytDecomp3Nf.setVisibility(View.GONE);

        hideDecomp3Nf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleSectionText(togleDecomp3NF,lytDecomp3Nf);
            }
        });

        togleDecomp3NF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleSectionText(togleDecomp3NF,lytDecomp3Nf);
            }
        });

        togleDecompBCNF = (ImageButton) findViewById(R.id.bt_toggle_text_decomp_BCNF);
        hideDecompBcnf = (Button) findViewById(R.id.bt_hide_text_decomp_BCNF);
        lytDecompBcnf = (View) findViewById(R.id.lyt_expand_text_decomp_BCNF);
        lytDecompBcnf.setVisibility(View.GONE);

        hideDecompBcnf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleSectionText(togleDecompBCNF,lytDecompBcnf);
            }
        });

        togleDecompBCNF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleSectionText(togleDecompBCNF,lytDecompBcnf);
            }
        });

    }

    private void toggleSectionText(View view, final View v1) {
        boolean show = toggleArrow(view);
        if (show) {
            ViewAnimation.expand(v1, new ViewAnimation.AnimListener() {
                @Override
                public void onFinish() {
//                    Tools.nestedScrollTo(nested_scroll_view, v1);
                }
            });
        } else {
            ViewAnimation.collapse(v1);
        }
    }


    public boolean toggleArrow(View view) {
        if (view.getRotation() == 0) {
            view.animate().setDuration(200).rotation(180);
            return true;
        } else {
            view.animate().setDuration(200).rotation(0);
            return false;
        }
    }
}