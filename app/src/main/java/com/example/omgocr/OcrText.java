package com.example.omgocr;

public class OcrText {
    private int textid;
    private int imageid;
    private String textresult;

    public int getTextid() {
        return textid;
    }

    public void setTextid(int textid) {
        this.textid = textid;
    }

    public int getImageid() {
        return imageid;
    }

    public void setImageid(int imageid) {
        this.imageid = imageid;
    }

    public String getTextresult() {
        return textresult;
    }

    public void setTextresult(String textresult) {
        this.textresult = textresult;
    }

    public OcrText(int textid, int imageid, String textresult) {
        this.textid = textid;
        this.imageid = imageid;
        this.textresult = textresult;
    }
}
