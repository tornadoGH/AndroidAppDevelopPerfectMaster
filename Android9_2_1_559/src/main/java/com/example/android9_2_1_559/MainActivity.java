package com.example.android9_2_1_559;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //  タイトルバーにスピナースタイルのプログレスを設定
        requestWindowFeature( Window.FEATURE_INDETERMINATE_PROGRESS );

        setContentView(R.layout.activity_main);

        setProgressBarIndeterminateVisibility( true );


        Button buttonStart = ( Button )findViewById( R.id.buttonStart );
        buttonStart.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //  タイトルバーのプログレス表示を有効にする
                setProgressBarIndeterminateVisibility( true );
            }
        });

        Button buttonStop = ( Button )findViewById( R.id.buttonStop );
        buttonStop.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //  タイトルバーのプログレス表示を無効にする
                setProgressBarIndeterminateVisibility( false );
            }
        });
    }
}
