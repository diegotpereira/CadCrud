package br.com.main.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

public class IncluirPessoaFrame extends JFrame {

	private JTextField tfNome;
	private JTextField tfEndereco;
	private JTextField tfCidade;
	private JTextField tfEstado;
	private JTextField tfTelefone;
	private JTextField tfEmail;
	private JTextField tfCpf;
	private JTextField tfRg;
	private JFormattedTextField tfDataNascimento;
	
	private JTextField tfDescricao;
	private JTextField tfPreco;
	private JFormattedTextField tfId;
	
	private JButton bSalvar;
	private JButton bCancelar;
	protected JButton bExcluir;
	
	private ListaPessoasFrame framePrincipal;
	
	
	public IncluirPessoaFrame(ListaPessoasFrame framePrincipal) {
		this.framePrincipal = framePrincipal;
		setTitle("Incluir Pessoa");
		setSize(600,300);
		setLocationRelativeTo(null);
		setResizable(false);
		inicializaComponentes();
		resetForm();
	}
	
	private void inicializaComponentes() {
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.add(montaPanelEditarPessoa(), BorderLayout.CENTER);
		panel.add(montaPanelBotoesEditar(), BorderLayout.SOUTH);
		add(panel);
		
		GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
	}
	private JPanel montaPanelBotoesEditar() {
		JPanel panel = new JPanel();

		bSalvar = new JButton("Salvar");
		bSalvar.setMnemonic(KeyEvent.VK_S);
		bSalvar.addActionListener(new SalvarPessoaListener());
		panel.add(bSalvar);
//
		bCancelar = new JButton("Cancelar");
		bCancelar.setMnemonic(KeyEvent.VK_C);
		bCancelar.addActionListener(new CancelarListener());
		panel.add(bCancelar);
//		
		bExcluir = new JButton();
		bExcluir.setText("Excluir");
		bExcluir.setMnemonic(KeyEvent.VK_E);
		bExcluir.addActionListener(new ExcluirPessoaListener());
		bExcluir.setVisible(false);
		panel.add(bExcluir);

		return panel;
	}
	private JPanel montaPanelEditarPessoa() {
		JPanel painelEditarPessoa = new JPanel();
		painelEditarPessoa.setLayout(new GridLayout(8, 1));
		
	
		tfNome = new JTextField();
		tfEndereco = new JTextField();
		tfCidade = new JTextField();
		tfEstado = new JTextField();
		tfTelefone = new JTextField();
		tfEmail = new JTextField();
		tfCpf = new JTextField();
		tfRg = new JTextField();
		tfDataNascimento = new JFormattedTextField();
		tfId = new JFormattedTextField();
		tfId.setEnabled(false);

		painelEditarPessoa.add(new JLabel("Nome:"));
		painelEditarPessoa.add(tfNome);
		painelEditarPessoa.add(new JLabel("Endereço:"));
		painelEditarPessoa.add(tfEndereco);
		painelEditarPessoa.add(new JLabel("Cidade:"));
		painelEditarPessoa.add(tfCidade);
		painelEditarPessoa.add(new JLabel("Estado:"));
		painelEditarPessoa.add(tfEstado);
		painelEditarPessoa.add(new JLabel("Telefone:"));
		painelEditarPessoa.add(tfTelefone);
		painelEditarPessoa.add(new JLabel("Email:"));
		painelEditarPessoa.add(tfEmail);
		painelEditarPessoa.add(new JLabel("CPF:"));
		painelEditarPessoa.add(tfCpf);
		painelEditarPessoa.add(new JLabel("RG:"));
		painelEditarPessoa.add(tfRg);
		painelEditarPessoa.add(new JLabel("Data de Nascimento:"));
		painelEditarPessoa.add(tfDataNascimento);
		painelEditarPessoa.add(new JLabel("Id:"));
		painelEditarPessoa.add(tfId);
		
		return painelEditarPessoa;
	}
	private void resetForm() {
//		tfId.setValue(null);
//		tfNome.setText("");
//		tfDescricao.setText("");
//		tfPreco.setText("");
//		tfQuantidade.setValue(new Integer(1));
	}
	
	private class CancelarListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
			resetForm();
		}
	}
	
	private class SalvarPessoaListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
//				Mercadoria m = loadMercadoriaFromPanel();
//				MercadoriaDAO dao = new MercadoriaDAOJDBC();
//				dao.save(m);
				
				setVisible(false);
				resetForm();
				SwingUtilities.invokeLater(framePrincipal.newAtualizaPessoasAction());
				
			} catch(Exception ex) {
				JOptionPane.showMessageDialog(IncluirPessoaFrame.this, 
						ex.getMessage(), "Erro ao incluir Mercadoria", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	private class ExcluirPessoaListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
//			Integer id = getIdMercadoria();
//			if (id != null) {
				try {
////					MercadoriaDAO dao = new MercadoriaDAOJDBC();
////					Mercadoria m = dao.findById(id);
////					if (m != null) {
////						dao.remove(m);
////					}
					
					setVisible(false);
					resetForm();
					SwingUtilities.invokeLater(framePrincipal.newAtualizaPessoasAction());
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(IncluirPessoaFrame.this,
							ex.getMessage(), "Erro ao excluir Mercadoria", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}
	
	

