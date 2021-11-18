package ru.netology.repository;

import ru.netology.domain.NotFoundException;
import ru.netology.domain.Product;

public class ProductRepository {

    private Product[] items = new Product[0];

    public void save(Product item) {
        int length = items.length + 1;
        Product[] tmp = new Product[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public Product[] findAll() {
        return items;
    }

/*    public Product findByID(int id) {
        for (Product product : items) {
         if (product.getId() == id) {
              return product;
         }
        }
        return null;
    }*/

    public Product findById(int id) {
        Product itemById = new Product();
        for (Product item : items) {
            if (item.getId() == id) {
                itemById = item;
            }
        }
        return itemById;
    }

    public void removeById(int id) {
        if (findById(id) != null) {
            int length = items.length - 1;
            Product[] tmp = new Product[length];
            int index = 0;
            for (Product item : items) {
                if (item.getId() != id) {
                    tmp[index] = item;
                    index++;
                }
                items = tmp;
            }
        } else {
            throw new NotFoundException("Element with ID " + id + " not found");
        }
    }
}
