class SmartLight implements Device {
    public void turnOn()  { System.out.println("Smart Light glows bright white."); }
    public void turnOff() { System.out.println("Smart Light shuts off."); }
    public void setVolume(int level) { System.out.println("Smart Light brightness set to: " + level + "%"); }
}

class BasicRemote {
    protected Device device;
    public BasicRemote(Device device) { this.device = device; }
    public void powerOn()  { device.turnOn(); }
    public void powerOff() { device.turnOff(); }
}

class AdvancedRemote extends BasicRemote {
    public AdvancedRemote(Device device) { super(device); }
    public void mute() {
        System.out.println("[Remote] Mute button pressed!");
        device.setVolume(0);
    }
}