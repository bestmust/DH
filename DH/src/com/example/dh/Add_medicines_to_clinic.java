package com.example.dh;


import java.util.ArrayList;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.app.Fragment;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

@SuppressLint("NewApi")
public class Add_medicines_to_clinic extends Fragment {

	String addedMedicines;
	ListView MedicinesList;
	// Defined Array values to show in ListView
	String[] values ;
	ArrayList<String> arrayListMedicines ;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setHasOptionsMenu(true);
	}
	
	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
	    inflater.inflate(R.menu.add_medicines_to_clinic, menu);
	    super.onCreateOptionsMenu(menu,inflater);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View v = inflater.inflate(R.layout.activity_add_medicines_to_clinic, null);
		MedicinesList = (ListView)v.findViewById(R.id.listViewAddMedicinesToClinic);
		arrayListMedicines = new ArrayList<String>();

		return v;
	}


	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	   // handle item selection
	   switch (item.getItemId()) {
		case R.id.add_add_medicines_to_clinic_menu :
		final Dialog dialog = new Dialog(getView().getContext());
		dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);

		dialog.setContentView(R.layout.activity_add_symptoms);
		Button add = (Button)dialog.findViewById(R.id.buttonAddPopUp);
		final EditText symptomEdit = (EditText)dialog.findViewById(R.id.editTextAddPopUp);
		TextView textLabel = (TextView)dialog.findViewById(R.id.textViewAddPopUp);
		textLabel.setText("Add Medicines to clinic");
		
		dialog.show();

		add.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				addedMedicines = symptomEdit.getText().toString();
				arrayListMedicines.add(addedMedicines);
				dialog.dismiss();
				if(arrayListMedicines!=null)
				{
					String[] stockArr = new String[arrayListMedicines.size()];
					stockArr = arrayListMedicines.toArray(stockArr);

					ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity().getBaseContext(),
							android.R.layout.simple_list_item_1, android.R.id.text1, stockArr);
				MedicinesList.setAdapter(adapter);
				}
			}
		});
	         return true;
	      default:
	         return super.onOptionsItemSelected(item);
	   }
	}

}
