package com.rmad.rafanadalapp.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rmad.rafanadalapp.R;

public class TriviaFragment extends Fragment{

	public TriviaFragment(){
		
	}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
  
        View rootView = inflater.inflate(R.layout.fragment_trivia, container, false);
          
        return rootView;
    }
}
