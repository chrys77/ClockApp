import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MyFrame extends JFrame {

    JPanel panel;
    SimpleDateFormat timeFormat;
    SimpleDateFormat dayFormat;
    SimpleDateFormat dateFormat;
    JLabel timeLabel;
    JLabel dayLabel;
    JLabel dateLabel;
    String time;
    String day;
    String date;

    MyFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("My CLock App, by Dobro");
        this.setLayout(null);
        this.setSize(350, 200);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.setSize(350, 200);
        panel.setBackground(Color.BLACK);
        panel.setOpaque(true);

        timeFormat = new SimpleDateFormat("hh:mm:ss a");
        dayFormat = new SimpleDateFormat("EEEE");
        dateFormat = new SimpleDateFormat("dd MMMMM yyyy");

        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Verdana", Font.PLAIN, 45));
        timeLabel.setForeground(Color.GREEN);

        dayLabel = new JLabel();
        dayLabel.setFont(new Font("Verdana", Font.PLAIN, 35));
        dayLabel.setForeground(Color.MAGENTA);

        dateLabel = new JLabel();
        dateLabel.setFont(new Font("Verdana", Font.PLAIN, 25));
        dateLabel.setForeground(Color.YELLOW);

        this.add(panel);
        panel.add(timeLabel);
        panel.add(dayLabel);
        panel.add(dateLabel);
        this.setVisible(true);

        setTime();
    }

    public void setTime() {
        while (true) {
            time = timeFormat.format(Calendar.getInstance().getTime());
            timeLabel.setText(time);

            day = dayFormat.format(Calendar.getInstance().getTime());
            dayLabel.setText(day);

            date = dateFormat.format(Calendar.getInstance().getTime());
            dateLabel.setText(date);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
