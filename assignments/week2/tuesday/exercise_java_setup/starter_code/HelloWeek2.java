public class HelloWeek2{
    public static void main(String[] args) {
        if(args.length >= 1){
            System.out.println(String.format("Hello, %s!", args[0]));
        }else{
            System.out.println("Hello, trainee!");
        }
    }
}