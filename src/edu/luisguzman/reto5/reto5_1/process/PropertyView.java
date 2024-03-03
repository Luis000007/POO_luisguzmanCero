package edu.luisguzman.reto5.reto5_1.process;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class PropertyView extends JFrame {
    private final JList<Property> propertyList;

    public PropertyView(List<Property> properties) {
        setTitle("Propiedades Cercanas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        propertyList = new JList<>(properties.toArray(new Property[0]));
        JScrollPane scrollPane = new JScrollPane(propertyList);

        getContentPane().add(scrollPane, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null); // Centrar la ventana en la pantalla
        setVisible(true);
    }
}

