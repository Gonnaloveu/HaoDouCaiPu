package com.lsx.haodoucaipu.gson.caipu;

public class CaiPuJsonResultGoods {
    private String name;
    private CaiPuJsonResultGoodsList[] list;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CaiPuJsonResultGoodsList[] getList() {
        return this.list;
    }

    public void setList(CaiPuJsonResultGoodsList[] list) {
        this.list = list;
    }
}
