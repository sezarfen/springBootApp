package com.singers.singers.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "dhikr")
public class Dhikr {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "arabic_read")
    private String arabicRead;

    @Column(name = "english_read")
    private String englishRead;

    @Column(name = "english_mean")
    private String englishMean;

    public Dhikr() {
    }

    public Dhikr(String arabicRead, String englishRead, String englishMean) {
        this.arabicRead = arabicRead;
        this.englishRead = englishRead;
        this.englishMean = englishMean;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getArabicRead() {
        return arabicRead;
    }

    public void setArabicRead(String arabicRead) {
        this.arabicRead = arabicRead;
    }

    public String getEnglishRead() {
        return englishRead;
    }

    public void setEnglishRead(String englishRead) {
        this.englishRead = englishRead;
    }

    public String getEnglishMean() {
        return englishMean;
    }

    public void setEnglishMean(String englishMean) {
        this.englishMean = englishMean;
    }

    @Override
    public String toString() {
        return "Dhikr{" +
                "id=" + id +
                ", arabicRead='" + arabicRead + '\'' +
                ", englishRead='" + englishRead + '\'' +
                ", englishMean='" + englishMean + '\'' +
                '}';
    }
}
