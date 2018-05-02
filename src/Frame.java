import javafx.event.ActionEvent;
import javax.swing.*;
import java.awt.event.*;



class NewFrame implements ActionListener {
    NewFrame() {
        //название окна
        JFrame MyFrame = new JFrame("Кредит");
        //Размеры окна и координаты
        MyFrame.setBounds(960, 540, 350, 200);
        //вся программа завершается при закрытии этого окна
        MyFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Отключение менеджера компоновки
        MyFrame.setLayout(null);
        //Нельзя изменять размер окна
        MyFrame.setResizable(false);

        //Создание кнопки "Закрыть"
        JButton btn1 = new JButton("Закрыть");
        //Положение и размер кнопки
        btn1.setBounds(220, 120, 100, 30);
        //Регистрация обработчика действий
        btn1.addActionListener(this);

        //Создание кнопки "Подсчет"
        JButton btn2 = new JButton("Подсчет");
        //Положение и размер кнопки
        btn2.setBounds(20, 120, 100, 30);
        //Регистрация обработчика действий
        btn2.addActionListener(this);



        //Создание текстового поля "Сумма кредита"
        JTextField tf1 = new JTextField();
        //Расположение поля
        tf1.setBounds(20,30, 50,30);

        //Создание текстового поля "Процентная ставка"
        JTextField tf2 = new JTextField();
        //Расположение поля
        tf2.setBounds(230,30, 50,30);


        //Создание первой текстовой метки
        JLabel jl1 = new JLabel("Сумма кредита");
        //Координаты и размеры метки
        jl1.setBounds(230,0,150,30);


        //Создание второй текстовой метки
        JLabel jl2 = new JLabel("Процентная ставка");
        //Координаты и размеры метки
        jl2.setBounds(20,0,150,30);

        MyFrame.add(btn1);
        MyFrame.add(btn2);
        MyFrame.add(tf1);
        MyFrame.add(tf2);
        MyFrame.add(jl1);
        MyFrame.add(jl2);
        //Отображение окна
        MyFrame.setVisible(true);
    }

    public void actionPerformed(java.awt.event.ActionEvent AE){
        System.exit(0);
    }
    }

