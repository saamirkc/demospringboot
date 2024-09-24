package com.springproject.demo.domain;
import jakarta.persistence.*;
import lombok.*;
//@Getter
//@Setter
@Data                           // @ Data Includes @Getter and @Setter for all fields.
                              //Additionally, it automatically generates:
                             //@ToString: A toString() method.
                            //@EqualsAndHashCode: equals() and hashCode() methods.
                           //@RequiredArgsConstructor: A constructor for final fields (if any).
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="books")
public class Books {
    @Id
    private String isbn;
    private String title;


    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

}
//here if I use cascade = CascadeType.ALL then it can cause unintended behavior when deleting a Books entity.
//This is generally undesirable because deleting one book should not remove the author, especially when the author has written other books.

//Suppose the author John has written 3 books (Book A, Book B, and Book C), and they all have John's id as author_id in the books table.
//If you delete Book A, due to CascadeType.ALL, Hibernate will also try to delete the associated author, which is John.
//Since John is the author for all 3 books (Book A, Book B, and Book C), deleting the Author will also result in all 3 books being deleted
// (because of the cascading delete operation).