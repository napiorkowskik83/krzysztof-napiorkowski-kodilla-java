package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InvoiceDaoTestSuite {

    @Autowired
    InvoiceDao invoiceDao;

    @Test
    public void testInvoiceDaoSave() {

        //Given
        Product product1 = new Product("Laptop");
        Product product2 = new Product("Tablet");

        Item item1 = new Item(product1, new BigDecimal(300), 3);
        Item item2 = new Item(product2, new BigDecimal(350), 1);
        Item item3 = new Item(product2, new BigDecimal(250), 3);

        product1.getItems().add(item1);
        product2.getItems().add(item2);
        product2.getItems().add(item3);

        Invoice invoice = new Invoice("123");

        invoice.getItems().add(item1);
        invoice.getItems().add(item2);
        invoice.getItems().add(item3);

        item1.setInvoice(invoice);
        item2.setInvoice(invoice);
        item3.setInvoice(invoice);

        invoice.getProducts().add(product1);
        invoice.getProducts().add(product2);

        product1.setInvoice(invoice);
        product2.setInvoice(invoice);

        //When
        invoiceDao.save(invoice);
        int invoiceId = invoice.getId();

        //Then
        Assert.assertNotEquals(0, invoiceId);


        //CleanUp
        try {
            invoiceDao.deleteById(invoiceId);

        } catch (Exception e) {
            //do nothing
        }
    }
}
