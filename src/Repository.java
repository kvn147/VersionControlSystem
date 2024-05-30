

/**
 * TODO: Finish this class.
 */
public class Repository {

    private String name;
    private Commit head;

    // You may add more fields


    //TODO Javadoc and finish
    /**
     * This method will initialize a new empty repository given a name  
     * @param name of repository
     */
    public Repository(String name){
        if (name == null) {
            throw new IllegalArgumentException("Not a Valid Repository Name");
        }
        Commit<String> name = new LinkedList<>();
    }
s
    // TODO Javadoc and finish
    /**
     * This method will get the name of repository
     * @return name of repository
     */
    public String getName(){
        return name;
    }

    // TODO Javadoc and finish
    /**
     * This method will get the head of the repository
     * @return the head toString representation
     */
    public String getRepoHead(){
        return head.message;
    }

    // TODO Javadoc and finish
    /**
     * This method will get the size of the repository
     * @return the size of repository
     */
    public int getRepoSize(){

        return Commit.size;
    }

    // TODO Javadoc and finish
    /**
     * This method will determine if a target ID is in the repository
     * @param targetID looking for in the repository
     * @return true if found, otherwise false
     */
    public boolean contains(int targetID){

        Commit current = head;
        for (int i = 0; i < size; i++) {
            if (current.id == targetID) {
                return true;
            }
            current = current.past;
        }
        return false;
    }

    // TODO JavaDoc and finish
    /**
     * This method will create a new commit to the repository
     * @param message of the new commmit added
     * @return target ID of it in the repository
     */
    public String commit(String message){

        return "";
    }

    // TODO JavaDoc and finish
    /**
     * This method will remove a commit from the repository
     * @param targetID of the commit to be removed
     * @return true if successfully removed, otherwise false
     */
    public boolean drop(int targetID) {
        
        // check that the targetID exists in repo
        if(contains(targetID) == true)) {
            // continue
            Commit current = head;
            for (int i = 0; i < size; i++) {
                current = current.past;
            }
        }
        else {
            return false;
        }
  
    }


    // TODO Javadoc and finish
    /**
     * This method will give the string representation of the 
     * most recent n commits of the repository
     * @param n recent commits to show
     * @return string representation of those commits
     */
    public String getHistory(int n){

        return "";
    }

    // TODO Javadoc and finish
    /**
     * This method will make the string representation
     */
    @Override
    public String toString(){
       return "";
    }
}
