class X{
    Y b = new Y();
    X(){
        System.out.println("X");
    }
}

class Y{
    Y(){
        System.out.println("Y");
    }
}

public class Text extends X{
    Y y = new Y;
    Text(){
        System.out.println("Z");
    }
    public static void main(String[] args) {
        new Text();
    }
}