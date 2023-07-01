package com.singers.singers.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "hadith")
public class Hadith {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "arabic_text")
    private String arabicText;

    @Column(name = "english_text")
    private String englishText;

    @Column(name = "reference")
    private String reference;

    public Hadith() {
    }

    public Hadith(String arabicText, String englishText, String reference) {
        this.arabicText = arabicText;
        this.englishText = englishText;
        this.reference = reference;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getArabicText() {
        return arabicText;
    }

    public void setArabicText(String arabicText) {
        this.arabicText = arabicText;
    }

    public String getEnglishText() {
        return englishText;
    }

    public void setEnglishText(String englishText) {
        this.englishText = englishText;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    @Override
    public String toString() {
        return "Hadith{" +
                "id=" + id +
                ", arabicText='" + arabicText + '\'' +
                ", englishText='" + englishText + '\'' +
                ", reference='" + reference + '\'' +
                '}';
    }
}
