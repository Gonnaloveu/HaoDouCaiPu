package com.lsx.haodoucaipu.gson.caipu;

public class CaiPuJsonResultAlbumList {
    private String Img;
    private String Recipe;
    private String Title;
    private CaiPuJsonResultAlbumListList[] List;
    private String Url;

    public String getImg() {
        return this.Img;
    }

    public void setImg(String Img) {
        this.Img = Img;
    }

    public String getRecipe() {
        return this.Recipe;
    }

    public void setRecipe(String Recipe) {
        this.Recipe = Recipe;
    }

    public String getTitle() {
        return this.Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public CaiPuJsonResultAlbumListList[] getList() {
        return this.List;
    }

    public void setList(CaiPuJsonResultAlbumListList[] List) {
        this.List = List;
    }

    public String getUrl() {
        return this.Url;
    }

    public void setUrl(String Url) {
        this.Url = Url;
    }
}
