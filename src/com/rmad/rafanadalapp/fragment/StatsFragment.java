package com.rmad.rafanadalapp.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rmad.rafanadalapp.R;

public class StatsFragment extends Fragment{

	public StatsFragment(){
		
	}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
  
        View rootView = inflater.inflate(R.layout.fragment_stats, container, false);
          
        return rootView;
    }
}
