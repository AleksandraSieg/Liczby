package pl.madison.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.madison.domain.Liczby;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class Test2Controller {

    private List<Liczby> listaLiczb = new ArrayList<Liczby>();

    @RequestMapping(value = "/dodawanie")
    public String uzupelnijLiczby(Map<String, Object> model) {
        //Liczby mmm = new Liczby(); z backendu mozna uzupelnic liczbe;
        //mmm.setLiczba1(3);
        model.put("bbbb", new Liczby()); //bbbb - nazwa obiektu z formularza na stronie dodawanie.html i jest to String
        return "dodawanie";    //przekieruje do dodawanie.html tak jakby to jest nasz String
    }

    @RequestMapping(value = "/suma", method= RequestMethod.POST)
    public String suma(Liczby liczby, Map<String, Object> model){
        int wynik = liczby.getLiczba1() + liczby.getLiczba2();
        model.put("ccc", wynik);
        listaLiczb.add(liczby);
        return "suma";
    }

    @RequestMapping(value = "/listaLiczb")
    public String listaLiczb(Map<String, Object> model){
        model.put("liczby", listaLiczb);
        return "listaLiczb";
    }
}
