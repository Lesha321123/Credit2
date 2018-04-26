import javafx.event.ActionEvent;

import javax.swing.*;
import java.awt.event.*;



class NewFrame{
    NewFrame() {
        //название окна
        JFrame MyFrame = new JFrame("Кредит");
        //Размеры окна и координаты
        MyFrame.setBounds(960, 540, 300, 200);
        //Закрывать при нажатии
        MyFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //отключение мененджера компоновки
        MyFrame.setLayout(null);
        //Отображение окна
        MyFrame.setVisible(true);

        //Создание кнопки "Подсчет"
        JButton btn1 = new JButton("Подсчет");
        //Положение и размер кнопки
        btn1.setBounds(90, 120, 180, 30);

        //Создание текстового поля "Сумма кредита"
        JTextField tf1 = new JTextField();
        //Расположение поля
        tf1.setBounds(20,30, 50,30);

        //Создание текстового поля "Процентная ставка"
        JTextField tf2 = new JTextField();
        //Расположение поля
        tf1.setBounds(230,30, 50,30);


        //Создание первой текстовой метки
        JLabel jl1 = new JLabel("Сумма кредита");
        //Координаты и размеры метки
        jl1.setBounds(20,0,150,30);


        //Создание второй текстовой метки
        JLabel jl2 = new JLabel("Процентная ставка");
        //Координаты и размеры метки
        jl1.setBounds(250,0,150,30);



        MyFrame.add(btn1);
        MyFrame.add(tf1);
        MyFrame.add(tf2);
        MyFrame.add(jl1);
        MyFrame.add(jl2);

    }
    }

