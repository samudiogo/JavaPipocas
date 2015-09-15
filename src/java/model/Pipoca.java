package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Samuel.Jesus
 */
@Entity
@Table(name="Pipoca")
public class Pipoca 
{
    @Id
    private int Codigo;
    private String Descricao;
    private Double Preco;
    
    /** cosntrutor default: (necessario para que o Java Persistence faça a criação
     * e maninpulação da entidade no banco de dados
     */
    
    public Pipoca(){}
    //construtor faclitador para criar objetos:
    public Pipoca(int Codigo, String Descricao, Double Preco)
    {
        setCodigo(Codigo);
        setDescricao(Descricao);
        setPreco(Preco);
    }
    
    /**
     * @return the Codigo
     */
    public int getCodigo() {
        return Codigo;
    }

    /**
     * @param Codigo the Codigo to set
     */
    public void setCodigo(int Codigo) {
        this.Codigo = Codigo;
    }

    /**
     * @return the Descricao
     */
    public String getDescricao() {
        return Descricao;
    }

    /**
     * @param Descricao the Descricao to set
     */
    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    /**
     * @return the Preco
     */
    public Double getPreco() {
        return Preco;
    }

    /**
     * @param Preco the Preco to set
     */
    public void setPreco(Double Preco) {
        this.Preco = Preco;
    }
}
