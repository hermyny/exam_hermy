package fr.hermancia.exam;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Press Alt+Entrée with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        // Press Maj+F10 or click the green arrow button in the gutter to run the code.
        for (int i = 1; i <= 5; i++) {

            // Press Maj+F9 to start debugging your code. We have set one breakpoint
            // for you, but you can always add more by pressing Ctrl+F8.
            System.out.println("i = " + i);
        }
    }

//    private static void testApiPost() {
//        HttpClientService hcs = new HttpClientService();
//
//        // On peut créer un JSON valide depuis un objet Map, via le JSONObject
//        Map<String, Object> json = new HashMap<>();
//        json.put("name", "Donovan");
//        json.put("email", "donovan@kevin.fr");
//        json.put("nickname", "Dono");
//        json.put("password", "Kevin1234");
//        JSONObject o = new JSONObject(json);
//
//        Dump.dump(hcs.post("https://steam-ish.test-02.drosalys.net/api/account", o.toString()));
//
//    }
}