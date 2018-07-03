package Logic;

import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

/**
 * Klasa odpowiedziana za talię kart.
 */
public class Deck {
    private List<Card> _deck = new ArrayList<Card>();

    /**
     * Konstruktor klasy Deck. Do prywatnego pola _deck dodaje 24 nowe karty a następnie losowo zmienia ich kolejność.
     */
    public Deck()
    {
        _deck.add(new Card(0,100, "./Cards/h09.png"));
        _deck.add(new Card(10,100, "./Cards/h10.png"));
        _deck.add(new Card(2,100, "./Cards/h12.png"));
        _deck.add(new Card(3,100, "./Cards/h13.png"));
        _deck.add(new Card(4,100, "./Cards/h14.png"));
        _deck.add(new Card(11,100, "./Cards/h01.png"));

        _deck.add(new Card(0,80, "./Cards/d09.png"));
        _deck.add(new Card(10,80, "./Cards/d10.png"));
        _deck.add(new Card(2,80, "./Cards/d12.png"));
        _deck.add(new Card(3,80, "./Cards/d13.png"));
        _deck.add(new Card(4,80, "./Cards/d14.png"));
        _deck.add(new Card(11,80, "./Cards/d01.png"));

        _deck.add(new Card(0,60, "./Cards/s09.png"));
        _deck.add(new Card(10,60, "./Cards/s10.png"));
        _deck.add(new Card(2,60, "./Cards/s12.png"));
        _deck.add(new Card(3,60, "./Cards/s13.png"));
        _deck.add(new Card(4,60, "./Cards/s14.png"));
        _deck.add(new Card(11,60, "./Cards/s01.png"));

        _deck.add(new Card(0,40, "./Cards/c09.png"));
        _deck.add(new Card(10,40, "./Cards/c10.png"));
        _deck.add(new Card(2,40, "./Cards/c12.png"));
        _deck.add(new Card(3,40, "./Cards/c13.png"));
        _deck.add(new Card(4,40, "./Cards/c14.png"));
        _deck.add(new Card(11,40, "./Cards/c01.png"));
        Collections.shuffle(_deck);
    }

    /**
     * Metoda przyjmuje jako parametry trzech graczy po czym każdemu z nich dodaje do ich pól _hand po 7 kart z pola _deck oraz po jednej białej karcie o wartościach color == 0 oraz value == 0, a następnie kasuje je z pola _deck.
     * @param p1 Gracza pierwszy.
     * @param p2 Gracz drugi.
     * @param p3 Gracz trzeci.
     */
    public void Rozdaj(Player p1,Player p2, Player p3)
    {
        Card blankCard = new Card(0,0,"./Cards/blankCard.png");
        for(int i = 0; i < 7;i++)
        {
            p1.AddToHand(_deck.get(0));
            _deck.remove(0);
        }
        p1.AddToHand(blankCard);
        for(int i = 0; i < 7;i++)
        {
            p2.AddToHand(_deck.get(0));
            _deck.remove(0);
        }
        p2.AddToHand(blankCard);
        for(int i = 0; i < 7;i++)
        {
            p3.AddToHand(_deck.get(0));
            _deck.remove(0);
        }
        p3.AddToHand(blankCard);
    }

    /**
     * Metoda zwraca kartę z pola _deck o podanym w parametrze indeksie.
     * @param index Indeks karty w polu _deck.
     * @return  Karta z pola _deck.
     */
    public Card getCard(int index)
    {
        return _deck.get(index);
    }

    /**
     * Metoda zamienia kartę o indeksie przekazanym w parametrze w _deck na białą katrę z wartościami color == 0 oraz value == 0.
     * @param index Indeks karty do zastąpienia.
     */
    public void removeCard(int index)
    {
        _deck.set(index,new Card(0,0,"./Cards/blankCard.png"));
    }
}
