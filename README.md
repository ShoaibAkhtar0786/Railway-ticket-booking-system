# IRCTC Railway Ticket Booking System A console-based Java application designed to 
simulate basic core functionalities of a train reservation platform like IRCTC. This project 
features user authentication, train searching, ticket booking, ticket cancellation, and booking 
history tracking using Object-Oriented Programming (OOP) concepts. --- ## 


 Features * 
**User Authentication**: * New User Registration (Username, Password, Full Name, Contact 
Info) * User Login and Session Management * Secure Logout mechanism * **Train 
Management**: *
Search trains by **Source** and **Destination** stations * Display train details 
including Train ID, Name, Route, and Available Seats * List all available trains on the platform * 
**Booking & Tickets**: * Book seats on available trains * Instant ticket generation upon 
successful booking * Real-time update of remaining train seat counts * View all active/booked 
tickets associated with the logged-in user * Cancel booked tickets with dynamic seat count 
restoration --- 


 Project Architecture & File Structure The project follows a modular 
structure separated into services and model classes: ```text ├── IRCTCAPP.java # Main entry 
point with interactive CLI menu ├── UserService.java # Logic for user registration, 
authentication, & session state ├── BookingService.java # Core business logic for train search, 
booking, and cancellation ├── User.java # Model representing system users ├── Train.java # 
Model representing train details and seat capacity └── Ticket.java # Model representing a 
booked ticket entity  
└── Ticket.java          
# Model representing a booked ticket entity 




Technical Stack 
● Language: Java (JDK 17+) 
● Data Structures: Java Collections Framework (ArrayList, Iterator) 
● I/O: Standard console scanner interface (java.util.Scanner) 



Sample App Workflow 
1. Start the application and select 1. Register to create an account. 
2. Log in using 2. Login with your credentials. 
3. Access the User Menu to: 
○ Option 1: Search trains between two cities (e.g., Delhi to Nagpur). 
○ Option 2: Book desired seats using the Train ID. 
○ Option 3: Check your booked tickets. 
○ Option 4: Cancel a ticket using your Ticket ID.
