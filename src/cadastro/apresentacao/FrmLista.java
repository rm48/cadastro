package cadastro.apresentacao;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import com.formdev.flatlaf.intellijthemes.FlatArcOrangeIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatCarbonIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatCyanLightIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatDarkFlatIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatDraculaIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatGradiantoDarkFuchsiaIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatHighContrastIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatSolarizedLightIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatXcodeDarkIJTheme;

import cadastro.modelo.dao.ClienteDAO;
import cadastro.util.ModeloGrade;
import java.awt.SystemColor;
import java.awt.Font;

public class FrmLista extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JPanel pnTabela;
	private JComboBox cbCampos;
	private JTextField txtValor;
	
	String [] colunas = {"id", "Nome", "Telefone", "Email"};

	Object [][] dados = {
			{"1","Julio","9999999","julio@email.com"},
			{"2","Elias","8888888","elias@email.com"},
			{"3","Jairo","7777777","jairo@email.com"},
	};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		FlatDarkFlatIJTheme.setup();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
//				try {
					
//					for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//						if ("Nimbus".equals(info.getName())) {
//							javax.swing.UIManager.setLookAndFeel(info.getClassName());
//							break;
//						}
//					}
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
				try {
//					UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
//					UIManager.setLookAndFeel("com.jtattoo.plaf.aero.AeroLookAndFeel");
//					UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
//					UIManager.setLookAndFeel("com.jtattoo.plaf.bernstein.BernsteinLookAndFeel");
//					UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
//					UIManager.setLookAndFeel("com.jtattoo.plaf.graphite.GraphiteLookAndFeel");
//					UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
					//UIManager.setLookAndFeel("com.jtattoo.plaf.luna.LunaLookAndFeel");
//					UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
//					UIManager.setLookAndFeel("com.jtattoo.plaf.mint.MintLookAndFeel");
//					UIManager.setLookAndFeel("com.jtattoo.plaf.noire.NoireLookAndFeel");
//					UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
//					UIManager.setLookAndFeel("com.jtattoo.plaf.texture.TextureLookAndFeel");	
					FrmLista frame = new FrmLista();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmLista() {
		setTitle("Cadastro de clientes");
		janela();
		tabela();
		atualizarGrade();
		populaCampos();
		
	}
	
	public void janela() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 647, 435);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(47, 79, 79));
		panel.setBounds(10, 12, 628, 82);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Campo");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Liberation Sans", Font.PLAIN, 15));
		lblNewLabel.setBounds(26, 11, 81, 14);
		panel.add(lblNewLabel);
		
		cbCampos = new JComboBox();
		cbCampos.setFont(new Font("Liberation Sans", Font.PLAIN, 15));
		cbCampos.setBounds(20, 37, 167, 34);
		panel.add(cbCampos);
		
		JLabel lblNewLabel_1 = new JLabel("Valor");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Liberation Sans", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(213, 11, 86, 14);
		panel.add(lblNewLabel_1);
		
		txtValor = new JTextField();
		txtValor.setBounds(213, 37, 238, 33);
		panel.add(txtValor);
		txtValor.setColumns(10);
		
		JButton btnNewButton = new JButton("Pesquisar");
		btnNewButton.setFont(new Font("Liberation Sans", Font.PLAIN, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pesquisa(""+cbCampos.getSelectedItem(), txtValor.getText());
				}
			});
		btnNewButton.setBounds(475, 37, 120, 35);
		panel.add(btnNewButton);
		
		pnTabela = new JPanel();
		pnTabela.setBounds(10, 106, 628, 220);
		contentPane.add(pnTabela);
		pnTabela.setLayout(new GridLayout(1, 1));
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 338, 628, 57);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnInserir = new JButton("Inserir");
		btnInserir.setFont(new Font("Liberation Sans", Font.PLAIN, 15));
		btnInserir.setBounds(10, 11, 89, 34);
		panel_2.add(btnInserir);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setFont(new Font("Liberation Sans", Font.PLAIN, 15));
		btnAlterar.setBounds(124, 11, 89, 34);
		panel_2.add(btnAlterar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setFont(new Font("Liberation Sans", Font.PLAIN, 15));
		btnExcluir.setBounds(246, 11, 89, 34);
		panel_2.add(btnExcluir);
		
		JButton btnVisualizar = new JButton("Visualizar");
		btnVisualizar.setFont(new Font("Liberation Sans", Font.PLAIN, 15));
		btnVisualizar.setBounds(362, 11, 129, 34);
		panel_2.add(btnVisualizar);
		
		JButton btnFechar = new JButton("Fechar");
		btnFechar.setFont(new Font("Liberation Sans", Font.PLAIN, 15));
		btnFechar.setBounds(523, 11, 89, 34);
		panel_2.add(btnFechar);
		
		btnInserir.addActionListener(new btnInserirListener());
		btnAlterar.addActionListener(new btnAlterarListener());
		btnExcluir.addActionListener(new btnExcluirListener());
		btnFechar.addActionListener(new btnFecharListener());
		
	}
	
	public void tabela(){
//		table = new JTable(new ModeloGrade());
		table = new JTable(dados, colunas);
		table.setFont(new Font("Liberation Sans", Font.PLAIN, 15));
		table.setCursor(new Cursor(Cursor.HAND_CURSOR));
		JScrollPane rolagem = new JScrollPane(table);
		pnTabela.add(rolagem);
	}
	
	public void atualizarGrade() {
		ResultSet rs = new ClienteDAO().carregarGrade();
		table.setModel(new ModeloGrade(rs, new String[] {"Código","Nome"}));
		table.getColumnModel().getColumn(0).setMaxWidth(60);
	}
	public void populaCampos() {
		List<String> campos = new ClienteDAO().nomeCampos();
		DefaultComboBoxModel dcm = (DefaultComboBoxModel) cbCampos.getModel();
		for (String campo: campos)
			dcm.addElement(campo);
	}
	public void pesquisa(String campo, String valor) {
//		ResultSet rs = new ClienteDAO().pesquisa(""+cbCampo.getSelectedItem(), txtValor.getText());
		ResultSet rs = new ClienteDAO().pesquisa(campo, valor);
		table.setModel(new ModeloGrade(rs, new String[] {"Código","Nome"}));
//		System.out.println("Campo: "+ campo +" | Valor: "+ valor);
		table.getColumnModel().getColumn(0).setMaxWidth(50);
	}
	
	public class btnInserirListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			CadastroCliente cli = new CadastroCliente();
			cli.setVisible(true);
			
			cli.addWindowListener(new WindowAdapter() {
				public void windowClosed(WindowEvent e) {
					atualizarGrade();
				}
			});
		}
	}
	public class btnAlterarListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent event) { 
			int linhaSelecionada = -1;
			linhaSelecionada = table.getSelectedRow();
			if (linhaSelecionada >= 0) {
				int id_cliente = (int)table.getValueAt(linhaSelecionada, 0);
				CadastroCliente cli = new CadastroCliente(id_cliente);
				cli.setVisible(true);
				
				cli.addWindowListener(new WindowAdapter() {
					public void windowClosed(WindowEvent e) {
						atualizarGrade();
					}
				});
				
			}else {
				JOptionPane.showMessageDialog(null, "Selecione um registro");
			}		
		}	
	}
	public class btnExcluirListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String[]opcoes = {"Sim", "Nao"};
			int linhaSelecionada = -1;
			linhaSelecionada = table.getSelectedRow();
			if (linhaSelecionada >= 0) {
				int id_cliente = (int)table.getValueAt(linhaSelecionada, 0);
				int opcao = JOptionPane.showOptionDialog(rootPane, "Deseja excluir este registro?","Confirmação",
						JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE,null, opcoes, opcoes[1]);
				if (JOptionPane.OK_OPTION == opcao) {
				new ClienteDAO().excluir(id_cliente);
				atualizarGrade();
				}
			}else {
				JOptionPane.showMessageDialog(null, "Selecione um registro");
			}	
		}
		
	}
	public class btnFecharListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			dispose();		
		}	
	}
}