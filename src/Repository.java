

/**
 * TODO: Finish this class.
 */
public class Repository {

    private String name;
    private Commit head;

    // You may add more fields


    //TODO Javadoc and finish
    public Repository(String name){
        if (name == null) {
            throw new IllegalArgumentException("Not a Valid Repo Name");
        }
        Commit<String> name = new LinkedList<String>();
    }

    // TODO Javadoc and finish
    public String getName(){
        return name;
    }

    // TODO Javadoc and finish
    public String getRepoHead(){
        return head.data;
    }

    // TODO Javadoc and finish
    public int getRepoSize(){

        return 1;
    }

    // TODO Javadoc and finish
    public boolean contains(int targetID){

        current = head;
        for (int i = 0; i < size; i++) {
            if (current.data = targetID) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // TODO JavaDoc and finish
    public String commit(String message){

        return "";
    }

    // TODO JavaDoc and finish
    public boolean drop(int targetID) {

        return true;
    }


    // TODO Javadoc and finish
    public String getHistory(int n){

        return "";
    }

    // TODO Javadoc and finish
    @Override
    public String toString(){
       return "";
    }
}
