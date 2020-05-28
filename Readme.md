# CodeClan Towers
Practice on Java classes, arraylist and Hashmaps with TDD
# Brief

You are being asked to build a booking system for the new CodeClan Towers hotel.

Use TDD in Junit to model the Hotel with Java classes, with separate test files for each class.

MVP
- Create a Guest class to represent a visitor to the hotel, they’ll at least need a name, you can add more properties later if and when they become necessary
 
- Create 2 different types of rooms:

     Bedrooms will have a room number, capacity, collection of Guests and a type (e.g. Single/Double.)
    
     ConferenceRooms will have a capacity, collection of Guests, name and any other properties you wish.

- Create a Hotel class, which has collections of rooms of different types.
- The Hotel will be able check guests in/out of rooms.

** Extensions **

- Create a Booking class which contains a Bedroom and a number of nights booked.
- Create a bookRoom method in your Hotel. This should book a given Bedroom for a number of nights. This should return a new Booking object.
- Add a nightly rate to your Bedrooms and write a method to return the total bill for the Booking.
- Add a DiningRoom class with a name, and collection of guests
- Hotel will have a HashMap based collection of DiningRooms.

** Advanced Extensions **
- Add functionality to the Hotel so it can return a collection of only the vacant Bedrooms.
- Update the check-in process so that Hotel will only be able to check guests into empty Bedrooms.
- Any other extensions you can think of!