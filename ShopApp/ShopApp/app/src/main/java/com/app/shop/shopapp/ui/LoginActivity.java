package com.app.shop.shopapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.app.shop.shopapp.R;
import com.app.shop.shopapp.model.User;
import com.app.shop.shopapp.utils.RealmWrapper;

import io.realm.Realm;
import io.realm.RealmResults;

public class LoginActivity extends AppCompatActivity {


    private EditText mEditTextEmail;
    private EditText mEditTextPassword;
    private TextView mTvSignUp;
    private Button mBtnSignIn;


    private String mUserName;
    private String mAddress;
    private String mContact;
    //private static Realm mRealm;
    private Realm mRealm;

    private static final String TAG = LoginActivity.class.getClass().getSimpleName();


    private void initViews() {
        mEditTextEmail = (EditText) findViewById(R.id.et_email);
        mEditTextPassword = (EditText) findViewById(R.id.et_password);
        mBtnSignIn = (Button) findViewById(R.id.btn_email_sign_in);
        mTvSignUp = (TextView) findViewById(R.id.tv_signUpTextView);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initViews();


        mRealm = RealmWrapper.createRealmInstance(this);

        mBtnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = "", password = "";
                email = mEditTextEmail.getText().toString().trim();
                password = mEditTextPassword.getText().toString().trim();

                if (email.length() <= 0 && password.length() <= 0) {
                    Toast.makeText(LoginActivity.this, "Enter Valid Data", Toast.LENGTH_SHORT).show();

                } else {

                    RealmResults<User> result =
                            mRealm.where(User.class).findAll();

                    for (User c : result) {
                        if (c.getmUserName().equals(email) && c.getmUserPassword().equals(password)) {
                            Intent intent = new Intent(LoginActivity.this, ProductListActivity.class);
                            startActivity(intent);
                            Log.d(TAG, c.getmUserName());

                        } else {
                            Toast.makeText(LoginActivity.this, "Invalid data..please try again", Toast.LENGTH_SHORT).show();
                        }


                    }
                }
            }
        });
        mTvSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });

    }

}

