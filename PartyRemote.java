class PartyRemote extends BasicRemote {
    public PartyRemote(Device device) { super(device); }
    public void partyMode() {
        System.out.println("[Party Remote] Pumping up the party!");
        device.turnOn();
        device.setVolume(100);
    }
}interface Video { void play(); }

class RealVideo implements Video {
    private final String name;
    public RealVideo(String name) {
        this.name = name;
        System.out.println("--> [DOWNLOADING] Connecting to server & buffering 4K video: " + name);
    }
    public void play() { System.out.println("Playing video: " + name); }
}

