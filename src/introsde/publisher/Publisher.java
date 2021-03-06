package introsde.publisher;

import javax.xml.ws.Endpoint;

import introsde.APP1.parks.soap.ParkImpl;
import introsde.APP2.sheds.soap.ShedImpl;
import introsde.APP3.users.soap.UserImpl;


//Endpoint publisher
public class Publisher{
    public static void main(String[] args) {
       Endpoint.publish("http://localhost:6900/app1/park", new ParkImpl());
       Endpoint.publish("http://localhost:6900/app2/shed", new ShedImpl());
       Endpoint.publish("http://localhost:6900/app3/user", new UserImpl());
    }
}