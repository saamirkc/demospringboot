package com.springproject.demo.domain;
import com.fasterxml.jackson.annotation.JsonBackReference;
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
    @JsonBackReference
    private Author author;

}
//here if I use cascade = CascadeType.ALL then it can cause unintended behavior when deleting a Books entity.
//This is generally undesirable because deleting one book should not remove the author, especially when the author has written other books.

//Suppose the author John has written 3 books (Book A, Book B, and Book C), and they all have John's id as author_id in the books table.
//If you delete Book A, due to CascadeType.ALL, Hibernate will also try to delete the associated author, which is John.
//Since John is the author for all 3 books (Book A, Book B, and Book C), deleting the Author will also result in all 3 books being deleted
// (because of the cascading delete operation).



//In a bidirectional relationship between entities (like Author and Books),
// the parent and child roles are determined based on the ownership of the foreign key. Specifically:
//The parent is the entity that does not own the foreign key.
//The child is the entity that owns the foreign key.
//so books is the child class as it contains foreign key author id while author doesnt contain any foreign key so it is parent .



//        In the context of handling bidirectional relationships in Java with Jackson (a library for processing JSON),
//        the annotations @JsonManagedReference and @JsonBackReference are used to solve issues related to infinite recursion during serialization.
//        1. @JsonManagedReference:
//        It is used on the parent side of the relationship.
//        This annotation marks the property that should be serialized when converting the object to JSON.
//2. @JsonBackReference:
//        It is used on the child side of the relationship.
//        This annotation marks the property that should be ignored during serialization (i.e., when converting to JSON) to prevent recursion issues.
//        The back reference is deserialized normally when reading JSON back into Java objects.
