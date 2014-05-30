package com.example.dh;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.app.Fragment;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

@SuppressLint("NewApi")
public class Tests extends Fragment {


	
	String addedTest;
	ListView TestList;
	// Defined Array values to show in ListView
	String[] values ;
	ArrayList<String> arrayListTest ;
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setHasOptionsMenu(true);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View v = inflater.inflate(R.layout.activity_patients_tests, null);
		TestList = (ListView)v.findViewById(R.id.listViewTests);
		arrayListTest = new ArrayList<String>();

		//			// enable ActionBar app icon to behave as action to toggle nav drawer
		//			getActionBar().setDisplayHomeAsUpEnabled(true);
		//			getActionBar().setHomeButtonEnabled(true);


		return v;
	}

	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		setHasOptionsMenu(true);
	    inflater.inflate(R.menu.menu_add_tests, menu);
	    super.onCreateOptionsMenu(menu,inflater);
	}
	
	
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub


		switch (item.getItemId()) {
		case R.id.add_tests_menu:
			final Dialog dialog = new Dialog(getView().getContext());
			dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);

			dialog.setContentView(R.layout.activity_add_symptoms);
			Button add = (Button)dialog.findViewById(R.id.buttonAddPopUp);
			final EditText symptomEdit = (EditText)dialog.findViewById(R.id.editTextAddPopUp);
			TextView textLabel = (TextView)dialog.findViewById(R.id.textViewAddPopUp);
			textLabel.setText("Add Tests");
			dialog.show();

			add.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					addedTest = symptomEdit.getText().toString();
					arrayListTest.add(addedTest);
					dialog.dismiss();
					if(arrayListTest!=null)
					{
						String[] stockArr = new String[arrayListTest.size()];
						stockArr = arrayListTest.toArray(stockArr);

						ArrayAdapter<String> adapter = new ArrayAdapter<String>(getView().getContext(),
								android.R.layout.simple_list_item_1, android.R.id.text1, stockArr);
						TestList.setAdapter(adapter);
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