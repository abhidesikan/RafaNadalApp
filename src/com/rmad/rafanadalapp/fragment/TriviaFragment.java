package com.rmad.rafanadalapp.fragment;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Fragment;
import android.database.Cursor;
import android.os.AsyncTask;
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
import com.rmad.rafanadalapp.db.JSONParser;

public class TriviaFragment extends Fragment {

	private MenuItem mRefreshMenuItem;
	Database db;
	JSONParser jsonParser = new JSONParser();
	// url to create new trivia
	private static String url_create_trivia = "http://192.168.0.16/RafaNadalApp_php/create_trivia.php"; // JSON
																										
	// Node names
	private static final String TAG_SUCCESS = "success";

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// fragment has action menu options
		setHasOptionsMenu(true);
		View rootView = inflater.inflate(R.layout.fragment_trivia, container,
				false);
		startAsynctask();
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
	//		displayTrivia();
			return true;
		}
		}
		return super.onOptionsItemSelected(item);
	}

	public void startAsynctask() {
		new CreateTrivia().execute();
	}

	class CreateTrivia extends AsyncTask<String, String, String> {

		List<String> triviaList = new ArrayList<String>();

		@Override
		protected String doInBackground(String... params) {
			// TODO Auto-generated method stub
			Log.i("message", "in here async");

			triviaList.add("Nadal and Mats Wilander are the only two male players in history who have won at least two Grand Slam titles on three different surfaces—hard court, grass, and clay.");
			triviaList.add("By winning the 2014 French Open, Nadal became the only male player to win a single Grand Slam tournament nine times and the first to win at least one Grand Slam tournament for ten consecutive years, breaking the record of eight consecutive years previously shared by Björn Borg, Pete Sampras, and Roger Federer.");
			triviaList.add("Nadal's uncle, Miguel Ángel Nadal, is a retired professional footballer, who played for RCD Mallorca, FC Barcelona, and the Spanish national team.");
			triviaList.add("Nadal holds the record for most consecutive titles at a particular tournament after winning his eighth straight Monte-Carlo Masters in 2012. He has won at least one Masters 1000 and one ATP 500 series tournament for 10 years in a row.");
			triviaList.add("In April 2002, at 15 years and 10 months, the world No. 762 Nadal won his first ATP match, defeating Ramón Delgado, and became the ninth player in the Open Era to do so before the age of 16.");
			triviaList.add("Nadal won five straight French Open singles titles from 2010 to 2014 to become the only player in this event to win five consecutive single titles.");
			triviaList.add("In 2009, Nadal became the first Spaniard to win the Australian Open, and the first male player to simultaneously hold Grand Slams on clay, grass and hardcourt.");
			triviaList.add("Nadal is the first, and only male player to date, to win three consecutive Grand Slam Tournaments on three different surfaces (clay, grass and hardcourt) in the same year (2010);[2] and across both sexes, second only to Steffi Graf's Calendar Year Golden Slam in 1988.");
			triviaList.add("Nadal has appeared in the finals of each Grand Slam event at least 3 times.");
			triviaList.add("In addition to tennis and football, Nadal enjoys golf and also poker. In April 2014 he played the world's number 1 female poker player, Vanessa Selbst, in a poker game in Monaco.");

			for (String s : triviaList) {
				List<NameValuePair> triviaString = new ArrayList<NameValuePair>();
				triviaString.add(new BasicNameValuePair("S_No", ""));
				triviaString.add(new BasicNameValuePair("Trivia_String", s));

				// getting JSON Object
				JSONObject json = jsonParser.makeHttpRequest(url_create_trivia,
						"POST", triviaString);

				// check for success tag
				try {
					int success = json.getInt(TAG_SUCCESS);

					if (success == 1) {
						// successfully created trivia
						System.out.println("Success");
					} else {
						// failed to create trivia
					}
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
			return null;
		}

	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {

		super.onActivityCreated(savedInstanceState);

		// Triva table entries
		// db = new Database(getActivity());
	}

	public void displayTrivia() {
		Cursor allTrivia = db.getTrivia();
		allTrivia.moveToFirst();
		TextView txt = (TextView) getActivity().findViewById(R.id.txtLabel);
		txt.setText(allTrivia.getString(1));
		// Log.println(1, txt.toString(), txt.toString());
	}
}
