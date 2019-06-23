package com.geca.trackingson.userinterface.login;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.geca.trackingson.R;
import com.geca.trackingson.model.login.LoginRequest;
import com.geca.trackingson.model.login.LoginResponse;
import com.geca.trackingson.userinterface.BaseView;
import com.geca.trackingson.userinterface.main.MainActivity;
import com.geca.trackingson.utility.Session;
import com.geca.trackingson.utility.SharedPreferenceManager;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity implements LoginContract.View{

    LoginContract.Presenter presenter;

    SharedPreferenceManager sharedPreferenceManager;

    private FirebaseAuth firebaseAuth;

    @BindView(R.id.emailEditText)
    EditText emailEditText;
    @BindView(R.id.passwordEditText)
    EditText passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        presenter = new LoginPresenter(this);
        sharedPreferenceManager = new SharedPreferenceManager(this);
        firebaseAuth = FirebaseAuth.getInstance();

        if(sharedPreferenceManager.getUser().getUserId()!=null){
            openView(new MainActivity());
            closeView();
        }

    }

    @OnClick(R.id.loginButton)
    void logIn(){
        LoginRequest request = new LoginRequest(emailEditText.getText().toString(), passwordEditText.getText().toString());
        presenter.login(request);
    }

    @Override
    public void setSharedPreferences(final LoginResponse response) {
        if (response.getUser().getRelative() == null) {
            showErrorBadRequest();
            return;
        }
        Session session = new Session();
        session.setAccessToken(response.getAccessToken());
        session.setUserId(String.valueOf(response.getUser().getId()));
        session.setRelativeId(String.valueOf(response.getUser().getRelative().getId()));
        sharedPreferenceManager.saveUser(session);

        firebaseAuth.signInWithEmailAndPassword(emailEditText.getText().toString(), passwordEditText.getText().toString()).
        addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                String relativeUid = firebaseAuth.getCurrentUser().getUid();
                DatabaseReference currentUserDB = FirebaseDatabase.getInstance().getReference().child("Users").child("Relative").child(relativeUid);

                currentUserDB.child("uid").setValue(relativeUid);
                currentUserDB.child("relativeId").setValue(response.getUser().getRelative().getId());

                openView(new MainActivity());
                closeView();
            }
        });
    }

    @Override
    public void setPresenter(LoginContract.Presenter presenter) {

    }

    @Override
    public void openView(BaseView view) {
        startActivity(new Intent(this, view.getClass()));
    }

    @Override
    public void closeView() {
        finish();
    }

    @Override
    public void showErrorBadRequest() {

    }

    @Override
    public void showErrorInternalError() {

    }

    @Override
    public void showLoadingDialog() {

    }

    @Override
    public void showSuccessDialog() {

    }
}
