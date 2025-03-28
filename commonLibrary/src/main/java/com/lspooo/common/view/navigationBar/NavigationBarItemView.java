package com.lspooo.common.view.navigationBar;

import static java.lang.Math.max;

import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.lspooo.common.R;

public class NavigationBarItemView extends FrameLayout {

    private NavigationBarItem navigationBarItem;

    private final TextView mTitleView;
    private final ImageView icon;


    public NavigationBarItemView(@NonNull Context context) {
        this(context, null);
    }

    public NavigationBarItemView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public NavigationBarItemView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public NavigationBarItemView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        LayoutInflater.from(context).inflate(R.layout.layout_navigation_bar_item, this, true);
        mTitleView = findViewById(R.id.navigation_bar_item_title);
        icon = findViewById(R.id.navigation_bar_item_icon);
    }

    public void createNavigationBarItem(NavigationBarItem navigationBarItem) {
        this.navigationBarItem = navigationBarItem;
        mTitleView.setText(navigationBarItem.getLabel());
        mTitleView.setTextSize(TypedValue.COMPLEX_UNIT_SP, NavigationBarHelper.navigationBarLabelSize);
        if (navigationBarItem.isChecked()){
            mTitleView.setTextColor(NavigationBarHelper.navigationBarLabelCheckedColor);
            icon.setImageResource(navigationBarItem.getCheckedIcon());
        } else {
            mTitleView.setTextColor(NavigationBarHelper.navigationBarLabelColor);
            icon.setImageResource(navigationBarItem.getIcon());
        }
    }

    public void toggle(){
        navigationBarItem.setChecked(!navigationBarItem.isChecked());
        if (navigationBarItem.isChecked()){
            mTitleView.setTextColor(NavigationBarHelper.navigationBarLabelCheckedColor);
            icon.setImageResource(navigationBarItem.getCheckedIcon());
        } else {
            mTitleView.setTextColor(NavigationBarHelper.navigationBarLabelColor);
            icon.setImageResource(navigationBarItem.getIcon());
        }
    }
}
