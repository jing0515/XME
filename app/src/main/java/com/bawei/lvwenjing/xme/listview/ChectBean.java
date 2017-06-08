package com.bawei.lvwenjing.xme.listview;

public class ChectBean {

    public String text;
    public boolean ischecked ;

    public ChectBean(boolean ischecked, String text) {
        this.ischecked = ischecked;
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean ischecked() {
        return ischecked;
    }

    public void setIschecked(boolean ischecked) {
        this.ischecked = ischecked;
    }
}