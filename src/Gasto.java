
import java.time.LocalDate;

/**
 *
 * @author Giovani
 */
public class Gasto {
    private String nome ;
    private TipoGas tipo;
    private FormaPag formaPag;
    
    private void setNome(String n){
        this.nome = n;
    }
    
    private void setTipo(int t, LocalDate d){
        TipoGas tipoGasto = new TipoGas(t,d);
        this.tipo = tipoGasto;
    }
    
    private void setForma(int f, double v){
        FormaPag formaPagamento = new FormaPag(f,v);
        this.formaPag = formaPagamento;
    }
    
    public Gasto(String n,int t, LocalDate d, int f, double v){
        this.setNome(n);
        this.setTipo(t,d);
        this.setForma(f,v);   
    }
 
    public String getNome() {
        return nome;
    }

    public TipoGas getTipo() {
        return tipo;
    }

    public FormaPag getFormaPag() {
        return formaPag;
    }

    @Override
    public String toString() {
        return "Gasto{" + "nome=" + nome + ", tipo=" + tipo + ", formaPag=" + formaPag + '}';
    }
    
    
}



