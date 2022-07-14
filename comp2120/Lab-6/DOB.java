package Lab6;

public class DOB {
    int month, day, year;
    public DOB(int month, int day, int year){
        this.month = month;
        this.day = day;
        this.year = year;
    }
    @Override
    public String toString(){
        return month + "/" + day + "/" + year;
    }
}
