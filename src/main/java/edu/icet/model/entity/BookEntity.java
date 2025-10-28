package edu.icet.model.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class BookEntity {

    @Id
    private Long id;
    private String title;
    private String author;
    private String publisher;
    private String isbm;
    private String category;
    private int availableCopies;

}
