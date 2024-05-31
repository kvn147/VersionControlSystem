import java.lang.*;
import java.util.*;

/**
 * This class will create a repository as a linked list where you can:
 * insert, remove, find, history list commits
 * @author Kevin Nguyen
 */
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
        if (head == null) {
            return "No commits";
        }
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

/*
Output from Client:
Welcome to the Mini-Git client program
Use this program to test your Mini-Git repository methods.

Available repositories:
Operations: [create, head, history, commit, contains, drop, quit]
Enter operation and repository: create repo1
  New repository created: repo1


Available repositories:
	repo1

Operations: [create, head, history, commit, contains, drop, quit]
Enter operation and repository: commit repo1
Enter commit message: First commit!
  New commit: First commit!

Available repositories:
	repo1
0 at 2024-05-30 19:05:17 PDT: First commit!

Operations: [create, head, history, commit, contains, drop, quit]
Enter operation and repository: commit repo1
Enter commit message: Another commit.
  New commit: Another commit.

Available repositories:
	repo1
1 at 2024-05-30 19:05:28 PDT: Another commit.
0 at 2024-05-30 19:05:17 PDT: First commit!

Operations: [create, head, history, commit, contains, drop, quit]
Enter operation and repository: history repo1
How many commits back? 2
1 at 2024-05-30 19:05:28 PDT: Another commit.
0 at 2024-05-30 19:05:17 PDT: First commit!


Available repositories:
	repo1
1 at 2024-05-30 19:05:28 PDT: Another commit.
0 at 2024-05-30 19:05:17 PDT: First commit!

Operations: [create, head, history, commit, contains, drop, quit]
Enter operation and repository: create repo2
  New repository created: repo2


Available repositories:
	repo2

	repo1
1 at 2024-05-30 19:05:28 PDT: Another commit.
0 at 2024-05-30 19:05:17 PDT: First commit!

Operations: [create, head, history, commit, contains, drop, quit]
Enter operation and repository: commit repo2
Enter commit message: Commit the third
  New commit: Commit the third

Available repositories:
	repo2
2 at 2024-05-30 19:06:02 PDT: Commit the third

	repo1
1 at 2024-05-30 19:05:28 PDT: Another commit.
0 at 2024-05-30 19:05:17 PDT: First commit!

Operations: [create, head, history, commit, contains, drop, quit]
Enter operation and repository: commit repo1
Enter commit message: Fourth commit
  New commit: Fourth commit

Available repositories:
	repo2
2 at 2024-05-30 19:06:02 PDT: Commit the third

	repo1
3 at 2024-05-30 19:06:15 PDT: Fourth commit
1 at 2024-05-30 19:05:28 PDT: Another commit.
0 at 2024-05-30 19:05:17 PDT: First commit!

Operations: [create, head, history, commit, contains, drop, quit]
Enter operation and repository: history repo1
How many commits back? 4
3 at 2024-05-30 19:06:15 PDT: Fourth commit
1 at 2024-05-30 19:05:28 PDT: Another commit.
0 at 2024-05-30 19:05:17 PDT: First commit!


Available repositories:
	repo2
2 at 2024-05-30 19:06:02 PDT: Commit the third

	repo1
3 at 2024-05-30 19:06:15 PDT: Fourth commit
1 at 2024-05-30 19:05:28 PDT: Another commit.
0 at 2024-05-30 19:05:17 PDT: First commit!

Operations: [create, head, history, commit, contains, drop, quit]
Enter operation and repository: head repo1
Fourth commit

Available repositories:
	repo2
2 at 2024-05-30 19:06:02 PDT: Commit the third

	repo1
3 at 2024-05-30 19:06:15 PDT: Fourth commit
1 at 2024-05-30 19:05:28 PDT: Another commit.
0 at 2024-05-30 19:05:17 PDT: First commit!

Operations: [create, head, history, commit, contains, drop, quit]
Enter operation and repository: commit repo1
Enter commit message: one more commit
  New commit: one more commit

Available repositories:
	repo2
2 at 2024-05-30 19:06:02 PDT: Commit the third

	repo1
4 at 2024-05-30 19:06:39 PDT: one more commit
3 at 2024-05-30 19:06:15 PDT: Fourth commit
1 at 2024-05-30 19:05:28 PDT: Another commit.
0 at 2024-05-30 19:05:17 PDT: First commit!

Operations: [create, head, history, commit, contains, drop, quit]
Enter operation and repository: contains repo1
Which id do you want to check? 3
	Id:3 is in repo1

Available repositories:
	repo2
2 at 2024-05-30 19:06:02 PDT: Commit the third

	repo1
4 at 2024-05-30 19:06:39 PDT: one more commit
3 at 2024-05-30 19:06:15 PDT: Fourth commit
1 at 2024-05-30 19:05:28 PDT: Another commit.
0 at 2024-05-30 19:05:17 PDT: First commit!

Operations: [create, head, history, commit, contains, drop, quit]
Enter operation and repository: drop repo1
Enter ID to drop: 3
  Successfully dropped 3

Available repositories:
	repo2
2 at 2024-05-30 19:06:02 PDT: Commit the third

	repo1
4 at 2024-05-30 19:06:39 PDT: one more commit
1 at 2024-05-30 19:05:28 PDT: Another commit.
0 at 2024-05-30 19:05:17 PDT: First commit!

Operations: [create, head, history, commit, contains, drop, quit]
Enter operation and repository: history repo1
How many commits back? 3
4 at 2024-05-30 19:06:39 PDT: one more commit
1 at 2024-05-30 19:05:28 PDT: Another commit.
0 at 2024-05-30 19:05:17 PDT: First commit!


Available repositories:
	repo2
2 at 2024-05-30 19:06:02 PDT: Commit the third

	repo1
4 at 2024-05-30 19:06:39 PDT: one more commit
1 at 2024-05-30 19:05:28 PDT: Another commit.
0 at 2024-05-30 19:05:17 PDT: First commit!

Operations: [create, head, history, commit, contains, drop, quit]
 */