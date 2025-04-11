package cadastro.apresentacao;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import cadastro.modelo.beans.Cliente;
import cadastro.modelo.dao.ClienteDAO;

public class CadastroCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtEndereco;
	private JTextField txtNome;
	private JTextField txtCodigo;
	private JTextField txtCidade;
	private JTextField txtBairro;
	private JTextField txtEmail;
	private JFormattedTextField txtCpf;
	private JFormattedTextField txtCep;
	private JFormattedTextField txtFone;
	private MaskFormatter fmtCPF;
	private MaskFormatter fmtCEP;
	private MaskFormatter fmtFone;
	private JRadioButton rdbtn_masc;
	private JRadioButton rdbtn_fem;
	private JComboBox cbUf;
	
	Cliente cliente;
	ClienteDAO dao;
	
	private int editar = -1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroCliente frame = new CadastroCliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public CadastroCliente() {
		janela();	
	}
	
	public CadastroCliente(int id) {
		janela();
//		txtCodigo.setText(""+id);
		editar = id;
		mostrarDados(id);
	}


	public void janela() {
		setTitle("Formulário");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 490, 427);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_titulo = new JLabel("Cadastro de Cliente");
		lbl_titulo.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lbl_titulo.setBounds(119, 12, 267, 29);
		contentPane.add(lbl_titulo);
		
		JLabel lbl_codigo = new JLabel("Código");
		lbl_codigo.setFont(new Font("Liberation Sans", Font.PLAIN, 15));
		lbl_codigo.setBounds(25, 57, 46, 14);
		contentPane.add(lbl_codigo);
		
		JLabel lbl_nome = new JLabel("Nome");
		lbl_nome.setFont(new Font("Liberation Sans", Font.PLAIN, 15));
		lbl_nome.setBounds(25, 98, 46, 14);
		contentPane.add(lbl_nome);
		
		JLabel lbl_cpf = new JLabel("CPF");
		lbl_cpf.setFont(new Font("Liberation Sans", Font.PLAIN, 15));
		lbl_cpf.setBounds(25, 140, 46, 14);
		contentPane.add(lbl_cpf);
		
		JLabel lbl_endereco = new JLabel("Endereço");
		lbl_endereco.setFont(new Font("Liberation Sans", Font.PLAIN, 15));
		lbl_endereco.setBounds(25, 181, 71, 14);
		contentPane.add(lbl_endereco);
		
		JLabel lbl_cidade = new JLabel("Cidade");
		lbl_cidade.setFont(new Font("Liberation Sans", Font.PLAIN, 15));
		lbl_cidade.setBounds(25, 222, 46, 14);
		contentPane.add(lbl_cidade);
		
		JLabel lbl_bairro = new JLabel("Bairro");
		lbl_bairro.setFont(new Font("Liberation Sans", Font.PLAIN, 15));
		lbl_bairro.setBounds(25, 263, 46, 14);
		contentPane.add(lbl_bairro);
		
		JLabel lbl_email = new JLabel("Email");
		lbl_email.setFont(new Font("Liberation Sans", Font.PLAIN, 15));
		lbl_email.setBounds(25, 308, 46, 14);
		contentPane.add(lbl_email);
		
		JLabel lbl_uf = new JLabel("UF");
		lbl_uf.setFont(new Font("Liberation Sans", Font.PLAIN, 15));
		lbl_uf.setBounds(358, 222, 22, 14);
		contentPane.add(lbl_uf);
		
		JLabel lbl_cep = new JLabel("CEP");
		lbl_cep.setFont(new Font("Liberation Sans", Font.PLAIN, 15));
		lbl_cep.setBounds(317, 263, 40, 14);
		contentPane.add(lbl_cep);
		
		JLabel lbl_fone = new JLabel("Telefone");
		lbl_fone.setFont(new Font("Liberation Sans", Font.PLAIN, 15));
		lbl_fone.setBounds(245, 140, 66, 14);
		contentPane.add(lbl_fone);
		
		txtEndereco = new JTextField();
		txtEndereco.setFont(new Font("Liberation Sans", Font.PLAIN, 15));
		txtEndereco.setBounds(101, 174, 352, 29);
		contentPane.add(txtEndereco);
		txtEndereco.setColumns(10);
		
		try {
			fmtCPF = new MaskFormatter(" ###.###.###-##");
			fmtCEP = new MaskFormatter(" #####-###");
			fmtFone = new MaskFormatter(" (##) # ####-####");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		txtCpf = new JFormattedTextField(fmtCPF);
		txtCpf.setFont(new Font("Liberation Sans", Font.PLAIN, 15));
		txtCpf.setBounds(101, 133, 126, 29);
		contentPane.add(txtCpf);
		txtCpf.setColumns(10);
		
		
		txtNome = new JTextField();
		txtNome.setFont(new Font("Liberation Sans", Font.PLAIN, 15));
		txtNome.setBounds(101, 91, 352, 29);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		txtCodigo = new JTextField();
		txtCodigo.setFont(new Font("Liberation Sans", Font.PLAIN, 14));
		txtCodigo.setEditable(false);
		txtCodigo.setBounds(101, 51, 66, 28);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtCidade = new JTextField();
		txtCidade.setFont(new Font("Liberation Sans", Font.PLAIN, 15));
		txtCidade.setBounds(101, 215, 245, 29);
		contentPane.add(txtCidade);
		txtCidade.setColumns(10);
		
		txtBairro = new JTextField();
		txtBairro.setFont(new Font("Liberation Sans", Font.PLAIN, 15));
		txtBairro.setBounds(101, 256, 198, 29);
		contentPane.add(txtBairro);
		txtBairro.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Liberation Sans", Font.PLAIN, 15));
		txtEmail.setBounds(101, 301, 354, 29);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		txtFone = new JFormattedTextField(fmtFone);
		txtFone.setFont(new Font("Liberation Sans", Font.PLAIN, 15));
		txtFone.setBounds(317, 133, 136, 29);
		contentPane.add(txtFone);
		txtFone.setColumns(10);
		
		txtCep = new JFormattedTextField(fmtCEP);
		txtCep.setFont(new Font("Liberation Sans", Font.PLAIN, 15));
		txtCep.setBounds(358, 255, 95, 28);
		contentPane.add(txtCep);
		txtCep.setColumns(10);
		
		rdbtn_masc = new JRadioButton("Masculino");
		rdbtn_masc.setFont(new Font("Liberation Sans", Font.PLAIN, 15));
		rdbtn_masc.setBounds(216, 50, 119, 23);
		rdbtn_masc.setSelected(true);
		contentPane.add(rdbtn_masc);
		
		rdbtn_fem = new JRadioButton("Feminino");
		rdbtn_fem.setFont(new Font("Liberation Sans", Font.PLAIN, 15));
		rdbtn_fem.setBounds(357, 49, 114, 23);
		contentPane.add(rdbtn_fem);
		
		ButtonGroup bgSexo = new ButtonGroup();
		bgSexo.add(rdbtn_masc);
		bgSexo.add(rdbtn_fem);
		
		cbUf = new JComboBox();
		cbUf.setFont(new Font("Liberation Sans", Font.PLAIN, 15));
		cbUf.setModel(new DefaultComboBoxModel(new String[] {"AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA", "MG", "MS", "MT", "PA","PB", "PE", "PI", "PR", "RJ", "RO", "RR", "RN", "RS", "SC", "SE", "SP", "TO"}));
		cbUf.setBounds(387, 216, 66, 27);
		contentPane.add(cbUf);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setFont(new Font("Liberation Sans", Font.PLAIN, 15));
		btnSalvar.setBounds(138, 342, 100, 34);
		contentPane.add(btnSalvar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Liberation Sans", Font.PLAIN, 15));
		btnCancelar.setBounds(302, 342, 108, 34);
		contentPane.add(btnCancelar);
		
		btnSalvar.addActionListener(new btnSalvarListener());
		btnCancelar.addActionListener(new btnCancelarListener());
	}
	
	public class btnSalvarListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			cliente = new Cliente();
			
			cliente.setNome(txtNome.getText());
			cliente.setEndereco(txtEndereco.getText());
			cliente.setCidade(txtCidade.getText());
			cliente.setUf(""+cbUf.getSelectedItem());
			cliente.setCep(txtCep.getText());
			cliente.setCpf(txtCpf.getText());
			cliente.setEmail(txtEmail.getText());
			
			if (rdbtn_masc.isSelected())
				cliente.setSexo("M");
			else if (rdbtn_fem.isSelected())
				cliente.setSexo("F");			
			
			cliente.setBairro(txtBairro.getText());
			cliente.setFone(txtFone.getText());
			
			dao = new ClienteDAO();
			if (editar>0) {
				cliente.setId(editar);
				boolean resultado = dao.alterar(cliente,true);
				if(resultado)
					JOptionPane.showMessageDialog(null, "Os dados do cliente foram atualizados.");
				else 
					JOptionPane.showMessageDialog(null, "Não foi possível atualizar os dados do cliente!");
			}
			else {
				boolean resultado = dao.alterar(cliente,false);
				if(resultado)
					JOptionPane.showMessageDialog(null, "O cliente foi cadastrado.");
				else 
					JOptionPane.showMessageDialog(null, "Não foi possível fazer o cadastro!");
			}		
			setVisible(false);
			dispose();
		}		
	}
	
	public class btnCancelarListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			dispose();			
		}	
	}
	
	public void mostrarDados (int id) {
		cliente = new ClienteDAO().PesquisarPorId(id);
		txtCodigo.setText(""+cliente.getId());
		txtNome.setText(cliente.getNome());
		txtEndereco.setText(cliente.getEndereco());
		txtCidade.setText(cliente.getCidade());
		txtCep.setText(cliente.getCep());
		txtBairro.setText(cliente.getBairro());
		txtFone.setText(cliente.getFone());
		txtEmail.setText(cliente.getEmail());
		txtCpf.setText(cliente.getCpf());
		cbUf.setSelectedItem(cliente.getUf());
		if(cliente.getSexo().equals("M"))
			rdbtn_masc.setSelected(true);
		else if(cliente.getSexo().equals("F"))
			rdbtn_fem.setSelected(true);	
	}
}
