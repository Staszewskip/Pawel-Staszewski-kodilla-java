package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class InvoiceDaoTestSuite {
    @Autowired
    private InvoiceDao invoiceDao;

    @Test
    void testInvoiceDaoSave() {
//        Given

        Product product1 = new Product("Onion");
        Product product2 = new Product("Potatoes");
        Product product3 = new Product("Tomatoes");

        Item item1 = new Item (new BigDecimal(5),100,new BigDecimal(500));
        Item item2 = new Item (new BigDecimal(3),200,new BigDecimal(600));
        Item item3 = new Item (new BigDecimal(10),50,new BigDecimal(500));

        item1.setProduct(product1);
        item2.setProduct(product2);
        item3.setProduct(product3);

        product1.getItems().add(item1);
        product2.getItems().add(item2);
        product3.getItems().add(item3);

        Invoice invoice = new Invoice(2,new ArrayList<>());
        invoice.getItems().add(item1);
        invoice.getItems().add(item2);
        invoice.getItems().add(item3);

        item1.setInvoice(invoice);
        item2.setInvoice(invoice);
        item3.setInvoice(invoice);

//        When
       invoiceDao.save(invoice);
       int id = invoice.getId();

//       Then
        assertNotEquals(0,id);

//        CleanUp
        invoiceDao.deleteById(id);
    }

}