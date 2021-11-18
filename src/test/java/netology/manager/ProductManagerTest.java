package netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.manager.ProductManager;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ProductManagerTest {

    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);

    private Product book1 = new Book(1, "Last Symbol", 1034, "Dan Brown");
    private Product book2 = new Book(2, "Shantaram", 2745, "Gregory David Roberts");
    private Product book3 = new Book(3, "Dune", 1562, "Frank Gerbert");
    private Product phone1 = new Smartphone(1, "Iphone XR", 15500, "Apple");
    private Product phone2 = new Smartphone(2, "Nokia 3310", 7930, "Nokia");
    private Product phone3 = new Smartphone(3, "Samsung Galaxy S2", 11390, "Samsung");
    private Product phone4 = new Smartphone(4, "Samsung A2", 10144, "Samsung");
    private Product anyProduct = new Product(1, "product", 1000);

    @BeforeEach
    void setUp() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(phone1);
        manager.add(phone2);
        manager.add(phone3);
        manager.add(phone4);
        manager.add(anyProduct);
    }

    @Test
    void searchIfAuthorNotFound() {
        Product[] actual = manager.searchBy("Nabokova");
        Product[] expected = new Product[0];

        assertArrayEquals(expected, actual);
    }

    @Test
    void searchIfAuthorFound() {
        Product[] actual = manager.searchBy("Frank Gerbert");
        Product[] expected = new Product[]{book3};

        assertArrayEquals(expected, actual);
    }

    @Test
    void searchIfBookNameFound() {
        Product[] actual = manager.searchBy("Dune");
        Product[] expected = new Product[]{book3};

        assertArrayEquals(expected, actual);
    }

    @Test
    void searchIfVendorNotFound() {
        Product[] actual = manager.searchBy("Motorola");
        Product[] expected = new Product[0];

        assertArrayEquals(expected, actual);
    }

    @Test
    void searchIf2PhonesFound() {
        Product[] actual = manager.searchBy("Samsung");
        Product[] expected = new Product[]{phone3, phone4};

        assertArrayEquals(expected, actual);
    }

    @Test
    void searchIfPhoneNameFound() {
        Product[] actual = manager.searchBy("Nokia 3310");
        Product[] expected = new Product[]{phone2};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFindByString() {
        Product[] expected = new Product[0];
        Product[] actual = manager.searchBy("Not Found");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByID() {
        manager.removeById(4);
        Product[] expected = new Product[]{book1, book2, book3, phone1, phone2, phone3, anyProduct};
        Product[] actual = manager.findAll();
        assertArrayEquals(expected, actual);
    }

}