package com.whiteshadow.studentlife;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.facebook.login.LoginManager;

/**
 * Created by ionut on 12-Apr-17.
 */

public class MainFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        final Button create_account_button = (Button) view.findViewById(R.id.logout_button);
        create_account_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                LoginManager.getInstance().logOut();
                Intent intent = new Intent(getActivity(), com.whiteshadow.studentlife.account.LoginActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }
}
