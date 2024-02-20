package com.example.happinesslevelsurvey.ins;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.example.happinesslevelsurvey.R;

public class DescriptionFragment extends Fragment {

    TextView lvl, title, desc;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState ) {

        View view = inflater.inflate( R.layout.desc_fragment, container, false );
        lvl = ( TextView )view.findViewById( R.id.LevelsLabel );
        title = ( TextView )view.findViewById( R.id.TitleLabel );
        desc = ( TextView )view.findViewById( R.id.tvDescription );

        return view;

    }
    public void change( String txt, String txt1, String txt2 ){

        lvl.setText( txt1 );
        title.setText( txt );
        desc.setText( txt2 );

    }

}
