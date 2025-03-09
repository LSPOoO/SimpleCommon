package com.lspooo.library;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


public abstract class BaseActivity extends AppCompatActivity {

    private int layoutId;
    private Toolbar toolbar;
    private TextView mTitleView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater mLayoutInflater = LayoutInflater.from(this);
        ViewGroup mRootView = (ViewGroup) mLayoutInflater.inflate(R.layout.activity_base, null);

        if (hasToolBar()){
            toolbar = (Toolbar) mLayoutInflater.inflate(R.layout.layout_toolbar, null);
            mTitleView = toolbar.findViewById(R.id.toolbar_title_view);
            mRootView.addView(toolbar,
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);
            setSupportActionBar(toolbar);
        }
        layoutId = getLayoutId();
        if (getLayoutId() != -1){
            View mContentView = View.inflate(this, layoutId, null);
            mRootView.addView(mContentView, LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.MATCH_PARENT);
        }
        setContentView(mRootView);
        initView();
    }

    private void initView(){

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    protected final void setToolbarTitle(CharSequence title) {
        if (toolbar == null) {
            return;
        }
        mTitleView.setText(title);
    }

    protected abstract int getLayoutId();
    protected abstract boolean hasToolBar();
}
