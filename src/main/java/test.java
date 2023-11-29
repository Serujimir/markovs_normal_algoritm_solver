import java.util.*;

public class test {
    public static void main(String[] args) {
        test_string();
    }

    public static void test_string() {

        // Здесь хранятся подстановки
        LinkedHashMap<String, String> podstanovki = new LinkedHashMap<>();
        podstanovki.put("%*", "*%");
        podstanovki.put("%|", "%*");
        podstanovki.put("*|", "**");
        podstanovki.put("|*", "t");
        podstanovki.put("t*", "*t");
        podstanovki.put("t%", "%t");
        podstanovki.put("%t", "%v|");
        podstanovki.put("t", "|");
        podstanovki.put("%v", "?d");
        podstanovki.put("?d", "d?");
        podstanovki.put("|d", "d|");
        podstanovki.put("?", "%");
        podstanovki.put("*d", "h");
        podstanovki.put("h*", "oh");
        podstanovki.put("h%", "h");
        podstanovki.put("h", "");
        podstanovki.put("*", "");
        podstanovki.put("d", "|_");
        podstanovki.put("/|", "-k");
        podstanovki.put("k|", "kk");
        podstanovki.put("k", "|+");
        podstanovki.put("+|", "|+");
        podstanovki.put("-", "ey");
        podstanovki.put("|e", "e|");
        podstanovki.put("y", "%");
        podstanovki.put("eo", "0o");
        podstanovki.put("e", "");
        podstanovki.put("|_", ".a");
        podstanovki.put("a.", ".a");
        podstanovki.put("..", ".");
        podstanovki.put(".aaaaaaaaaa", "a,.");
        podstanovki.put(",a", "a,");
        podstanovki.put(".aaaaaaaaa", "9");
        podstanovki.put(".aaaaaaaa", "8");
        podstanovki.put(".aaaaaaa", "7");
        podstanovki.put(".aaaaaa", "6");
        podstanovki.put(".aaaaa", "5");
        podstanovki.put(".aaaa", "4");
        podstanovki.put(".aaa", "3");
        podstanovki.put(".aa", "2");
        podstanovki.put(".a", "1");
        podstanovki.put(".", "0");
        podstanovki.put(",", "");
        podstanovki.put("a", ".a");
        podstanovki.put("o", "p||||||||||");
        podstanovki.put("|p", "p|");
        podstanovki.put("pp", "p");
        podstanovki.put("%", "u");
        podstanovki.put("u+", "u");
        podstanovki.put("u", "_");
        podstanovki.put("|+", "|)+");
        podstanovki.put(")", "(>");
        podstanovki.put(">+", "+>");
        podstanovki.put("+", "{");
        podstanovki.put("{", "|");
        podstanovki.put(">>>>>", "=");
        podstanovki.put("|=", "=");
        podstanovki.put("(=", "=");
        podstanovki.put("(", "/");
        podstanovki.put("p=", "=<");
        podstanovki.put("<0", "0<");
        podstanovki.put("<1", "1<");
        podstanovki.put("<2", "2<");
        podstanovki.put("<3", "3<");
        podstanovki.put("<4", "4<");
        podstanovki.put("<5", "5<");
        podstanovki.put("<6", "6<");
        podstanovki.put("<7", "7<");
        podstanovki.put("<8", "8<");
        podstanovki.put("<9", "9<");
        podstanovki.put("<<<<<", "$");
        podstanovki.put("0$", "$0");
        podstanovki.put("1$", "$1");
        podstanovki.put("2$", "$2");
        podstanovki.put("3$", "$3");
        podstanovki.put("4$", "$4");
        podstanovki.put("5$", "$5");
        podstanovki.put("6$", "$6");
        podstanovki.put("7$", "$7");
        podstanovki.put("8$", "$8");
        podstanovki.put("9$", "$9");
        podstanovki.put("=$", ".FIN");
        podstanovki.put("0=", "=0");
        podstanovki.put("1=", "=1");
        podstanovki.put("2=", "=2");
        podstanovki.put("3=", "=3");
        podstanovki.put("4=", "=4");
        podstanovki.put("5=", "=5");
        podstanovki.put("6=", "=6");
        podstanovki.put("7=", "=7");
        podstanovki.put("8=", "=8");
        podstanovki.put("9=", "=9");
        podstanovki.put("_>", "");
        podstanovki.put("0>", ">0");
        podstanovki.put("1>", ">1");
        podstanovki.put("2>", ">2");
        podstanovki.put("3>", ">3");
        podstanovki.put("4>", ">4");
        podstanovki.put("5>", ">5");
        podstanovki.put("6>", ">6");
        podstanovki.put("7>", ">7");
        podstanovki.put("8>", ">8");
        podstanovki.put("9>", ">9");
        podstanovki.put("p>", "");
        podstanovki.put("p", ".");
        podstanovki.put("_", ".");

        // Выводит текущие подстановки
        System.out.println("Current podstanovki: " + podstanovki + " Where [symbol=] is Empty Stroke");

        // Формирует "первичные" ключи, то есть группы символов для подстановки. (походу не объяснил)
        Set<String> podstanovkiKeySet = podstanovki.keySet();
        ArrayList<String> podstanovkiKey = new ArrayList<>(podstanovkiKeySet);

        // Сюда вводится строка (каждый символ по отдельности)
        ArrayList<String> stroka = new ArrayList<>();
        stroka.add("|");
        stroka.add("/");
        stroka.add("|");
        stroka.add("|");
        stroka.add("|");
        stroka.add("|");

        // Сюда добавляем финализирующие подстановки. (после которых завершаем все действия)
        LinkedHashMap<String, String> finalize = new LinkedHashMap<>();
        finalize.put("p", ".");
        finalize.put("_", ".");
        Set<String> finalizeKeySet = finalize.keySet();
        ArrayList<String> finalizeKey = new ArrayList<>(finalizeKeySet);

        // Выводит исходную строку
        System.out.println("Start stroka: " + String.join("", stroka) + "\n");

        // Буллин для проверки [изменилась ли строка?]. Если за все циклы нет, то ставится false и конец операций
        boolean is_changed = true;

        // Точка отчёта
        int from = 0;
        // Точка до куда считать
        int to = 0;
        // Для счёта количества полный шагов
        int iter = 1;
        // Для счёта всех шагов
        int steps = 0;

        // Как уже говорилось при false полная остановка программы
        while (is_changed) {

            // Цикл в пределах размера массива подстановок
            for (int g = 0; g <= podstanovkiKey.size() - 1; g++) {

                // При каждой новой подстановке всегда проверяем строку с начала
                from = 0;
                to = 0;

                // Цикл пока from не больше или равен длине строки
                while (from <= stroka.size()) {
                    steps++;
                    to = from;

                    // Цикл пока to не больше или равен длине строки
                    while (to <= stroka.size() - 1) {

                        // Формирует строку из рабочего массива (тот, который "строка" в обычном понимании)
                        String prevsStroka = String.join("", stroka);

                        // Создаёт массив строки с символами от from до to
                        ArrayList<String> iterMassiv = new ArrayList<>();
                        for (int i = from; i <= to; i++) {
                            iterMassiv.add(stroka.get(i));
                        }

                        // Создаёт строку из текущей итерации
                        String iterStroka = String.join("", iterMassiv);

                        // Если строка итерации и текущая подстановка равны
                        if (iterStroka.equals(podstanovkiKey.get(g))) {

                            // Удаляются замененные символы
                            for (int s = to; s >= from; s--) {
                                stroka.remove(s);
                            }

                            // Массив для заполнения значением подстановки каждым символом отдельно
                            ArrayList<String> podstanovkaSymbs = new ArrayList<>();
                            // Строка зо значением подстановки
                            String podstanovkaSymb = podstanovki.get(podstanovkiKey.get(g));

                            // Если значение подстановки не финальное
                            if(!finalizeKey.contains(podstanovkiKey.get(g))) {

                                // В массив для значения текущей подстановки
                                for (int v = 0; v <= podstanovkaSymb.length() - 1; v++) {
                                    podstanovkaSymbs.add(String.valueOf(podstanovkaSymb.charAt(v)));
                                }
                                // После этого добавляем в строку значения текущей подстановки
                                if (podstanovkaSymbs.size() != 0) {
                                    for (int s = 0; s <= podstanovkaSymbs.size() - 1; s++) {
                                        stroka.add(from + s, podstanovkaSymbs.get(s));
                                    }
                                }
                                // Если подстановка была пустым символом, то просто удаляем этот символ
                                for (int s = stroka.size() - 1; s >= 0; s--) {
                                    if (stroka.get(s) == "") {
                                        stroka.remove(s);
                                    }
                                }
                                // Редачим общие параметры
                                from = 0;
                                to = -1;
                                is_changed = true;
                                // Выводим изменения
                                System.out.println("Sub: " + (g + 1) + " Iter: " + iter + " From: [" + prevsStroka +
                                        "] To: [" + String.join("", stroka) + "]" + " Podstavili: " +
                                        podstanovki.get(podstanovkiKey.get(g)));
                                iter++;
                                g = 0;
                            }
                            // Иначе
                            else{
                                // Тоже самое, что сверху, но внизу изменения
                                for (int v = 0; v <= podstanovkaSymb.length() - 1; v++) {
                                    podstanovkaSymbs.add(String.valueOf(podstanovkaSymb.charAt(v)));
                                }
                                if (podstanovkaSymbs.size() != 0) {
                                    for (int s = 0; s <= podstanovkaSymbs.size() - 1; s++) {
                                        stroka.add(from + s, podstanovkaSymbs.get(s));
                                    }
                                }
                                for (int s = stroka.size() - 1; s >= 0; s--) {
                                    if (stroka.get(s) == "") {
                                        stroka.remove(s);
                                    }
                                }

                                from = 0;
                                to = -1;
                                // Теперь цикл завершится
                                is_changed = false;
                                // Вывод изменений
                                System.out.println("Sub: " + (g + 1) + " Iter: " + iter + " From: [" + prevsStroka + "] To: [" + String.join("", stroka) + "]" + " Podstavili: " + podstanovki.get(podstanovkiKey.get(g)));
                                iter++;
                                // Перестраховка
                                g = podstanovkiKey.size() - 1;
                            }
                        }
                        // Типичная операция
                        to++;
                    }
                    // Типичная операция
                    from++;
                }
            }
            // Если ни одной следующей подстановки не найдено
            is_changed = false;
        }
        // Вывод общего числа шагов
        System.out.println("Steps count: " + steps);
    }
}