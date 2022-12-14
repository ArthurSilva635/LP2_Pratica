package br.ufrn.imd.model;

import java.time.LocalTime;
import java.util.Arrays;

public class Sessao {
	
	private Filme filme;
    private Sala sala;
    private LocalTime horarioInicial;
    private LocalTime horarioFinal;
    private double valorIngresso;
    private char[] poltronas; //l = livre; m = meia; i = inteira
    private boolean exibicao3D;
    private String tipoAudio;
    
	public Sessao(Filme filme, Sala sala, LocalTime horarioInicial, LocalTime horarioFinal, double valorIngresso,boolean exibicao3d, String tipoAudio) {
		this.filme = filme;
		this.sala = sala;
		this.horarioInicial = horarioInicial;
		this.horarioFinal = horarioFinal;
		this.valorIngresso = valorIngresso;
		exibicao3D = exibicao3d;
		this.tipoAudio = tipoAudio;
		
		poltronas = new char[sala.getCapacidade()];
        for(int i=0; i < poltronas.length; i++) { //Inicializando todas as poltronas como livres.
            poltronas[i] = 'l';
        }
	}
	public Filme getFilme() {
		return filme;
	}
	public void setFilme(Filme filme) {
		this.filme = filme;
	}
	public Sala getSala() {
		return sala;
	}
	public void setSala(Sala sala) {
		this.sala = sala;
	}
	public LocalTime getHorarioInicial() {
		return horarioInicial;
	}
	public void setHorarioInicial(LocalTime horarioInicial) {
		this.horarioInicial = horarioInicial;
	}
	public LocalTime getHorarioFinal() {
		return horarioFinal;
	}
	public void setHorarioFinal(LocalTime horarioFinal) {
		this.horarioFinal = horarioFinal;
	}
	public double getValorIngresso() {
		return valorIngresso;
	}
	public void setValorIngresso(double valorIngresso) {
		this.valorIngresso = valorIngresso;
	}
	public char[] getPoltronas() {
		return poltronas;
	}
	public void setPoltronas(char[] poltronas) {
		this.poltronas = poltronas;
	}
	public boolean isExibicao3D() {
		return exibicao3D;
	}
	public void setExibicao3D(boolean exibicao3d) {
		exibicao3D = exibicao3d;
	}
	public String getTipoAudio() {
		return tipoAudio;
	}
	public void setTipoAudio(String tipoAudio) {
		this.tipoAudio = tipoAudio;
	}
	
	public boolean ocuparPoltrona(int poltrona, char tipoIngresso) {

        if(poltronas[poltrona] == 'l') {
            poltronas[poltrona] = tipoIngresso;
            return true;
        } else {
            return false;
        }

    }

    public boolean liberarPoltrona(int poltrona) {

        if(poltronas[poltrona] != 'l') {
            poltronas[poltrona] = 'l';
            return true;
        } else {
            return false;
        }

    }
    
    public double taxaOcupacao(){
        double ocupados=0;

        for (char p : poltronas) {
            if(p != 'l'){
                ocupados++;
            }         
        }

        return ocupados / sala.getCapacidade();
    }
    
    public String poltronasLivres(){
        int quantidade = 0;
        String poltronasLivres = "|  ";

        for(int i = 0; i < poltronas.length; i++){

            if(poltronas[i] == 'l'){
                quantidade++;

                if (i<9){
                    poltronasLivres += " " + (i+1) + "  |  ";    
                } else {
                    poltronasLivres += (i+1) + "  |  ";
                }

            }

            if((i+1) % 10 == 0 && i != 0 && i != poltronas.length-1) { //Dividir em 10 colunas
                poltronasLivres += "\n|  ";
            }

        }
        return "Quantidade de poltronas livres: " + quantidade + "\n   > Poltronas <   \n" + poltronasLivres;
    }
    
    public String poltronasOcupadas(){
        int quantidade = 0;
        String poltronasOcupadas = "|  ";

        for(int i = 0; i < poltronas.length; i++){

            if(poltronas[i] != 'l'){
                quantidade++;

                if (i<9){
                    poltronasOcupadas += " " + (i+1) + "  |  ";    
                } else {
                    poltronasOcupadas += (i+1) + "  |  ";    
                }

            }

            if(i % 9 == 0 && i != 0 && i != poltronas.length-1) { //Dividir em 10 colunas
                poltronasOcupadas += "\n|  ";
            }
            
        }
        return "\n Quantidade de poltronas Ocupadas: " + quantidade + "\n\n    > Poltronas <   \n" + poltronasOcupadas;
    }
    
    
	@Override
	public String toString() {
		return "Sessao [filme=" + filme + ", horarioInicial=" + horarioInicial + ", horarioFinal=" + horarioFinal
				+ ", valorIngresso=" + valorIngresso + ", poltronas=" + Arrays.toString(poltronas) + ", exibicao3D="
				+ exibicao3D + ", tipoAudio=" + tipoAudio + "]";
	}
	
	
    
    
}
