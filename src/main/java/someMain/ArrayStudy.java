package someMain;

import trainingWithObjects.TestInterface;

import java.util.*;

public class ArrayStudy implements TestInterface {

    int[] integerArray = new int[10];
    int[] ints = new int[]{1, 2, 3, 4, 5, 6, 7, 10, 15, 20};

    Integer[] integers = new Integer[]{};

    List<Integer> integerList = new ArrayList<>();
    List<Integer> integerLinkedList = new LinkedList<>();

    Set<Integer> integerSet = new HashSet<>();

    int[][] integerArray2 = new int[][]{new int[2]};
    int[][] integerArray3 = new int[7][2];

    Map<Integer, String> stringStringMap = new TreeMap<>();

    public void workWithMap(){
        stringStringMap.put(25, "value25");
        stringStringMap.put(30, "value30");
        stringStringMap.put(3, "value3");
        stringStringMap.put(325, "value325");
        stringStringMap.put(151, "value151");
        //System.out.println(stringStringMap);
      //  System.out.println(stringStringMap.get(32));
        for (Integer key : stringStringMap.keySet()){
            System.out.println(stringStringMap.get(key));
        }

    }

    public void workWithArrays(){
        integerArray3[0][0] = 1;
        integerArray3[1][0] = 2;
        integerArray3[2][0] = 2;
        integerArray3[3][0] = 2;
        integerArray3[4][0] = 2;
        integerArray3[5][0] = 2;
        integerArray3[6][0] = 2;
        integerArray3[0][1] = 1;
        integerArray3[1][1] = 2;
        integerArray3[2][1] = 2;
        integerArray3[3][1] = 2;
        integerArray3[4][1] = 2;
        integerArray3[5][1] = 2;
        integerArray3[6][1] = 2;
        integerArray[0] = 25;
        //System.out.println(integerArray[0]);
        for(int i = 0; i < ints.length; i++){
            integerArray[i] = ints[i];
        }
        integerList.add(4);
        integerList.add(1);
        integerList.add(3);
        integerList.add(5);
        integerList.add(2);



        integerList.remove(4);

     //   System.out.println(integerList);

        for (Integer integer : integerList) {
           // System.out.println(integer.toString());
            integerLinkedList.add(integer);
        }

        System.out.println(integerList);
        Collections.sort(integerList);
        System.out.println(integerList);
    }

    public void sum(int one, int two){
        System.out.println(one+two);
    }

    public void sum(String one, String two){
        System.out.println(one+two);
    }

    public void sum(int one, int two, int three){
        System.out.println(one+two+three);
    }

    public void sum (int[] arrayForSum){
        int result = 0;
        for (int value : arrayForSum) {
            result += value;
        }
        System.out.println(Arrays.toString(arrayForSum));
        System.out.println(result);
    }

    @Override
    public String getSomeTestName() {
        return this.getClass().getName();
    }
}
