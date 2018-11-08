/*  
    David Peacock / SN8583
    CS-401 Software Engineering
    Due: Fri 9 Nov 2018 @ 11:59 PM
    HW_5
*/

package ticket2rideview;

public class Ticket
{
    String origin_destination;
    int points;
    
    // Default Constructor
    Ticket()
    {   origin_destination = "SanFrancisco_LosAngeles";
        points = 4; }
   
    // Constructor w/1 argument
    Ticket(String orig_des)
    {
        origin_destination = orig_des;

        if(orig_des == "Salt Lake City")
            points = 1;
        else if(orig_des == "Portland")
            points = 1;
        else if(orig_des == "Los Angeles")
            points = 1;          
    }

    // Setter
    public void setOrigin_Destination(String orig_des)
    {   origin_destination = orig_des;  }

    public String getOrigin_Destination()
    {   return origin_destination;  }
    
    public int getPoints()
    {   return points;  }
}
