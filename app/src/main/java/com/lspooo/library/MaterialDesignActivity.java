package com.lspooo.library;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.lspooo.common.utils.ToastUtils;


/**
 * 1. 关于android:theme的详细理解（附图）；
 *     （运用：使用Toolbar代替ActionBar时，须将Theme.AppCompat.Light.DarkActionBar改成Theme.AppCompat.Light.NoActionBar）
 * 2. 在activity_main.xml中使用Toolbar代替ActionBar；
 *         关于命名空间：android  app；
 *         关于Toolbar控件的属性；尤其android:theme以及app:popupTheme的用法理解；
 *
 * 3. 关于activity.android：label；
 *
 * 4. 通过Menu resource file菜单文件式（同时为xml格式）来为Toolbar添加action按钮；
 *         文件中：
 *         <item>标签来定义action按钮，
 *         android：id用于指定按钮的id，
 *         android:icon用于指定按钮的图标，
 *         android：title用于指定按钮的文字；
 *         使用app：showAsAction来指定按钮的显示位置，再次使用了app命名空间，同样是为了能够兼容低版本的系统；
 *          showAsAction的几种选值：always   ifRoom   never
 *         注意，
 *                 Toolbar中的action按钮只会显示图标，
 *                 菜单中的action按钮只会显示文字；
 *
 * 5. onCreateOptionsMenu()加载描述Toolbar的action按钮的Menu resource file；
 *     onOptionsItemSelected()方法中处理各个按钮的点击事件；
 */


public class MaterialDesignActivity extends BaseActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setDisplayHomeAsUp(true);
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
        } else {
            return super.onOptionsItemSelected(item);
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
