public class Train{
    //variables
    String model;
    int capacity;
    int peopleOnBoard;
    boolean mechanicalissues;
    
    //constructor
    public Train(String model){
        this.model= model;
        //we assign the capacity of the train based on the model name
        switch(this.model){
            case "DART8100":
                this.capacity = 320;
                break;
            case "DART8500":
                this.capacity = 220;
                break;
            case "IE22000":
                this.capacity = 260;
                break;
            case "XTRAPOLIS":
                this.capacity = 550;
                break;
            default:
                this.capacity = 200;
        }
        this.peopleOnBoard = 0;
        
        // the mechanical issues are assigned randomly when the object is spawned 
        int myRand = (int)(Math.random()*10);
        //System.out.println(myRand);
        if(myRand>7){
            this.mechanicalissues = true;
        }
        else{
            this.mechanicalissues = false;
        }
    }
    
    
    public void addPeople(int people){
        int totalPeople = people + peopleOnBoard;
        
        if(totalPeople>capacity){
            System.out.println("\nIt's not possible to embark that many people. Operation cancelled");
        }
        else{
            peopleOnBoard = totalPeople;
            System.out.println(people+" passengers just got on the train");
        }
    }
    
    
    public void fixMechanicalissues(){
        mechanicalissues=false;
    }

    public boolean getMechanicalissues(){
        return mechanicalissues;
    }    
    
    
    public int getPeople(){
        return peopleOnBoard;
    }
    
    public int getCapacity(){
        return capacity;
    }
    
    
    public String toString(){
        return model + ". Seats occupied: " + peopleOnBoard  + "/" + capacity + ". Does it have mechanical issues? "+ mechanicalissues;  
    }




}
