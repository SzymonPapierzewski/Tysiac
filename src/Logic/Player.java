package Logic;

import java.util.ArrayList;
import java.util.List;

/**
 * Klasa przchowuje dane o graczu.
 */
public class Player {
    /**
     * Lista zawierająca karty danego gracza.
     */
    public List<Card> _hand = new ArrayList<Card>();
    /**
     * Liczba punktów danego gracza.
     */
    public int _points;
    /**
     * Liczba punktów zdobyta do tej pory przez danego gracza w obecnej rundzie.
     */
    public int _roundPionts;
    /**
     * Nazwa gracza.
     */
    public String _name;
    /**
     * Ilość ponktów zadeklarowana do ugrania w obecnej rundzie przez danego gracza.
     */
    public int _votingPoints;
    /**
     * Zmienna określająca czy gracz zrezygnował z licytacji. Przyjmuje wartość true jeżeli zrezygnował i false w przeciwnym przypadku.
     */
    public boolean dismissed;

    /**
     * konstruktor gracza.
     */
    public Player() { }

    /**
     * Zwraca pole _hand gracza.
     * @return List<Card> _hand;
     */
    public List<Card> GetHand()
    {
        return _hand;
    }

    /**
     * Dodaje do _hand gracza kartę przekazaną w parametrze.
     * @param card Karta do dodania.
     */
    public void AddToHand(Card card)
    {
        _hand.add(card);
    }

    /**
     * Metoda zamienia kartę o indeksie przekazanym w parametrze w _hand gracza na białą katrę z wartościami color == 0 oraz value == 0.
     * @param index Indeks karty do zastąpienia.
     */
    public void removeCard(int index)
    {
        _hand.set(index,new Card(0,0,"./Cards/blankCard.png"));
    }

    /**
     * Funkcja pozbywa się z _hand gracza wszystkich białych kart o wartościach color == 0 oraz value == 0.
     */
    public void ClearHand()
    {
        int contains = 1;
        while(contains == 1)
        {
            contains = 0;
            if(!_hand.isEmpty()) {
                Card tmpCard = _hand.get(0);
                for (Card card : _hand) {
                    if (card.getImageURL() == "./Cards/blankCard.png") {
                        tmpCard = card;
                        contains = 1;
                    }
                }
                if (contains == 1) _hand.remove(tmpCard);
            }
        }
    }
}
