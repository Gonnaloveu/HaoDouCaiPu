package com.lsx.haodoucaipu.gson.caipu;

public class CaiPuJsonResultPerson {
    private String name;
    private String icon;
    private CaiPuJsonResultPersonTag[] tag;
    private CaiPuJsonResultPersonList[] list;
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

    public CaiPuJsonResultPersonTag[] getTag() {
        return this.tag;
    }

    public void setTag(CaiPuJsonResultPersonTag[] tag) {
        this.tag = tag;
    }

    public CaiPuJsonResultPersonList[] getList() {
        return this.list;
    }

    public void setList(CaiPuJsonResultPersonList[] list) {
        this.list = list;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
