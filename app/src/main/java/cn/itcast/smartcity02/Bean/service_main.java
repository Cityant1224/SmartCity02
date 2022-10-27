package cn.itcast.smartcity02.Bean;

public class service_main {
    private String items_name;
    private String itemimages;


    public service_main(String items_name, String itemimages){
        this.itemimages = itemimages;
        this.items_name = items_name;
    }

    public String getItems_name() {
        return items_name;
    }

    public String getItemimages() {
        return itemimages;
    }
}
