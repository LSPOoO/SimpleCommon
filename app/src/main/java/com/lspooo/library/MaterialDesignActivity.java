package com.lspooo.library;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.lspooo.common.utils.ToastUtils;

public class MaterialDesignActivity extends BaseActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setToolbarTitle(getString(R.string.text_material_design));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int itemId = item.getItemId();
        if (itemId == R.id.menu_backup) {
            ToastUtils.showMessage(getApplicationContext(), getString(R.string.text_menu_backup));
        } else if (itemId == R.id.menu_delete) {
            ToastUtils.showMessage(getApplicationContext(), getString(R.string.text_menu_delete));
        } else if (itemId == R.id.menu_settings) {
            ToastUtils.showMessage(getApplicationContext(), getString(R.string.text_menu_settings));
        }
        return true;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_material_design;
    }

    @Override
    protected boolean hasToolBar() {
        return true;
    }
}
