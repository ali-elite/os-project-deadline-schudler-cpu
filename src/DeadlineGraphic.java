import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DeadlineGraphic extends JFrame implements ActionListener {
    private JTextField atTxtField;
    private JButton addButton;
    private JTextField cbtTxtField;
    private JTextField deadlineTxtField;
    private JTextField nameTxtField;
    private JTextField numberTxtField;
    private JTextField priorityTxtField;
    private JButton startButton;
    private JTable table;
    public Scheduler scheduler;

    public DeadlineGraphic(Scheduler scheduler) {
        this.scheduler = scheduler;
        initComponents();
    }

    private void initComponents() {
        JPanel panel = new JPanel();
        JLabel numberLabel = new JLabel();
        numberTxtField = new JTextField();
        JLabel nameLabel = new JLabel();
        nameTxtField = new JTextField();
        JLabel atLabel = new JLabel();
        atTxtField = new JTextField();
        JLabel cbtLabel = new JLabel();
        cbtTxtField = new JTextField();
        JLabel priorityLabel = new JLabel();
        priorityTxtField = new JTextField();
        JLabel deadlineLabel = new JLabel();
        deadlineTxtField = new JTextField();
        addButton = new JButton();
        JScrollPane scrollPane = new JScrollPane();
        startButton = new JButton();
        table = new JTable();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        panel.setBackground(new Color(255, 255, 255));

        numberLabel.setFont(new Font("Segoe UI", Font.BOLD, 12)); // NOI18N
        numberLabel.setHorizontalAlignment(SwingConstants.CENTER);
        numberLabel.setText("Number:");
        numberLabel.setPreferredSize(new Dimension(64, 20));

        numberTxtField.setHorizontalAlignment(JTextField.CENTER);
        numberTxtField.setBorder(new SoftBevelBorder(BevelBorder.RAISED, Color.lightGray, Color.gray, null, Color.darkGray));
        numberTxtField.setMinimumSize(new Dimension(64, 20));
        numberTxtField.setPreferredSize(new Dimension(64, 20));
        numberTxtField.addActionListener(this);

        nameLabel.setFont(new Font("Segoe UI", Font.BOLD, 12)); // NOI18N
        nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        nameLabel.setText("Name:");
        nameLabel.setPreferredSize(new Dimension(64, 20));

        nameTxtField.setHorizontalAlignment(JTextField.CENTER);
        nameTxtField.setBorder(new SoftBevelBorder(BevelBorder.RAISED, Color.lightGray, Color.gray, null, Color.darkGray));
        nameTxtField.setMinimumSize(new Dimension(64, 20));
        nameTxtField.setPreferredSize(new Dimension(64, 20));
        nameTxtField.addActionListener(this);

        atLabel.setFont(new Font("Segoe UI", Font.BOLD, 12)); // NOI18N
        atLabel.setHorizontalAlignment(SwingConstants.CENTER);
        atLabel.setText("AT:");
        atLabel.setPreferredSize(new Dimension(64, 20));

        atTxtField.setHorizontalAlignment(JTextField.CENTER);
        atTxtField.setBorder(new SoftBevelBorder(BevelBorder.RAISED, Color.lightGray, Color.gray, null, Color.darkGray));
        atTxtField.setMinimumSize(new Dimension(64, 20));
        atTxtField.setPreferredSize(new Dimension(64, 20));
        atTxtField.addActionListener(this);

        cbtLabel.setFont(new Font("Segoe UI", Font.BOLD, 12)); // NOI18N
        cbtLabel.setHorizontalAlignment(SwingConstants.CENTER);
        cbtLabel.setText("CBT:");
        cbtLabel.setMinimumSize(new Dimension(64, 20));
        cbtLabel.setPreferredSize(new Dimension(64, 20));

        cbtTxtField.setHorizontalAlignment(JTextField.CENTER);
        cbtTxtField.setBorder(new SoftBevelBorder(BevelBorder.RAISED, Color.lightGray, Color.gray, null, Color.darkGray));
        cbtTxtField.setMinimumSize(new Dimension(64, 20));
        cbtTxtField.setPreferredSize(new Dimension(64, 20));
        cbtTxtField.addActionListener(this);

        priorityLabel.setFont(new Font("Segoe UI", Font.BOLD, 12)); // NOI18N
        priorityLabel.setHorizontalAlignment(SwingConstants.CENTER);
        priorityLabel.setText("Priority:");
        priorityLabel.setMinimumSize(new Dimension(64, 20));
        priorityLabel.setPreferredSize(new Dimension(64, 20));

        priorityTxtField.setHorizontalAlignment(JTextField.CENTER);
        priorityTxtField.setBorder(new SoftBevelBorder(BevelBorder.RAISED, Color.lightGray, Color.gray, null, Color.darkGray));
        priorityTxtField.setMinimumSize(new Dimension(64, 20));
        priorityTxtField.setPreferredSize(new Dimension(64, 20));
        priorityTxtField.addActionListener(this);

        deadlineLabel.setFont(new Font("Segoe UI", Font.BOLD, 12)); // NOI18N
        deadlineLabel.setHorizontalAlignment(SwingConstants.CENTER);
        deadlineLabel.setText("Deadline:");
        deadlineLabel.setMinimumSize(new Dimension(64, 20));
        deadlineLabel.setPreferredSize(new Dimension(64, 20));

        deadlineTxtField.setHorizontalAlignment(JTextField.CENTER);
        deadlineTxtField.setBorder(new SoftBevelBorder(BevelBorder.RAISED, Color.lightGray, Color.gray, null, Color.darkGray));
        deadlineTxtField.setMinimumSize(new Dimension(64, 20));
        deadlineTxtField.setPreferredSize(new Dimension(64, 20));
        deadlineTxtField.addActionListener(this);

        addButton.setFont(new Font("Segoe UI", Font.BOLD, 12)); // NOI18N
        addButton.setText("+");
        addButton.setBorder(new LineBorder(new Color(153, 153, 153), 0, true));
        addButton.setMaximumSize(new Dimension(20, 20));
        addButton.setMinimumSize(new Dimension(20, 20));
        addButton.setPreferredSize(new Dimension(20, 20));
        addButton.addActionListener(this);

        table.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{"Name", "AT", "CBT", "Priority", "Deadline", "FT"}
        ) {
            boolean[] canEdit = new boolean[]{false, false, false, false, false, false};

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        scrollPane.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setResizable(false);
            table.getColumnModel().getColumn(1).setResizable(false);
            table.getColumnModel().getColumn(2).setResizable(false);
            table.getColumnModel().getColumn(3).setResizable(false);
            table.getColumnModel().getColumn(4).setResizable(false);
            table.getColumnModel().getColumn(5).setResizable(false);
        }

        startButton.setFont(new Font("Segoe UI", Font.BOLD, 12)); // NOI18N
        startButton.setText("Start");
        startButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, Color.lightGray, Color.gray, null, Color.darkGray));
        startButton.setBorder(new LineBorder(new Color(153, 153, 153), 0, true));
        startButton.setMaximumSize(new Dimension(64, 20));
        startButton.setMinimumSize(new Dimension(64, 20));
        startButton.setPreferredSize(new Dimension(64, 20));
        startButton.addActionListener(this);

        GroupLayout panelLayout = new GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
                panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(panelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(scrollPane)
                                        .addGroup(panelLayout.createSequentialGroup()
                                                .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(panelLayout.createSequentialGroup()
                                                                .addComponent(numberLabel, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(numberTxtField, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(panelLayout.createSequentialGroup()
                                                                .addComponent(nameLabel, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(nameTxtField, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(atLabel, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(atTxtField, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(cbtLabel, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(cbtTxtField, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(priorityLabel, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(priorityTxtField, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(deadlineLabel, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(deadlineTxtField, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(addButton, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)))
                                                .addGap(0, 12, Short.MAX_VALUE)))
                                .addContainerGap())
                        .addGroup(panelLayout.createSequentialGroup()
                                .addGap(346, 346, 346)
                                .addComponent(startButton, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelLayout.setVerticalGroup(
                panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(panelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(numberLabel, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(numberTxtField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(nameLabel, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(nameTxtField, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(atLabel, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(atTxtField, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cbtLabel, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cbtTxtField, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(priorityLabel, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(priorityTxtField, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(deadlineLabel, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(deadlineTxtField, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(addButton, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(startButton, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            if (table.getRowCount() < Integer.parseInt(numberTxtField.getText())) {
                if (nameTxtField.getText().equals("") ||
                        atTxtField.getText().equals("") ||
                        cbtTxtField.getText().equals("") ||
                        priorityTxtField.getText().equals("") ||
                        deadlineTxtField.getText().equals(""))
                    JOptionPane.showMessageDialog(this, "Please enter all the data!");
                else {
                    Task task = new Task(nameTxtField.getText(),
                            Integer.parseInt(priorityTxtField.getText()),
                            Long.parseLong(atTxtField.getText()),
                            Long.parseLong(cbtTxtField.getText()),
                            Long.parseLong(deadlineTxtField.getText()));
                    scheduler.addTask(task);
                    String[] taskTable = {nameTxtField.getText(),
                            atTxtField.getText(),
                            cbtTxtField.getText(),
                            priorityTxtField.getText(),
                            deadlineTxtField.getText()};
                    DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
                    tableModel.addRow(taskTable);
                    JOptionPane.showMessageDialog(this, "Data added.");
                    nameTxtField.setText("");
                    atTxtField.setText("");
                    cbtTxtField.setText("");
                    priorityTxtField.setText("");
                    deadlineTxtField.setText("");
                }
            }
        } else if (e.getSource() == startButton) {
            if (table.getRowCount() == Integer.parseInt(numberTxtField.getText())) {
                scheduler.process();
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                int rows = model.getRowCount();
                for (int i = rows - 1; i >= 0; i--) model.removeRow(i);
                ArrayList<Task> finalTasks = scheduler.getFinalTasks();
                for (Task task : finalTasks) {
                    String[] taskTable = {task.getName(), String.valueOf(task.getArriveTime()),
                            String.valueOf(task.getCbt()), String.valueOf(task.getPriority()),
                            String.valueOf(task.getDeadline()), "-"};
                    if (task.isFinished)
                        taskTable = new String[]{task.getName(), String.valueOf(task.getArriveTime()),
                                String.valueOf(task.getCbt()), String.valueOf(task.getPriority()),
                                String.valueOf(task.getDeadline()), String.valueOf(task.getFinishedTime())};
                    DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
                    tableModel.addRow(taskTable);
                }
                JOptionPane.showMessageDialog(this, "Done.");
            }
        }
    }
}




