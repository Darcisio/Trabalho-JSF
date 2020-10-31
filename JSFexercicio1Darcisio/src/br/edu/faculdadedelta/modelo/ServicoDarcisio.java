package br.edu.faculdadedelta.modelo;

import java.util.Date;

public class ServicoDarcisio {
private Long id;
private String descC;
private String descS;
private double valor;
private int qtdS;
private Date dataexecS;

public ServicoDarcisio() {
}

public ServicoDarcisio(long id, String descC, String descS, double valor, int qtdS, Date dataexecS) {
	this.id = id;
	this.descC = descC;
	this.descS = descS;
	this.valor = valor;
	this.qtdS = qtdS;
	this.dataexecS = dataexecS;
}

public Long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}

public String getDescC() {
	return descC;
}

public void setDescC(String descC) {
	this.descC = descC;
}

public String getDescS() {
	return descS;
}

public void setDescS(String descS) {
	this.descS = descS;
}

public double getValor() {
	return valor;
}

public void setValor(double valor) {
	this.valor = valor;
}

public int getQtdS() {
	return qtdS;
}

public void setQtdS(int qtdS) {
	this.qtdS = qtdS;
}

public Date getDataexecS() {
	return dataexecS;
}

public void setDataexecS(Date dataexecS) {
	this.dataexecS = dataexecS;
}
public double getValorTotal() {
	return (qtdS * valor );
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + (int) (id ^ (id >>> 32));
	return result;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	ServicoDarcisio other = (ServicoDarcisio) obj;
	if (id != other.id)
		return false;
	return true;
}


}
