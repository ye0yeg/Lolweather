package lol.ye0yeg.lolweather.bean;

/**
 * Created by Administrator on 6/24/2017.
 */
public class PicBean {
    private int height;
    private String url;

    public PicBean(String url) {
        this.url = url;
    }
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


}
