package com.joshuamiddletonfyp.myfitandroidfitnesspackage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.joshuamiddletonfyp.myfitandroidfitnesspackage.DatabaseManagment.ProfileManagment.ProfileDBHelper;
import com.joshuamiddletonfyp.myfitandroidfitnesspackage.DatabaseManagment.ProfileManagment.ProfileDBManager;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Registration extends AppCompatActivity {

    EditText firstName;
    EditText lastName;
    EditText age;
    EditText email;
    EditText username;
    EditText password;
    UserAccount user;
    Button registerButton;
    private Pattern pattern;
    private Matcher matcher;

    private static final String PASSWORD_PATTERN =
            "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{6,20})";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        pattern = Pattern.compile(PASSWORD_PATTERN);
        firstName=(EditText)findViewById(R.id.register_first_name_edit);
        lastName=(EditText)findViewById(R.id.register_last_name_edit);
        age=(EditText)findViewById(R.id.register_agel_edit);
        email=(EditText)findViewById(R.id.register_email_edit);
        password = (EditText)findViewById(R.id.register_password);
        username = (EditText)findViewById(R.id.register_user_edit);
        registerButton = (Button)findViewById(R.id.register_button);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_registration, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public final static boolean isValidEmail(CharSequence target) {
        if (target == null) {
            return false;
        } else {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
        }
    }
    public boolean passwordCheck(String password){

        matcher = pattern.matcher(password);
        return matcher.matches();

    }

    public void register(){
        ProfileDBManager db = new ProfileDBManager();
        String susername = username.getText().toString();
        String spassword = password.getText().toString();
        String sfirstName = firstName.getText().toString();
        String slastName = lastName.getText().toString();
        int sage = Integer.parseInt(age.getText().toString());
        String semail = email.getText().toString();
        if((susername != null)&(spassword != null)&(sfirstName != null)&(slastName != null)&(semail != null)){
            if(isValidEmail(semail)){
                if(passwordCheck(spassword)){
                    user.setAge(sage);
                    user.setEmail(semail);
                    user.setFirstName(sfirstName);
                    user.setLastName(slastName);
                    user.setPassword(spassword);
                    user.setUserName(susername);
                    db.writeToDB(user,getApplicationContext());
                }
            }else{
                Toast.makeText(getApplicationContext(),"Please enter a valid email address",Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(getApplicationContext(),"Please fill in all fields",Toast.LENGTH_SHORT).show();
        }
    }
}
