/*
   Filename: repaymentScript.js
   Author:   Andre Long
   Date:     2/20/2024
   Description: The purpose of this Javascript file is to display all tickets
   for a single employee
*/

window.onload = start();

function start()
{
	ether();
}

function ether()
{
   const welcomeDiv = document.getElementById('welcome');
   const userInfoDiv = document.getElementById('userInfo');
   const reimbursementDiv = document.getElementById('MyReimbursements');


    fetch('http://localhost:8080/user/loggInUser')
      .then(response => response.text())
      .then(text => {
          welcomeDiv.innerHTML = "<h2 id='welcomeMessage'>Welcome  " + text + "</h2>" +
          "<form id='andrelogout' method='post' action='/logout.html'>" +
          "<input type='submit' value='Sign Out'>" +
          "</form>";
      });


    fetch('http://localhost:8080/user/currentUserInfo')
          .then(response => response.text())
          .then(text => {
              userInfoDiv.innerHTML = "<h4 id='userInfoMessage'>  " + text + "</h4>";
          });

    fetch('http://localhost:8080/user/displayMyTickets')
              .then(response => response.text())
              .then(text => {
                              let billy = JSON.parse(text);
                              let lengthBilly = billy.length;
                              let info = " ";

                              for(let j = 0; j < lengthBilly; j++)
                              {
                                      data = billy[j]; //Controls which ticket to display
                                      oneTicketArray = data.split(",");
                                      for(let i = 0; i < 1; i++)
                                      {

                                            info += "<tr class = 'suckerFish'>" +
                                            "<td class='sonOfSuckerFish'>" + oneTicketArray[i]   + "</td>" +
                                            "<td class='sonOfSuckerFish'>" + oneTicketArray[i+1] + "</td>" +
                                            "<td class='sonOfSuckerFish'>" + oneTicketArray[i+2] + "</td>" +
                                            "<td class='sonOfSuckerFish'>" + oneTicketArray[i+3] + "</td>" +
                                            "<td class='sonOfSuckerFish'>" + oneTicketArray[i+4] + "</td>" +
                                            "<td class='sonOfSuckerFish'>" + oneTicketArray[i+5] + "</td>" +
                                            "<td class='sonOfSuckerFish'>" + oneTicketArray[i+6] + "</td>" +
                                            "<td class='sonOfSuckerFish'>" + oneTicketArray[i+7] + "</td></tr>";

                                      }
                              }
                               let Outer = "<table id ='AndreTable'><tr>" +
                                           "<th id='ticketid'>Ticket Number</th><th id='description'>Ticket Description</th>" +
                                           "<th id='ticketstatus'>Ticket Status</th><th id='amount'>Reimbursement Amount</th>" +
                                           "<th id='datesubmitted'>Date Submitted </th><th id='dateresolved'>Date Resolved</th>" +
                                           "<th id='reimbursementtype'>Reimbursement Type </th><th id='employeeid'> Employee ID</th></tr>";

                               reimbursementDiv.innerHTML = Outer + info + "</table>";


            });



}







