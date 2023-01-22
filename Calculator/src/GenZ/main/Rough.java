package GenZ.main;

public class Rough {
    
    public static void main(String[] args) {
        stringToPostFix str;
        str = new stringToPostFix();
        double d = str.convertStrIntoNum("2+2-18/6+5");
        System.out.println(d);
    }
    
}
