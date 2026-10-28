
interface Image { void show(); }

class RealImage implements Image {
    private final String fileName;
    public RealImage(String fileName) {
        this.fileName = fileName;
        System.out.println("--> [SLOW] Reading " + fileName + " from hard drive...");
    }
    public void show() { System.out.println("Displaying " + fileName + " on screen!"); }
}

class ProxyImage implements Image {
    private final String fileName;
    private final String userRole;
    private RealImage realImage;

    public ProxyImage(String fileName, String userRole) {
        this.fileName = fileName;
        this.userRole = userRole;
    }
    public void show() {
        if (!"ADMIN".equals(userRole)) {
            System.out.println("[ACCESS DENIED] You lack permission to view: " + fileName);
            return;
        }
        if (realImage == null) realImage = new RealImage(fileName); // lazy load
        realImage.show();
    }
}

public class Main {
    public static void main(String[] args) {
        new ProxyImage("salary_sheet.png", "GUEST").show();
        new ProxyImage("salary_sheet.png", "ADMIN").show();

        Video video = new ProxyVideo("Cat_Memes.mp4");
        video.play();
        video.play();
        video.play();

        Internet net = new SchoolProxyInternet();
        net.connectTo("wikipedia.org");
        net.connectTo("gaming.com");

        Device light = new SmartLight();
        AdvancedRemote remote = new AdvancedRemote(light);
        remote.powerOn();
        remote.mute();

        PartyRemote party = new PartyRemote(new Radio());
        party.partyMode();

        new Knight(new Sword()).attack();
        new Knight(new MagicWand()).attack();
    }
}