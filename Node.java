public class Node<Train>{
    public Train theTrain;
    public Node<Train> prev;
    public Node<Train> next;
 
    public Node(Train theTrain){
        this.theTrain = theTrain;
        this.prev = null;
        this.next = null; 
       
    }
    
    public Train getTrain(){
        return theTrain;
    }

}
