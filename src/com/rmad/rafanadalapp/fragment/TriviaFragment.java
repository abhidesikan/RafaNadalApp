package com.rmad.rafanadalapp.fragment;

import android.app.Fragment;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rmad.rafanadalapp.R;
import com.rmad.rafanadalapp.db.Database;

public class TriviaFragment extends Fragment {

	private MenuItem mRefreshMenuItem;
	Database db;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// fragment has action menu options
		setHasOptionsMenu(true);
		View rootView = inflater.inflate(R.layout.fragment_trivia, container,
				false);

		return rootView;
	}

	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		// TODO Auto-generated method stub
		super.onCreateOptionsMenu(menu, inflater);
		inflater.inflate(R.menu.main, menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.action_refresh: {
			displayTrivia();
			return true;
		}
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {

		super.onActivityCreated(savedInstanceState);

		// Triva table entries
		db = new Database(getActivity());

		db.addTrivia("Nadal and Mats Wilander are the only two male players in history who have won at least two Grand Slam titles on three different surfaces—hard court, grass, and clay.");
		db.addTrivia("By winning the 2014 French Open, Nadal became the only male player to win a single Grand Slam tournament nine times and the first to win at least one Grand Slam tournament for ten consecutive years, breaking the record of eight consecutive years previously shared by Björn Borg, Pete Sampras, and Roger Federer.");
		db.addTrivia("Nadal's uncle, Miguel Ángel Nadal, is a retired professional footballer, who played for RCD Mallorca, FC Barcelona, and the Spanish national team.");
		db.addTrivia("Nadal holds the record for most consecutive titles at a particular tournament after winning his eighth straight Monte-Carlo Masters in 2012. He has won at least one Masters 1000 and one ATP 500 series tournament for 10 years in a row.");
		db.addTrivia("In April 2002, at 15 years and 10 months, the world No. 762 Nadal won his first ATP match, defeating Ramón Delgado, and became the ninth player in the Open Era to do so before the age of 16.");
		db.addTrivia("Nadal won five straight French Open singles titles from 2010 to 2014 to become the only player in this event to win five consecutive single titles.");
		db.addTrivia("In 2009, Nadal became the first Spaniard to win the Australian Open, and the first male player to simultaneously hold Grand Slams on clay, grass and hardcourt.");
		db.addTrivia("Nadal is the first, and only male player to date, to win three consecutive Grand Slam Tournaments on three different surfaces (clay, grass and hardcourt) in the same year (2010);[2] and across both sexes, second only to Steffi Graf's Calendar Year Golden Slam in 1988.");
		db.addTrivia("Nadal has appeared in the finals of each Grand Slam event at least 3 times.");
		db.addTrivia("In addition to tennis and football, Nadal enjoys golf and also poker. In April 2014 he played the world's number 1 female poker player, Vanessa Selbst, in a poker game in Monaco.");
	}

	public void displayTrivia() {
		Cursor allTrivia = db.getTrivia();
		allTrivia.moveToFirst();
		TextView txt = (TextView) getActivity().findViewById(R.id.txtLabel);
		txt.setText(allTrivia.getString(1));
	//	Log.println(1, txt.toString(), txt.toString());
	}
}
