/* Implement the UndergroundSystem class:
 *
 * void checkIn(int id, string stationName, int t)
 * A customer with a card id equal to id, gets in the station stationName at time t.
 * A customer can only be checked into one place at a time.
 * void checkOut(int id, string stationName, int t)
 * A customer with a card id equal to id, gets out from the station stationName at time t.
 * double getAverageTime(string startStation, string endStation)
 * Returns the average time to travel between the startStation and the endStation.
 * The average time is computed from all the previous traveling from startStation to endStation that happened directly.
 * Call to getAverageTime is always valid.
 * You can assume all calls to checkIn and checkOut methods are consistent. If a customer gets in at time t1 at some station, they get out at time t2 with t2 > t1. All events happen in chronological order.
 * 
 * Example 1:
 * Input
 * ["UndergroundSystem","checkIn","checkIn","checkIn","checkOut","checkOut","checkOut","getAverageTime","getAverageTime","checkIn","getAverageTime","checkOut","getAverageTime"]
 * [[],[45,"Leyton",3],[32,"Paradise",8],[27,"Leyton",10],[45,"Waterloo",15],[27,"Waterloo",20],[32,"Cambridge",22],["Paradise","Cambridge"],["Leyton","Waterloo"],[10,"Leyton",24],["Leyton","Waterloo"],[10,"Waterloo",38],["Leyton","Waterloo"]]
 * 
 * Output
 * [null,null,null,null,null,null,null,14.00000,11.00000,null,11.00000,null,12.00000]
 * 
 * Explanation
 * UndergroundSystem undergroundSystem = new UndergroundSystem();
 * undergroundSystem.checkIn(45, "Leyton", 3);
 * undergroundSystem.checkIn(32, "Paradise", 8);
 * undergroundSystem.checkIn(27, "Leyton", 10);
 * undergroundSystem.checkOut(45, "Waterloo", 15);
 * undergroundSystem.checkOut(27, "Waterloo", 20);
 * undergroundSystem.checkOut(32, "Cambridge", 22);
 * undergroundSystem.getAverageTime("Paradise", "Cambridge");       // return 14.00000. There was only one travel from "Paradise" (at time 8) to "Cambridge" (at time 22)
 * undergroundSystem.getAverageTime("Leyton", "Waterloo");          // return 11.00000. There were two travels from "Leyton" to "Waterloo", a customer with id=45 from time=3 to time=15 and a customer with id=27 from time=10 to time=20. So the average time is ( (15-3) + (20-10) ) / 2 = 11.00000
 * undergroundSystem.checkIn(10, "Leyton", 24);
 * undergroundSystem.getAverageTime("Leyton", "Waterloo");          // return 11.00000
 * undergroundSystem.checkOut(10, "Waterloo", 38);
 * undergroundSystem.getAverageTime("Leyton", "Waterloo");          // return 12.00000
*/
 class  CheckInIncidence{
    int id;
    String stationName;
    int t;
    public CheckInIncidence(int id, String stationName, int t) {
        this.id = id;
        this.stationName = stationName;
        this.t = t;
    }
}


class UndergroundSystem {

    HashMap<Integer, CheckInIncidence> Customers;
    HashMap<String, List<Double>> stationTime;
    
    public UndergroundSystem() {
       
       Customers = new HashMap<Integer, CheckInIncidence>(); 
       stationTime = new HashMap<String, List<Double>>();
        
    }
    
    public void checkIn(int id, String stationName, int t) {
    
         CheckInIncidence CurrentCheckInIncidence = new  CheckInIncidence(id, stationName,t);
        
         Customers.put(id, CurrentCheckInIncidence);
       
    }
    
    public void checkOut(int id, String stationName, int t) {
        
        CheckInIncidence PreviousCheckInIncidence = Customers.get(id);
        Customers.remove(id);
        String stationCombine = PreviousCheckInIncidence.stationName +  stationName;
        
        
            double time = t - PreviousCheckInIncidence.t;
            List<Double> list = stationTime.getOrDefault(stationCombine, new ArrayList<Double>());
            list.add(time);
            stationTime.put(stationCombine, list);
       
    }
    
    public double getAverageTime(String startStation, String endStation) {
      
        String stationCombine = startStation +  endStation;
        List<Double> list = stationTime.getOrDefault(stationCombine, new ArrayList<Double>());
            
            double sum =0.0;
            for( int i=0; i<list.size(); i++)
            {
                sum += list.get(i);
            }
        return sum/list.size();
    }
    
    
}



/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */
