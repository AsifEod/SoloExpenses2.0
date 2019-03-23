package com.expenseondemand.soloexpenses.presentation.model;

import com.expenseondemand.soloexpenses.presentation.activity.DashBoardActivity;

public class DashBoardMenuModel {

    private int iconResourceId;
    private String menuName;
    private DashBoardActivity.Menu menuType;
    private int ActionCount = 0;

    public DashBoardMenuModel(int iconResourceId, String menuName, DashBoardActivity.Menu menuType, int actionCount) {
        this.iconResourceId = iconResourceId;
        this.menuName = menuName;
        this.menuType = menuType;
        ActionCount = actionCount;
    }

    public int getIconResourceId() {
        return iconResourceId;
    }

    public String getMenuName() {
        return menuName;
    }

    public DashBoardActivity.Menu getMenuType() {
        return menuType;
    }

    public int getActionCount() {
        return ActionCount;
    }

    public void setActionCount(int actionCount) {
        ActionCount = actionCount;
    }
}
