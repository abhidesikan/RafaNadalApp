package com.rmad.rafanadalapp.fragment;

import com.rmad.rafanadalapp.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class LiveScoreFragment extends Fragment{

	public LiveScoreFragment(){
		
	}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
  
        View rootView = inflater.inflate(R.layout.fragment_live_score, container, false);
          
        return rootView;
    }
	
}
