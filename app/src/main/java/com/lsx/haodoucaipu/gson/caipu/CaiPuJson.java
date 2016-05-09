package com.lsx.haodoucaipu.gson.caipu;

public class CaiPuJson {
    private CaiPuJsonResult result;
    private String _AB;
    private String request_id;
    private String status;

    public CaiPuJsonResult getResult() {
        return this.result;
    }

    public void setResult(CaiPuJsonResult result) {
        this.result = result;
    }

    public String get_AB() {
        return this._AB;
    }

    public void set_AB(String _AB) {
        this._AB = _AB;
    }

    public String getRequest_id() {
        return this.request_id;
    }

    public void setRequest_id(String request_id) {
        this.request_id = request_id;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
