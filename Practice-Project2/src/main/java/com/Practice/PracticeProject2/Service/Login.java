package com.Practice.PracticeProject2.Service;

import com.Practice.PracticeProject2.Repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import java.security.Principal;
import java.util.List;

/**
 * The purpose of this class Login is to get user information login and ticket information. These methods are called
 * inside a controller
 */
@Service
public class Login
{
    /**
     * This field is needed to call ticketRepository methods
     */
    @Autowired
    TicketRepository ticketRepository;

    /**
     * The purpose of this method loggInUser(Principal principal, UserDetailsService userDetailsService) is to display
     * the username of the logged-in user. It will return a String which will be caught by the Fetch API
     * @param principal
     * @param userDetailsService
     * @return String
     */
    public String loggInUser(Principal principal, UserDetailsService userDetailsService)
    {
        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());

        if (userDetails != null)
        {
            System.out.println("Andre the current user is " + userDetails.getUsername());
            return userDetails.getUsername();
        }
        else
        {
            System.out.println("No current user");
            return "No Current User";
        }

    }

    /**
     * The purpose of this method currentUserInfo(Principal principal, UserDetailsService userDetailsService) is to display
     * all user information on the home.html web page. It will return a String which will be caught by the Fetch API
     *
     * @param principal
     * @param userDetailsService
     * @return
     */
    public String currentUserInfo(Principal principal, UserDetailsService userDetailsService)
    {
        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
        if (userDetails != null)
        {
            return userDetails.toString();
        }
        else
        {
            return "No Current User";
        }
    }

    /**
     * The purpose of this method AllMyTickets(int id, TicketRepository ticketRepository) is to display all tickets of a
     * particular user. It is called inside a controller. It returns a list of Strings which is caught by the
     * Fetch API
     * @param id
     * @param ticketRepository
     * @return List<String>
     */
    public List<String> AllMyTickets(int id, TicketRepository ticketRepository)
    {
        this.ticketRepository = ticketRepository;
        List<String> myTickets = ticketRepository.findAllByEmployeeID(id);
        if(myTickets.isEmpty())
        {
            System.out.println("Did not find any Tickets for given empoyeeid");
            System.exit(0);
        }
        System.out.println("My Tickets: " + myTickets.toString());
        return myTickets;
    }

}
