package com.lspooo.library.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.lspooo.library.R;

public class ContactFragment extends Fragment {


    private View mBaseLayoutView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LayoutInflater mLayoutInflater = LayoutInflater.from(getActivity());
        mBaseLayoutView = mLayoutInflater.inflate(R.layout.fragment_contact, null);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return mBaseLayoutView;
    }
}
