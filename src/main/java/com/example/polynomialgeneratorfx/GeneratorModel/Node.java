package com.example.polynomialgeneratorfx.GeneratorModel;

public class Node
{

	/**
	 * Coefficient
	 */
	private int coeff;
	/**
	 * Term Variable
	 */
	private String var;
	/**
	 * Term Exponent
	 */
	private int expo;
	/**
	 * Whether the term contains a variable
	 */
	private boolean noVar;

	/**
	 * Creates a term
	 * @param coeff Coefficient
	 * @param var Variable
	 * @param expo EXponent
	 */
	public Node(int coeff, String var, int expo)
	{
		this.coeff = coeff;
		setCoeff(coeff);
		setVar(var);
		setExpo(expo);
	}

	/**
	 * Overrides the default variable
	 * @param var Variable
	 */
	public void setVariable(String var)
	{
		setVar(var);
	}

	/**
	 * Sets the coefficient
	 * @param coeff coefficient
	 */
	private void setCoeff(int coeff)
	{
		if(coeff > 1){
			this.coeff = coeff;
		}else{
			this.coeff = -1;
		}
	}

	/**
	 * Sets exponent
	 * @param expo exponent
	 */
	private void setExpo(int expo)
	{
		if(!noVar) {
			this.expo = expo;
		}else{
			this.expo = 1;
		}
	}

	/**
	 * Sets variable
	 * @param var variable
	 */
	private void setVar(String var)
	{
		if(var.length() != 0){
			this.var = var;
			this.noVar = false;
		}else{
			this.noVar = true;
		}
	}

	/**
	 * Getter
	 * @return Value
	 */
	public int getCoeff()
	{
		return coeff;
	}

	/**
	 * Getter
	 * @return Value
	 */
	public String getVar()
	{
		return var;
	}

	/**
	 * Getter
	 * @return Value
	 */
	public int getExpo()
	{
		return expo;
	}

	@Override
	public String toString()
	{
		String poly = "";
		if(coeff > 1){
			poly += getCoeff();
		}
		if(!noVar){
			poly += getVar();
		}
		if(getExpo()>1) {
			poly += "^" + getExpo();
		}
		return poly;
	}
}
