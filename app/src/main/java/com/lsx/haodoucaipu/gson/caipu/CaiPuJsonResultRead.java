package com.lsx.haodoucaipu.gson.caipu;

public class CaiPuJsonResultRead {
    private String name;
    private String icon;
    private String Count;
    private CaiPuJsonResultReadList[] list;
    private String url;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return this.icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getCount() {
        return this.Count;
    }

    public void setCount(String Count) {
        this.Count = Count;
    }

    public CaiPuJsonResultReadList[] getList() {
        return this.list;
    }

    public void setList(CaiPuJsonResultReadList[] list) {
        this.list = list;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
