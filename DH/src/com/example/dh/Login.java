package com.example.dh;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Login extends Activity implements OnClickListener {

	SharedPreferences sp ;
	EditText username, password ;
	Button login, registration;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.aivity_login); 
	
		
		username = (EditText)findViewById(R.id.editTextUserNameLogIn);
		login = (Button)findViewById(R.id.buttonLogin);
		registration = (Button)findViewById(R.id.buttonRegister);
		password = (EditText)findViewById(R.id.editTextPasswordLogin);
		sp = PreferenceManager.getDefaultSharedPreferences(Login.this);
		
		
		login.setOnClickListener(this);
		registration.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.buttonLogin:
			if(username.getText().toString().equalsIgnoreCase(sp.getString("user_name_login", "oiuntvcexcdvubexa"))  && password.getText().toString().equalsIgnoreCase(sp.getString("password_login", "oiuntvcexcdvubexa")))
			{
				Intent i = new Intent(Login.this, MainActivity.class);
				startActivity(i);
				overridePendingTransition(R.anim.side_down, R.anim.slide_up);
			}
			else
			{
				username.setError("Enter valid details");
				password.setError("Enter valid details");
			}
			break;

			case R.id.buttonRegister :
				Intent i = new Intent(Login.this, Registration.class);
				startActivity(i);
				overridePendingTransition(R.anim.side_down, R.anim.slide_up);
				break;
		default:
			break;
		}
	}

}
