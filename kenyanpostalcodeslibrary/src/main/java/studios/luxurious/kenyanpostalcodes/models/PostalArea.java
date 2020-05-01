package studios.luxurious.kenyanpostalcodes.models;

public class PostalArea {
    private String areaName;
    private String areaCode;

    public PostalArea(String areaName, String areaCode) {
        this.areaName = areaName;
        this.areaCode = areaCode;
    }

    public String getAreaName() {
        return areaName;
    }

    public String getAreaCode() {
        return areaCode;
    }
}
