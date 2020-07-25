package com.ederfmatos.mockbean;

import com.ederfmatos.mockbean.bean.Category;
import com.ederfmatos.mockbean.bean.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.ederfmatos.mockbean.MockBean.mock;
import static com.ederfmatos.mockbean.MockBean.mockBean;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.ThrowableAssert.catchThrowable;

public class MockBeanTest {

    @Test
    @DisplayName("Should be create a mock of category")
    public void shouldBeMockCategory() {
        Category category = mockBean(Category.class).build();

        assertThat(category).isNotNull();
        assertThat(category.getId()).isNotNull();
        assertThat(category.getName()).isNotEmpty();
    }

    @Test
    @DisplayName("Should be create a mock of category without name")
    public void shouldBeMockCategoryWithoutName() {
        Category category = mock(Category.class)
                .without("name")
                .build();

        assertThat(category.getName()).isNull();
    }

    @Test
    @DisplayName("Should be create a mock of category without id and name")
    public void shouldBeMockCategoryWithoutIdAndName() {
        Category category = mock(Category.class)
                .without("id", "name")
                .build();

        assertThat(category.getId()).isNull();
        assertThat(category.getName()).isNull();
    }

    @Test
    @DisplayName("Should be create a mock of category with specific name")
    public void shouldBeMockCategoryWithSpecificName() {
        Category category = mock(Category.class)
                .with("name", "Tecnologia")
                .build();

        assertThat(category.getName()).isEqualTo("Tecnologia");
    }

    @Test
    @DisplayName("Should be create a mock of category with specific id")
    public void shouldBeMockCategoryWithSpecificId() {
        Category category = mock(Category.class)
                .with("id", 1)
                .build();

        assertThat(category.getId()).isEqualTo(1);
    }

    @Test
    @DisplayName("Should be create a mock of category list with 3 items")
    public void shouldBeMockListOfCategory() {
        List<Category> categories = mock(Category.class)
                .build(3);

        assertThat(categories).hasSize(3);
    }

    @Test
    @DisplayName("Should be create a mock of category list without items")
    public void shouldBeMockListOfCategoryWithoutItems() {
        List<Category> categories = mock(Category.class).build(0);

        assertThat(categories).isEmpty();
    }

    @Test
    @DisplayName("Should be throw exception on pass inexistent field to set")
    public void shouldBeThrowExceptionOnPassInexistentField() {
        Throwable exception = catchThrowable(() -> mock(Category.class).without("categoryName"));

        assertThat(exception)
                .isInstanceOf(RuntimeException.class)
                .hasMessage("Field \"categoryName\" not found");
    }

    @Test
    @DisplayName("Should be create a mock of product")
    public void shouldBeMockOfProductWithoutCategory() {
        Product product = mock(Product.class).build();

        assertThat(product).isNotNull();
        assertThat(product.getId()).isNotNull();
        assertThat(product.getName()).isNotEmpty();
        assertThat(product.getCreatedAt()).isNotNull();
        assertThat(product.getUpdatedAt()).isNotNull();
        assertThat(product.getPrice()).isNotNull();
        assertThat(product.getStock()).isNotNull();
        assertThat(product.getDiscount()).isNotNull();
        assertThat(product.isInactive()).isNotNull();
        assertThat(product.getCategory()).isNotNull();
    }

}