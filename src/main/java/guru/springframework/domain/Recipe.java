package guru.springframework.domain;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Data
@Entity
@Table(name = "recipes")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @Column(name = "prep_time")
    private Integer prepTime;

    @Column(name = "cook_time")
    private Integer cookTime;

    private Integer servings;
    private String source;
    private String url;

    @Lob
    private String directions;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe") // field in Ingredient class
    private Set<Ingredient> ingredients = new HashSet<>();

    @OneToOne(cascade = CascadeType.ALL)
    private Notes notes;

    @Lob
    private Byte[] image;

    @Enumerated(value = EnumType.STRING) //ORDINAL is default
    private Difficulty difficulty;

    // if you don't describe the relation, ORM will create 2 intermediate tables
    @ManyToMany
    @JoinTable(name = "recipe_category",
            joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return Objects.equals(id, recipe.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Recipe addIngredient(@NonNull Ingredient ingredient) {
        ingredient.setRecipe(this); //Implementing  bidirectional relation
        this.ingredients.add(ingredient);
        return this;
    }

    public void setNotes(Notes notes) {
        notes.setRecipe(this); // implementing bidirectional relation
        this.notes = notes;
    }
}
