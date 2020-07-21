package com.kodilla.patterns.prototype.library;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class LibraryTestSuite {

    @Test
    public void testGetBooks() {
        //Given
        Library library = new Library("library1");
        Book b1 = new Book("One Hundred Years of Solitude", "Gabriel García Márquez", LocalDate.of(1967, 6, 8));
        Book b2 = new Book("Submission", "Michel Houellebecq", LocalDate.of(2015, 1, 29));
        Book b3 = new Book("Limes inferior", "Janusz A. Zajdl", LocalDate.of(1982, 11, 2));
        Book b4 = new Book("The Shadow of the Wind", "Carlos Ruiz Zafón", LocalDate.of(2001, 5, 13));
        Book b5 = new Book("Catch 22", "Joseph Heller", LocalDate.of(1961, 12, 24));

        library.addBook(b1);
        library.addBook(b2);
        library.addBook(b3);
        library.addBook(b4);
        library.addBook(b5);

        Library clonedLibrary = null;
        try {
            clonedLibrary = library.shallowCopy();
            clonedLibrary.setName("library2");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        Library deepClonedLibrary = null;
        try {
            deepClonedLibrary = library.deepCopy();
            deepClonedLibrary.setName("library3");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        //When
        library.getBooks().remove(b3);

        //Then
        System.out.println(library);
        System.out.println(clonedLibrary);
        System.out.println(deepClonedLibrary);
        Assert.assertEquals(4, library.getBooks().size());
        Assert.assertEquals(4, clonedLibrary.getBooks().size());
        Assert.assertEquals(5, deepClonedLibrary.getBooks().size());
        Assert.assertEquals(clonedLibrary.getBooks().size(), library.getBooks().size());
        Assert.assertNotEquals(library.getBooks().size(), deepClonedLibrary.getBooks().size());

    }
}
