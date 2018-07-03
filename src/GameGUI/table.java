package GameGUI;

import Logic.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Klasa odpowiedzialna za graficzny intefejs użytkownika.
 */
public  class table extends JFrame {
    private static Game game;
    private JButton NewGame;
    private JPanel panel1;
    private JPanel Gracz2;
    private JPanel Gracz3;
    private JPanel Musik;
    private JLabel PlayerName2;
    private JButton nextPlayer;
    private JLabel one;
    private JLabel two;
    private JLabel three;
    private JLabel four;
    private JLabel five;
    private JLabel six;
    private JLabel seven;
    private JLabel eight;
    private JButton playCard1;
    private JButton playCard2;
    private JButton playCard3;
    private JButton playCard4;
    private JButton playCard5;
    private JButton playCard6;
    private JButton playCard7;
    private JButton playCard8;
    private JLabel playGround0;
    private JLabel playGround1;
    private JLabel playGround2;
    private JButton playGround0Button;
    private JTextField answer1;
    private JButton OKButton;
    public JPanel enter1;
    private JPanel enter2;
    private JPanel enter3;
    private JTextField answer2;
    private JTextField answer3;
    private JButton OkButton2;
    private JButton OkButton3;
    private JLabel PlayerName3;
    private JLabel PlayerName1;
    private JPanel playGround1Panel;
    private JButton playGround1Button;
    private JButton playGround2Button;
    private JButton startButton;
    private JButton revealButton;
    private JLabel ask1;
    private JLabel ask2;
    private JLabel ask3;
    private JLabel Name1;
    private JLabel Name2;
    private JLabel Name3;
    private JLabel Points1;
    private JLabel Points2;
    private JLabel Points3;
    private JButton dismissButton1;
    private JButton dismissButton2;
    private JButton dismissButton3;
    private JLabel textLabel;
    private JLabel numberLabel;
    private JLabel textLabel2;
    private JLabel numberLabel2;
    private JLabel winnerText;
    private JLabel winnerLabel;
    private JButton melduj;
    private JButton cancelMelduj;
    private JLabel currentMendunek;
    private JLabel meldunekValue;

