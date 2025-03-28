package com.lspooo.common.view.navigationBar;

public class NavigationBarItem {

    private int index;
    private int icon;
    private int checkedIcon;
    private String label;
    private int attachedFragment;
    private boolean checked = false;


    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public int getCheckedIcon() {
        return checkedIcon;
    }

    public void setCheckedIcon(int checkedIcon) {
        this.checkedIcon = checkedIcon;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getAttachedFragment() {
        return attachedFragment;
    }

    public void setAttachedFragment(int attachedFragment) {
        this.attachedFragment = attachedFragment;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }




}
