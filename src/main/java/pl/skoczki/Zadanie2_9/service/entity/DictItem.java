package pl.skoczki.Zadanie2_9.service.entity;

public class DictItem {

    private final String name;
    private final String value;

    public DictItem(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }
}