    private table() {
        Init();

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startButton.setVisible(false);
                enter1.setVisible(true);
            }
        });

        OKButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                String textFieldValue = answer1.getText();
                    if (game.voting)
                    {
                        if(game.players[0].dismissed) enter1.setVisible(false);
                        int intFieldValue = -1;
                        try {
                            intFieldValue = Integer.parseInt(textFieldValue);
                        } catch (NumberFormatException e) {
                            ask1.setText("Wrong value. Try again:");
                        }
                        if(intFieldValue != -1 && intFieldValue > game.howMuch && intFieldValue%10 == 0)
                        {
                            game.howMuch = intFieldValue;
                            game.gamer = 0;
                            game.players[0]._votingPoints = intFieldValue;
                            game.players[1]._votingPoints = 0;
                            game.players[2]._votingPoints = 0;
                            enter1.setVisible(false);
                            nextPlayer.setVisible(true);
                        }
                        else
                        {
                            ask1.setText("Wrong value. Try again:");
                        }
                    } else
                    {
                        PlayerName1.setText(textFieldValue);
                        game.players[0]._name = textFieldValue;
                        Name1.setText(textFieldValue);
                        enter1.setVisible(false);
                        enter2.setVisible(true);
                    }
                    answer1.setText("");
            }
        });

        dismissButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.players[0].dismissed = true;
                game.players[0]._votingPoints = 0;
                game.dismissCounter--;
                if(game.dismissCounter == 0)
                {
                    game.voting = false;
                    game.musik = true;
                    playGround0Button.setEnabled(true);
                    playGround1Button.setEnabled(true);
                    playGround2Button.setEnabled(true);
                    if(!game.players[1].dismissed)game.currentPlayer = 0;
                    if(!game.players[2].dismissed)game.currentPlayer = 1;
                }
                enter1.setVisible(false);
                nextPlayer.setVisible(true);
                nextPlayer.setEnabled(true);
            }
        });

        OkButton2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                String textFieldValue = answer2.getText();
                if (game.voting)
                {
                    if(game.players[1].dismissed) enter2.setVisible(false);
                    int intFieldValue = -1;
                    try {
                        intFieldValue = Integer.parseInt(textFieldValue);
                    } catch (NumberFormatException e) {
                        ask2.setText("Wrong value. Try again:");
                    }
                    if(intFieldValue != -1 && intFieldValue > game.howMuch && intFieldValue%10 == 0)
                    {
                        game.howMuch = intFieldValue;
                        game.gamer = 1;
                        game.players[0]._votingPoints = 0;
                        game.players[1]._votingPoints = intFieldValue;
                        game.players[2]._votingPoints = 0;
                        enter2.setVisible(false);
                        nextPlayer.setVisible(true);
                    }
                    else
                    {
                        ask2.setText("Wrong value. Try again:");
                    }
                } else
                {
                    PlayerName2.setText(textFieldValue);
                    game.players[1]._name = textFieldValue;
                    Name2.setText(textFieldValue);
                    enter2.setVisible(false);
                    enter3.setVisible(true);
                }
                answer2.setText("");
            }
        });

        dismissButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.players[1].dismissed = true;
                game.players[1]._votingPoints = 0;
                game.dismissCounter--;
                if(game.dismissCounter == 0)
                {
                    game.voting = false;
                    game.musik = true;
                    playGround0Button.setEnabled(true);
                    playGround1Button.setEnabled(true);
                    playGround2Button.setEnabled(true);
                    if(!game.players[0].dismissed)game.currentPlayer = 2;
                    if(!game.players[2].dismissed)game.currentPlayer = 1;
                }
                enter2.setVisible(false);
                nextPlayer.setVisible(true);
                nextPlayer.setEnabled(true);
            }
        });

        OkButton3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                String textFieldValue = answer3.getText();
                if (game.voting)
                {
                    if(game.players[2].dismissed) enter3.setVisible(false);
                    int intFieldValue = -1;
                    try {
                        intFieldValue = Integer.parseInt(textFieldValue);
                    } catch (NumberFormatException e) {
                        ask3.setText("Wrong value. Try again:");
                    }
                    if(intFieldValue != -1 && intFieldValue > game.howMuch && intFieldValue%10 == 0)
                    {
                        game.howMuch = intFieldValue;
                        game.gamer = 2;
                        game.players[0]._votingPoints = 0;
                        game.players[1]._votingPoints = 0;
                        game.players[2]._votingPoints = intFieldValue;
                        enter3.setVisible(false);
                        nextPlayer.setVisible(true);
                    }
                    else
                    {
                        ask3.setText("Wrong value. Try again:");
                    }
                } else
                {
                    PlayerName3.setText(textFieldValue);
                    game.players[2]._name = textFieldValue;
                    Name3.setText(textFieldValue);
                    enter3.setVisible(false);
                    revealButton.setVisible(true);
                    SetPlayGroundVisible(true);
                    game.voting = true;
                }
                answer3.setText("");
            }
        });

        dismissButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.players[2].dismissed = true;
                game.players[2]._votingPoints = 0;
                game.dismissCounter--;
                if(game.dismissCounter == 0)
                {
                    game.voting = false;
                    game.musik = true;
                    playGround0Button.setEnabled(true);
                    playGround1Button.setEnabled(true);
                    playGround2Button.setEnabled(true);
                    if(!game.players[0].dismissed)game.currentPlayer = 2;
                    if(!game.players[1].dismissed)game.currentPlayer = 0;
                }
                enter3.setVisible(false);
                nextPlayer.setVisible(true);
                nextPlayer.setEnabled(true);
            }
        });

        nextPlayer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(game.playGround[0].getImageURL() != "./Cards/blankCard.png" && game.playGround[1].getImageURL() != "./Cards/blankCard.png" && game.playGround[2].getImageURL() != "./Cards/blankCard.png") {
                    game.CircleEnd();
                }
                else
                {
                    game.currentPlayer = (game.currentPlayer + 1) % 3;
                }
                CoverCards();
                revealButton.setVisible(true);
                nextPlayer.setVisible(false);
                PlayerName1.setText(game.players[game.currentPlayer]._name);
                PlayerName2.setText(game.players[(game.currentPlayer + 1) % 3]._name);
                PlayerName3.setText(game.players[(game.currentPlayer + 2) % 3]._name);
                melduj.setVisible(false);
                cancelMelduj.setVisible(false);
            }
        });

        revealButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MeldunekIcon(game.meldunek);
                if(game.voting)
                {
                    textLabel.setText("Higher vote: ");
                    numberLabel.setText(Integer.toString(game.howMuch));
                    ShowHand();
                    SetPlayButtonsVisible(false);
                    if(game.currentPlayer == 0)
                    {
                        enter1.setVisible(true);
                        dismissButton1.setVisible(true);
                        ask1.setText("How much you can play?");
                    } else
                    if(game.currentPlayer == 1)
                    {
                        enter2.setVisible(true);
                        dismissButton2.setVisible(true);
                        ask2.setText("How much you can play?");
                    } else
                    if(game.currentPlayer == 2)
                    {
                        enter3.setVisible(true);
                        dismissButton3.setVisible(true);
                        ask3.setText("How much you can play?");
                    }
                }
                else
                    {
                        if(!game.musik)
                        {
                            textLabel.setText("Voted points: ");
                            numberLabel.setText(Integer.toString(game.players[game.currentPlayer]._votingPoints));
                            textLabel2.setText("Round points: ");
                            numberLabel2.setText(Integer.toString(game.players[game.currentPlayer]._roundPionts));
                            Card blankCard = new Card(0, 0, "./Cards/blankCard.png");
                            if (game.playGround[0].getImageURL() != "./Cards/blankCard.png" && game.playGround[1].getImageURL() != "./Cards/blankCard.png" && game.playGround[2].getImageURL() != "./Cards/blankCard.png") {
                                game.playGround[0] = blankCard;
                                game.playGround[1] = blankCard;
                                game.playGround[2] = blankCard;
                                game.circleCounter--;
                            }
                            ShowHand();
                            ShowPlayGround();
                            SetPlayButtonsVisible(true);
                            nextPlayer.setVisible(true);
                            nextPlayer.setEnabled(false);
                            int winner;
                            if(game.circleCounter == 0)
                            {
                                winner = game.RoundEnd();
                                if(winner == -1)
                                {
                                    game.RoundStart();
                                    MeldunekIcon(0);
                                    revealButton.doClick();
                                }
                                else {
                                    SetPlayGroundVisible(false);
                                    SetPlayButtonsVisible(false);
                                    SetPlayButtonsVisible(false);
                                    CoverCards();
                                    enter1.setVisible(false);
                                    enter2.setVisible(false);
                                    enter3.setVisible(false);
                                    nextPlayer.setVisible(false);
                                    melduj.setVisible(false);
                                    MeldunekIcon(0);
                                    Name1.setVisible(false);
                                    Name2.setVisible(false);
                                    Name3.setVisible(false);
                                    Points1.setVisible(false);
                                    Points2.setVisible(false);
                                    Points3.setVisible(false);
                                    textLabel.setVisible(false);
                                    textLabel2.setVisible(false);
                                    numberLabel.setVisible(false);
                                    numberLabel2.setVisible(false);
                                    winnerText.setText("The winner is ");
                                    winnerLabel.setText(game.players[winner]._name + " !!!");
                                }
                            }
                            if (game.playGround[0].getImageURL() == "./Cards/blankCard.png" && game.playGround[1].getImageURL() == "./Cards/blankCard.png" && game.playGround[2].getImageURL() == "./Cards/blankCard.png")
                            {
                                melduj.setVisible(true);
                                cancelMelduj.setVisible(false);
                            }
                        }
                        else
                        {
                            playGround0.setIcon(game._deck.getCard(0).getImage());
                            playGround1.setIcon(game._deck.getCard(1).getImage());
                            playGround2.setIcon(game._deck.getCard(2).getImage());
                            SetPlayGroundButtonsVisible(true);
                            SetPlayButtonsVisible(true);
                            SetPlayButtonsText("Dismiss");
                            ShowHand();
                            ShowPlayGround();
                        }
                    }
                revealButton.setVisible(false);
                UpdatePoints();
            }
        });

        playGround0Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Click_Dismiss(0);
                playGround0Button.setEnabled(false);
            }
        });

        playGround1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Click_Dismiss(1);
                playGround1Button.setEnabled(false);
            }
        });

        playGround2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Click_Dismiss(2);
                playGround2Button.setEnabled(false);
            }
        });

        playCard1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Click_Play(0);
            }
        });

        playCard2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Click_Play(1);
            }
        });

        playCard3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Click_Play(2);
            }
        });

        playCard4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Click_Play(3);
            }
        });

        playCard5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Click_Play(4);
            }
        });

        playCard6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Click_Play(5);
            }
        });

        playCard7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Click_Play(6);
            }
        });

        playCard8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { Click_Play(7); }
        });

        melduj.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                melduj.setVisible(false);
                cancelMelduj.setVisible(true);
                DisablePlayButtons();
                if(IfContainsMeldunek(40))
                {
                    Card tmpQeen = new Card(3,40, "./Cards/c13.png");
                    EnableQueenPlayButton(QueenIndex(40));
                }
                if(IfContainsMeldunek(60))
                {
                    Card tmpQeen = new Card(3,60, "./Cards/s13.png");
                    EnableQueenPlayButton(QueenIndex(60));
                }
                if(IfContainsMeldunek(80))
                {
                    Card tmpQeen = new Card(3,80, "./Cards/d13.png");
                    EnableQueenPlayButton(QueenIndex(80));
                }
                if(IfContainsMeldunek(100))
                {
                    Card tmpQeen = new Card(3,100, "./Cards/h13.png");
                    EnableQueenPlayButton(QueenIndex(100));
                }
                game.melduj = true;
            }
        });

        cancelMelduj.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cancelMelduj.setVisible(false);
                melduj.setVisible(true);
                game.melduj = false;
                ShowHand();
            }
        });
    }

    private void Init()
    {
        SetPlayGroundButtonsVisible(false);
        SetPlayButtonsVisible(false);
        SetPlayGroundVisible(false);
        nextPlayer.setVisible(false);
        revealButton.setVisible(false);
        dismissButton1.setVisible(false);
        dismissButton2.setVisible(false);
        dismissButton3.setVisible(false);
        enter1.setVisible(false);
        enter2.setVisible(false);
        enter3.setVisible(false);
        melduj.setVisible(false);
        cancelMelduj.setVisible(false);
    }

    private void Click_Play(int index)
    {
        if(!game.musik && !game.melduj) {
            game.playCard(index);
            ShowHand();
            ShowPlayGround();
            DisablePlayButtons();
            nextPlayer.setEnabled(true);
            melduj.setVisible(false);
        }
        if(game.musik){
            game.players[(game.currentPlayer + game.musikCounter) % 3]._hand.add(game.players[game.currentPlayer].GetHand().get(index));
            game.players[game.currentPlayer].removeCard(index);
            game.musikCounter--;
            ShowHand();
            MusikEnd();
        }
        if(game.melduj)
        {
            game.meldunek = game.players[game.currentPlayer]._hand.get(index).getColor();
            game.playCard(index);
            ShowHand();
            ShowPlayGround();
            DisablePlayButtons();
            nextPlayer.setEnabled(true);
            cancelMelduj.setVisible(false);
            game.players[game.currentPlayer]._roundPionts += game.meldunek;
            game.melduj = false;

        }
    }

    private void MeldunekIcon(int color)
    {
        if(color == 0) {
            currentMendunek.setText("");
            meldunekValue.setText("");
        }
        if(color == 40){
            currentMendunek.setText("Current meldunek: ");
            meldunekValue.setText("Spades");
        }
        if(color == 60){
            currentMendunek.setText("Current meldunek: ");
            meldunekValue.setText("Clubs");
        }
        if(color == 80){
            currentMendunek.setText("Current meldunek: ");
            meldunekValue.setText("Diamonds");
        }
        if(color == 100){
            currentMendunek.setText("Current meldunek: ");
            meldunekValue.setText("Hearts");
        }

    }

    private void Click_Dismiss(int index)
    {
        game.players[(game.currentPlayer + game.musikCounter) % 3].GetHand().add(game._deck.getCard(index));
        game._deck.removeCard(index);
        game.musikCounter--;
        ShowPlayGround();
        ShowHand();
        MusikEnd();
    }

    private void MusikEnd()
    {
        if(game.musikCounter == 0)
        {
            if(game._deck.getCard(0).getImageURL() != "./Cards/blankCard.png")game.players[game.currentPlayer]._hand.add(game._deck.getCard(0));
            if(game._deck.getCard(1).getImageURL() != "./Cards/blankCard.png")game.players[game.currentPlayer]._hand.add(game._deck.getCard(1));
            if(game._deck.getCard(2).getImageURL() != "./Cards/blankCard.png")game.players[game.currentPlayer]._hand.add(game._deck.getCard(2));
            game.players[0].ClearHand();
            game.players[1].ClearHand();
            game.players[2].ClearHand();
            game.musik = false;
            Card blankCard = new Card(0, 0, "./Cards/blankCard.png");
            if (game.playGround[0].getImageURL() != "./Cards/blankCard.png" && game.playGround[1].getImageURL() != "./Cards/blankCard.png" && game.playGround[2].getImageURL() != "./Cards/blankCard.png") {
                game.playGround[0] = blankCard;
                game.playGround[1] = blankCard;
                game.playGround[2] = blankCard;
            }
            ShowHand();
            ShowPlayGround();
            SetPlayButtonsVisible(true);
            nextPlayer.setVisible(true);
            nextPlayer.setEnabled(false);
            UpdatePoints();
            playGround0Button.setEnabled(true);
            playGround1Button.setEnabled(true);
            playGround2Button.setEnabled(true);
            SetPlayGroundButtonsVisible(false);
            SetPlayButtonsText("Play");
            melduj.setVisible(true);
        }
    }

    private void ShowPlayGround()
    {
        if(!game.musik)
        {
            playGround0.setIcon(game.playGround[0].getImage());
            playGround1.setIcon(game.playGround[1].getImage());
            playGround2.setIcon(game.playGround[2].getImage());
        }
        else
        {
            playGround0.setIcon(game._deck.getCard(0).getImage());
            playGround1.setIcon(game._deck.getCard(1).getImage());
            playGround2.setIcon(game._deck.getCard(2).getImage());
        }
    }

    private void ShowHand()
    {
        one.setIcon(game.players[game.currentPlayer].GetHand().get(0).getImage());
        two.setIcon(game.players[game.currentPlayer].GetHand().get(1).getImage());
        three.setIcon(game.players[game.currentPlayer].GetHand().get(2).getImage());
        four.setIcon(game.players[game.currentPlayer].GetHand().get(3).getImage());
        five.setIcon(game.players[game.currentPlayer].GetHand().get(4).getImage());
        six.setIcon(game.players[game.currentPlayer].GetHand().get(5).getImage());
        seven.setIcon(game.players[game.currentPlayer].GetHand().get(6).getImage());
        eight.setIcon(game.players[game.currentPlayer].GetHand().get(7).getImage());

        playCard1.setEnabled(false);
        playCard2.setEnabled(false);
        playCard3.setEnabled(false);
        playCard4.setEnabled(false);
        playCard5.setEnabled(false);
        playCard6.setEnabled(false);
        playCard7.setEnabled(false);
        playCard8.setEnabled(false);

        if(game.currentPlayer != game.gamer)
        {
            int gamerColor = game.playGround[game.gamer].getColor();
            int flag = 0;
            for (Card card : game.players[game.currentPlayer].GetHand())
            {
                if (card.getColor() == gamerColor)
                {
                    flag = 1;
                }
            }
            if(flag == 1){
                if (game.players[game.currentPlayer].GetHand().get(0).getImageURL() != "./Cards/blankCard.png" && game.players[game.currentPlayer].GetHand().get(0).getColor() == gamerColor)
                    playCard1.setEnabled(true);
                if (game.players[game.currentPlayer].GetHand().get(1).getImageURL() != "./Cards/blankCard.png" && game.players[game.currentPlayer].GetHand().get(1).getColor() == gamerColor)
                    playCard2.setEnabled(true);
                if (game.players[game.currentPlayer].GetHand().get(2).getImageURL() != "./Cards/blankCard.png" && game.players[game.currentPlayer].GetHand().get(2).getColor() == gamerColor)
                    playCard3.setEnabled(true);
                if (game.players[game.currentPlayer].GetHand().get(3).getImageURL() != "./Cards/blankCard.png" && game.players[game.currentPlayer].GetHand().get(3).getColor() == gamerColor)
                    playCard4.setEnabled(true);
                if (game.players[game.currentPlayer].GetHand().get(4).getImageURL() != "./Cards/blankCard.png" && game.players[game.currentPlayer].GetHand().get(4).getColor() == gamerColor)
                    playCard5.setEnabled(true);
                if (game.players[game.currentPlayer].GetHand().get(5).getImageURL() != "./Cards/blankCard.png" && game.players[game.currentPlayer].GetHand().get(5).getColor() == gamerColor)
                    playCard6.setEnabled(true);
                if (game.players[game.currentPlayer].GetHand().get(6).getImageURL() != "./Cards/blankCard.png" && game.players[game.currentPlayer].GetHand().get(6).getColor() == gamerColor)
                    playCard7.setEnabled(true);
                if (game.players[game.currentPlayer].GetHand().get(7).getImageURL() != "./Cards/blankCard.png" && game.players[game.currentPlayer].GetHand().get(7).getColor() == gamerColor)
                    playCard8.setEnabled(true);
            }
            else
            {
                if (game.players[game.currentPlayer].GetHand().get(0).getImageURL() != "./Cards/blankCard.png")
                playCard1.setEnabled(true);
                if (game.players[game.currentPlayer].GetHand().get(1).getImageURL() != "./Cards/blankCard.png")
                    playCard2.setEnabled(true);
                if (game.players[game.currentPlayer].GetHand().get(2).getImageURL() != "./Cards/blankCard.png")
                    playCard3.setEnabled(true);
                if (game.players[game.currentPlayer].GetHand().get(3).getImageURL() != "./Cards/blankCard.png")
                    playCard4.setEnabled(true);
                if (game.players[game.currentPlayer].GetHand().get(4).getImageURL() != "./Cards/blankCard.png")
                    playCard5.setEnabled(true);
                if (game.players[game.currentPlayer].GetHand().get(5).getImageURL() != "./Cards/blankCard.png")
                    playCard6.setEnabled(true);
                if (game.players[game.currentPlayer].GetHand().get(6).getImageURL() != "./Cards/blankCard.png")
                    playCard7.setEnabled(true);
                if (game.players[game.currentPlayer].GetHand().get(7).getImageURL() != "./Cards/blankCard.png")
                    playCard8.setEnabled(true);
            }
        }
        else {
            if (game.players[game.currentPlayer].GetHand().get(0).getImageURL() != "./Cards/blankCard.png")
                playCard1.setEnabled(true);
            if (game.players[game.currentPlayer].GetHand().get(1).getImageURL() != "./Cards/blankCard.png")
                playCard2.setEnabled(true);
            if (game.players[game.currentPlayer].GetHand().get(2).getImageURL() != "./Cards/blankCard.png")
                playCard3.setEnabled(true);
            if (game.players[game.currentPlayer].GetHand().get(3).getImageURL() != "./Cards/blankCard.png")
                playCard4.setEnabled(true);
            if (game.players[game.currentPlayer].GetHand().get(4).getImageURL() != "./Cards/blankCard.png")
                playCard5.setEnabled(true);
            if (game.players[game.currentPlayer].GetHand().get(5).getImageURL() != "./Cards/blankCard.png")
                playCard6.setEnabled(true);
            if (game.players[game.currentPlayer].GetHand().get(6).getImageURL() != "./Cards/blankCard.png")
                playCard7.setEnabled(true);
            if (game.players[game.currentPlayer].GetHand().get(7).getImageURL() != "./Cards/blankCard.png")
                playCard8.setEnabled(true);
        }
    }

    private void CoverCards()
    {
        ImageIcon image = new javax.swing.ImageIcon(table.class.getResource("./CardBacks/Card-Back-01.png"));
        one.setIcon(image);
        two.setIcon(image);
        three.setIcon(image);
        four.setIcon(image);
        five.setIcon(image);
        six.setIcon(image);
        seven.setIcon(image);
        eight.setIcon(image);
    }

    private void DisablePlayButtons()
    {
        playCard1.setEnabled(false);
        playCard2.setEnabled(false);
        playCard3.setEnabled(false);
        playCard4.setEnabled(false);
        playCard5.setEnabled(false);
        playCard6.setEnabled(false);
        playCard7.setEnabled(false);
        playCard8.setEnabled(false);
    }

    private void SetPlayButtonsVisible(boolean set)
    {
        playCard1.setVisible(set);
        playCard2.setVisible(set);
        playCard3.setVisible(set);
        playCard4.setVisible(set);
        playCard5.setVisible(set);
        playCard6.setVisible(set);
        playCard7.setVisible(set);
        playCard8.setVisible(set);
    }

    private void SetPlayButtonsText(String tekst)
    {
        playCard1.setText(tekst);
        playCard2.setText(tekst);
        playCard3.setText(tekst);
        playCard4.setText(tekst);
        playCard5.setText(tekst);
        playCard6.setText(tekst);
        playCard7.setText(tekst);
        playCard8.setText(tekst);
    }

    private void SetPlayGroundButtonsVisible(boolean set)
    {
        playGround0Button.setVisible(set);
        playGround1Button.setVisible(set);
        playGround2Button.setVisible(set);
    }

    private void SetPlayGroundVisible(boolean set)
    {
        playGround0.setVisible(set);
        playGround1.setVisible(set);
        playGround2.setVisible(set);
    }

    private void UpdatePoints()
    {
        String tmpString;
        tmpString = Integer.toString(game.players[0]._points);
        Points1.setText(tmpString + " points");
        tmpString = Integer.toString(game.players[1]._points);
        Points2.setText(tmpString + " points");
        tmpString = Integer.toString(game.players[2]._points);
        Points3.setText(tmpString + " points");
        textLabel.setText("Voted points: ");
        numberLabel.setText(Integer.toString(game.players[game.currentPlayer]._votingPoints));
        textLabel2.setText("Round points: ");
        numberLabel2.setText(Integer.toString(game.players[game.currentPlayer]._roundPionts));
    }

    private boolean IfContainsMeldunek(int color)
    {
        int couple = 0;
        for(Card queen: game.players[game.currentPlayer]._hand)
        {
            if(queen.getColor() == color && queen.getValue() == 3) couple++;
        }
        for(Card king: game.players[game.currentPlayer]._hand)
        {
            if(king.getColor() == color && king.getValue() == 4) couple++;
        }
        if(couple == 2)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    private void EnableQueenPlayButton(int index) {
        if(index == 0) playCard1.setEnabled(true);
        if(index == 1) playCard2.setEnabled(true);
        if(index == 2) playCard3.setEnabled(true);
        if(index == 3) playCard4.setEnabled(true);
        if(index == 4) playCard5.setEnabled(true);
        if(index == 5) playCard6.setEnabled(true);
        if(index == 6) playCard7.setEnabled(true);
        if(index == 7) playCard8.setEnabled(true);
    }

    private int QueenIndex(int color)
    {
        int index = 0;
        int i = 0;
        for(Card queen: game.players[game.currentPlayer]._hand)
        {
            if(queen.getValue() == 3 && queen.getColor() == color) index = i;
            i++;
        }
        return index;
    }

    /**
     * Metoda main odpowiedzialna za inicjację aplikacji, jej interfejsu graficznego oraz tworząca nową grę (Game).
     * @param args default.
     */
    public static void main(String[] args){
    JFrame frame = new JFrame("App");
    frame.setContentPane (new table().panel1);
    game = new Game();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
}
    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}