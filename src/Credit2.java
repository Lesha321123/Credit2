import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;


class NewFrame implements ActionListener, KeyListener {

    //День выплаты
    public static void dayOfPayment(Calendar data) {
        data.add(Calendar.DAY_OF_MONTH, 50);
        SimpleDateFormat format1 = new SimpleDateFormat("dd-MM-yyyy");
        String formatted = format1.format(data.getTime());
        System.out.println("Дата выплаты: " + formatted); }

    private JFrame frame;
    JButton btn1;
    JButton btn2;
    JTextField tf1;
    JTextField tf2;
    JLabel jl1;
    JLabel jl2;
    JLabel jl3;
    double debt;
    double mon;
    double mon2;
    double pay;
    double pay1;
    int width = 350;
    int height = 200;

    //Число месяцев
    int i = 0;
    //Сегодняшняя дата
    Calendar data = Calendar.getInstance();
    SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
    String formatted = format1.format(data.getTime());


    NewFrame() {
        //название окна
        frame = new JFrame("Кредит");
        //Размеры окна и координаты
        frame.setBounds(960, 540, width, height);
        //вся программа завершается при закрытии этого окна
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Отключение менеджера компоновки
        frame.setLayout(null);
        //Нельзя изменять размер окна
        frame.setResizable(false);

        //Создание кнопки "Закрыть"
        btn1 = new JButton("Закрыть");
        //Положение и размер кнопки
        btn1.setBounds(220, height-80, 100, 30);
        //Регистрация обработчика действий
        btn1.addActionListener(this);


        //Создание кнопки "Подсчет"
        btn2 = new JButton("Подсчет");
        //Положение и размер кнопки
        btn2.setBounds(20, height-80, 100, 30);
        //Регистрация обработчика действий
        btn2.addActionListener(this);

        //Создание текстового поля "Сумма кредита"
        tf1 = new JTextField();
        //Расположение поля
        tf1.setBounds(35, 30, 50, 30);
        tf1.addKeyListener(this);


        //Создание текстового поля "Процентная ставка"
        tf2 = new JTextField();
        //Расположение поля
        tf2.setBounds(width-140, 30, 50, 30);
        tf2.addKeyListener(this);


        //Создание первой текстовой метки
        jl1 = new JLabel("Сумма кредита");
        //Координаты и размеры метки
        jl1.setBounds(20, 0, 150, 30);

        //Создание второй текстовой метки
        jl2 = new JLabel("Процентная ставка");
        //Координаты и размеры метки
        jl2.setBounds(width-170, 0, 150, 30);


        //Создание третьей текстовой метки
        jl3 = new JLabel("Сегодня " + formatted);
        //Координаты и размеры метки
        jl3.setBounds(width/2-80, height/2-20, 150, 30);

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
            mon2 = mon / 12 + 5;
            pay1 = debt / 100 * mon2;
                if(pay1 < 150)
                    pay1 = 150;
            while (debt > 150) {
                pay = debt / 100 * mon2;//Обязательный платеж
                if (pay > 150) {
                    i++;
                    dayOfPayment(data);
                } else {
                    i++;
                    pay = 150;
                    dayOfPayment(data);
                }
                System.out.println("Задолженность: " + Math.round(debt));
                System.out.println("Обязательный платеж: " + Math.round(pay));
                debt = debt - pay;
                if (debt < 150) {
                    i++;
                    dayOfPayment(data);
                    pay = debt;
                    System.out.println("Задолженность: " + Math.round(debt));
                    System.out.println("Обязательный платеж: " + Math.round(pay));
                    System.out.println("Общее количество месяцев: " + i);
                    break; }

            }
            pay = pay + 150;
            JOptionPane.showMessageDialog(null, "Общее кол-во месяцев: " + i + '\n'
                    + "Первый платеж: " + Math.round(pay1) + '\n' + "Последний платеж: " + Math.round(pay));
        }
        if (btName.equalsIgnoreCase(btn1.getText())){
            System.exit(0);}
    }}


public class Credit2 {
    public static void main(String[] args) {

        //Окно
        new NewFrame(); }}