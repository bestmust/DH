package com.example.patient;

import com.example.asyncTask.ForgotPasswordTassk;
import com.example.asyncTask.LoginTask;
import com.example.asyncTask.RegisterTask;
import com.example.dataModel.LoginModel;
import com.example.dataModel.RegisterModel;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

public class Login extends Activity implements OnClickListener {

	EditText mUsername, mPassword,mFirstName,mLastName,mEmailId,mAddress,mContactNo,mpass,muser,mEmailForgot;
	TextView textViewCreateAccount,textViewforgot;
	Button mLogin, mRegister,mLoginRegister,mforgot;
	ImageButton buttonSearch;
	FrameLayout framelLayoutlogin,framelLayoutregister,framLayoutForgot;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.copy_activity_login);

		init();

		textViewCreateAccount.setOnClickListener(this);
		mLoginRegister.setOnClickListener(this);
		mLogin.setOnClickListener(this);
		mRegister.setOnClickListener(this);
		textViewforgot.setOnClickListener(this);
		mforgot.setOnClickListener(this);
	}

	private void init() {

		mUsername = (EditText)findViewById(R.id.editTextUsernameLogin);
		mPassword = (EditText)findViewById(R.id.editTextPasswordLogin);
		mLogin = (Button)findViewById(R.id.buttonLoginLogin);
		textViewCreateAccount = (TextView)findViewById(R.id.textViewCreate);
		framelLayoutlogin = (FrameLayout)findViewById(R.id.frameLayoutLogin);
		framelLayoutregister=(FrameLayout)findViewById(R.id.frameLayoutRegister); 
		mRegister = (Button)findViewById(R.id.buttonRegister);
		mLoginRegister = (Button)findViewById(R.id.buttonLogin);

		mFirstName = (EditText)findViewById(R.id.editTextFirstName);
		mLastName = (EditText)findViewById(R.id.editTextLastName);
		mEmailId = (EditText)findViewById(R.id.editTextEmailId);
		mContactNo = (EditText)findViewById(R.id.editTextContactNo);
		mAddress = (EditText)findViewById(R.id.editTextAddress);
		mpass = (EditText)findViewById(R.id.editTextPassword);
		muser = (EditText)findViewById(R.id.editTextUserName);
		textViewforgot = (TextView)findViewById(R.id.textViewforgot);
		framLayoutForgot = (FrameLayout)findViewById(R.id.frameLayoutForgot);
		mforgot = (Button)findViewById(R.id.buttonForgot);
		mEmailForgot = (EditText)findViewById(R.id.editTextEmailForgot);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId())
		{
		case R.id.buttonLoginLogin:

			/*
			 * On Click of login button send parameters to LoginDTO model 
			 * And send these parameters to repective webservice to do proecssing and
			 * in onPostExecute of task do what ever operation you want to do
			 */

			/*	if(mUsername.getText().toString().equalsIgnoreCase("") || mPassword.getText().toString().equalsIgnoreCase("")){
					showdialog();
			}*/

			LoginModel logiinModel = new LoginModel();
			logiinModel.setmPassword(mPassword.getText().toString());
			logiinModel.setmUsername(mUsername.getText().toString());

			new LoginTask(Login.this).execute(logiinModel);

			Intent intent = new Intent(Login.this,HomePage.class);
			startActivity(intent);

			break;

		case R.id.textViewCreate:

			framelLayoutlogin.setVisibility(View.GONE);
			framelLayoutregister.setVisibility(View.VISIBLE);

			break;
		case R.id.buttonLogin:

			framelLayoutregister.setVisibility(View.GONE);
			framelLayoutlogin.setVisibility(View.VISIBLE);

			break;

		case R.id.buttonRegister:
			/*
			 * On Click of Register button send parameters to RegisterModel 
			 * And send these parameters to repective webservice to do proecssing and
			 * in onPostExecute of task do what ever operation you want to do
			 */

			if(mFirstName.getText().toString().equalsIgnoreCase("")){
				showdialog();
			}else if(mLastName.getText().toString().equalsIgnoreCase("")){
				showdialog();

			}else if(mEmailId.getText().toString().equalsIgnoreCase("")){
				showdialog();

			}else if(mpass.getText().toString().equalsIgnoreCase("")){
				showdialog();

			}else if(mContactNo.getText().toString().equalsIgnoreCase("")){
				showdialog();

			}else if(mAddress.getText().toString().equalsIgnoreCase("")){
				showdialog();

			}else if(muser.getText().toString().equalsIgnoreCase("")){
				showdialog();

			}else{

				RegisterModel objRegisterModel  =new RegisterModel();
				objRegisterModel.setFirstName(mFirstName.getText().toString());
				objRegisterModel.setLastName(mLastName.getText().toString());
				objRegisterModel.setEmailId(mEmailId.getText().toString());
				objRegisterModel.setPassword(mpass.getText().toString());
				objRegisterModel.setContactNo(mContactNo.getText().toString());
				objRegisterModel.setAddress(mAddress.getText().toString());
				objRegisterModel.setUserName(muser.getText().toString());

				new RegisterTask(Login.this).execute(objRegisterModel);
			}
			break;	

		case R.id.textViewforgot:

			framelLayoutlogin.setVisibility(View.GONE);
			framLayoutForgot.setVisibility(View.VISIBLE);
			break;

		case R.id.buttonForgot:

			/*
			 * For forgot password send useremail  to LoginModel 
			 * And send these parameters to repective webservice to do proecssing and
			 * in onPostExecute of task do what ever operation you want to do
			 */

			LoginModel objLoginModel = new LoginModel();
			objLoginModel.setmUsername(mEmailForgot.getText().toString());

			new ForgotPasswordTassk(Login.this).execute(objLoginModel);

			//-------------manipulate these lines when password send Successfully-----------
			framLayoutForgot.setVisibility(View.GONE);
			framelLayoutlogin.setVisibility(View.VISIBLE);

			break;
		}
	}

	private void showdialog() {

		AlertDialog alertDialog = new AlertDialog.Builder(
				Login.this).create();

		// Setting Dialog Title
		alertDialog.setTitle("Warning");

		// Setting Dialog Message
		alertDialog.setMessage("Please enter all the information");


		// Setting OK Button
		alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				// Write your code here to execute after dialog closed
			}
		});
		alertDialog.show();
	}

}
