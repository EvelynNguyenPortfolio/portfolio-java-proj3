import java.util.InputMismatchException;
import java.util.Scanner;
public class Driver
{
    public static void main (String[] args)
    {
        //declare Scanner object
        Scanner scan = new Scanner(System.in);

        //declare and initialize AirplaneSeat objects
        AirplaneSeat oneA = new AirplaneSeat("Abigail Jones", false, "EXTRA_LEGROOM");
        AirplaneSeat oneB = new AirplaneSeat("Daniel Jones", false, "EXTRA_LEGROOM");
        AirplaneSeat oneC = new AirplaneSeat();
        AirplaneSeat twoA = new AirplaneSeat("Sally McConnell", false, "STANDARD");
        AirplaneSeat twoB = new AirplaneSeat();
        AirplaneSeat twoC = new AirplaneSeat();
        AirplaneSeat threeA = new AirplaneSeat("Joseph Rogers", false, "STANDARD");
        AirplaneSeat threeB = new AirplaneSeat();
        AirplaneSeat threeC = new AirplaneSeat("Vincent Potters", false, "EXTRA_LEGROOM");
        AirplaneSeat fourA = new AirplaneSeat("Elizabeth Stone", false, "STANDARD");
        AirplaneSeat fourB = new AirplaneSeat();
        AirplaneSeat fourC = new AirplaneSeat();

        //declare and initialize 2D array
        AirplaneSeat[][] planeSeats = {{oneA, oneB, oneC},
                                        {twoA, twoB, twoC},
                                        {threeA, threeB, threeC},
                                        {fourA, fourB, fourC}};

        //declare and initialize 2D array with elements containing seat names
        String[][] seatNames = {{"1A", "1B", "1C"},
                                {"2A", "2B", "2C"},
                                {"3A", "3B", "3C"},
                                {"4A", "4B" ,"4C"}};

        //declare and initialize variable exit
        boolean exit = false;

        //output the menu for the program
        do {
            //print Strings explaining menu
            System.out.println("1 - Print Current Seat Status");
            System.out.println("2 - Print Current Passenger List");
            System.out.println("3 - Reserve Seat");
            System.out.println("4 - Find Passenger");
            System.out.println("5 - Exit");

            //try if user inputs an integer
            try
            {
                //assign value of user's input to variable input
                int input = scan.nextInt();

                //execute code in if-block if value of variable input is 1
                if(input == 1)
                {
                    //execute seatStatus method
                    seatStatus(planeSeats, seatNames);
                }
                //execute code in else if-block if value of variable input is 2
                else if (input == 2)
                {
                    //execute passengerList method
                    passengerList(planeSeats, seatNames);
                }
                //execute code in else if-block if value of variable input is 3
                else if (input == 3)
                {
                   //execute selectSeat method
                   selectSeat(planeSeats, seatNames);
                }
                //execute code in else if-block if value of variable input is 4
                else if (input ==4)
                {
                    //execute and print findPassenger method
                    System.out.println(findPassenger(planeSeats, seatNames));
                }
                //execute code in else if-block if value of variable input is 5
                else if (input == 5)
                {
                   //assign value true to variable exit
                   exit = true;
                }
                //execute code in else-block if user enters an input that is NOT any of the integers from 1 to 5
                else
                {
                    //print String explaining that error occurred
                    System.out.println("Error occurred! Please try again.");
                }
            }
            //catch if value of variable input is not an integer
            catch(InputMismatchException e)
            {
                scan.nextLine();

                //print String explaining that error occurred
                System.out.println("Error occurred! Please try again.");
            }

            //print empty line
            System.out.println();
        }
        //repeat do while loop if variable exit is false
        while(exit == false);
    }


    //execute seatStatus method
    public static void seatStatus(AirplaneSeat[][] planeSeats, String[][] seatNames)
    {
        //loop through rows in array planeSeats
        for(int row = 0; row < planeSeats.length; row++)
        {
            //loop through columns in array planeSeats
            for(int column = 0; column < planeSeats[row].length; column++)
            {
                //executes code inside if-code block if getAvailable() for AirPlaneSeat object returns true
                if(planeSeats[row][column].getAvailable() == true)
                {
                    //print seatName element and the character "A"
                    System.out.print(seatNames[row][column] + " A" + "     ");
                }
                //executes code inside else-block if getAvailable() for AirPlaneSeat object does NOT return true
                else
                {
                    //print seatName element and the character "X"
                    System.out.print(seatNames[row][column] + " X" + "     ");
                }
            }

            //print empty line
            System.out.println();
        }
    }


    //execute passengerList method
    public static void passengerList(AirplaneSeat[][] planeSeats, String[][] seatNames)
    {
        //loop through rows in array planeSeats
        for(int row = 0; row < planeSeats.length; row++)
        {
            //loop through columns in array planeSeats
            for(int column = 0; column < planeSeats[row].length; column++)
            {
                //executes code inside if-code block if getAvailable() AirPlaneSeat object does NOT return true
                if(planeSeats[row][column].getAvailable() != true)
                {
                    //print seatName element and AirPlaneSeat object
                    System.out.println(seatNames[row][column] + " " + planeSeats[row][column].toString());
                }
            }
        }
    }


