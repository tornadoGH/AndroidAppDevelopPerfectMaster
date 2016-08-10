package com.example.android11_4_1_692;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private EditText varShowText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //  ViewGroup配置
        LinearLayout varLayout = new LinearLayout( this );
        varLayout.setLayoutParams( new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT ));
        varLayout.setOrientation( LinearLayout.VERTICAL );
        setContentView( varLayout );

        //  TextView配置
        varShowText = new EditText( this );
        varShowText.setText("Please click button!");
        varShowText.setLayoutParams( new ViewGroup.LayoutParams( ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT ));
        varLayout.addView( varShowText );

        //  Button配置
        Button varButton1 = new Button( this );
        varButton1.setText("Button A");
        varButton1.setLayoutParams( new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT ));
        varButton1.setOnClickListener( new View.OnClickListener()
        {
            @Override
            public void onClick( View view )
            {
                varShowText.setText("Button A pushed.");
            }
        });
        varLayout.addView( varButton1 );

        //  Button配置
        Button varButton2 = new Button( this );
        varButton2.setText("Button B");
        varButton2.setLayoutParams( new ViewGroup.LayoutParams( ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT ));
        varButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                varShowText.setText("Button B pushed.");
            }
        });
        varLayout.addView( varButton2 );
    }
}
