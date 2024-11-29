import javax.swing.JFrame;

 public class imagenmain {
    public static void main(String[] args) {
        {
            JFrame frame = new JFrame("Nah");
            frame.setSize(476, 476);
            frame.setLocation(0, 0);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setContentPane(new Imagenes());
            frame.setVisible(true);
        }
}

}