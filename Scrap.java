import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Scrap {
    public static void main(String[] args) {

        List<String> commands = List.of("DetectSquares", "add1", "add2", "add3", "count4", "count", "add6", "count7");
        Map<String, Character> firstCharByString = commands.stream()
                                                           .distinct()
                                                           .filter(s -> s.contains("1"))
                                                           .collect(Collectors.toMap(Function.identity(),
                                                                                     s -> s.charAt(0)));

        String c = firstCharByString.keySet().stream().reduce("", String::concat);



        String abc = "123;";

//        String[] commands = {"DetectSquares", "add", "add", "add", "count", "count", "add", "count"};
//        int[][] commandInputs = {{}, {3, 10}, {11, 2}, {3, 2}, {11, 10}, {14, 8}, {11, 2}, {11, 10}};
//        DetectSquares obj = new DetectSquares();
//        int[] input1 = {419,351};
//        int[] input2 = {798,351};
//        int[] input3 = {798,730};
//        int[] input4 = {419,730};
//        int[] input5 = {14,8};
//        int[] input6 = {11,2};
//        int[] input7 = {11,10};
//        obj.add(input1);
//        obj.add(input2);
//        obj.add(input3);
//        obj.count(input4);
//        obj.count(input5);
//        obj.add(input6);
//        obj.count(input7);

//        String abc = "abc";
//["DetectSquares","add","add","add","count","add","add","add","count","add","add","add","count","add",
//                "add","add","count","add","add","add","count","add","add","add","count","add","add","add","count","add","add","add","count","add","add","add","count","add","add","add","count","add","add","add","count"]
//[[],[[419,351]],[[798,351]],[[798,730]],[[419,730]],[[998,1]],[[0,999]],[[998,999]],[[0,1]],[[226,561]],[[269,561]],
//        [[226,604]],[[269,604]],[[200,274]],[[200,793]],[[719,793]],[[719,274]],[[995,99]],[[146,948]],[[146,99]],
//        [[995,948]],[[420,16]],[[962,558]],[[420,558]],[[962,16]],[[217,833]],[[945,105]],[[217,105]],[[945,833]],
//        [[26,977]],[[26,7]],[[996,7]],[[996,977]],[[96,38]],[[96,483]],[[541,483]],[[541,38]],[[38,924]],[[961,1]],
//        [[961,924]],[[38,1]],[[438,609]],[[818,609]],[[818,229]],[[438,229]]]
//["DetectSquares","add","add","add","count","count","add","count"]
//[[],[[3,10]],[[11,2]],[[3,2]],[[11,10]],[[14,8]],[[11,2]],[[11,10]]]


//        DetectSquares obj = new DetectSquares(commands, commandInputs);
//        obj.add(a);
//        Leet2013 a = new Leet2013(commands, commandInputs);
//        String abc = "abc";


        String input =  "><<><";
        System.out.println(fixBrac(input));
    }

    public static String fixBrac(String s){
        if(s.length() == 0)
        {
            return "";
        }

        int currentOpenBrackets = 0;
        int leadingOpenBrackets = 0;
        char leftBracket = '<';
        char rightBracket = '>';
        String ret = "";



        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == rightBracket) {
                if (currentOpenBrackets == 0) {
                    leadingOpenBrackets++;
                } else {
                    currentOpenBrackets--;
                }
            } else {
                currentOpenBrackets++;
            }
        }

        // should use string builder here but i'm to lazy since this is scrap
        for (int i =0; i < leadingOpenBrackets; i++)
        {
            ret = ret + leftBracket;
        }

        ret = ret+s;

        for (int i =0; i < currentOpenBrackets; i++)
        {
            ret = ret + rightBracket;
        }

        return ret;
    }
}
