package com.example.happinesslevelsurvey.ins;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.fragment.app.ListFragment;
import com.example.happinesslevelsurvey.R;

public class LevelFragment extends ListFragment {

    String[] Levels = new String[] { "Level 1","Level 2","Level 3","Level 4" };
    String[] Titles = new String[] {

            "Immediate Gratification",
            "Comparative / Personal Achievement",
            "Contributive",
            "Ultimate Good"

    };

    String[] Descrip = new String[] {

            "\"Pleasure and minimize pain.\"",
            "\"Ego Recentness, better than, gain advantage.\"",
            "\"Do good beyond self, Make an optimal positive difference for others.\"",
            "\"Participate in giving and receiving ultimate meaning, goodness, ideals and love.\""

    };

    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState ) {

        View view = inflater.inflate( R.layout.levels_fragment, container, false );
        ArrayAdapter<String> adapter = new ArrayAdapter<String>( requireActivity(), android.R.layout.simple_list_item_1, Levels );
        setListAdapter( adapter );

        return view;

    }
    @Override
    public void onListItemClick( ListView l, View v, int position, long id ) {

        assert getFragmentManager() != null;
        DescriptionFragment txt = ( DescriptionFragment)getFragmentManager().findFragmentById(R.id.fragment2 );
        assert txt != null;
        txt.change( Levels[ position ], Titles[ position ], Descrip[ position ] );
        getListView().setSelector( android.R.color.holo_blue_dark );

    }

}
