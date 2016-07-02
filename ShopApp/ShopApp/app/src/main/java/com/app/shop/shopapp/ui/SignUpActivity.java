package com.app.shop.shopapp.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.app.shop.shopapp.R;
import com.app.shop.shopapp.model.User;
import com.app.shop.shopapp.utils.RealmWrapper;

import io.realm.Realm;

public class SignUpActivity extends AppCompatActivity {


    private EditText mEditTextEmailSignUp;
    private EditText mEditTextPasswordSignUp;
    private Button mBtnSignUp;

    private Realm mRealm;

    private void initViews() {
        mEditTextEmailSignUp = (EditText) findViewById(R.id.et_email_sign_up);
        mEditTextPasswordSignUp = (EditText) findViewById(R.id.et_password_sign_up);
        mBtnSignUp = (Button) findViewById(R.id.btn_sign_up);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        initViews();

        mRealm = RealmWrapper.createRealmInstance(this);

        mBtnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = "", password = "";
                email = mEditTextEmailSignUp.getText().toString().trim();
                password = mEditTextPasswordSignUp.getText().toString().trim();

                if (email.length() <= 0 && password.length() <= 0) {
                    Toast.makeText(SignUpActivity.this, "Enter Valid Data", Toast.LENGTH_SHORT).show();

                } else {

                    mRealm.beginTransaction();
                    // Create an object
                    User user = mRealm.createObject(User.class);
                    user.setmUserName(email); // Set its fields
                    user.setmUserPassword(password); // Set its fields
                    mRealm.commitTransaction();

                    Toast.makeText(SignUpActivity.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                    onBackPressed();

                }


            }
        });


    }
}
