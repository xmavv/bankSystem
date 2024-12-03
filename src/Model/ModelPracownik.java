package Model;

import java.util.ArrayList;

public class ModelPracownik {
    private static ArrayList<Pracownik> pracownicy = new ArrayList<>() {{
        add(new Pracownik("MATEUSZ", "OLEKSY", 100542));
    }};
    private static int pracownikId = 0;
}
