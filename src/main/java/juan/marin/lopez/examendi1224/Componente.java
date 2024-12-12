package juan.marin.lopez.examendi1224;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import javax.swing.*;
import java.awt.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;


/**
 *
 * @author ADMINISTRADORGS2
 */




public class Componente extends JTextField {
    

    public Componente() {
        super("1");
        configurarEstilo();
        agregarListener();
    }


    public Componente(String textoInicial) {
        super(textoInicial);
        configurarEstilo();
        agregarListener();
    }


    private void configurarEstilo() {
        setOpaque(true); 
        setHorizontalAlignment(SwingConstants.CENTER);
        setFont(new Font("Arial", Font.BOLD, 16)); 
        actualizarColor();
    }


    private void agregarListener() {
        getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                validarTexto();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                validarTexto();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                validarTexto();
            }
        });
    }


    private void validarTexto() {
        SwingUtilities.invokeLater(() -> {
            String texto = getText().trim();
            try {
                int numero = Integer.parseInt(texto);
                if (numero < 1) {
                    setText("1");
                } else if (numero > 10) {
                    setText("10"); 
                }
            } catch (NumberFormatException e) {
                setText("1"); 
            }
            actualizarColor(); 
        });
    }


    private void actualizarColor() {
        try {
            int numero = Integer.parseInt(getText().trim());
            if (numero < 5) {
                setForeground(Color.RED); 
            } else {
                setForeground(Color.BLACK);
            }
        } catch (NumberFormatException e) {
            setForeground(Color.GRAY);
        }
    }
}
