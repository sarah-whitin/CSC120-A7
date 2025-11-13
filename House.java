/* This is a stub for the House class */

import java.util.ArrayList;

public class House extends Building implements HouseRequirements{
  private ArrayList<Student> residents;
  // The <Student> tells Java what kind of data we plan to store IN the ArrayList
  private boolean hasDiningRoom;

  /**
   * Constructor 
   * @param d boolean, if the house has a dining room or not
   */
  public House(boolean d) {
    this.residents = new ArrayList<Student>();
    this.hasDiningRoom = d;
    System.out.println("You have built a house: 🏠");
  }
  
  /**
   * Find if house has dining room
   * @return boolean, if the house has a dining room or not
   */
  public boolean hasDiningRoom(){
    return this.hasDiningRoom;
  }
  
  /**
   * Get the number of residents in the house
   * @return number of residents 
   */
  public int nResidents(){
    return this.residents.size();
  }
  
  /**
   * Move in a student, or add them to the ArrayList of students
   * @param s the student moving in
   */
  public void moveIn(Student s){
    this.residents.add(s);
  }
  
  /**
   * Move out a student, or remove them from the ArrayList of students
   * @param s the student moving out
   * @return the student moving out
   */
  public Student moveOut(Student s){
    this.residents.remove(s);
    return s;
  }
  
  /**
   * see if student lives in house
   * @param s student to find resident status of
   * @return if student is a resident
   */
  public boolean isResident(Student s){
    boolean livesHere = this.residents.contains(s);
    return livesHere;
  }

  public static void main(String[] args) {
    new House(true);
  }

}