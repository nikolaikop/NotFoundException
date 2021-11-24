package netology.domain;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ProductTest {

    private Product book1 = new Book(1, "Last Symbol", 1034, "Dan Brown");
    private Product book2 = new Book(2, "Shantaram", 2745, "Gregory David Roberts");
    private Product phone4 = new Smartphone(4, "Samsung A2", 10144, "Samsung");


    @Test
    void bookNameMatch() {
        boolean actual = book2.matches("Shantaram");
        assertTrue(actual);
    }

    @Test
    void bookNameDoesntMatch() {
        boolean actual = book1.matches("Dune");
        assertFalse(actual);
    }

    @Test
    void phoneNameMatch() {
        boolean actual = phone4.matches("Samsung A2");
        assertTrue(actual);
    }

}