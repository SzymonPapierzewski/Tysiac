package Logic;

import GameGUI.table;

import javax.swing.*;

/**
 * Klasa odpowiedzialna za karty.
 */
public class Card {
    private int _value;
    private int _color;
    private ImageIcon _image;
    private String _imageURL;

    /**
     * Konstruktor ,który polu _value przypisuje wartość value, polu _color wartość color, polu _imageURL wartość imageURL oraz polu _image ggeneruje obraz o adresie URL z pola _imageURL.
     * @param value Wartość figury.
     * @param color Wartość koloru.
     * @param imageURL  URL obrazka karty.
     */
    public Card(int value, int color, String imageURL)
    {
        _value = value;
        _color = color;
        _image = new javax.swing.ImageIcon(table.class.getResource(imageURL));
        _imageURL = imageURL;
    }

    /**
     * Metoda zwraca wartość pola _value.
     * @return  Wartość figury.
     */
    public int getValue()
    {
        return _value;
    }

    /**
     * Metoda zwraca wartość pola _color.
     * @return Wartość koloru.
     */
    public int getColor()
    {
        return _color;
    }

    /**
     * Metoda zwraca wartość pola _imageURL.
     * @return URL obrazka.
     */
    public String getImageURL() { return _imageURL; }

    /**
     * Metoda zwraca wartość pola _image.
     * @return Obrazek.
     */
    public ImageIcon getImage() { return _image; }
}