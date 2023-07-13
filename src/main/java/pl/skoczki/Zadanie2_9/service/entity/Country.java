package pl.skoczki.Zadanie2_9.service.entity;

public enum Country {
    POLAND("Polska"),
    CZECH_REPUBLIC("Czechy"),
    NORWAY("Norwegia"),
    FINLAND("Finlandia"),
    GERMANY("Niemcy"),
    JAPAN("Japonia"),
    ITALY("Włochy"),
    AUSTRIA("Austria"),
    SWITZERLAND("Szwajcaria"),
    SLOVENIA("Słowenia"),
    USA("Stany Zjednoczone");

    private final String displayName;

    Country(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}