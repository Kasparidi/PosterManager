package ru.netology.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PosterItem {
    private int id;
    private int movieId;
    private String movieName;
    private int genre;
    private int data;
}
