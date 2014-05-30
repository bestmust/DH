package com.example.dh;

import com.example.asyctask.LoginTask;
import com.example.datamodels.LoginModel;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.KeyEvent;
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
			
			if(username.getText().toString().equalsIgnoreCase("")){
				ErrorDialog.ErrorDialogCreation(Login.this,"Warning", "Please Enter UserName");
			}else if(password.getText().toString().equalsIgnoreCase("")){
				ErrorDialog.ErrorDialogCreation(Login.this,"Warning", "Please Enter Password");
			}else{
				
				LoginModel objLoginModel = new LoginModel();
				objLoginModel.setUserName(username.getText().toString());
				objLoginModel.setPassword(password.getText().toString());
				new LoginTask(Login.this).execute(objLoginModel);
				
			}
			
			
			/*if(username.getText().toString().equalsIgnoreCase(sp.getString("user_name_login", "oiuntvcexcdvubexa"))  && password.getText().toString().equalsIgnoreCase(sp.getString("password_login", "oiuntvcexcdvubexa")))
			{
				Intent i = new Intent(Login.this, MainActivity.class);
				startActivity(i);
				overridePendingTransition(R.anim.side_down, R.anim.slide_up);
			}
			else
			{
				username.setError("Enter valid details");
				password.setError("Enter valid details");
			}*/
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
	

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {

		if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) { 
			// do something on back.
			Intent startMain = new Intent(Intent.ACTION_MAIN); 
			startMain.addCategory(Intent.CATEGORY_HOME); 
			startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			startActivity(startMain); 
			return true; 
		}
		return super.onKeyDown(keyCode, event);
	}

}
