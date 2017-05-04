package com.whiteshadow.studentlife.account;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.Profile;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.whiteshadow.studentlife.App;
import com.whiteshadow.studentlife.MainActivity;
import com.whiteshadow.studentlife.R;
import com.whiteshadow.studentlife.domain.DaoSession;
import com.whiteshadow.studentlife.domain.Student;
import com.whiteshadow.studentlife.domain.StudentDao;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

import static com.facebook.FacebookSdk.getApplicationContext;

/**
 * Created by Incau Ionut on 12-Apr-17.
 * Contact: ionut.incau@gmail.com
 */

public class LoginFragment extends Fragment{

    private CallbackManager callbackManager;
    private FacebookCallback<LoginResult> facebookCallback;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        callbackManager = CallbackManager.Factory.create();
        facebookCallback = new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                boolean accountExist = getAccount();
                if (accountExist) {
                    Intent intent = new Intent(getActivity(), MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                }
                else {
                    Intent intent = new Intent(getActivity(), CreateAccountActivity.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onCancel() {
                Context context = getApplicationContext();
                CharSequence text = "Login canceled!\nLogin to continue";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }

            @Override
            public void onError(FacebookException error) {
                Context context = getApplicationContext();
                CharSequence text = "Error connecting with Facebook!\nCheck internet connection";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        };
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        final LoginButton loginButton = (LoginButton) view.findViewById(R.id.login_button);
        loginButton.setReadPermissions("email");
        loginButton.setFragment(this);
        loginButton.registerCallback(callbackManager, facebookCallback);

        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    /**
     * check database for user account
     * if there is no account means that user login for first time
     */
    private boolean getAccount() {
        DaoSession daoSession = ((App) getActivity().getApplication()).getDaoSession();
        StudentDao studentDao = daoSession.getStudentDao();
        List<Student> list = studentDao.loadAll();
        String id = Profile.getCurrentProfile().getId();
        for (Student s : list) {
            if (s.getFacebookId().equals(id)) return true;
        }
        return false;
    }
}
