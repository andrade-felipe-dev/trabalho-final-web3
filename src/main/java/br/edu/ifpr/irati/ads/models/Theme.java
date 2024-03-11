package br.edu.ifpr.irati.ads.models;

import br.edu.ifpr.irati.ads.models.enums.NameThemeEnum;
import br.edu.ifpr.irati.ads.models.user.Admin;
import jakarta.persistence.*;

@Entity(name = "theme")
public class Theme implements Comparable<Theme> {
    public Theme() {
        id = 0;
        name = NameThemeEnum.OUTROS;
        endDateWithDays = 0;
    }

    public Theme(int id, NameThemeEnum name, int endDateWithDays) {
        this.id = id;
        this.name = name;
        this.endDateWithDays = endDateWithDays;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq-theme")
    @SequenceGenerator(name = "seq-theme", sequenceName = "THEME_SEQ", allocationSize = 1, initialValue = 1)
    private int id;

    @Enumerated(EnumType.STRING)
    private NameThemeEnum name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int endDateWithDays;

    public NameThemeEnum getName() {
        return name;
    }

    public void setName(NameThemeEnum name) {
        this.name = name;
    }

    public int getEndDateWithDays() {
        return endDateWithDays;
    }

    public void setEndDateWithDays(int endDateWithDays) {
        this.endDateWithDays = endDateWithDays;
    }

    @Override
    public int compareTo(Theme o) {
        return this.id - o.id;
    }
}
