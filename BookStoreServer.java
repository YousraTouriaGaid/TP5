/*
  * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bookstorermi;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BookStoreServer extends UnicastRemoteObject implements BookFacade{

    
    private List<Book> bookList;
    
    public BookStoreServer(List<Book> bookList) throws RemoteException {
        super();
        this.bookList = bookList;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Registry reg = LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
            
            BookStoreServer store = new BookStoreServer(init());
            
            reg.rebind("rmi://localhost/service", store);
            System.out.println("Server Running...");
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public Book findBook(Book b) throws RemoteException {
        Predicate<Book> predicate = x -> x.getCode().equals(b.getCode());
        Book response = bookList.stream().filter(predicate).findFirst().get();
        return response;
    }

    @Override
    public List<Book> getAllBooks() throws RemoteException {
        return bookList;
    }
    
    private static List<Book> init() {
        List<Book> list = new ArrayList<>();
        list.add(new Book("yago", "A1", 31));
        list.add(new Book("Rami", "A2", 10));
        list.add(new Book("Rami", "A2", 10));
        return list;
    }
    public void addBook(Book newBook) {
        bookList.add(newBook);
    }
    public void removeBook(Book book) {
        bookList.remove(book);
    }
    public void updateBook(Book oldBook, Book newBook) throws RemoteException {
        bookList.remove(oldBook);
        bookList.add(newBook);
    } 
    
	
}
