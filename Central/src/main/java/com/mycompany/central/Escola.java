package com.mycompany.central;

public class Escola {
    private double valSalarios;
    private double valMensalidades;

    public Escola() {
        for (Aluno aluno : Aluno.getListaAlunos()) {
            this.valMensalidades += aluno.getMensalidade();
        }

        for (Professor professor : Professor.getListaProfessores()) {
            this.valSalarios += professor.getSalario();
        }
        for(Funcionario funcionario : Funcionario.getListaFuncionarios()){
            this.valSalarios += funcionario.getSalario();
        }
        
    }

    public double getValSalarios() {
        return valSalarios;
    }

    public void setValSalarios(double valSalarios) {
        this.valSalarios = valSalarios;
    }

    public double getValMensalidades() {
        return valMensalidades;
    }

    public void setValMensalidades(double valMensalidades) {
        this.valMensalidades = valMensalidades;
    }

}
