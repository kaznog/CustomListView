package com.kaznog.as.customlistview;

/**
 * Created by kaznog on 2014/09/23.
 */
public class Model {
    private String title;
    private boolean toggleswitch;

    public Model(String title, boolean toggle) {
        this.title = title;
        this.toggleswitch = toggle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isToggleswitch() {
        return toggleswitch;
    }

    public void setToggleswitch(boolean toggleswitch) {
        this.toggleswitch = toggleswitch;
    }
}
