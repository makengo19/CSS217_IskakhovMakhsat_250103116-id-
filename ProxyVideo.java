class ProxyVideo implements Video {
    private final String name;
    private RealVideo realVideo;
    private int viewCount = 0;

    public ProxyVideo(String name) { this.name = name; }
    public void play() {
        viewCount++;
        System.out.println("--> [AUDIT] Video has been played " + viewCount + " time(s).");
        if (realVideo == null) realVideo = new RealVideo(name);
        realVideo.play();
    }
}
