package guru.springframework.services;

import guru.springframework.domain.Recipe;
import guru.springframework.repositories.RecipeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class RecipeServiceImplTest {

    RecipeService recipeService;

    @Mock
    RecipeRepository recipeRepository;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        recipeService = new RecipeServiceImpl(recipeRepository);
    }

    @Test
    public void getRecipes() {
        Set<Recipe> expected_0 = Collections.emptySet();
        assertEquals(expected_0, recipeService.getRecipes());

        Set<Recipe> recipes = new HashSet<>(Collections.singletonList(new Recipe()));
        Set<Recipe> expected_1 = new HashSet<>(recipes);
        when(recipeService.getRecipes())
                .thenReturn(recipes);
        assertEquals(expected_1, recipeService.getRecipes());

        verify(recipeRepository, times(2))
                .findAll(); // we want to verify that .findAll() is invoked n times.
    }
}