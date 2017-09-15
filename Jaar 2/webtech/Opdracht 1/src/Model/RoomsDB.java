package Model;

import java.util.ArrayList;

/**
 * Created by Frank on 01-09-16.
 */
public class RoomsDB {
    private ArrayList<Room> rooms;

    /**
     * Constructor voor een nieuwe room database, voegt auto 2 huizen toe
     */
    public RoomsDB(){
        rooms = new ArrayList<>();
        addRoom(new Room("Naam", 12, 12.4, new Verhuurder("username", "password")));
        addRoom(new Room("Naam", 12, 12.1, new Verhuurder("username", "password")));
    }

    public void addRoom(Room room){
        rooms.add(room);
    }

    public ArrayList<Room> getRooms(){
        return this.rooms;
    }
}
