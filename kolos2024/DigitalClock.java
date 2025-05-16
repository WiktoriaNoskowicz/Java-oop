public class DigitalClock extends Clock {
    enum Clock12or24{
        Clock12,
        Clock24
    }
    Clock12or24 type;
    City city;

    public DigitalClock(int hour,int minute, int second,Clock12or24 type,City city) {
        super(hour,minute,second,city);
        this.type = type;
    }

    public String checkType(){
        if (this.type == Clock12or24.Clock24){
             return super.toString();
        }
        else{
            return toString();
        }
    }

    public String toString(){
        String res;
        if(this.hour<12){
            res = String.format("%02d:%02d:%02d AM\n", this.hour , this.minute, this.second);
        } else {
//            return hour - 12 + ":" + minute + ":" + second.format() + "PM\n";
        res = String.format("%02d:%02d:%02d PM\n", this.hour - 12, this.minute, this.second);
        }
        return res;
    }

    }
