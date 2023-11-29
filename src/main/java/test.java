import java.util.*;

public class test {
    public static void main(String[] args) {
        test_string();
    }

    public static void test_string() {
        LinkedHashMap<String, String> podstanovki = new LinkedHashMap<>();
        podstanovki.put("ac", "aa");
        podstanovki.put("bc", "");

        Set<String> podstanovkiKeySet = podstanovki.keySet();
        ArrayList<String> podstanovkiKey = new ArrayList<>(podstanovkiKeySet);
//        System.out.println(podstanovkiKey);

        ArrayList<String> stroka = new ArrayList<>();
        stroka.add("a");
        stroka.add("b");
        stroka.add("c");
        stroka.add("c");

        boolean is_changed = true;

        int from = 0;
        int to = 0;
        int iter = 1;
        int steps = 0;

//        System.out.println(stroka);

        while (is_changed) {
            while (from <= stroka.size()) {
                steps++;
                to = from;
                while (to <= stroka.size() - 1) {
                    String prevsStroka = String.join("", stroka);
                    ArrayList<String> iterMassiv = new ArrayList<>();
                    for (int i = from; i <= to; i++) {
                        iterMassiv.add(stroka.get(i));
                    }
                    String iterStroka = String.join("", iterMassiv);

                    for (int i = 0; i <= podstanovkiKey.size() - 1; i++) {
                        if (iterStroka.equals(podstanovkiKey.get(i))) {
//                            System.out.println(from + "--" + to);
//                            System.out.println(stroka);
                            for (int s = to; s >= from; s--) {
                                stroka.remove(s);
                            }
//                            System.out.println(stroka);
                            ArrayList<String> podstanovkaSymbs = new ArrayList<>();
                            String podstanovkaSymb = podstanovki.get(podstanovkiKey.get(i));
                            for(int v = 0; v <= podstanovkaSymb.length() - 1;v++){
                                podstanovkaSymbs.add(String.valueOf(podstanovkaSymb.charAt(v)));
                            };
//                            System.out.println("from " + from + " to " + to);
                            if (podstanovkaSymbs.size() != 0) {
//                                System.out.println("stroka " + stroka);
//                                System.out.println(podstanovkaSymbs);
//                                System.out.println(podstanovkaSymbs.size());
                                for (int s = 0; s <= podstanovkaSymbs.size() - 1; s++) {
//                                    System.out.println("before " + stroka);
                                    stroka.add(from + s, podstanovkaSymbs.get(s));
//                                    System.out.println("after " + stroka);
                                }
                            }
                            from = 0;
                            to = 0;
                            is_changed = true;
                            System.out.println("Iter: " + iter + " From: [" + prevsStroka + "] To: [" + String.join("", stroka) + "]");
                            iter++;
                            break;
                        }
                    }
                    for(int s = stroka.size() - 1; s >= 0; s--){
                        if(stroka.get(s) == ""){
                            stroka.remove(s);
                        }
                    }
                    to++;
                }
                from++;
            }
            is_changed = false;
        }
        System.out.println("Steps count: " + steps);
    }
}