import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Scrap {

    // notes on generics
    public static <T> List<T> fromArrayToList(T[] a) {
        return Arrays.stream(a).collect(Collectors.toList());
    }

    public static <T, G> List<G> fromArrayToList(T[] a, Function<T, G> mapperFunction) {
        return Arrays.stream(a)
                .map(mapperFunction)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        // map, filter, reduce, sort, toMap
        List<String> commands = List.of("DetectSquares", "add1", "add2", "add3", "count4", "count", "add6", "count7");
        Map<String, Character> firstCharByString = commands.stream()
                                                           .distinct()
                                                           .filter(s -> s.contains("1"))
                                                           .collect(Collectors.toMap(Function.identity(),
                                                                                     s -> s.charAt(0)));

        String c = firstCharByString.keySet().stream().reduce("", String::concat);

        // random Comparators
        // Comparator.reverseOrder()

        Comparator<String> integerStringComparator = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return Integer.parseInt(s1) - Integer.parseInt(s2);
            }
        };

        // IntelliJ suggestions
        // Comparator<String> a = (s1, s2) -> Integer.parseInt(s1) - Integer.parseInt(s2);
        // Comparator<String> a = Comparator.comparingInt(Integer::parseInt);


        // synxtax remidners
        List<String> numberStrings = List.of("10", "9", "8", "7", "6", "5", "4", "3", "2", "1");

        List<String> sortedNumberStrings = List.of("10", "9", "8", "7", "6", "5", "4", "3", "2", "1")
                                               .stream()
                                               .sorted(integerStringComparator)
                                               .collect(Collectors.toList());

        List<Integer> numbers = numberStrings.stream()
                                             .map(n -> Integer.parseInt(n))
                                             .collect(Collectors.toList());
        // IntelliJ suggestion
        // List<Integer> numbers = numberStrings.stream().map(Integer::parseInt).toList();
        List<Integer> evenNumbers = numbers.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
        List<Integer> sortedEventNumbers = numbers.stream().sorted().collect(Collectors.toList());
        Integer evenNumbersSum = evenNumbers.stream().reduce(0, (currentTotal, number) -> currentTotal + number);
        // IntelliJ suggestion
        // Integer evenNumbersSum = evenNumbers.stream().reduce(0, Integer::sum);

        // reminder on how to use generics
        Integer[] intArray = {1, 2, 3, 4, 5};
        Boolean[] boolArray = {true, false, false, false, true};

        List<Integer> integerList = fromArrayToList(intArray);
        List<Boolean> booleanList = fromArrayToList(boolArray);
        List<String> stringList = fromArrayToList(intArray, Object::toString);
        List<String> booleanStringList = fromArrayToList(boolArray, Object::toString);

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

        // should use string builder here but i'm to lazy since this is scrap code
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
