package com.lsx.haodoucaipu.gson.caipu;

public class CaiPuJsonResultAlbum {
    private String name;
    private String icon;
    private CaiPuJsonResultAlbumList[] list;
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

    public CaiPuJsonResultAlbumList[] getList() {
        return this.list;
    }

    public void setList(CaiPuJsonResultAlbumList[] list) {
        this.list = list;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
