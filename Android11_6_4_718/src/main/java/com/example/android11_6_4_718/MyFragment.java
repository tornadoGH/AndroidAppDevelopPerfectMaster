package com.example.android11_6_4_718;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

/**
 * Created by kooka on 2016/07/22.
 */
public class MyFragment extends Fragment {

    public enum words {
        number1,
        number2,
        number3,
        number4,
        number5
    };

    @Override
    public void onActivityCreated( Bundle savedInstanceState )
    {
        super.onActivityCreated( savedInstanceState );
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState )
    {
        View v = inflater.inflate( R.layout.fragment_my, container );
        final TextView tv = ( TextView )v.findViewById( R.id.textView1 );
        Button button = ( Button )v.findViewById( R.id.button1 );
        button.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick( View v )
            {
                words result = chooseOne();
                tv.setText( result.toString());
                if( result == words.number1 )
                    Toast.makeText( getActivity(), "1", Toast.LENGTH_SHORT ).show();
                if( result == words.number2 )
                    Toast.makeText( getActivity(), "2", Toast.LENGTH_SHORT ).show();
                if( result == words.number3 )
                    Toast.makeText( getActivity(), "3", Toast.LENGTH_SHORT ).show();
                if( result == words.number4 )
                    Toast.makeText( getActivity(), "4", Toast.LENGTH_SHORT ).show();
                if( result == words.number5 )
                    Toast.makeText( getActivity(), "5", Toast.LENGTH_SHORT ).show();
            }
        });
        return v;
    }

    private words chooseOne()
    {
        Random rnd = new Random();
        int r = rnd.nextInt( 5 );
        words result = words.number1;

        switch( r )
        {
            case 1:
                result = words.number1;
                break;
            case 2:
                result = words.number2;
                break;
            case 3:
                result = words.number3;
                break;
            case 4:
                result = words.number4;
                break;
            case 5:
                result = words.number5;
                break;
        }

        return result;
    }
}
