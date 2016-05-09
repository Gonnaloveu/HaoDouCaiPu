package com.lsx.haodoucaipu.gson.caipu;

public class CaiPuJsonResultVip {
    private String name;
    private String icon;
    private CaiPuJsonResultVipList[] list;
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

    public CaiPuJsonResultVipList[] getList() {
        return this.list;
    }

    public void setList(CaiPuJsonResultVipList[] list) {
        this.list = list;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
