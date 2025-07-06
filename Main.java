
import java.util.Scanner;
import java.util.List;

public class Main{
    
    static Scanner myS = new Scanner(System.in);

    public static void main(String[] args){
    
    
        System.out.println("Welcome! Please enter the name of the station:");
        String nameStation = myS.nextLine();

        System.out.println("How many trains can the station hold? ");
        int capacityS = myS.nextInt();   
        myS.nextLine();     
    
        System.out.println("Your station name is "+nameStation+" and can hold "+capacityS+" trains");
        
        //create a station queue object based on the name and capacity entered by the user.
        StationQ myStation = new StationQ(nameStation, capacityS);
    

        
        while(true){
            
            //main menu logic
            int userChoice = 99;
            List<Integer> choices = List.of(1,2,3,4,5,6);
            while(!choices.contains(userChoice)){
                System.out.println("\nPlease select: "
                                    +"\n1 - Let a new train enter the station"
                                    +"\n2 - Give the green light to the first train in the queue"
                                    +"\n3 - View the front of the queue"
                                    +"\n4 - Return number of trains currently at the station"
                                    +"\n5 - Let passengers embark the train at the front"
                                    +"\n6 - Quit");            
                userChoice = myS.nextInt();
                myS.nextLine(); 
            }
            if(userChoice==1){
                addTrain(myStation);
            }
            else if(userChoice==2){
                if(!myStation.isEmpty()){
                    if(myStation.getFront().getMechanicalissues()){
                        System.out.println("It seems that the Train has a technical problem. Do you want to repair it? [Y/N]: ");
                        char choice = myS.next().toLowerCase().charAt(0);
                        if(choice=='y'){
                            myStation.getFront().fixMechanicalissues();
                            System.out.println("The train has been repaired!\nPress enter to continue..."); 
                        }else{
                            System.out.println("The train has not been repaired....\nPress enter to return to the main menu");
                        }
                        myS.nextLine();
                    }else{
                        myStation.dequeue();
                        System.out.println("A train has just left the station!\nPress enter to continue... ");
                    }
                }
                else{
                    System.out.println("There are no trains at the station...");
                }
            }
            else if(userChoice==3){
                if(!myStation.isEmpty()){
                    System.out.println("Next train scheduled for departure:\n"+myStation.getFront());
                }
                else{
                    System.out.println("No departures are scheduled at the moment...");
                }
                
            }
            else if(userChoice==4){
                System.out.println("Trains currently at the station: "+myStation.getTotTrains());
            }
            else if(userChoice==5){
                if(!myStation.isEmpty()){
                    System.out.println("There are currently "+myStation.getFront().getPeople()+" passengers on the train.\nHow passengers do you want to let in? ");
                    int numberPass = myS.nextInt();
                    myS.nextLine(); 
                    myStation.embarkPassengers(numberPass);
                }
                else{
                    System.out.println("There are no trains at the platform...");
                }
                
            }             
            else if(userChoice==6){
                System.out.println("...exiting");
                break;
            }
            myS.nextLine();           
            
        }
    }
    
    
    public static void addTrain(StationQ myStation){
        System.out.println("What's the train model?\n-DART8100\n-DART8500\n-IE22000\n-XTRAPOLIS\n");
        String model = myS.nextLine().toUpperCase();
        
        Train TrainObject = new Train(model);
        
        myStation.enqueue(TrainObject);
        
    }
}
