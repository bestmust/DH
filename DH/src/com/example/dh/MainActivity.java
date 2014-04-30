package com.example.dh;

import com.example.dh.CountryListFragment.ListFragmentItemClickListener;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Configuration;

@SuppressLint("NewApi")
public class MainActivity extends Activity implements ListFragmentItemClickListener {

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		// enable ActionBar app icon to behave as action to toggle nav drawer
				getActionBar().setDisplayHomeAsUpEnabled(true);
				getActionBar().setHomeButtonEnabled(true);
				
	}

    @Override
    public void onListFragmentItemClick(int position) {
    	
    	int orientation = getResources().getConfiguration().orientation;
    	
    	if(orientation == Configuration.ORIENTATION_LANDSCAPE ){
    		FragmentManager fragmentManager = getFragmentManager();
    		FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
    		Fragment prevFrag = fragmentManager.findFragmentByTag("com.exampe.dh.country.details");
    	
    		if(prevFrag!=null)
    			fragmentTransaction.remove(prevFrag);    		
    		
    		switch (position) {
			case 0:
				// Main Activity
				
				DoctorsProfile dp = new DoctorsProfile();
	    		fragmentTransaction.add(R.id.detail_fragment_container, dp,"com.exampe.dh.country.details");
	    		fragmentTransaction.addToBackStack(null);
	    		fragmentTransaction.commit();
				
				break;
				
			case 1 :
				// Patients Login
				PatientsLogin pl = new PatientsLogin();
				fragmentTransaction.add(R.id.detail_fragment_container, pl,"com.exampe.dh.country.details");
	    		fragmentTransaction.addToBackStack(null);
	    		fragmentTransaction.commit();
				break;
				
			case 2 :
				
				// Add medicines to clinic
				Add_medicines_to_clinic amtc = new Add_medicines_to_clinic();
				fragmentTransaction.add(R.id.detail_fragment_container, amtc,"com.exampe.dh.country.details");
	    		fragmentTransaction.addToBackStack(null);
	    		fragmentTransaction.commit();
				break;
				
			case 3 :
				// Login
				Intent i =new Intent(MainActivity.this, Login.class);
				startActivity(i);
				overridePendingTransition(R.anim.slide_up, R.anim.side_down);
	    		
				break;
			default:
				break;
			}
    		
    		
    		
    	}
    
    }
	

	@Override
	public void onBackPressed() {
		super.onBackPressed();

	}

	
}
