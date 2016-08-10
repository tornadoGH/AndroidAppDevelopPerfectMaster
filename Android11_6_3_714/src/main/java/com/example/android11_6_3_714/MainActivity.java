package com.example.android11_6_3_714;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = ( Button )findViewById( R.id.button1 );
        button.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick( View v )
            {
                MyDialogFragment fragment = new MyDialogFragment();
                fragment.show( getFragmentManager(), "my_dialog_fragment");
            }
        });
    }
}
