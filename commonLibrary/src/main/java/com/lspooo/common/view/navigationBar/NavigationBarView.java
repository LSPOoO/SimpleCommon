package com.lspooo.common.view.navigationBar;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.lspooo.common.R;
import com.lspooo.common.utils.DensityUtil;

import java.util.ArrayList;
import java.util.List;

public class NavigationBarView extends ViewGroup {

    private final Context context;

    private final ViewGroup navigationBarContainer;
    private List<NavigationBarItem> navigationBarItemList;
    private NavigationBarItemView[] navigationBarItemViewArray;
    private int checkedIndex = 0;

    private OnNavigationBarToggleListener onNavigationBarToggleListener;

    public NavigationBarView(Context context) {
        this(context, null);
    }

    public NavigationBarView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public NavigationBarView(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public NavigationBarView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.context = context;
        LayoutInflater.from(context).inflate(R.layout.layout_navigation_bar, this, true);
        navigationBarContainer = findViewById(R.id.navigation_bar_container);
        TypedArray attributes = context.obtainStyledAttributes(attrs, R.styleable.NavigationBarView);
        //解析NavigationBarView的自定义属性
        parseAttributeSet(attributes);
        //开始创建NavigationBarView
        createNavigationBar();
        attributes.recycle();
    }

    private void parseAttributeSet(TypedArray attributes){
        //获取NavigationBarView的label数组
        if (!attributes.hasValue(R.styleable.NavigationBarView_labelArray)){
            return;
        }
        int labelArrayId = attributes.getResourceId(R.styleable.NavigationBarView_labelArray, 0);
        String[] labelArray = getResources().getStringArray(labelArrayId);
        //获取NavigationBarView的icon数组
        if (!attributes.hasValue(R.styleable.NavigationBarView_iconArray)){
            return;
        }
        int iconArrayId = attributes.getResourceId(R.styleable.NavigationBarView_iconArray, 0);
        TypedArray iconArray = getResources().obtainTypedArray(iconArrayId);
        //获取NavigationBarView的checkedIcon数组
        if (!attributes.hasValue(R.styleable.NavigationBarView_checkedIconArray)){
            return;
        }
        int checkedIconArrayId = attributes.getResourceId(R.styleable.NavigationBarView_checkedIconArray, 0);
        TypedArray checkedIconArray = getResources().obtainTypedArray(checkedIconArrayId);
        //获取与NavigationBarView关联的fragment的ID数组
        if (!attributes.hasValue(R.styleable.NavigationBarView_attachedFragmentArray)){
            return;
        }
        int attachedFragmentArrayId = attributes.getResourceId(R.styleable.NavigationBarView_attachedFragmentArray, 0);
        TypedArray attachedFragmentArray = getResources().obtainTypedArray(attachedFragmentArrayId);
        //获取NavigationBarView的label的字体大小
        float labelSizePx = attributes.getDimension(R.styleable.NavigationBarView_labelSize, 0);
        NavigationBarHelper.navigationBarLabelSize = DensityUtil.px2sp(context, labelSizePx);
        //获取NavigationBarView的label的颜色
        NavigationBarHelper.navigationBarLabelColor = attributes.getColor(R.styleable.NavigationBarView_labelColor, 0);
        NavigationBarHelper.navigationBarLabelCheckedColor = attributes.getColor(R.styleable.NavigationBarView_labelCheckedColor, 0);


        navigationBarItemList = new ArrayList<>();
        if (labelArray.length == iconArray.length() && labelArray.length == checkedIconArray.length()){
            for (int i = 0; i < labelArray.length; i ++){
                NavigationBarItem item = new NavigationBarItem();
                item.setIndex(i);
                item.setLabel(labelArray[i]);
                item.setIcon(iconArray.getResourceId(i, 0));
                item.setCheckedIcon(checkedIconArray.getResourceId(i, 0));
                item.setAttachedFragment(attachedFragmentArray.getResourceId(i, 0));
                item.setChecked(i == 0);
                navigationBarItemList.add(item);
            }
        }
        iconArray.recycle();
        checkedIconArray.recycle();
        attachedFragmentArray.recycle();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        measureChildren(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        final int count = getChildCount();
        final int x = right - left;
        final int y = bottom - top;
        final View child = getChildAt(0);
        child.layout(0, 0, x, y);
    }

    /**
     * 创建NavigationBarView
     */
    public void createNavigationBar(){
        if (navigationBarItemList == null){
            return;
        }
        checkedIndex = 0;
        navigationBarItemViewArray = new NavigationBarItemView[navigationBarItemList.size()];
        LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        params.weight = 1;
        params.gravity = Gravity.CENTER_VERTICAL;
        for (NavigationBarItem item: navigationBarItemList){
            NavigationBarItemView navigationBarItemView = new NavigationBarItemView(context);
            navigationBarItemView.createNavigationBarItem(item);
            navigationBarItemView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    toggle(item.getIndex());
                    if (onNavigationBarToggleListener != null) {
                        onNavigationBarToggleListener.onToggle(item);
                    }
                }
            });
            navigationBarItemViewArray[item.getIndex()] = navigationBarItemView;
            navigationBarContainer.addView(navigationBarItemView, params);
        }
    }

    public void toggle(int toggleIndex){
        if (checkedIndex == toggleIndex) {
            return;
        }
        NavigationBarItemView checkedView = navigationBarItemViewArray[checkedIndex];
        checkedView.toggle();
        NavigationBarItemView toggleView = navigationBarItemViewArray[toggleIndex];
        toggleView.toggle();
        checkedIndex = toggleIndex;
    }

    public void setOnNavigationBarToggleListener(OnNavigationBarToggleListener onNavigationBarToggleListener) {
        this.onNavigationBarToggleListener = onNavigationBarToggleListener;
    }

    public interface OnNavigationBarToggleListener{
        void onToggle(NavigationBarItem item);
    }


}
