package com.whiteshadow.studentlife.account;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.whiteshadow.studentlife.R;

/**
 * Created by Incau Ionut on 04-May-17.
 * Contact: ionut.incau@gmail.com
 */

public class ShowAccountFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_show_account, container, false);
        Button continueButton = (Button) view.findViewById(R.id.changeButon);
        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity()
                        .getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container_account, new EditAccountFragment())
                        .commit();
            }
        });
        return view;
    }
}
