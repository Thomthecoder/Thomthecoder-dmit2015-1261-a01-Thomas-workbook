package dmit2015.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ProductTest {

    // Test 1 — Verify Product Name
    @Test
    void getName_whenProductCreatedWithValidInputs_shouldReturnName() {
        // Arrange
        Product product = new Product("Laptop", 1200);
        // Act
        String actualName = product.getName();
        // Assert
        assertThat(actualName).isEqualTo("Laptop");
    }

    // Test 2 — Verify Product Price
    @Test
    void getPrice_whenProductCreatedWithValidInputs_shouldReturnPrice() {
        // Arrange
        Product product = new Product("Laptop", 1200);
        // Act
        double actualPrice = product.getPrice();
        // Assert
        assertThat(actualPrice).isCloseTo(1200.0, within(0.01));
    }

    // Test 3 — Verify Tax Calculation (1200 + 5% = 1260)
    @Test
    void getPriceWithTax_whenPriceIs1200_shouldReturnPricePlus5PercentTax() {
        // Arrange
        Product product = new Product("Laptop", 1200);
        double expectedTotal = 1200 * 1.05; // computed independently = 1260.0
        // Act
        double actualTotal = product.getPriceWithTax();
        // Assert
        assertThat(actualTotal).isCloseTo(expectedTotal, within(0.01));
    }

    // Test 4 — Verify Invalid Product Name (null, empty, whitespace)
    @Test
    void constructor_whenNameIsNull_shouldThrowIllegalArgumentException() {
        assertThatThrownBy(() -> new Product(null, 100))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("required");
    }

    @Test
    void constructor_whenNameIsEmpty_shouldThrowIllegalArgumentException() {
        assertThatThrownBy(() -> new Product("", 100))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("required");
    }

    @Test
    void constructor_whenNameIsWhitespace_shouldThrowIllegalArgumentException() {
        assertThatThrownBy(() -> new Product(" ", 100))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("required");
    }

    // Test 5 — Verify Invalid Price (0 and -5)
    @Test
    void constructor_whenPriceIsZero_shouldThrowIllegalArgumentException() {
        assertThatThrownBy(() -> new Product("Laptop", 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("greater than 0");
    }

    @Test
    void constructor_whenPriceIsNegative_shouldThrowIllegalArgumentException() {
        assertThatThrownBy(() -> new Product("Laptop", -5))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("greater than 0");
    }
}
