import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

class Car {
    String model;
    boolean available;

    public Car(String model, boolean available) {
        this.model = model;
        this.available = available;
    }

    @Override
    public String toString() {
        return model + " - " + (available ? "Available" : "Not Available");
    }
}

class CarRentalSystem {
    private List<Car> cars;

    public CarRentalSystem() {
        cars = new ArrayList<>();
        cars.add(new Car("Sedan", true));
        cars.add(new Car("SUV", true));
        cars.add(new Car("Convertible", false));
    }

    public List<Car> getAvailableCars() {
        List<Car> availableCars = new ArrayList<>();
        for (Car car : cars) {
            if (car.available) {
                availableCars.add(car);
            }
        }
        return availableCars;
    }

    public void makeReservation(int index) {
        if (index >= 0 && index < cars.size()) {
            cars.get(index).available = false;
        }
    }
}

class CarRentalGUI extends JFrame {
    private CarRentalSystem carRentalSystem;

    private JList<String> carList;
    private DefaultListModel<String> listModel;

    public CarRentalGUI() {
        carRentalSystem = new CarRentalSystem();

        setTitle("Car Rental System");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initComponents();
    }

    private void initComponents() {
        listModel = new DefaultListModel<>();
        updateCarList();

        carList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(carList);

        JButton reserveButton = new JButton("Make Reservation");
        reserveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = carList.getSelectedIndex();
                if (selectedIndex != -1) {
                    carRentalSystem.makeReservation(selectedIndex);
                    updateCarList();
                    JOptionPane.showMessageDialog(CarRentalGUI.this, "Reservation made successfully!");
                } else {
                    JOptionPane.showMessageDialog(CarRentalGUI.this, "Please select a car to make a reservation.");
                }
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(scrollPane)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(150, 150, 150)
                                .addComponent(reserveButton)
                                .addContainerGap(150, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(reserveButton)
                                .addContainerGap(30, Short.MAX_VALUE))
        );
    }

    private void updateCarList() {
        listModel.clear();
        List<Car> availableCars = carRentalSystem.getAvailableCars();
        for (Car car : availableCars) {
            listModel.addElement(car.toString());
        }
    }
}

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
            }
        });
    }
}
