class vehicle{
    String info(){
        return "This is the base class vehicle";
    }
}

class Car extends vehicle{
    String info(){
        return "This is Child class Car";
    }
}

class Bus extends vehicle{
    String info(){
        return "This is Child class Bus";
    }
}

public class Answer1a{
    public static void main(String[] args){
        Car mes=new Car();
        System.out.println(mes.info());

        Bus nes=new Bus();
        System.out.println(nes.info());
    }
}