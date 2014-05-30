package com.example.dh;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

@SuppressLint("NewApi")
public class Disease_Diagnosed extends Fragment {


	
	String addedDisease;
	ListView DiseaseList;
	// Defined Array values to show in ListView
	String[] values ;
	ArrayList<String> arrayListDisease ;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setHasOptionsMenu(true);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View v = inflater.inflate(R.layout.activity_patients_disease_diagnosed, null);
		DiseaseList = (ListView)v.findViewById(R.id.listViewDisease);
		arrayListDisease = new ArrayList<String>();
		//			// enable ActionBar app icon to behave as action to toggle nav drawer
		//			getActionBar().setDisplayHomeAsUpEnabled(true);
		//			getActionBar().setHomeButtonEnabled(true);

		return v;
	}

	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		setHasOptionsMenu(true);
	    inflater.inflate(R.menu.menu_add_disease_diagnosed, menu);
	    super.onCreateOptionsMenu(menu,inflater);
	}

	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub

		switch (item.getItemId()) {
		case R.id.add_disease_diagnosed_menu:
			final Dialog dialog = new Dialog(getView().getContext());
			dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);

			dialog.setContentView(R.layout.activity_add_symptoms);
			Button add = (Button)dialog.findViewById(R.id.buttonAddPopUp);
			final EditText symptomEdit = (EditText)dialog.findViewById(R.id.editTextAddPopUp);
			TextView textLabel = (TextView)dialog.findViewById(R.id.textViewAddPopUp);
			textLabel.setText("Add Disease Diagnosed");
			
			dialog.show();

			add.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					addedDisease = symptomEdit.getText().toString();
					arrayListDisease.add(addedDisease);
					dialog.dismiss();
					if(arrayListDisease!=null)
					{
						String[] stockArr = new String[arrayListDisease.size()];
						stockArr = arrayListDisease.toArray(stockArr);

						ArrayAdapter<String> adapter = new ArrayAdapter<String>(getView().getContext(),
								android.R.layout.simple_list_item_1, android.R.id.text1, stockArr);
						DiseaseList.setAdapter(adapter);
					}
				}
			});
			break;

		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}
	

}