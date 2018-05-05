import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLOutput;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Calendar;


class NewFrame implements ActionListener, KeyListener {

    private JFrame frame;
    JButton btn1;
    JButton btn2;
    JTextField tf1;
    JTextField tf2;
    JLabel jl1;
    JLabel jl2;
    JLabel jl3;
    static double debt;
    static double mon;



    NewFrame() {

        //название окна
        frame = new JFrame("Кредит");
        //Размеры окна и координаты
        frame.setBounds(960, 540, 350, 300);
        //вся программа завершается при закрытии этого окна
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Отключение менеджера компоновки
        frame.setLayout(null);
        //Нельзя изменять размер окна
        frame.setResizable(false);

        //Создание кнопки "Закрыть"
        btn1 = new JButton("Закрыть");
        //Положение и размер кнопки
        btn1.setBounds(220, 220, 100, 30);
        //Регистрация обработчика действий
        btn1.addActionListener(this);


        //Создание кнопки "Подсчет"
        btn2 = new JButton("Подсчет");
        //Положение и размер кнопки
        btn2.setBounds(20, 220, 100, 30);
        //Регистрация обработчика действий
        btn2.addActionListener(this);

        //Создание текстового поля "Сумма кредита"
        tf1 = new JTextField();
        //Расположение поля
        tf1.setBounds(20, 30, 50, 30);
        tf1.addKeyListener(this);


        //Создание текстового поля "Процентная ставка"
        tf2 = new JTextField();
        //Расположение поля
        tf2.setBounds(20, 100, 50, 30);
        tf2.addKeyListener(this);


        //Создание первой текстовой метки
        jl1 = new JLabel("Сумма кредита");
        //Координаты и размеры метки
        jl1.setBounds(20, 0, 150, 30);

        //Создание второй текстовой метки
        jl2 = new JLabel("Процентная ставка");
        //Координаты и размеры метки
        jl2.setBounds(20, 70, 150, 30);


        //Создание третьей текстовой метки
        jl3 = new JLabel();
        //Координаты и размеры метки
        jl3.setBounds(175, 190, 150, 30);

        frame.add(btn1);
        frame.add(btn2);
        frame.add(tf1);
        frame.add(tf2);
        frame.add(jl1);
        frame.add(jl2);
        frame.add(jl3);
        //Отображение окна
        frame.setVisible(true);
        btn2.setEnabled(false);
    }


    public void keyReleased(KeyEvent ke) {
        try {
            Integer.parseInt(tf1.getText());
            Integer.parseInt(tf2.getText());
            btn2.setEnabled(true);
        } catch (Exception e) {
            btn2.setEnabled(false);
        }
    }


    public void keyPressed(KeyEvent ke) {
    }

    public void keyTyped(KeyEvent ke) {
    }

    public void actionPerformed(java.awt.event.ActionEvent ae) {

        String btName = ae.getActionCommand();

        if (btName.equalsIgnoreCase(btn2.getText())) {
            debt = Double.parseDouble(tf1.getText());
            mon = Double.parseDouble(tf2.getText());
            System.out.println(debt+ " " + mon);
        }
        else System.exit(0);


    }
}


    public class Credit2 {
          static double mon;
        public static void main(String[] args) {
            //Окно
            new NewFrame();
            //Число месяцев
            int i = 0;
            //Сегодняшняя дата
            Calendar data = Calendar.getInstance();
            SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
            String formatted = format1.format(data.getTime());
            System.out.println("Сегодня: " + formatted);
            /*Вводим сумму кредита
            System.out.println("Введите сумму кредита");
            double debt = Enter();
            //Вводим процентную ставку
            System.out.println("Введите процентную ставку");
            double mon = Monthly();*/
            //Считаем задолженность и обязательный платеж
            mon = mon/12 + 5;
            while (NewFrame.debt > 150) {
                double pay = NewFrame.debt / 100 * mon; //Обязательный платеж
                if (pay > 150) {
                    i++;
                    dayOfPayment(data);
                } else {
                    i++;
                    pay = 150;
                    dayOfPayment(data);
                }
                System.out.println("Задолженность: " + Math.round(NewFrame.debt));
                System.out.println("Обязательный платеж: " + Math.round(pay));
                NewFrame.debt = NewFrame.debt - pay;
                if (NewFrame.debt < 150) {
                    i++;
                    dayOfPayment(data);
                    pay = NewFrame.debt;
                    System.out.println("Задолженность: " + Math.round(NewFrame.debt));
                    System.out.println("Обязательный платеж: " + Math.round(pay));
                    System.out.println("Общее количество месяцев: " + i);
                    break; }
            }
        }


        //Методы

        //Ввод данных
        public static double Enter() {
            Scanner sc = new Scanner(System.in);
            return sc.nextDouble();
        }

        //Процентная ставка
        public static double Monthly() {
            Scanner sc2 = new Scanner(System.in);
            double st = sc2.nextDouble();
            return st / 12 + 5;
        }

        //День выплаты
        public static void dayOfPayment(Calendar data) {
            data.add(Calendar.DAY_OF_MONTH, 50);
            SimpleDateFormat format1 = new SimpleDateFormat("dd-MM-yyyy");
            String formatted = format1.format(data.getTime());
            System.out.println("Дата выплаты: " + formatted);
        }
    }