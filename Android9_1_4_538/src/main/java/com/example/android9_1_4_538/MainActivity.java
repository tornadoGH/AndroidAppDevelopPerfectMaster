package com.example.android9_1_4_538;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private CharSequence[] items = {"Green","Blue","Red","Yellow","Purple"};
    private boolean[] checkedItems = { false, false, false, false, false };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = ( Button )findViewById( R.id.button );
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {

                TextView textView = ( TextView )findViewById( R.id.textView );
                textView.setText(
                        "Nothing"
                );

                AlertDialog.Builder dialog = new AlertDialog.Builder( MainActivity.this );
                dialog.setTitle("Pick a color");
                dialog.setMultiChoiceItems( items, checkedItems, new DialogInterface.OnMultiChoiceClickListener()
                {
                    public void onClick( DialogInterface dialog, int which, boolean isChecked )
                    {
                        checkedItems[which] = isChecked;
                    }
                });
                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                    }
                });
                dialog.show();
            }
        });
    }
}
