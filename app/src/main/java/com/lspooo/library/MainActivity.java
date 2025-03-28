package com.lspooo.library;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import com.lspooo.common.utils.ToastUtils;
import com.lspooo.common.view.navigationBar.NavigationBarHelper;
import com.lspooo.common.view.navigationBar.NavigationBarItem;
import com.lspooo.common.view.navigationBar.NavigationBarView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private NavigationBarView navigationBarView;
    private NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initNavigationBar();
        initFragment();
    }

    private void initFragment(){
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_container_view);
        if (navHostFragment == null) {
            return;
        }
        navController = navHostFragment.getNavController();
        navController.navigate(R.id.main_fragment, null);
    }

    private void initNavigationBar(){
        navigationBarView = findViewById(R.id.navigation_bar_view);
        navigationBarView.setOnNavigationBarToggleListener(new NavigationBarView.OnNavigationBarToggleListener() {
            @Override
            public void onToggle(NavigationBarItem item) {
                if (navController != null) {
                    navController.navigate(item.getAttachedFragment(), null);
                }
            }
        });
    }

}