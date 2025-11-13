/* This is a stub for the Library class */

import java.util.Hashtable;
import java.util.Set;

public class Library extends Building implements LibraryRequirements {
    
  private Hashtable<String, Boolean> collection;
  
  /**
   * Constructor
   */
  public Library() {
    this.collection = new Hashtable<String, Boolean>();
    System.out.println("You have built a library: 📖");
  }

  /**
   * Add a book to collections, defaults as available for check out
   * @param title string, title of the book to be added to collection
   */
  public void addTitle(String title){
    boolean availablity = true;
    this.collection.put(title, availablity);
    System.out.println(this.collection);
  }

  /**
   * Remove a book from collections
   * @param title string, title of book to be removed from collections
   */
  public String removeTitle(String title){
    this.collection.remove(title);
    return title;
  }
    
  /**
   * Updates title to map to boolean false, or checks out the book so it is no longer available
   * @param title string, title of book to be checked out
   */
  public void checkOut(String title){
    boolean status = this.isAvailable(title);
    if(status == true){
      this.collection.replace(title, false);
    }
    if(status == false){
      System.out.println(title+" is already checked out.");
    }
  }

  /**
   * Updates title to map to boolean true, or returns  the book so it is available
   * @title string, title of book to be returned out
   */
  public void returnBook(String title){
    boolean status = this.isAvailable(title);
    if(status == false){
      this.collection.replace(title, true);
    }else{
      System.out.println(title+" is not checked out.");
    }
  } 

  /**
   * 
   */
  public boolean containsTitle(String title){
    return this.collection.containsKey(title);
  }

  /**
   * 
   */
  public boolean isAvailable(String title){
    if (this.containsTitle(title) == true){
      boolean status = this.collection.get(title);
      return status;
    }else{
      return false;
    }
  }

  /**
   * 
   */
  public void printCollection(){
    // for key in keys
    Set<String> keys = this.collection.keySet();
      for(String key: keys){
      boolean value = collection.get(key);
      if(value == true){
        System.out.println(key+" is available.");
      }else{
        System.out.println(key+" is checked out.");
      }
    }
  }

  public static void main(String[] args) {
    Library neilson = new Library();
    neilson.addTitle("Dr. Seuss");
    neilson.addTitle("Harry Potter");
    neilson.checkOut("Dr. Seuss");
    // neilson.removeTitle("Dr. Seuss");
    // System.out.println(neilson.containsTitle("Dr. Seuss"));
    // System.out.println(neilson.isAvailable("Dr. Seuss"));
    neilson.printCollection();
  }
  
}