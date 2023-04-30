
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Giovani
 */
public class Ganho {
    private String nome;
    private TipoGan tipo;
    private LocalDate data;
    
    private void setNome(String n){
        this.nome = n;
    }
    
    private void setTipo(int t, double v){
        TipoGan tipoDeGanho = new TipoGan(t,v);
        this.tipo = tipoDeGanho;
    }
    
    private void setData(LocalDate d){
        this.data = d;
    }
    
    public Ganho(String n, int t, double v, LocalDate d){
        this.setNome(n);
        this.setTipo(t,v);
        this.setData(d);
    }

    public String getNome() {
        return nome;
    }

    public TipoGan getTipo() {
        return tipo;
    }

    public LocalDate getData() {
        return data;
    }
    
    public double buscarGanhosMesAno(List<Ganho> listaGanhos, LocalDate data) {
    double totalGastos = 0.0;
    for (Ganho g : listaGanhos) {
        LocalDate dataGasto = g.getData();
            if (dataGasto.getMonth() == data.getMonth() && dataGasto.getYear() == data.getYear()) {
                totalGastos += g.getTipo().getValor();
            }
        }
        return totalGastos;
    }
    
    
}
