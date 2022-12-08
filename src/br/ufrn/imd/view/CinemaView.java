package br.ufrn.imd.view;

import br.ufrn.imd.controller.CinemaController;
import br.ufrn.imd.controller.FilmeController;
import br.ufrn.imd.controller.SalaController;
import br.ufrn.imd.controller.SessaoController;
import br.ufrn.imd.model.Cinema;


public class CinemaView {
	
	public static void main(String[] args) {
		Cinema cinema = new Cinema();
		//MenuGerenciamento mg = new MenuGerenciamento();
		//mg.menuGeral();
		//mg.gerenciarFilmes();
		//mg.gerenciarSalas();
		
		//CinemaController cc = new CinemaController();
		//cc.venderIngresso();
		
		
		FilmeController ctl = new FilmeController();
		//ctl.criarFilme();
		cinema.addFilmes(ctl.criarFilme());
		ctl.lerFilmes(cinema.getFilmes());
		//ctl.modificarFilme();
		
		SalaController scl = new SalaController();
		//scl.criarSalas();
		cinema.addSala(scl.criarSalas());
		System.out.println(cinema.getSalas().size());
		scl.lerSalas(cinema.getSalas());
		//scl.modificarSala();
	
		
		SessaoController sscl = new SessaoController();
		cinema.addSessoes(sscl.criarSessao(cinema));
		sscl.lerSessoes(cinema.getSessoes());
		
		//cc.lerFaturamento();
	
	}

}
