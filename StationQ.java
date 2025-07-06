public class StationQ<T extends Train> {
    
    //variables
	Node<Train> head;
	Node<Train> tail;

    String nameStation;
    int capacityS;
	
	
	//constructor
	public StationQ(String nameStation, int capacityS){
		head = null;
		tail = null;
		
        this.nameStation = nameStation;
        this.capacityS = capacityS;
	}

    //add a new train object to the queue
	public void enqueue(Train theTrain){
	    if(getTotTrains()<capacityS){
		    Node<Train> myNode = new Node(theTrain);
		    Node oldTail = tail;
		    //if the queue is empty, the new train becomes the new head AND the new tail
		    if (head == null){
			    head = myNode;
			    tail = head;
			    
		    }else{
		        //otherwise we just add to the queue, but we need the old tail to point at the new one
			    oldTail.next = myNode;
			    tail = myNode;
		    }   
		    System.out.println("New train created! Press enter to continue"); 
	    }
	    else{
	        System.out.println("We can't add a new train. The station at the moment is full.\nPress enter to return to the main menu");
	    }
	}
    
    //to remove from the queue (FIFO)
	public void dequeue(){
	    //if the queue is not empty
		if(!isEmpty()){
		    //we change the reference of the head element (front of the queue)
			head = head.next;
		}
	}
	
	public boolean isEmpty(){
	    return head == null;
	}

	public String printQueue(){
		String myResult= "";
		if(head==null){
		}else{
			Node<Train> iterationNode = head;
			while(iterationNode!=null){
				myResult += iterationNode.theTrain+"\n";
				iterationNode = iterationNode.next;
			}
		}
		return myResult;
	}
	
	//return object at the front
	public Train getFront(){
	    return head.theTrain;
	}
	
	//to return the number of objects in the queue
	public int getTotTrains(){
		if(head==null){
			return 0;
		}else{
		    //we start from 1 because we know for sure that the head is not null
		    int result = 1;
		    //then we create a temporary object to iterate throught the queue
		    Node<Train> current = head;
		    //and while we have a next element...
		    while(current.next!=null){
		        //...we continue the iteration and we increase the counter
		        current = current.next;
		        result++;
		    }
		    return result;
		}
	}
	
	//to embarka passengers we need to access the addPeople method in the Train.java file
	public void embarkPassengers(int passengers){
	    Train updatedTrain = head.theTrain;
	    updatedTrain.addPeople(passengers);
	}
}






