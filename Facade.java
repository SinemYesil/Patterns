class Facade {
    public static void main(String[] args) {
        TV led = new TV();
        SoundBar lg = new SoundBar();
        StreamingDevice viewsonic = new StreamingDevice();

        System.out.println("I want to watch a movie with Cinema mod on Netflix...");
        led.turnOn();
        lg.on();
        viewsonic.startDevice();
        lg.changeMod("Cinema");
        viewsonic.chooseApp("Netflix");
        System.out.println("Enjoy...");
    }
}
class Asistan  {
    public Asistan(){
        tv=new TV();
        soundBar=new SoundBar();
        streamingDevice=new StreamingDevice();


    }
    public Boolean IsEligible(){
        Boolean eligible=true;
        if ()
    }
    private TV tv;
    private SoundBar soundBar;
    private StreamingDevice streamingDevice;

}

class TV{
    public void turnOn(){System.out.println("TV turned on...");}
}

class SoundBar{
    public void on(){System.out.println("The SoundBar is on now...");}

    public void changeMod(String mod){
        if(mod.equals("Cinema") || mod.equals("Tv Show"))
            System.out.println("The SoundBar mod changed to " + mod);
        else
            System.out.println("Wrong mod...");
    }
}

class StreamingDevice{
    public void startDevice(){System.out.println("Device is ready to stream...");}

    public void chooseApp(String app){
        if(app.equals("Netflix") || app.equals("Exxen") || app.equals("Amazon Prime"))
            System.out.println("Streaming from " + app);
        else
            System.out.println("Wrong app name...");
    }
}