package ge.tbc.testautomation.constants;

public enum Resolution {
    DESKTOP(1440, 900, false),
    MOBILE(390, 844, true);

    private final int width;
    private final int height;
    private final boolean mobile;

    Resolution(int width, int height, boolean mobile) {
        this.width = width;
        this.height = height;
        this.mobile = mobile;
    }

    public int width() { return width; }
    public int height() { return height; }
    public boolean isMobile() { return mobile; }
    public String asBrowserSize() { return width + "x" + height; }

    public static Resolution fromProfile(String profile) {
        return "mobile".equalsIgnoreCase(profile == null ? "" : profile.trim()) ? MOBILE : DESKTOP;
    }
}
