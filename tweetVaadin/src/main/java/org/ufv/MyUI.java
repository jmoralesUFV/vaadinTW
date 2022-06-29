package org.ufv;

import javax.servlet.annotation.WebServlet;

import com.sun.org.apache.xalan.internal.xsltc.dom.StepIterator;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.*;

import java.util.Date;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of an HTML page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI {

    Tweets listaTweets = new Tweets();
    Tweet tweet = new Tweet();

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        final VerticalLayout layout = new VerticalLayout();
        HorizontalLayout botons = new HorizontalLayout();
        VerticalLayout mainRight = new VerticalLayout();

        /*
        final TextField name = new TextField();
        name.setCaption("Type your name here:");

        Button button = new Button("Click Me");
        button.addClickListener(e -> {
            layout.addComponent(new Label("Thanks " + name.getValue() 
                    + ", it works!"));
        });
        
        layout.addComponents(name, button);
        */

        // setContent(layout);

        TextField usuario = new TextField("Username:");
        TextField mensaje = new TextField("Message:");

        usuario.setWidth(25, Unit.PERCENTAGE);
        mensaje.setWidth(25, Unit.PERCENTAGE);

        Button button2 = new Button("Imprimir datos");
        button2.addClickListener(e -> {

            String fechaFormeteada = tweet.getFechaFormateada(tweet.getFecha());

            listaTweets.addTW(new Tweet(String.valueOf(usuario.getValue()), String.valueOf(mensaje.getValue()), String.valueOf(mensaje.getValue().length()), new Date()));

            mainRight.addComponent(new Label("Usuario: " + usuario.getValue()
                    + ", dice: " + mensaje.getValue() + ", a fecha: " + fechaFormeteada + ", con un tamaño de: " + mensaje.getValue().length() + " caracteres."));

        });

        Button buton3 = new Button("Actualizar tweets");
        Button buton4 = new Button("Limpiar pantalla tweets");

        buton3.addClickListener(e -> {

            Tweet elem;

            mainRight.removeAllComponents();

            int pos = listaTweets.returnTamaño();

            // mainRight.addComponent(new Label(String.valueOf(listaTweets.getAllTW())));

           for(int i = 0; i < pos; i++)
           {

               String username = listaTweets.getBusquedaById(i).getNombre_usuario();
               String dice = listaTweets.getBusquedaById(i).getMensaje();
               String tamaño = listaTweets.getBusquedaById(i).getTamaño();
               String fecha = listaTweets.getBusquedaById(i).getFechaFormateada(listaTweets.getBusquedaById(i).getFecha());

               mainRight.addComponent(new Label("Usuario: " + username
                       + ", dice: " + dice + ", a fecha: " + fecha + ", con un tamaño de: " + tamaño + " caracteres."));

           }

        });

        buton4.addClickListener(e -> {
            mainRight.removeAllComponents();
        });

        layout.addComponents(usuario, mensaje);

        setContent(layout);

        botons.addComponents(button2, buton3, buton4);

        layout.addComponents(botons, mainRight);

        setContent(layout);
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
