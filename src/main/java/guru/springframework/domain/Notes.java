package guru.springframework.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Data
@Entity
public class Notes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Recipe recipe;

    @Lob
    private String recipeNotes;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Notes notes = (Notes) o;
        return Objects.equals(id, notes.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
