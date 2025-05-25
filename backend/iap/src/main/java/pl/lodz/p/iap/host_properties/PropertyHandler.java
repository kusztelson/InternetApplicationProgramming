package pl.lodz.p.iap.host_properties;

public abstract class PropertyHandler {
    private String address;
    private String port;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public PropertyHandler() {

    }
}
