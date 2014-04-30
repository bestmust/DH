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
public class Medicines extends Fragment {


	
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
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View v = inflater.inflate(R.layout.medicines, null);
		MedicinesList = (ListView)v.findViewById(R.id.listViewMedicines);
		arrayListMedicines = new ArrayList<String>();

		return v;
	}

	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		setHasOptionsMenu(true);
	    inflater.inflate(R.menu.menu_add_patients_medicines, menu);
	    super.onCreateOptionsMenu(menu,inflater);
	}

	
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub

		switch (item.getItemId()) {
		case R.id.add_patients_medicines_menu:
			final Dialog dialog = new Dialog(getView().getContext());
			dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);

			dialog.setContentView(R.layout.activity_add_symptoms);
			Button add = (Button)dialog.findViewById(R.id.buttonAddPopUp);
			final EditText symptomEdit = (EditText)dialog.findViewById(R.id.editTextAddPopUp);
			TextView textLabel = (TextView)dialog.findViewById(R.id.textViewAddPopUp);
			textLabel.setText("Suggest Medicines");
			
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

						ArrayAdapter<String> adapter = new ArrayAdapter<String>(getView().getContext(),
								android.R.layout.simple_list_item_1, android.R.id.text1, stockArr);
					MedicinesList.setAdapter(adapter);
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
