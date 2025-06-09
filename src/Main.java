

import java.sql.*;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static final String URL="jdbc:mysql://localhost:3306/xyzbusez";
    public static final String username="root";
    public static final String password="Root";
    public static void main(String[]args){
    Scanner sc=new Scanner(System.in);
    System.out.println("Menu: ");
    System.out.println("1.Operator Portal: ");
    System.out.println("2.Customer Portal: ");
    System.out.print("Enter 1/2: ");
    int a=sc.nextInt();
    sc.nextLine();
    switch(a){
        case 1:{
            Operator();
            break;
        } case 2:{
            Passenger();
            break;
        }
        default:System.out.println("Wrong choice Entered! Sorry");
    }
    sc.close();
    }
    static void Operator() {
        Scanner scanner = new Scanner(System.in);
        String cont;
        do {
            System.out.println("Welcome to the Operator Portal: ");
            System.out.println("Menu: ");
            System.out.println("1.View a Bus Detail: ");
            System.out.println("2. Enter new Bus Detail: ");
            System.out.println("3. Delete a Bus Detail: ");
            System.out.println("4. Update a Bus Detail:  ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1: {
                    Busview(); break;

                }
                case 2: {
                    NewBus(); break;

                }
                case 3: {
                    DeleteBus(); break;

                }
                case 4: {
                    UpdateBus(); break;

                }

                default:System.out.println("Illegal Choice Entered: ");

            }
            System.out.println("If you still want to continue Enter (Y/N");
            System.out.println("Waiting for user input...");

            cont = scanner.next();

        } while (Objects.equals(cont.toUpperCase().charAt(0), 'Y'));
        scanner.close();
    }

    static void Busview(){
        System.out.println("WELCOME TO BUS VIEW");
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter The BUSID: ");
        int a=sc.nextInt();
        sc.nextLine();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        try{
          Connection connection=DriverManager.getConnection(URL,username,password);
          String Query="SELECT * FROM BUSES WHERE BUSNO=?";
          PreparedStatement pre=connection.prepareStatement(Query);
          pre.setInt(1,a);

          ResultSet r=pre.executeQuery();
          while(r.next()){
              System.out.println("The busID: "+r.getInt("BUSNO"));
              System.out.println("JOURNEYDATE: "+r.getDate("JRNYDATE"));
              System.out.println("Capacity: "+r.getInt("CAPACITY"));
              System.out.println("AVAILABLE: "+r.getInt("AVAILABLE"));
              System.out.println("Starting Point: "+r.getString("SPOINT"));
              System.out.println("Ending Point: "+r.getString("ENDING_POINT"));

          }


        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return;
    }

    static void NewBus(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Welcome To Bus Entry System: ");
        System.out.println("Enter the BusNo of new Bus: ");
        int busno=sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the Journey Date(YYYY-MM-DD): ");
        String date=sc.next();
        System.out.println("Enter the capacity of the Bus: ");
        int capacity=sc.nextInt();
        System.out.println("Enter the Avialiable seats: ");
        int availiable=sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the Starting point of the Ship: ");
        String Spoint=sc.nextLine();
        System.out.println("Enter the ending point of the Bus: ");
        String Epoint=sc.nextLine();
        //To convert Date which is taken in form String to Date datadype accepted by mysql.

        Date dateUse= Date.valueOf(date);

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        try{
            Connection connection =DriverManager.getConnection(URL,username,password);
            String Query="INSERT INTO BUSES(BUSNO,JRNYDATE,CAPACITY,AVAILABLE,SPOINT,ENDING_POINT) VALUES (?,?,?,?,?,?)";
            PreparedStatement pre=connection.prepareStatement(Query);
            pre.setInt(1,busno);
            pre.setDate(2,dateUse);
            pre.setInt(3,capacity);
            pre.setInt(4,availiable);
            pre.setString(5,Spoint);
            pre.setString(6,Epoint);
            pre.executeUpdate();
            connection.close();
            System.out.println("New Bus data Entered: ");


        }catch(SQLException e){
            System.out.println(e.getMessage());
        }



        return;
    }
    //FUNCTION TO delete a Bus from Buses table

    static void DeleteBus(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the BUSNO which you want to Delete: ");
        int bus=sc.nextInt();
        sc.nextLine();

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        try{
            Connection connection=DriverManager.getConnection(URL,username,password);
            String Query="DELETE FROM BUSES WHERE BUSNO=?";
            PreparedStatement pre=connection.prepareStatement(Query);
            pre.setInt(1,bus);
            pre.executeUpdate();

            connection.close();

        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        ;
    }

    static void  UpdateBus(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Welcome to Bus Updation Service: ");
        System.out.println("Below Mentioned Things About can be Bus info can we updated: ");
        System.out.println("MENU: ");
        System.out.println("1.Journey Date: ");
        System.out.println("2.Total Capacity of The Bus: ");
        System.out.println("3.Available No of Seats: ");
        System.out.println("4.Starting Point: ");
        System.out.println("5.Ending Point: ");
        int a=sc.nextInt();
        switch(a){
            case 1: UpdateJourneyDate();break;
            case 2:ChangeCapacity();break;
            case 3:ChangeAvailiableSeat();break;
            case 4: ChangeStartingPoint();break;
            case 5:ChangeEndingPoint();break;
            default: System.out.println("Entered Wrong Choice: ");
        }
    }



   static void UpdateJourneyDate(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Welcome to Updation of Journey Date: ");
        System.out.println("Enter the BusNo. :");
        int k=sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the New Date(YYYY-MM-DD)");
        String date=sc.nextLine();
        Date NewDate= Date.valueOf(date);
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        try{
           Connection connection =DriverManager.getConnection(URL,username,password);
           String Query="UPDATE BUSES SET JRNYDATE=? WHERE BUSNO=?";
           PreparedStatement pre=connection.prepareStatement(Query);
           pre.setDate(1,NewDate);
           pre.setInt(2,k);
           int l=pre.executeUpdate();
           if(l>0){
               System.out.println("Journey Date Updated: ");
           }



        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return;
    }

    static void ChangeCapacity(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Welcome to Capacity Change Portal: ");
        System.out.println("Enter the BusNo. :");
        int a=sc.nextInt();
        System.out.println("Enter the New Capacity of The Bus: ");
        int b=sc.nextInt();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        try{
            Connection connection=DriverManager.getConnection(URL,username,password);
            String Query="UPDATE BUSES SET CAPACITY=? WHERE BUSNO=?";
            PreparedStatement pre=connection.prepareStatement(Query);
            pre.setInt(1,b);
            pre.setInt(2,a);
           pre.executeUpdate();

        }catch(SQLException e){
            System.out.println(e.getMessage());
        }return;
    }

    static void ChangeAvailiableSeat(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Welcome to Portal for Change of Avialiable Seats: ");
        System.out.println("Enter the BusNo. :");
        int a=sc.nextInt();
        System.out.println("Enter the Avialable Seats: ");
        int b=sc.nextInt();

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        try{
            Connection connection=DriverManager.getConnection(URL,username,password);
            String Query="UPDATE BUSES SET AVAILABLE=? WHERE BUSNO=?";
            PreparedStatement pre=connection.prepareStatement(Query);
            pre.setInt(1,b);
            pre.setInt(2,a);
            pre.executeUpdate();



        }catch(SQLException e){
            System.out.println(e.getMessage());
        }return;
    }

    static void ChangeStartingPoint(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Welcome to Starting Point Changing Portal: ");
        System.out.println("Enter the BusNo. :");
        int a=sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the New Bus Starting Point: ");
        String s=sc.nextLine();

        try{
           Connection connection=DriverManager.getConnection(URL,username,password);
           String Query="UPDATE BUSES SET SPOINT=? WHERE BUSNO=?";
           PreparedStatement pre=connection.prepareStatement(Query);
           pre.setString(1,s);
           pre.setInt(2,a);
           pre.executeUpdate();


        }catch(SQLException e){
            System.out.println(e.getMessage());
        }return;
    }

    static void ChangeEndingPoint(){
        System.out.println("Welcome to Ending Point Changing Potal for Operator:  ");
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the BusNo. :");
        int a=sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the Ending Point: ");
        String s=sc.nextLine();
        try{
           Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        try{
            Connection connection=DriverManager.getConnection(URL,username,password);
            String Query="UPDATE BUSES SET ENDING_POINT=? WHERE BUSNO=?";

            PreparedStatement pre=connection.prepareStatement(Query);
            pre.setString(1,s);
            pre.setInt(2,a);
            pre.executeUpdate();

        }catch(SQLException e){
            System.out.println(e.getMessage());
        }return;
    }

    static void Passenger(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        try{
           Connection connection=DriverManager.getConnection(URL,username,password);
           PreparedStatement pre = null;
           System.out.println("Welcome to the Passenger Portal: ");
        Scanner sc=new Scanner(System.in);
        String s;
        do {
            System.out.println("Menu: ");
            System.out.println("1.Book a Ticket: ");
            System.out.println("2.Cancel a ticket: ");
            System.out.println("3.View a bus detail: ");
            System.out.println("Enter Your Choice: ");
            int a=sc.nextInt();
            sc.nextLine();
            switch(a){
                case 1:{BookTicket(pre,connection);
                break;}
                case 2:{
                    CancelTicket(pre,connection);
                    break;
                }
                case 3:{
                    ViewBus(pre,connection);
                    break;
                }
                default: System.out.println("Sorry Entered the Wrong Choice: ");

            }
            System.out.println("Do you still want ot continue or Exit: ");
            System.out.println("Enter (Y/N)");
             s=sc.nextLine();

        }while(Objects.equals(s.toUpperCase().charAt(0), 'Y'));

        }catch(SQLException e){
            System.out.println(e.getMessage());
        }

        }

        static void  BookTicket(PreparedStatement pre,Connection connection) throws SQLException {
        Scanner sc=new Scanner(System.in);
        System.out.println("Welcome to Ticket Booking for Passanger: ");
        System.out.println("Enter the BusNo of Booking: ");
        int busno=sc.nextInt();
        System.out.println("Enter PssengerId: ");
        int passid=sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the name of the Passenger: ");
        String name=sc.nextLine();
        System.out.println("Enter the Date of Ticket Booking: ");
        String date=sc.nextLine();
        System.out.println("Enter the Amount Paid: ");
        int paid=sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the Starting Point: ");
        String start=sc.nextLine();
        System.out.println("Enter the Destination Point: ");
        String Dest=sc.nextLine();
            Date NewDate= Date.valueOf(date);
       try {
           String Query = "INSERT INTO PASSENGER(PASSID,NAME,DATE_BOOKED,AMOUNT,BUSNO,STARTINGPOINT,DESTINATIONPOINT) VALUES(?,?,?,?,?,?,?)";
           pre = connection.prepareStatement(Query);
           pre.setInt(1,passid);
           pre.setString(2,name);
           pre.setDate(3,NewDate);
           pre.setInt(4,paid);
           pre.setInt(5,busno);
           pre.setString(6,start);
           pre.setString(7,Dest);
           pre.executeUpdate();
           String QueryONE="UPDATE BUSES SET AVAILABLE=AVAILABLE-1 WHERE BUSNO=?";
           pre=connection.prepareStatement(QueryONE);
           pre.setInt(1,busno);

           connection.close();
       }catch(SQLException e){
           System.out.println(e.getMessage());
       }
        }
        static void CancelTicket(PreparedStatement pre,Connection connection) throws SQLException {
        Scanner sc=new Scanner(System.in);
        System.out.println("Welcome to Ticket Cancelling Portal: ");
        System.out.println("Enter the passenger Id: ");
        int passid=sc.nextInt();
        String Query="SELECT BUSNO FROM PASSENGER WHERE PASSID=?";
        pre=connection.prepareStatement(Query);
        pre.setInt(1,passid);
        ResultSet r=pre.executeQuery();
        int i=-1;
        if(r.next()) {
            i = r.getInt("BUSNO");
        }

        String QueryOne="DELETE FROM PASSENGER WHERE passid=?";
        pre=connection.prepareStatement(QueryOne);
        pre.setInt(1,passid);
        pre.executeUpdate();

        String QueryTwo="UPDATE BUSES SET AVAILABLE=AVAILABLE+1 WHERE BUSNO=? ";
        pre=connection.prepareStatement(QueryTwo);
        pre.setInt(1,i);
        pre.executeUpdate();
        }

        static void ViewBus(PreparedStatement pre,Connection connection) throws SQLException{
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the BusNo: ");
        int a=sc.nextInt();
        String Query="SELECT * FROM BUSES WHERE BUSNO=?";
        pre=connection.prepareStatement(Query);
        pre.setInt(1,a);
        ResultSet r=pre.executeQuery();
        while(r.next()){
            System.out.println("Journey Date: "+r.getDate("JRNYDATE"));
            System.out.println("AVAILIABLE SEATS: "+r.getInt("AVAILABLE"));
            System.out.println("Starting Point: "+r.getString("SPOINT"));
            System.out.println("Ending Point: "+r.getString("ENDING_POINT"));
        }
        r.close();


        }



}
