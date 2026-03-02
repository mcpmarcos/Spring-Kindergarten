@FunctionalInterface
public interface ICalculo {
    
    double executar(double a, double b);

    // Métodos "default" e métodos estáticos são permitidos em interfaces funcionais, porém deve existir no máximo 1 método abstrato. Além duisso, o(s) outro método(s) criado precisa(m) ser "default" ou "static". 

    // Em um destes outros possíveis métodos, eu posso interagir/chamar o método abstrato da interface funcional

    // default String legal(){
    //     return "cool";
    // }
  
    // default String muitoLegal(){
    //     return executar(a, b);
    // }
    
    // default String muitoLegal2(double a, double b){
    //     return executar(a, b);
    // }

}

