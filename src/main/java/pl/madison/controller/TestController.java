package pl.madison.controller;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TestController {



    @RequestMapping(value = "/ileLiczbWiekszych/{liczba}")
    public String sprawdzIleLiczbWiekszych(@PathVariable("liczba") int liczba){
        int[] tab = {1, 2, 3, 5, 27, 38, 46, 58, 80, 99};
        int licznik = 0;

        for(int i = 0; i<tab.length; i++){
            if(liczba<tab[i]){
                licznik++;
            }
        }

        return "Ilosc liczb wiekszych od zdeklarowanej liczby: " + licznik;
    }

    public int[] tablica(){
        int[] tab = {1, 2, 3, 5, 27, 38, 46, 58, 80, 99};
        return tab;
    }

    @RequestMapping(value = "ileLiczbMniejszych/{liczba}")
    public String sprzwdzIleLiczbWiekszych(@PathVariable("liczba") int liczba){
        int tab[] = tablica();

        int licznik = 0;
        for(int i = 0; i<tab.length; i++){
            if(liczba>tab[i]){
                licznik++;
            }
        }

        return "Ilosc liczb mniejszych od zdeklarowanej liczby: " + licznik;
    }

    public List<Integer> lista(){
        List<Integer> lista = new ArrayList<Integer>();
        lista.add(2);
        lista.add(8);
        lista.add(34);
        lista.add(45);
        lista.add(56);
        lista.add(77);
        lista.add(99);

        return lista;
    }

    @RequestMapping(value = "/liczbyMniejsze/{liczba}")
    public String liczbyMniejsze(@PathVariable("liczba") Integer liczba){
        List<Integer> lista = lista();
        List<Integer> nowaLista = new ArrayList<Integer>();
        for(Integer i : lista){
            if(liczba>i){
                nowaLista.add(i);
            }
        }

        return "lista liczb mniejszych od zdeklarowanej liczby: " + nowaLista;
    }

    @RequestMapping(value = "/liczbyPodzielne/{liczba}")
    public String liczbyPodzielne(@PathVariable("liczba") Integer liczba){
        List<Integer> lista = lista();
        List<Integer> nowaLista = new ArrayList<Integer>();
        for(Integer i : lista){
            if(i%liczba==0){
                nowaLista.add(i);
            }
        }

        return "Liczby podzielne przez dana przez uzytkownika liczbe: "+nowaLista;
    }

}
