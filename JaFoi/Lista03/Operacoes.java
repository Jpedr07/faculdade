/**
*minha resolucao
 */
public class Operacoes {

    static String imprimir(Aluno[] classe) {
        if (classe == null || classe.length == 0) {
            return "{}";
        }
        StringBuilder resultado = new StringBuilder("{");

        for (int i = 0; i < classe.length; i++) {
            if (classe[i] != null && classe[i].getNome() != null) {
                resultado.append(classe[i].getNome());
                if (i < classe.length - 1) {
                    resultado.append(", ");
                }
            }
        }
        
        resultado.append("}");
        
        return resultado.toString();
    }

    static double calcularMedia(Aluno alu) {
        if (alu == null || alu.getNotas() == null || alu.getNotas().length == 0) {
            return 0.0;
        }
        double[] notas = alu.getNotas();
        double soma = 0.0;
        for (double nota : notas) {
            soma += nota;
        }
        return soma / notas.length;
    }

    static Aluno encontrarMaiorMedia(Aluno[] classe) {
        if (classe == null || classe.length == 0) {
            return null;
        }
        Aluno alunoMaiorMedia = null;
        for (Aluno aluno : classe) {
            if (aluno != null) {
                double media = calcularMedia(aluno);
                if (media > maiorMedia) {
                    maiorMedia = media;
                    alunoMaiorMedia = aluno;
                }
            }
        }
        return alunoMaiorMedia;
    }

    static boolean existeAlunoRA(Aluno[] classe, int ra) {
        if (classe == null || classe.length == 0) {
            return false;
        }
        
        for (Aluno aluno : classe) {
            if (aluno != null && aluno.getRA() == ra) {
                return true;
            }
        }
        return false;
    }

    static String aprovados(Aluno[] classe, double notaCorte) {
        if (classe == null || classe.length == 0) {
            return "{}";
        }
        
        StringBuilder resultado = new StringBuilder("{");
        
        for (int i = 0; i < classe.length; i++) {
            if (classe[i] != null) {
                double media = calcularMedia(classe[i]);
                if (media >= notaCorte) {
                    resultado.append(classe[i].getNome());
                    resultado.append(", ");
                }
            }
        }
        resultado.append("}");
        return resultado.toString();
    }
}
