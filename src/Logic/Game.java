package Logic;

/**
 * Klasa odpiwiedzialna za 1 kompletną grę.
 */
public class Game {
    /**
     * Pole przechowuje aktualną talię.
     */
    public Deck _deck;
    /**
     * Lista graczy.
     */
    public Player[] players = new Player[3];
    /**
     * Pole przechowuje indeks aktualnego gracza.
     */
    public int currentPlayer = 0;
    /**
     * Pole przechowuje indeks gracza który jako pierwszy zagrywa kartę na czyste pole gry.
     */
    public int gamer = 0;
    /**
     * Tablica przechowująca trzy karty. Jest to pole gry.
     */
    public Card[] playGround = new Card[3];
    /**
     * Ilość punktów jaką zadeklarował gracz, który wygrał licytację do zdobycia w danej rundzie.
     */
    public int howMuch;
    /**
     * Liczba osów, która musi zrezygnować z licytacji aby ta się zakończyła
     */
    public int dismissCounter;

    private int startingPlayer;
    /**
     * Pole pozwalające określić któremu graczowi przyznać kartę oddaną po wygranej licytacji.
     */
    public int musikCounter;
    /**
     * Ilość pełnych przejść kolejki jaka pozostała do końca rundy.
     */
    public int circleCounter;
    /**
     * Wartość aktualnie zameldowanego koloru.
     */
    public int meldunek;
    /**
     * Pole przyjmuje wartość true jeżeli trwa licytacja lub false w przeciwnym przypadku.
     */
    public boolean voting;
    /**
     * Pole przyjmuje wartość true jeżeli trwa odrzucanie kart po wygranej licytacji lub false w przeciwnym przypadku.
     */
    public boolean musik;
    /**
     * Pole przyjmuje wartość true jeżeli trwa meldowanie lub false w przeciwnym przypadku.
     */
    public boolean melduj;

    /**
     * Metoda dodaje kartę do pola gry danego gracza i zastępuje ja w polu _hand gracza białą kartą o wartościach color == 0 oraz value == 0.
     * @param index indeks zagrywanej katry w polu _hand gracza.
     */
    public void playCard(int index)
    {
        playGround[currentPlayer] = players[currentPlayer].GetHand().get(index);
        Card blankCard = new Card(0,0,"./Cards/blankCard.png");
        players[currentPlayer].GetHand().set(index,blankCard);
    }

    /**
     * Metoda wyznacza kto wygrał daną kolejkę oraz przyznaje mu odpowiednią ilość punktów. Ustala również kto rozpocznie następną kolejkę.
     */
    public void CircleEnd()
    {
        int winner = gamer;
        if(playGround[gamer].getColor() == meldunek || meldunek == 0 || (playGround[(gamer+1)%3].getColor() != meldunek && playGround[(gamer+2)%3].getColor() != meldunek)) {
            if (playGround[gamer].getColor() == playGround[(gamer + 1) % 3].getColor()) {
                if (playGround[gamer].getValue() < playGround[(gamer + 1) % 3].getValue()) {
                    winner = (gamer + 1) % 3;
                }
            }
            if (playGround[winner].getColor() == playGround[(gamer + 2) % 3].getColor()) {
                if (playGround[winner].getValue() < playGround[(gamer + 2) % 3].getValue()) winner = (gamer + 2) % 3;
            }
        }
        else{
            if(playGround[(gamer+1)%3].getColor() == meldunek){
                winner = (gamer+1)%3;
                if(playGround[(gamer+2)%3].getColor() == meldunek)
                    if(playGround[(gamer+1)%3].getValue() < playGround[(gamer+2)%3].getValue())
                        winner = (gamer+2)%3;
            }
            else{
                winner = (gamer+2)%3;
            }
        }
        gamer = winner;
        players[gamer]._roundPionts = players[gamer]._roundPionts + playGround[0].getValue() + playGround[1].getValue() + playGround[2].getValue();
        currentPlayer = gamer;
    }

    /**
     * Metoda ustawia parametry startowa nowej rundy oraz rozpoczyna ją.
     */
    public void RoundStart()
    {
        _deck = new Deck();
        players[0].ClearHand();
        players[1].ClearHand();
        players[2].ClearHand();
        _deck.Rozdaj(players[0],players[1],players[2]);
        Card blankCard = new Card(0,0,"./Cards/blankCard.png");
        playGround[0] = blankCard;
        playGround[1] = blankCard;
        playGround[2] = blankCard;
        voting = true;
        howMuch = 100;
        players[0]._votingPoints = 100;
        players[1]._votingPoints = 100;
        players[2]._votingPoints = 100;
        currentPlayer = startingPlayer;
        gamer = (startingPlayer + 2)%3;
        musikCounter = 2;
        circleCounter = 8;
        dismissCounter = 2;
        startingPlayer = (startingPlayer + 1) % 3;
        melduj = false;
        meldunek = 0;
    }

    /**
     * Metoda przyznaje punkty graczom po skończonej rundzie oraz zwraca indesk gracza który wygrał grę. Jeżeli nie ma takiego metoda zwraca -1.
     * @return  int gameWinner;
     */
    public int RoundEnd()
    {
        int gameWinner = -1;
        for(int i = 0; i < 3; i++)
        {
            if(players[i]._votingPoints == 0)
            {
                players[i]._points += players[i]._roundPionts;
            }
            else
            {
                if(players[i]._roundPionts >= players[i]._votingPoints)
                {
                    players[i]._points += players[i]._votingPoints;
                }
                else
                {
                    players[i]._points -= players[i]._votingPoints;
                }
            }
            players[i]._votingPoints = 100;
        }
        players[0]._roundPionts = 0;
        players[1]._roundPionts = 0;
        players[2]._roundPionts = 0;
        if(players[0]._points > 1000)gameWinner = 0;
        if(players[1]._points > 1000)gameWinner = 1;
        if(players[2]._points > 1000)gameWinner = 2;
        return gameWinner;
    }

    /**
     * Konstruktor kalsy. Ustawia parametry startowe nowej gry.
     */
    public Game()
    {
        players[0] = new Player();
        players[1] = new Player();
        players[2] = new Player();
        _deck = new Deck();
        _deck.Rozdaj(players[0],players[1],players[2]);
        Card blankCard = new Card(0,0,"./Cards/blankCard.png");
        playGround[0] = blankCard;
        playGround[1] = blankCard;
        playGround[2] = blankCard;
        voting = false;
        howMuch = 100;
        players[0]._votingPoints = 100;
        players[1]._votingPoints = 100;
        players[2]._votingPoints = 100;
        currentPlayer = startingPlayer;
        gamer = (startingPlayer + 2)%3;
        musikCounter = 2;
        circleCounter = 8;
        dismissCounter = 2;
        startingPlayer = (startingPlayer + 1) % 3;
        melduj = false;
    }
}