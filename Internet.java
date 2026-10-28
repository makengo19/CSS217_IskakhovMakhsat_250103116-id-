interface Internet { void connectTo(String site); }

class RealInternet implements Internet {
    public void connectTo(String site) { System.out.println("Connected to site: " + site); }
}

class SchoolProxyInternet implements Internet {
    private RealInternet realInternet;
    public void connectTo(String site) {
        if (site.equals("gaming.com") || site.equals("socialmedia.com")) {
            System.out.println("[BLOCKED BY FIREWALL] Cannot access: " + site);
            return;
        }
        if (realInternet == null) realInternet = new RealInternet();
        realInternet.connectTo(site);
    }
}


interface Device {
    void turnOn();
    void turnOff();
    void setVolume(int level);
}

class Radio implements Device {
    public void turnOn()  { System.out.println("Radio starts playing static/music."); }
    public void turnOff() { System.out.println("Radio shuts off."); }
    public void setVolume(int level) { System.out.println("Radio volume knob turned to: " + level); }
}