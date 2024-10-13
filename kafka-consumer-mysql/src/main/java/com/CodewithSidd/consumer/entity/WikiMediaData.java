package com.CodewithSidd.consumer.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "wikimedia_data")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class WikiMediaData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private String wikiMediaEventData;

    public String getWikiMediaEventData() {
        return wikiMediaEventData;
    }

    public void setWikiMediaEventData(String wikiMediaEventData) {
        this.wikiMediaEventData = wikiMediaEventData;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
