package sptech.projeto01;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContadorController {

    private int contador;

    @GetMapping("/contar")
    public String contar() {
        contador++;
        return String.format("Você já fez %d acessos", contador);
    }

    /*
{n1} e {n2} são PATH PARAMS
{n1} foi mapeado para o argumento n1 por causa da anotação @PathVariable
{n2} foi mapeado para o argumento n2 por causa da anotação @PathVariable
O nome do path param deve ser o mesmo do argumento do método
     */
    @GetMapping("/somar/{n1}/{n2}")
    public String somar(@PathVariable double n1, @PathVariable double n2) {
        return
            String.format("A soma entre %.2f e %.2f é %.2f", n1, n2, (n1+n2));
    }

/*
Chamada /calcular-vr/{salario}/{nome}
Ela retorna a frase "Olá, NOME seu VR será de X"
Onde X é 8% do salário
 */
    @GetMapping("/calcular-vr/{salario}/{nome}")
    public String calcularVR(@PathVariable double salario,
                             @PathVariable String nome) {
        return String.format(
                "Olá, %s, seu VR será de R$%.2f", nome, salario * 0.08);
    }




}
