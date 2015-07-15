package com.sl.rcie;

import java.util.ArrayList;

import android.app.ActionBar;
import android.app.Fragment;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;


public class CardLayoutFragment extends Fragment {

    private ListView cardsList;

    public CardLayoutFragment() {
        // nop
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_card_layout, container, false);
        ActionBar ab = getActivity().getActionBar();
        ColorDrawable cd = new ColorDrawable(getResources().getColor(R.color.green));
        ab.setBackgroundDrawable(cd);
        //ab.hide();
        ab.setIcon(R.drawable.news);
        ab.setTitle("NewsFeed");
        
        cardsList = (ListView) rootView.findViewById(R.id.cards_list);
        
        setupList();
        return rootView;
    }

    private void setupList() {
        cardsList.setAdapter(createAdapter());
        cardsList.setOnItemClickListener(new ListItemClickListener());
    }

    private CardsAdapter createAdapter() {
        ArrayList<String> items = new ArrayList<String>();
        items.add(0,"Zostel Entrepreneurship");
       // for (int i = 0; i < 10; i++) { //card header
       //     items.add(i, "Heading: " + i);
       // }

        return new CardsAdapter(getActivity(), items, new ListItemButtonClickListener());
    }

    private final class ListItemButtonClickListener implements OnClickListener {
        @Override
        public void onClick(View v) {
          for (int i = cardsList.getFirstVisiblePosition(); i <= cardsList.getLastVisiblePosition(); i++) {
         
            }
        }
    }

    private final class ListItemClickListener implements OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
           
        	Intent i = new Intent(getActivity(), eachnews.class);
        	startActivity(i);
        	
        	//Toast.makeText(getActivity(), "Clicked on List Item " + position, Toast.LENGTH_SHORT).show();
        }
    }
}
