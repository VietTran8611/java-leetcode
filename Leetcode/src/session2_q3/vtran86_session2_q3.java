package session2_q3;

import java.util.*;

public class vtran86_session2_q3 {
    private Map<String,Integer> emplNum = new HashMap<>();

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("A","C");
        map.put("B","C");
        map.put("F","F");
        map.put("G","A");
        map.put("H","D");
        map.put("D","E");
        map.put("E","F");
        map.put("C","F");
        // maneger to employee map for ezer viewing
        //{A=[G], C=[A, B], D=[H], E=[D], F=[C, E]}

        vtran86_session2_q3 var= new vtran86_session2_q3();
        System.out.println(var.mapTheThings(map));

        //out: {A=1, B=0, C=3, D=1, E=2, F=7, G=0, H=0}
    }

    public Map<String,Integer> mapTheThings(Map<String, String> map){
        Map<String, List<String>> manTOEmp =  new HashMap<>();

        // get maneger to employee map
        for (Map.Entry<String,String> set: map.entrySet()){
            if (set.getKey()!=set.getValue()){
                if (manTOEmp.containsKey(set.getValue())){
                    List<String> list=manTOEmp.get(set.getValue());
                    list.add(set.getKey());
                    manTOEmp.put(set.getValue(),list);
                }else {
                    List<String> arrl= new ArrayList<String>();
                    arrl.add(set.getKey());
                    manTOEmp.put(set.getValue(),arrl);
                }
            }
        }
        System.out.println(manTOEmp);

        //populate the return map
        for (Map.Entry<String,String> set: map.entrySet()){
           TopDownDP(set.getKey(),manTOEmp);
        }

        return emplNum;
    }

    private int TopDownDP(String man,Map<String, List<String>> manTOEmp){
        // top down dynamic programming with cache
        int num =0;
        if (emplNum.containsKey(man)){
            //if number of employee of a certain manager is lready calculated and saved in cache return that
            return emplNum.get(man);
        }else if (!manTOEmp.containsKey(man)){
            //base case if employee does not manage anyone return 0, save it in cache
            emplNum.put(man,0);
            return 0;
        }else {

            List<String> list;
            list=manTOEmp.get(man);

            //add all direct employees that maneger has in num
            num += list.size();

            //for each of those employee recursively call this function to calculated  employee they manage and add the count
            for (int i=0;i<list.size();i++){
               num+= TopDownDP(list.get(i),manTOEmp);
            }
        }

        emplNum.put(man,num);
        return num;
    }


}
