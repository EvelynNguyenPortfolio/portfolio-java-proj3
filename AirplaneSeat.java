package Project1;
public class AirplaneSeat
{

    //declare and initialize instance variables used in the AirplaneSeat class
    private String passengerName;
    private boolean available;
    private enum seatType {STANDARD, EXTRA_LEGROOM};
    private seatType type;


    //default constructor
    public AirplaneSeat()
    {
        passengerName = "";
        available = true;
        type = seatType.STANDARD;
    }


    //overloaded constructor
    public AirplaneSeat(String passengerName, boolean available, String type)
    {
        this.passengerName = passengerName;
        this.available = available;
        this.type = seatType.valueOf(type);
    }


    //get value of variable passengerName
    public String getPassengerName()
    {
        return passengerName;
    }

    //get value of variable available
    public boolean getAvailable()
    {
        return available;
    }

    //get value of variable type
    public String getType()
    {
        return type.toString();
    }


    //set or change the value of variable passengerName to value of passed argument
    public void setPassengerName(String passengerName)
    {
        this.passengerName = passengerName;
    }

    //set or change the value of variable available to value of passed argument
    public void setAvailable(boolean available)
    {
        this.available = available;
    }

    //set or change the value of variable type to value of passed argument
    public void setType(String type)
    {
        this.type = seatType.valueOf(type);
    }


    //prints out data in object of AirplaneSeat class instead of its memory location
    public String toString()
    {
        //executes code inside if-code block if value of variable available is true
        if(getAvailable() == true)
        {
            //return String stating that the seat is available and the seat type
            return "Available "+ getType();
        }
        //executes code inside else-code block if value of variable available is false
        else
        {
            //return String stating passenger's name and the seat type
            return "Passenger Name: " + passengerName + "\n" + "   Seat Type: " + getType();
        }
    }
}

