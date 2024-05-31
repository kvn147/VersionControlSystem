import java.lang.*;
import java.util.*;

public class Repository {

    private String name;
    private Commit head;

    // You may add more fields

    /**
     * This method will initialize a new empty repository given a name  
     * @param name of repository
     */
    public Repository(String name){
        if (name == null) {
            throw new IllegalArgumentException("Not a Valid Repository Name");
        }
        this.name = name;
        this.head = null;
    }

    /**
     * This method will get the name of repository
     * @return name of repository
     */
    public String getName(){
        return name;
    }

    /**
     * This method will get the head of the repository
     * @return the head toString representation
     */
    public String getRepoHead(){
        return head.message;
    }

    /**
     * This method will get the size of the repository
     * @return the size of repository
     */
    public int getRepoSize(){
        int size = 0;
        Commit current = head;

        while (current != null) {
            size++;
            current = current.past;
        }
        return size;
    }

    /**
     * This method will determine if a target ID is in the repository
     * @param targetID looking for in the repository
     * @return true if found, otherwise false
     */
    public boolean contains(int targetID){
        Commit current = head;

        while(current != null) {
            if (current.id == targetID) {
                return true;
            }
            current = current.past;
        }
        return false;
    }

    /**
     * This method will create a new commit to the repository
     * @param message of the new commmit added
     * @return target ID of it in the repository
     */
    public String commit(String message){
        head = new Commit(message, head);
        return head.message;
    }

    /**
     * This method will remove a commit from the repository
     * @param targetID of the commit to be removed
     * @return true if successfully removed, otherwise false
     */
    public boolean drop(int targetID) {
        // base case
        if (head == null) {
            return false;
        }
        if (head.id == targetID) {
            head = head.past;
            return true;
        }

        // Linked List traversal
        Commit current = head;
        while (current.past != null) {
            if (current.past.id == targetID) {
                // pointer set to after target ID
                current.past = current.past.past;
                return true;
            }
            current = current.past;
        }
        return false;
    }

    /**
     * This method will give the string representation of the 
     * most recent n commits of the repository
     * @param n recent commits to show
     * @return string representation of those commits
     */
    public String getHistory(int n){
        String result = "";
        Commit current = head;
        int count = 0;

        while (current != null && count < n) {
            result += current.toString() + "\n";
            current = current.past;
            count++;
        }
        return result;
    }

    /**
     * This method will make the string representation <name> Current head: <head>
     */
    @Override
    public String toString(){
       String result = name + "\n";

       Commit current = head;
       while (current != null) {
           result += current.toString() + "\n";
           current = current.past;
       }
       return result;
    }
}
