package tool;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class 萬國碼轉換UI {

	public 萬國碼轉換UI() {
		jContentPane = null;
		jPanel = null;
		jIPLabel = null;
		jUserNameLabel = null;
		jPasswordLabel = null;
		jUserNameField = null;
		jPasswordField = null;
		jPasswordField2 = null;
		jButtonPanel = null;
		jOKButton = null;
		jCancelButton = null;
	}

	public static void main(String args[]) {
		萬國碼轉換UI a = new 萬國碼轉換UI();
		JFrame b = new JFrame("ddd");
		b.add(a.getJContentPane());
		b.setDefaultCloseOperation(3);
		b.pack();
		b.setVisible(true);
	}

	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(new BorderLayout());
			jContentPane.add(getJPanel(), "Center");
			jContentPane.add(getJButtonPanel(), "South");
		}
		return jContentPane;
	}

	private JPanel getJPanel() {
		if (jPanel == null) {
			GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
			gridBagConstraints5.fill = 2;
			gridBagConstraints5.gridy = 2;
			gridBagConstraints5.weightx = 1.0D;
			gridBagConstraints5.gridx = 1;
			GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
			gridBagConstraints4.fill = 2;
			gridBagConstraints4.gridy = 1;
			gridBagConstraints4.weightx = 1.0D;
			gridBagConstraints4.gridx = 1;
			GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
			gridBagConstraints3.fill = 2;
			gridBagConstraints3.gridy = 0;
			gridBagConstraints3.weightx = 1.0D;
			gridBagConstraints3.gridwidth = 2;
			gridBagConstraints3.gridx = 1;
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.gridx = 0;
			gridBagConstraints2.insets = new Insets(0, 3, 0, 3);
			gridBagConstraints2.gridy = 2;
			jPasswordLabel = new JLabel();
			jPasswordLabel.setText("\u7DE8\u6210unicode");
			jPasswordLabel.setFont(new Font("\u7D30\u660E\u9AD4", 1, 24));
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.gridx = 0;
			gridBagConstraints1.insets = new Insets(0, 3, 0, 3);
			gridBagConstraints1.gridy = 1;
			jUserNameLabel = new JLabel();
			jUserNameLabel.setText("\u672A\u7DE8\u78BC");
			jUserNameLabel.setFont(new Font("\u7D30\u660E\u9AD4", 1, 24));
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.gridx = 0;
			gridBagConstraints.insets = new Insets(0, 3, 0, 3);
			gridBagConstraints.gridy = 0;
			jIPLabel = new JLabel();
			jIPLabel.setText("\u4F3A\u670D\u7AEF\u4F4D\u7F6E");
			jIPLabel.setFont(new Font("\u7D30\u660E\u9AD4", 1, 24));
			jPanel = new JPanel();
			jPanel.setLayout(new GridBagLayout());
			jPanel.add(jUserNameLabel, gridBagConstraints1);
			jPanel.add(jPasswordLabel, gridBagConstraints2);
			jPanel.add(getJUserNameField(), gridBagConstraints4);
			jPanel.add(getJPasswordField(), gridBagConstraints5);
		}
		return jPanel;
	}

	private JTextField getJUserNameField() {
		if (jPasswordField == null) {
			jPasswordField = new JTextField();
			jPasswordField.setFont(new Font("\u7D30\u660E\u9AD4", 1, 24));
		}
		return jPasswordField;
	}

	private JTextField getJPasswordField() {
		if (jPasswordField2 == null) {
			jPasswordField2 = new JTextField();
			jPasswordField2.setFont(new Font("\u7D30\u660E\u9AD4", 1, 24));
		}
		return jPasswordField2;
	}

	private JPanel getJButtonPanel() {
		if (jButtonPanel == null) {
			jButtonPanel = new JPanel();
			jButtonPanel.setLayout(new FlowLayout());
			jButtonPanel.add(getJOKButton(), null);
			jButtonPanel.add(getJCancelButton(), null);
		}
		return jButtonPanel;
	}

	private JButton getJOKButton() {
		if (jOKButton == null) {
			jOKButton = new JButton();
			jOKButton.setFont(new Font("\u7D30\u660E\u9AD4", 1, 24));
			jOKButton.setText("\u78BA\u5B9A");
			jOKButton.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					kkk();
				}

				final 萬國碼轉換UI this$0;

				{
					this$0 = 萬國碼轉換UI.this;

				}
			});
		}
		return jOKButton;
	}

	private JButton getJCancelButton() {
		if (jCancelButton == null) {
			jCancelButton = new JButton();
			jCancelButton.setText("\u53D6\u6D88");
			jCancelButton.setFont(new Font("\u7D30\u660E\u9AD4", 1, 24));
			jCancelButton.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}

				final 萬國碼轉換UI this$0;

				{
					this$0 = 萬國碼轉換UI.this;

				}
			});
		}
		return jCancelButton;
	}

	public static String numFull(String a) {
		int b = a.length();
		for (int i = b; i < 4; i++)
			a = (new StringBuilder("0")).append(a).toString();

		return a;
	}

	public void kkk() {
		String a = jPasswordField.getText();
		if (!a.equals("")) {
			char b[] = a.toCharArray();
			String c = "";
			if (a == null || a.length() == 0)
				return;
			for (int i = 0; i < b.length; i++) {
				int d = b[i];
				c = (new StringBuilder(String.valueOf(c))).append("\\u")
						.append(numFull(Integer.toHexString(d)).toUpperCase()).toString();
			}

			jPasswordField2.setText(c);
			return;
		}
		try {
			a = jPasswordField2.getText();
			StringTokenizer c = new StringTokenizer(a, "\\u");
			String b = "";
			while (c.hasMoreTokens()) {
				String msg = c.nextToken();
				if (msg.startsWith("MSG")) {
					System.out.println();
					System.out.print(msg);
				} else {
					msg = msg.toUpperCase();
					char msga[] = msg.toCharArray();
					char kk = '\0';
					for (int i = 0; i < msga.length; i++) {
						int k = 0;
						if (msga[i] >= 'A')
							k = (msga[i] - 65) + 10;
						else
							k = msga[i] - 48;
						kk += k << 12 - i * 4;
					}

					b = (new StringBuilder(String.valueOf(b))).append(kk).toString();
				}
			}
			jPasswordField.setText(b);
		} catch (Exception exception) {
		}
	}

	private JPanel jContentPane;
	private JPanel jPanel;
	private JLabel jIPLabel;
	private JLabel jUserNameLabel;
	private JLabel jPasswordLabel;
	private JFormattedTextField jUserNameField;
	private JTextField jPasswordField;
	private JTextField jPasswordField2;
	private JPanel jButtonPanel;
	private JButton jOKButton;
	private JButton jCancelButton;
}
