package com.lsx.haodoucaipu.gson.caipu;

public class CaiPuJsonResultEvent {
    private String name;
    private String icon;
    private CaiPuJsonResultEventList[] list;
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

    public CaiPuJsonResultEventList[] getList() {
        return this.list;
    }

    public void setList(CaiPuJsonResultEventList[] list) {
        this.list = list;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
