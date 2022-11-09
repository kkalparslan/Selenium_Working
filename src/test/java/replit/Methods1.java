package replit;

public class Methods1 {
    public static void main(String[] args) {

        method("3");

    }
    public static void method(String s){
        if(method(3).equals(s)){
            System.out.println("Great!");
        }
    }
    public static String method(int i){
        if(i==3){
            return "3";
        }else{
            return "something is going wrong";
        }

    }

}
