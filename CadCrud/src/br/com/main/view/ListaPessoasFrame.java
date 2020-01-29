package br.com.main.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import br.com.java.exception.PersistenceException;

public class ListaPessoasFrame extends JFrame {

	
	
	
	
	private JScrollPane scrollPane;
	private JButton bNovaPessoa;
	private JButton bBuscarPessoa;
	private JButton bAtualizaLista;
	
	
	private IncluirPessoaFrame incluirFrame;
	private EditarPessoaFrame editarFrame;
	private BuscaPessoaFrame buscaFrame;
	
	
	public ListaPessoasFrame() {
		setTitle("Lista de Pessoas");
		
		inicializaComponentes();
		adicionaComponentes();
		
		pack();
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	private void inicializaComponentes() {
		
		scrollPane = new JScrollPane();


		bNovaPessoa = new JButton();
		bNovaPessoa.setText("Nova");
		bNovaPessoa.setMnemonic(KeyEvent.VK_N);
		bNovaPessoa.addActionListener(new IncluirPessoaListener());

		bBuscarPessoa = new JButton();
		bBuscarPessoa.setText("Buscar");
		bBuscarPessoa.setMnemonic(KeyEvent.VK_B);
		bBuscarPessoa.addActionListener(new BuscarPessoaListener());
		
		bAtualizaLista = new JButton();
		bAtualizaLista.setText("Atualizar");
		bAtualizaLista.setMnemonic(KeyEvent.VK_A);
		bAtualizaLista.addActionListener(new AtualizarListaListener());

		
		incluirFrame = new IncluirPessoaFrame(this);
//		editarFrame = new EditarPessoaFrame(this);
//		buscaFrame = new BuscaPessoaFrame(this);

	}
	
	private void adicionaComponentes(){
		add(scrollPane);
		JPanel panel = new JPanel();
		panel.add(bNovaPessoa);
		panel.add(bBuscarPessoa);
		panel.add(bAtualizaLista);
		add(panel, BorderLayout.SOUTH);
	}
	public Runnable newAtualizaPessoasAction() {
		return new Runnable() {
			public void run() {
				try {
//					MercadoriaDAO dao = new MercadoriaDAOJDBC();
//					tabela.reload(dao.getAll());
				} catch (PersistenceException ex) {
					JOptionPane.showMessageDialog(ListaPessoasFrame.this,
							ex.getMessage(), "Erro ao consultar Pessoa(s)", JOptionPane.ERROR_MESSAGE);
				}
			}
		};
	}
	

	
	private class AtualizarListaListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			SwingUtilities.invokeLater(newAtualizaPessoasAction());
		}
	}
	
	private class IncluirPessoaListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			incluirFrame.setVisible(true);
		}
	}
	
	private class EditarPessoaListener extends MouseAdapter {
		public void mouseClicked(MouseEvent event) {
//			if (event.getClickCount() == 2) {
//				Mercadoria m = tabela.getMercadoriaSelected();
//				if (m != null) {
//					editarFrame.setMercadoria(m);
//					editarFrame.setVisible(true);
//				}
//			}
		}
	}
	
	private class BuscarPessoaListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			buscaFrame.setVisible(true);
		}
	}
}