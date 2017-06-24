package lol.ye0yeg.lolweather.bean;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 6/23/2017.
 */

@Root(name = "Profiles", strict = false)//需要解析的头部
public class WeatherXml {
    @ElementList(required = true, inline = true, entry = "Weather")
    private List<WeatherData> list = new ArrayList<>();

    public List<WeatherData> getList() {
        return list;
    }

    public void setList(List<WeatherData> list) {
        this.list = list;
    }


}
