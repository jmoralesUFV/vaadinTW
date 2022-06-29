package org.ufv;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Tweets {

    private ArrayList<Tweet> ListaTweets;

    public Tweets()
    {
        this.ListaTweets = new ArrayList<Tweet>(500);
    }

    // Funciones

    public Boolean addTW(Tweet TW)
    {
        Boolean añadido=this.ListaTweets.add(TW);
        return añadido;
    }

    public ArrayList<Tweet> getAllTW()
    {
        return this.ListaTweets;
    }

    public Tweet getBusquedaById(int id)
    {
        return this.ListaTweets.get(id);
    }

    public Tweet updateTweetById(int id, Tweet newTweet)
    {   // Aquí solo se modifica el mensaje y tamaño
        this.ListaTweets.get(id).setMensaje(newTweet.getMensaje());
        this.ListaTweets.get(id).setTamaño(String.valueOf(newTweet.getMensaje().length()));
        return this.ListaTweets.get(id);
    }

    public Tweet removeTweetById(int id)
    {
        return this.ListaTweets.remove(id);
    }

    public int returnTamaño()
    {
        return ListaTweets.size();
    }

}