    //execute selectSeat method
    public static boolean selectSeat(AirplaneSeat[][] planeSeats, String[][] seatNames)
    {
        //declare boolean repeat
        boolean repeat;

        //declare and initialize boolean seatReservation
        boolean seatReservation = false;

        //execute code in do while loop
        do {
            //assign value false to variable repeat
            repeat = false;

            //declare Scanner object
            Scanner scan = new Scanner(System.in);

            //print String introducing method
            System.out.println("Let's reserve a seat!");

            //print String asking user to enter his/her name
            System.out.println("Please enter your name.");

            //assign value of user's input to variable userName
            String userName = scan.nextLine();

            //print String asking user to enter the row he/she would like to sit in
            System.out.println("Please enter the row you would like to sit in.");

            //assign value of user's input to variable selectedRow
            String selectedRow = scan.next();

            //print String asking user to enter a seat for reservation
            System.out.println("Please enter the seat you would like to reserve.");

            //assign value of user's input to variable selectedSeat
            String selectedSeat = scan.next();

            //print String asking user to enter which seat type he/she wants
            System.out.println("Please enter the seat type you want.");

            //assign value of user's input to variable seatType
            String seatType = scan.next();

            //loop through rows in array planeSeats
            for (int row = 0; row < planeSeats.length; row++)
            {
                //loop through columns in array planeSeats
                for (int column = 0; column < planeSeats[row].length; column++)
                {
                    //executes code inside if-code block if seatName element equals the combined values of variables selectedRow and selectedSeat
                    if (seatNames[row][column].equalsIgnoreCase(selectedRow + selectedSeat))
                    {
                        //executes code inside if-code block if getAvailable() for AirPlaneSeat object returns true
                        if (planeSeats[row][column].getAvailable() == true)
                        {
                            //set or change value of AirPlaneSeat object's variable passengerName to value of variable userName
                            planeSeats[row][column].setPassengerName(userName);

                            //set or change value of AirPlaneSeat object's variable available to false
                            planeSeats[row][column].setAvailable(false);

                            //set or change value of AirPlaneSeat object's variable type to value of variable seatType
                            planeSeats[row][column].setType(seatType.toUpperCase());

                            //print String confirming that seat has been reserved
                            System.out.println("Success! Seat: " + selectedRow + selectedSeat + " has been reserved.");

                            //assign value true to variable seatReservation
                            seatReservation = true;
                        }
                        //executes code inside if-code block if getAvailable() for AirPlaneSeat object does NOT return true
                        else
                        {
                            //assign value true to variable repeat
                            repeat = true;

                            //print String explaining that error occurred
                            System.out.println("Error! Seat is unavailable.");

                            //print empty line
                            System.out.println();
                        }
                    }
                }
            }
        }
        //repeat do while loop if value of variable repeat is true
        while (repeat);

        //return value of seatReservation
        return seatReservation;
    }


    //execute findPassenger method
    public static String findPassenger(AirplaneSeat[][] planeSeats, String[][] seatNames)
    {
        //declare Scanner object
        Scanner scan = new Scanner(System.in);

        //declare and initialize boolean passengerPresent
        boolean passengerPresent = false;

        //declare and initialize variables to assign passenger's information to
        String passengerName = "";
        String seatNumber = "";
        String seatType = "";

        //print String asking user to enter the name of the passenger they want to look up
        System.out.println("Please enter the name of the passenger you want to find");

        //assign value of user's input to variable passenger
        String passenger = scan.nextLine();

        //loop through rows in array planeSeats
        for (int row = 0; row < planeSeats.length; row++)
        {
            //loop through columns in array planeSeats
            for (int column = 0; column < planeSeats[row].length; column++)
            {
                //executes code inside if-code block if getPassengerName for AirPlaneSeat object equals variable passenger
                if (planeSeats[row][column].getPassengerName().equals(passenger))
                {
                    //assign value true to variable passengerPresent
                    passengerPresent = true;

                    //assign value of AirPlaneSeat object's variable name to variable passengerName
                    passengerName =  planeSeats[row][column].getPassengerName();

                    //assign value of array seatName's element to variable seatNumber
                    seatNumber =  seatNames[row][column];

                    //assign value of AirPlaneSeat object's variable type to variable seatType
                    seatType = planeSeats[row][column].getType();
                }
            }
        }

        //executes code inside if-code block if value of variable passengerPresent is false
        if (passengerPresent == false)
        {
            //return String stating that passenger does not exist
            return "Passenger does not exist";
        }
        //executes code inside if-code block if value of variable passengerPresent is true
        else
        {
            //return String stating passenger's information
            return "Passenger: " + passengerName +
                    "\n" + "Seat Number: " + seatNumber +
                    "\n" + "Seat Type: " + seatType;
        }
    }
}
