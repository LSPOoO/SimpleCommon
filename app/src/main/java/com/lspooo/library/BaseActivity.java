package com.lspooo.library;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.lspooo.common.swipe.SwipeBackActivity;


public abstract class BaseActivity extends SwipeBackActivity {

    private int layoutId;
    private Toolbar toolbar;
    private ActionBar actionBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater mLayoutInflater = LayoutInflater.from(this);
        ViewGroup mRootView = (ViewGroup) mLayoutInflater.inflate(R.layout.activity_base, null);

        if (hasToolBar()){
            toolbar = (Toolbar) mLayoutInflater.inflate(R.layout.layout_toolbar, null);
            mRootView.addView(toolbar,
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);
            setSupportActionBar(toolbar);
            actionBar = getSupportActionBar();
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
        if (item.getItemId() == android.R.id.home){
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    protected final void setToolbarTitle(CharSequence title) {
        if (TextUtils.isEmpty(title)) {
            return;
        }
        if (actionBar == null) {
            return;
        }
        actionBar.setTitle(title);
        actionBar.setDisplayShowTitleEnabled(true);
    }

    protected final void setDisplayHomeAsUp(boolean enabled){
        if (actionBar == null) {
            return;
        }
        actionBar.setDisplayHomeAsUpEnabled(enabled);
    }

    protected abstract int getLayoutId();
    protected abstract boolean hasToolBar();


}
